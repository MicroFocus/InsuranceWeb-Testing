/**
 * Copyright 2017 Micro Focus. All rights reserved. 
 * Portions Copyright 1992-2009 Borland Software Corporation (a Micro Focus company).
 */
package sample.insurance.test;

import org.junit.Assert;
import org.junit.Test;

import com.borland.silktest.jtf.common.CommonOptions;
import com.borland.silktest.jtf.common.TruelogScreenshotMode;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomListBox;

import sample.insurance.Automobile;
import sample.insurance.DrivingRecord;
import sample.insurance.FinacialInfo;
import sample.insurance.Gender;
import sample.insurance.Keywords;

public class JUnitKeywordDrivenTest extends ATest {

	private static Keywords keywords = new Keywords();

	@Test
	public void autoQuote() {
		browserWindow.<DomListBox> find("//SELECT[@id='quick-link:jump-menu']").select("Auto Quote");

		keywords.fillOutCommunicationInfo("4040", "john.smith@gmail.com", Automobile.CAR);
		keywords.fillOutGeneralInfo(30, Gender.MALE, DrivingRecord.EXCELLENT);
		keywords.fillOutCarInfo(2012, "Buick", "Electra", FinacialInfo.OWN);

		desktop.logInfo("Quote", TruelogScreenshotMode.ActiveWindow);
		DomElement quoteResultFinalp = browserWindow.<DomElement> find("//FORM[@id='quote-result']//H1/B");
		Assert.assertEquals("USD 1.190,00", quoteResultFinalp.getText());
		desktop.<DomLink> find("//A[@textContents='Home']").domClick();
	}

	@Test
	public void login() {
		desktop.setOption(CommonOptions.OPT_TRUELOG_SCREENSHOT_MODE, TruelogScreenshotMode.ActiveWindow);
		Assert.assertEquals("John Smith", keywords.login("john.smith@gmail.com", "john"));
		desktop.logInfo("Logged-In", TruelogScreenshotMode.ActiveWindow);
		browserWindow.<DomButton> find("//INPUT[@id='logout-form:logout']").select();
		desktop.setOption(CommonOptions.OPT_TRUELOG_SCREENSHOT_MODE, TruelogScreenshotMode.None);
	}
}