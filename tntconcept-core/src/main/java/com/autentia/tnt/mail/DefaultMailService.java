/**
 * TNTConcept Easy Enterprise Management by Autentia Real Bussiness Solution S.L.
 * Copyright (C) 2007 Autentia Real Bussiness Solution S.L.
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.autentia.tnt.mail;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Semaphore;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.autentia.tnt.util.ConfigurationUtil;

public class DefaultMailService implements MailService,Runnable {

    private static final Log log = LogFactory.getLog(DefaultMailService.class);

    private final Properties properties = new Properties();

    private Session session;

    private final ConfigurationUtil configurationUtil;

	private String to, subject, text;
	 private final Semaphore mutex = new Semaphore(1);

    public DefaultMailService(ConfigurationUtil configurationUtil) {
        super();
        this.configurationUtil = configurationUtil;
    }

    /**
     * This method is used by Spring Framework
     */
    private void init() {
        try {
            properties.put("mail.smtp.host", configurationUtil.getMailHost());
            properties.put("mail.smtp.port", Integer.parseInt(configurationUtil.getMailPort()));
            properties.put("mail.smtp.user", configurationUtil.getMailUsername());
            properties.put("mail.smtp.auth", configurationUtil.getMailRequiresAuth());
            properties.put("mail.smtp.starttls.enable", "true");

            session = Session.getDefaultInstance(properties);
        } catch (Exception e) {
            log.warn("The smtp server is not configured: " + e);
        }
    }

    public void sendFiles(String to, String subject, String text, Collection<File> attachments) throws MessagingException {

        MimeMessage message = new MimeMessage(session);
        Transport t = session.getTransport("smtp");

        message.setFrom(new InternetAddress(configurationUtil.getMailUsername()));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setSentDate(new Date());
        if (attachments == null || attachments.size() < 1) {
            message.setText(text);
        } else {
            // create the message part
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(text);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            for (File attachment : attachments) {

                messageBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(attachment);
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(attachment.getName());
                multipart.addBodyPart(messageBodyPart);
            }
            message.setContent(multipart);
        }

        t.connect(configurationUtil.getMailUsername(), configurationUtil.getMailPassword());

        t.sendMessage(message, message.getAllRecipients());
        t.close();
    }

    public void sendOutputStreams(String to, String subject, String text, Map<InputStream, String> attachments) throws MessagingException {
        Transport t = null;

        try {
            MimeMessage message = new MimeMessage(session);

            t = session.getTransport("smtp");

            message.setFrom(new InternetAddress(configurationUtil.getMailUsername()));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            sendMail(subject, text, attachments, t, message);
        } catch (Exception e) {
            System.err.println("sendOutputStreams ERROR: " + e.getStackTrace().toString());
        }
        finally {
            if (t != null) {
                t.close();
            }
        }

    }

    public void sendOutputStreams(String[] recipients, String subject, String text, Map<InputStream, String> attachments) throws MessagingException {
        Transport t = null;
        InternetAddress[] addresses = new InternetAddress[ recipients.length ];

        try {
            MimeMessage message = new MimeMessage(session);

            t = session.getTransport("smtp");

            message.setFrom(new InternetAddress(configurationUtil.getMailUsername()));

            for( int i = 0; i < recipients.length; i++) {
                addresses[ i ] = new InternetAddress( recipients[ i ] );
            }

            message.addRecipients(Message.RecipientType.BCC, addresses);

            sendMail(subject, text, attachments, t, message);
        } catch (Exception e) {
            System.err.println("sendOutputStreams ERROR: " + e.getStackTrace().toString());
        }
        finally {
            if (t != null) {
                t.close();
            }
        }

    }

    private void sendMail(String subject, String text, Map<InputStream, String> attachments, Transport t, MimeMessage message) throws MessagingException {
        message.setSubject(subject);
        message.setSentDate(new Date());
        if (attachments == null || attachments.size() < 1) {
            message.setText(text);
        } else {
            // create the message part
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(text);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            try {
                for (InputStream attachment : attachments.keySet()) {
                    messageBodyPart = new MimeBodyPart();
                    DataSource source = new ByteArrayDataSource(attachment, "application/octet-stream");

                    messageBodyPart.setDataHandler(new DataHandler(source));
                    messageBodyPart.setFileName(attachments.get(attachment)); //NOSONAR
                    multipart.addBodyPart(messageBodyPart);                      //Se emplea keyset y no valueset porque se emplea tanto la key como el val
                }
            } catch (IOException e) {
                throw new MessagingException("cannot add an attachment to mail", e);
            }
            message.setContent(multipart);
        }

        t.connect(configurationUtil.getMailUsername(), configurationUtil.getMailPassword());

        t.sendMessage(message, message.getAllRecipients());
    }

    public void send(String to, String subject, String text) throws MessagingException {
        if(ConfigurationUtil.getDefault().getEnabledSendMail()){
    		sendFiles(to, subject, text, null);
        }
    }

    
	public void setHtmlData(String to, String subject, String text) {
		try {
			mutex.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.to = to;
		this.subject = subject;
		this.text = text;
	}

	@Override
	public void run() {

		String particularTo = to;
		String particularSubject = subject;
		String particularText = text;
		mutex.release();
		
		try {

			MimeMessage message = new MimeMessage(session);
			Transport t = session.getTransport("smtp");

			message.setFrom(new InternetAddress(configurationUtil.getMailUsername()));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(particularTo));
			message.setSubject(particularSubject);
			message.setSentDate(new Date());
			message.setContent(particularText, "text/html; charset=utf-8");

			t.connect(configurationUtil.getMailUsername(), configurationUtil.getMailPassword());

			t.sendMessage(message, message.getAllRecipients());
			t.close();

		} catch (MessagingException e) {
			log.error("Send mail", e);
		}
	}

	public void sendHtml(String to, String subject, String text) {
		if(ConfigurationUtil.getDefault().getEnabledSendMail()){
			setHtmlData(to, subject, text);
			new Thread(this).start();
		}
	}


}