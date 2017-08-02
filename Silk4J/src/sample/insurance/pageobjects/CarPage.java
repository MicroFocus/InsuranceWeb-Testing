/**
 * Copyright 2017 Micro Focus. All rights reserved. 
 * Portions Copyright 1992-2009 Borland Software Corporation (a Micro Focus company).
 */
package sample.insurance.pageobjects;

import com.borland.silktest.jtf.common.TruelogScreenshotMode;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomRadioButton;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import sample.insurance.FinacialInfo;


public class CarPage extends InsuranceMainPage {

	private final String locYearTxt = "//INPUT[@id='autoquote:year']";
	private final String locNextBtn = "//INPUT[@id='autoquote:next']";

	public CarPage() {
		super();
		
		desktop.logInfo("CarDetails-Form", TruelogScreenshotMode.ActiveWindow);
	}

	public SummaryPage fillInCarInfoAndProceed(int year, String make, String model, FinacialInfo info) {
		browserWindow.<DomTextField>find(locYearTxt).setText("" + year);
		browserWindow.<DomElement>find("//IMG[@class='x-form-trigger x-for*']").domClick();
		browserWindow.<DomElement>find("//DIV[@textContents='" + make + "']").domClick();
		browserWindow.<DomElement>find("//IMG[@class='x-form-trigger x-for*'][2]").domClick();
		browserWindow.<DomElement>find("//DIV[@textContents='" + model + "']").domClick();
		browserWindow.<DomRadioButton>find("//INPUT[@id='autoquote:finInfo:" + info.ordinal() + "']").select();
		desktop.logInfo("Completed CarDetails-Form", TruelogScreenshotMode.ActiveWindow);
		browserWindow.<DomButton>find(locNextBtn).domClick();
		return new SummaryPage();
	}

}
