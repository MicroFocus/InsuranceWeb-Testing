/**
 * Copyright 2017 Micro Focus. All rights reserved. 
 * Portions Copyright 1992-2009 Borland Software Corporation (a Micro Focus company).
 */
package sample.insurance.pageobjects;

import com.borland.silktest.jtf.common.TruelogScreenshotMode;
import com.borland.silktest.jtf.common.types.FindOptions;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomRadioButton;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import sample.insurance.DrivingRecord;
import sample.insurance.Gender;

public class UserDetailPage extends InsuranceMainPage {
	
	private final String locAgeTxt = "//INPUT[@id='autoquote:age']";
	private final String locNextBtn = "//INPUT[@id='autoquote:next']";

	public UserDetailPage() {
		super();
		
		desktop.logInfo("UserDetail-Form", TruelogScreenshotMode.ActiveWindow);
	}

	public CarPage fillInUserDetailAndProceed(int age, Gender gender, DrivingRecord record) {
		browserWindow.<DomTextField>find(locAgeTxt, new FindOptions(10000)).setText("" + age);
		browserWindow.<DomRadioButton>find("//INPUT[@id='autoquote:gender:" + gender.ordinal() + "']").select();
		browserWindow.<DomRadioButton>find("//INPUT[@id='autoquote:type:" + record.ordinal() + "']").select();
		desktop.logInfo("Completed UserDetail-Form", TruelogScreenshotMode.ActiveWindow);
		browserWindow.<DomButton>find(locNextBtn).domClick();
		return new CarPage();
	}

}
