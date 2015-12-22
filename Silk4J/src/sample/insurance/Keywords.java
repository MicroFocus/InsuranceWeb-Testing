/**
 * Copyright 2013 Micro Focus. All rights reserved. 
 * Portions Copyright 1992-2009 Borland Software Corporation (a Micro Focus company).
 */
package sample.insurance;

import org.junit.Assert;

import com.borland.silk.keyworddriven.annotations.Argument;
import com.borland.silk.keyworddriven.annotations.Keyword;
import com.borland.silktest.jtf.BrowserBaseState;
import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.common.BrowserType;
import com.borland.silktest.jtf.common.CommonOptions;
import com.borland.silktest.jtf.common.TruelogScreenshotMode;
import com.borland.silktest.jtf.common.types.FindOptions;
import com.borland.silktest.jtf.common.types.MouseButton;
import com.borland.silktest.jtf.xbrowser.BrowserApplication;
import com.borland.silktest.jtf.xbrowser.BrowserWindow;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomRadioButton;
import com.borland.silktest.jtf.xbrowser.DomTextField;

public class Keywords {
	private Desktop desktop = new Desktop();

	@Keyword("login as John Smith")
	public void login() {
		login("john.smith@gmail.com", "john");
	}

	@Keyword("login")
	public String login(String username, String password) {
		BrowserApplication bw = desktop.find("//BrowserApplication");
		bw.setActive();
		BrowserWindow browser = bw
				.find("//BrowserWindow");

		DomButton logout = browser.<DomButton> find(
				"//INPUT[@id='logout-form:logout']",
				new FindOptions(false, 500));
		if (logout != null)
			logout.select();

		browser.<DomTextField> find("//INPUT[@id='login-form:email']").setText(
				username);
		browser.<DomTextField> find("//INPUT[@id='login-form:password']")
				.setText(password);
		desktop.logInfo("Login", TruelogScreenshotMode.ActiveWindow);
		browser.<DomButton> find("//INPUT[@id='login-form:login']").select();
		desktop.logInfo("Logged In", TruelogScreenshotMode.ActiveWindow);

		return browser.<DomElement> find(
				"//LABEL[@class='login' and @for='logout-form']").getText();
	}

	@Keyword("fill out user contact data")
	public void fillOutCommunicationInfo(String zipCode, String email,
			Automobile type) {
		desktop.logInfo("CommunicationInfo", TruelogScreenshotMode.ActiveWindow);

		BrowserWindow browser = desktop
				.find("//BrowserApplication//BrowserWindow");
		browser.<DomTextField> find("//INPUT[@id='autoquote:zipcode']")
				.setText(zipCode);
		browser.<DomTextField> find("//INPUT[@id='autoquote:e-mail']").setText(
				email);
		browser.<DomRadioButton> find(
				"//INPUT[@id='autoquote:vehicle:" + type.ordinal() + "']")
				.select();
		desktop.logInfo("filled out CommunicationInfo",
				TruelogScreenshotMode.ActiveWindow);
		browser.<DomButton> find("//INPUT[@id='autoquote:next']").domClick();
	}

	@Keyword("fill out user details")
	public void fillOutGeneralInfo(@Argument("age") int age, Gender gender,
			DrivingRecord record) {
		desktop.logInfo("GeneralInfo", TruelogScreenshotMode.ActiveWindow);

		BrowserWindow browser = desktop
				.find("//BrowserApplication//BrowserWindow");
		browser.<DomTextField> find("//INPUT[@id='autoquote:age']",
				new FindOptions(10000)).setText("" + age);
		browser.<DomRadioButton> find(
				"//INPUT[@id='autoquote:gender:" + gender.ordinal() + "']")
				.select();
		browser.<DomRadioButton> find(
				"//INPUT[@id='autoquote:type:" + record.ordinal() + "']")
				.select();
		desktop.logInfo("filled out GeneralInfo",
				TruelogScreenshotMode.ActiveWindow);
		browser.<DomButton> find("//INPUT[@id='autoquote:next']").domClick();
	}

	@Keyword("fill out information about the car")
	public void fillOutCarInfo(int year, String make, String model,
			FinacialInfo info) {
		desktop.logInfo("CarInfo", TruelogScreenshotMode.ActiveWindow);

		BrowserWindow browser = desktop
				.find("//BrowserApplication//BrowserWindow");
		browser.<DomTextField> find("//INPUT[@id='autoquote:year']").setText(
				"" + year);
		browser.<DomElement> find("//IMG[@class='x-form-trigger x-for*']")
				.domClick();
		browser.<DomElement> find("//DIV[@textContents='" + make + "']")
				.domClick();
		browser.<DomElement> find("//IMG[@class='x-form-trigger x-for*'][2]")
				.domClick();
		browser.<DomElement> find("//DIV[@textContents='" + model + "']")
				.domClick();
		browser.<DomRadioButton> find(
				"//INPUT[@id='autoquote:finInfo:" + info.ordinal() + "']")
				.select();
		desktop.logInfo("filled out CarInfo",
				TruelogScreenshotMode.ActiveWindow);
		browser.<DomButton> find("//INPUT[@id='autoquote:next']").domClick();
	}

	@Keyword("start Browser")
	public BrowserApplication startBrowser() {
		return startBrowser(new BrowserBaseState());
	}

	@Keyword("start Browser with parameters")
	public BrowserApplication startBrowser(String url, BrowserType type) {
		return startBrowser(new BrowserBaseState(type, url));
	}

	public BrowserApplication startBrowser(BrowserBaseState baseState) {
		baseState.setOption(CommonOptions.OPT_APPREADY_TIMEOUT, 60000);
		if ("true".equals(System.getProperty("#sctm_tunnel_to_internal_proxy"))
				&& baseState.getBrowserType().equals(BrowserType.GoogleChrome)) {
			baseState.setCommandLineArguments("--proxy-server=localhost:8080");
			baseState.setCommandLinePattern("*");
		}
		return desktop.executeBaseState(baseState);
	}

	@Keyword("select Agent Lookup")
	public void selectAgentLookup() {
		selectAService("Agent Lookup");
	}

	@Keyword("select a Service")
	public void selectAService(String service) {
		desktop.<DomListBox> find(
				"//BrowserApplication//BrowserWindow//SELECT[@id='quick-link:jump-menu']")
				.select(service);
	}

	@Keyword("logout")
	public void logout() {
		desktop.<DomLink> find(
				"//BrowserApplication//BrowserWindow//A[@textContents='Home']")
				.click(MouseButton.LEFT);
		desktop.<DomButton> find(
				"//BrowserApplication//BrowserWindow//INPUT[@id='logout-form:logout']")
				.click(MouseButton.LEFT);
	}

	@Keyword("search for all Agents")
	public void searchForAllAgents() {
		desktop.<DomListBox> find(
				"//BrowserApplication//BrowserWindow//SELECT[@id='quick-link:jump-menu']")
				.select("Agent Lookup");
		desktop.<DomButton> find(
				"//BrowserApplication//BrowserWindow//INPUT[@id='show-all:search-all']")
				.click(MouseButton.LEFT);
	}

	@Keyword("validate that Agent Walker exists")
	public void validate_that_Agent_Walker_exists() {
		validate_that_Agent_exists("Walker");
	}

	@Keyword("validate that a specific Agent exists")
	public void validate_that_Agent_exists(String agentName) {
		desktop.logInfo("Validate if Agent '" +agentName +"' exists",
				TruelogScreenshotMode.ActiveWindow);
		Assert.assertTrue(desktop.exists(
				"//BrowserApplication//BrowserWindow//DIV[@textContents='"
						+ agentName + "']", 1000));
	}
}