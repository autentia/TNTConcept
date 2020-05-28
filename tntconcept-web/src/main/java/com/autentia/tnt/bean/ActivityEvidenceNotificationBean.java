package com.autentia.tnt.bean;

import com.autentia.tnt.businessobject.Activity;
import com.autentia.tnt.businessobject.Project;
import com.autentia.tnt.businessobject.ProjectRole;
import com.autentia.tnt.businessobject.User;
import com.autentia.tnt.dao.search.ActivitySearch;
import com.autentia.tnt.dao.search.UserSearch;
import com.autentia.tnt.mail.MailService;
import com.autentia.tnt.manager.activity.ActivityManager;
import com.autentia.tnt.manager.admin.UserManager;
import com.autentia.tnt.manager.security.AuthenticationManager;
import com.autentia.tnt.manager.security.Principal;
import com.autentia.tnt.util.ConfigurationUtil;
import org.acegisecurity.Authentication;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class ActivityEvidenceNotificationBean {
    private static final Log log = LogFactory.getLog(ContractExpirationNotificationBean.class);

    private MailService mailService;


    public ActivityEvidenceNotificationBean(MailService mailService) {
        this.mailService = mailService;
    }

//    public void checkActivitiesWithNoEvidence() throws MessagingException {
//        log.info("Checking for users with no activity evidence images attached for the past 7 days");
//
//        authenticateAs(ConfigurationUtil.getDefault().getAdminUser());
//
//        Date oneWeekAgo = Date.from(LocalDate.now().plusDays(-7).atStartOfDay(ZoneId.systemDefault()).toInstant());
//
//        UserSearch userSearch = new UserSearch();
//        userSearch.setActive(true);
//        List<User> users = UserManager
//                .getDefault()
//                .getAllEntities(userSearch,null)
//                .stream().filter(user -> user.getEmail() != null)
//                .collect(Collectors.toList());
//
//        List<Project> projects = ProjectManager
//                .getDefault()
//                .getAllEntities(null, null);
//
//        for (User user: users) {
//            ActivitySearch search = new ActivitySearch();
//            search.setStartStartDate(oneWeekAgo);
//            search.setUser(user);
//            List<Activity> activities = ActivityManager.getDefault().getAllEntities(search, null);
//            activities = activities.stream().filter(activity -> activity.getRole().getRequireEvidence()).collect(Collectors.toList());
//
//            if (activities.isEmpty()) {
//                continue;
//            }
//
//            boolean anyHasImage = false;
//            for (Activity activity : activities) {
//                if (activity.isHasImage()) {
//                    anyHasImage = true;
//                    break;
//                }
//            }
//
//            if (!anyHasImage) {
//                String emailSubject = ConfigurationUtil.getDefault().getNoEvidenceInActivityMailSubject();
//                String emailBody = ConfigurationUtil.getDefault().getNoEvidenceInActivityMailBody();
//                mailService.send(user.getEmail(), emailSubject, emailBody);
//                log.info("Email sent to: " + user.getEmail());
//            }
//        }
//    }

    public void checkActivitiesWithNoEvidence() throws MessagingException {
        log.info("Checking for users with no activity evidence images attached for the past 7 days");

        authenticateAs(ConfigurationUtil.getDefault().getAdminUser());

        Date oneWeekAgo = Date.from(LocalDate.now().plusDays(-7).atStartOfDay(ZoneId.systemDefault()).toInstant());

        UserSearch userSearch = new UserSearch();
        userSearch.setActive(true);
        List<User> users = UserManager
                .getDefault()
                .getAllEntities(userSearch,null)
                .stream().filter(user -> user.getEmail() != null)
                .collect(Collectors.toList());


        for (User user: users) {
            ActivitySearch search = new ActivitySearch();
            search.setStartStartDate(oneWeekAgo);
            search.setUser(user);
            List<Activity> activities = ActivityManager.getDefault().getAllEntities(search, null);
            activities = activities
                    .stream()
                    .filter(activity -> doesProjectContainRoleWithRequiredEvidence(activity.getRole().getProject()))
                    .collect(Collectors.toList());

            if (activities.isEmpty()) {
                continue;
            }

            HashMap<Project, List<Activity>> groupedActivities = groupedActivitiesByProject(activities);
            for(Project project: groupedActivities.keySet()) {
                List<Activity> prjActivities = groupedActivities.get(project);
                if(prjActivities.stream().noneMatch(Activity::isHasImage)) {
                    prjActivities
                            .stream()
                            .findFirst()
                            .ifPresent(activity -> {
                                try {
                                    sendEmail(activity.getRole(), user.getEmail());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            });
                }
            }
        }
    }

    private void sendEmail(ProjectRole role, String email) throws Exception {
        String roleName = role.getName();
        String prjName = role.getProject().getName();
        String emailSubject = String.format(ConfigurationUtil.getDefault().getNoEvidenceInActivityMailSubject(),prjName,roleName);
        String emailBody = String.format(ConfigurationUtil.getDefault().getNoEvidenceInActivityMailBody(),prjName,roleName);
        mailService.send(email, emailSubject, emailBody);
        log.info("Email sent to: " + email);
    }

    private HashMap<Project,List<Activity>> groupedActivitiesByProject(List<Activity> activities) {
        HashMap<Project, List<Activity>> map = new HashMap<>();
        activities.forEach(activity -> {
            Project project = activity.getRole().getProject();
            List<Activity> prjActivities = map.getOrDefault(project, new ArrayList<>());
            prjActivities.add(activity);
            map.put(project, prjActivities);
        });

        return map;
    }

    private boolean doesProjectContainRoleWithRequiredEvidence(Project project) {
        return project.getRoles().stream().anyMatch(ProjectRole::getRequireEvidence);
    }

    // TODO Extract to a Security Utils Class or similar
    private void authenticateAs(final String userLogin) {
        final Principal principal = (Principal) AuthenticationManager.getDefault().loadUserByUsername(userLogin);
        Authentication auth = new UsernamePasswordAuthenticationToken(principal, principal.getUser().getPassword(),principal.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
