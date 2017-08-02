/**
 * Copyright 2017 Micro Focus. All rights reserved. 
 * Portions Copyright 1992-2009 Borland Software Corporation (a Micro Focus company).
 */
package sample.insurance.pageobjects;

import org.hamcrest.core.Is;
import org.junit.Assert;

import com.borland.silktest.jtf.common.TruelogScreenshotMode;
import com.borland.silktest.jtf.xbrowser.DomElement;

public class SummaryPage extends InsuranceMainPage {

	private final String locYearTxt = "//FORM[@id='quote-result']//H1/B";

	public SummaryPage() {
		super();
		
		desktop.logInfo("Summary-Page", TruelogScreenshotMode.ActiveWindow);
	}

	public SummaryPage validateQuote(String expectedQuote) {
		String actualQuote = browserWindow.<DomElement>find(locYearTxt).getText();
		Assert.assertThat(expectedQuote, Is.is(actualQuote));
		return this;
	}

}
