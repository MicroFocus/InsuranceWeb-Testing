/**
 * Copyright 2017 Micro Focus. All rights reserved. 
 * Portions Copyright 1992-2009 Borland Software Corporation (a Micro Focus company).
 */
package sample.insurance.pageobjects;

import com.borland.silktest.jtf.common.TruelogScreenshotMode;
import com.borland.silktest.jtf.common.types.FindOptions;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomTextField;

public class HomePage extends InsuranceMainPage {

	private final String locLogoutBtn = "//INPUT[@id='logout-form:logout']";
	private final String locEMailTxt = "Web.Login.EMail";
	private final String locPasswordTxt = "Web.Login.Password";
	private final String locLoginBtn = "Web.Login.Login";

	public HomePage() {
		super();
	}

	public HomePage login(String username, String password) {
		DomButton logout = browserWindow.<DomButton>find(locLogoutBtn, new FindOptions(false, 500));
		if (logout != null)
			logout.select();

		desktop.<DomTextField>find(locEMailTxt).setText(username);
		desktop.<DomTextField>find(locPasswordTxt).setText(password);
		desktop.logInfo("Login", TruelogScreenshotMode.ActiveWindow);
		desktop.<DomButton>find(locLoginBtn).select();
		desktop.logInfo("Logged In", TruelogScreenshotMode.ActiveWindow);

		return this;
	}
	
	public String getUserName() {
		DomElement userName = browserWindow.<DomElement> find(
				"//LABEL[@class='login' and @for='logout-form']", new FindOptions(false, 500));
		if (userName != null)
			return userName.getText();
		
		return "";
	}

	public HomePage logout() {
		DomButton logout = browserWindow.<DomButton>find(locLogoutBtn,
				new FindOptions(false, 500));
		if (logout != null)
			logout.select();

		return this;
	}

}
