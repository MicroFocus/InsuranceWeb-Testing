/**
 * Copyright 2017 Micro Focus. All rights reserved. 
 * Portions Copyright 1992-2009 Borland Software Corporation (a Micro Focus company).
 */
package sample.insurance.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.borland.silktest.jtf.common.CommonOptions;
import com.borland.silktest.jtf.common.TruelogScreenshotMode;

import sample.insurance.Automobile;
import sample.insurance.DrivingRecord;
import sample.insurance.FinacialInfo;
import sample.insurance.Gender;
import sample.insurance.pageobjects.AgentsPage;
import sample.insurance.pageobjects.HomePage;
import sample.insurance.pageobjects.SummaryPage;

public class PageObjectTest extends ATest {
	
	private HomePage homePage;
	
	@Before
	public void initHomePage() {
		homePage = new HomePage();
	}

	@Test
	public void autoQuote() {
		SummaryPage summary = homePage.gotoAutoQuote()
				.fillInContactDataAndProceed("4040", "john.smith@gmail.com", Automobile.CAR)
				.fillInUserDetailAndProceed(30, Gender.MALE, DrivingRecord.EXCELLENT)
				.fillInCarInfoAndProceed(2012, "Toyota", "Camry", FinacialInfo.LEASE);

		summary.validateQuote("USD 1.666,00");
		summary.gotoHomePage();
	}
	
	@Test
	public void searchForAgentWalkerByName() {
		String agentName = "Walker";
		
		AgentsPage agents = homePage.gotoAgentLookup().searchForAgentByName(agentName);
		agents.validateAgentExists(agentName);
		agents.gotoHomePage();
	}
	
	@Test
	public void login() {
		desktop.setOption(CommonOptions.OPT_TRUELOG_SCREENSHOT_MODE, TruelogScreenshotMode.ActiveWindow);
		homePage.login("john.smith@gmail.com", "john");
		Assert.assertEquals("John Smith", homePage.getUserName());
		desktop.logInfo("Logged-In", TruelogScreenshotMode.ActiveWindow);
		homePage.logout();
		desktop.setOption(CommonOptions.OPT_TRUELOG_SCREENSHOT_MODE, TruelogScreenshotMode.None);
		Assert.assertEquals("", homePage.getUserName());
	}

}
