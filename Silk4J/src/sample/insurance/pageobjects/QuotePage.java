/**
 * Copyright 2017 Micro Focus. All rights reserved. 
 * Portions Copyright 1992-2009 Borland Software Corporation (a Micro Focus company).
 */
package sample.insurance.pageobjects;

import com.borland.silktest.jtf.common.TruelogScreenshotMode;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomRadioButton;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import sample.insurance.Automobile;

public class QuotePage extends InsuranceMainPage {

	private final String locZipCodeTxt = "//INPUT[@id='autoquote:zipcode']";
	private final String locEMailTxt = "//INPUT[@id='autoquote:e-mail']";
	private final String locNextBtn = "//INPUT[@id='autoquote:next']";

	public QuotePage() {
		super();
		
		desktop.logInfo("ContactInformation-Form", TruelogScreenshotMode.ActiveWindow);
	}

	public UserDetailPage fillInContactDataAndProceed(String zipCode, String email, Automobile type) {
		browserWindow.<DomTextField>find(locZipCodeTxt).setText(zipCode);
		browserWindow.<DomTextField>find(locEMailTxt).setText(email);
		browserWindow.<DomRadioButton>find("//INPUT[@id='autoquote:vehicle:" + type.ordinal() + "']").select();
		desktop.logInfo("Completed ContactInformation-Form", TruelogScreenshotMode.ActiveWindow);
		browserWindow.<DomButton>find(locNextBtn).domClick();
		return new UserDetailPage();
	}

}
