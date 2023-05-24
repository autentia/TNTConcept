package com.autentia.tnt.bean.contacts;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import org.flywaydb.core.Flyway;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.autentia.tnt.bean.billing.BillBean;
import com.autentia.tnt.businessobject.BillBreakDown;
import com.autentia.tnt.businessobject.OfferCost;
import com.autentia.tnt.businessobject.OfferRole;
import com.autentia.tnt.test.utils.SpringUtilsForTesting;

public class OfferBeanTest {
//
//	private final BigDecimal IVA16 = new BigDecimal("16");
//
//	private final BigDecimal IVA18 = new BigDecimal("18");
//
//	private final BigDecimal IVA21 = new BigDecimal("21");
//
//	@BeforeClass
//    public static void init() throws Exception {
//
//		Flyway flyway = Flyway.configure()
//				.dataSource("jdbc:hsqldb:mem:tnt;DB_CLOSE_DELAY=-1;sql.syntax_mys=true", "sa", "").load();
//		flyway.migrate();
//
//		SpringUtilsForTesting.configure(new ClassPathXmlApplicationContext("applicationContext-test.xml"));
//		SpringUtilsForTesting.loadPrincipalInSecurityContext("admin");
//    }
//
//	@Test
//	public void createRolesIn2009Test() {
//
//		final OfferBean offerBean = new OfferBean();
//		offerBean.create();
//		final GregorianCalendar calendar = new GregorianCalendar(2009, 8, 31);
//		offerBean.setCreationDate(calendar.getTime());
//		offerBean.createRoles();
//		for (OfferRole offerRole:offerBean.getRoles()) {
//			assertEquals(IVA16,offerRole.getIva());
//		}
//	}
//
//	@Test
//	public void createRolesInFirstDayOf18Test() {
//
//		OfferBean offerBean = new OfferBean();
//		offerBean.create();
//		final GregorianCalendar calendar = new GregorianCalendar(2010, 6, 1);
//		offerBean.setCreationDate(calendar.getTime());
//		offerBean.createRoles();
//		for (OfferRole offerRole:offerBean.getRoles()) {
//			assertEquals(IVA18,offerRole.getIva());
//		}
//	}
//
//	@Test
//	public void createRolesInLastDayOf18Test() {
//
//		OfferBean offerBean = new OfferBean();
//		offerBean.create();
//		final GregorianCalendar calendar = new GregorianCalendar(2012, 7, 31);
//		offerBean.setCreationDate(calendar.getTime());
//		offerBean.createRoles();
//		for (OfferRole offerRole:offerBean.getRoles()) {
//			assertEquals(IVA18,offerRole.getIva());
//		}
//	}
//
//	@Test
//	public void createRolesInFirstDayOf21Test() {
//
//		BillBean billBean = new BillBean();
//		billBean.create();
//		final GregorianCalendar calendar = new GregorianCalendar(2012, 8, 1);
//		billBean.setCreationDate(calendar.getTime());
//		billBean.createBreakDown();
//		for (BillBreakDown billBreakDown:billBean.getBill().getBreakDown()) {
//			assertEquals(IVA21,billBreakDown.getIva());
//		}
//	}
//
//	@Test
//	public void createCostsIn2009Test() {
//
//		final OfferBean offerBean = new OfferBean();
//		offerBean.create();
//		final GregorianCalendar calendar = new GregorianCalendar(2009, 8, 31);
//		offerBean.setCreationDate(calendar.getTime());
//		offerBean.createCosts();
//		for (OfferCost offerCost:offerBean.getCosts()) {
//			assertEquals(IVA16,offerCost.getIva());
//		}
//	}
//
//	@Test
//	public void createCostsInFirstDayOf18Test() {
//
//		OfferBean offerBean = new OfferBean();
//		offerBean.create();
//		final GregorianCalendar calendar = new GregorianCalendar(2010, 6, 1);
//		offerBean.setCreationDate(calendar.getTime());
//		offerBean.createCosts();
//		for (OfferCost offerCost:offerBean.getCosts()) {
//			assertEquals(IVA18,offerCost.getIva());
//		}
//	}
//
//	@Test
//	public void createCostsInLastDayOf18Test() {
//
//		OfferBean offerBean = new OfferBean();
//		offerBean.create();
//		final GregorianCalendar calendar = new GregorianCalendar(2012, 7, 31);
//		offerBean.setCreationDate(calendar.getTime());
//		offerBean.createCosts();
//		for (OfferCost offerCost:offerBean.getCosts()) {
//			assertEquals(IVA18,offerCost.getIva());
//		}
//	}
//
//	@Test
//	public void createCostsInFirstDayOf21Test() {
//
//		OfferBean offerBean = new OfferBean();
//		offerBean.create();
//		final GregorianCalendar calendar = new GregorianCalendar(2012, 8, 1);
//		offerBean.setCreationDate(calendar.getTime());
//		offerBean.createCosts();
//		for (OfferCost offerCost:offerBean.getCosts()) {
//			assertEquals(IVA21,offerCost.getIva());
//		}
//	}
}