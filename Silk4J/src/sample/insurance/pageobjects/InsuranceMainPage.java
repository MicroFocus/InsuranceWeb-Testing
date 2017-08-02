/**
 * Copyright 2017 Micro Focus. All rights reserved. 
 * Portions Copyright 1992-2009 Borland Software Corporation (a Micro Focus company).
 */
package sample.insurance.pageobjects;

import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.xbrowser.BrowserApplication;
import com.borland.silktest.jtf.xbrowser.BrowserWindow;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomListBox;

public abstract class InsuranceMainPage {

	private final String locQuickJumpSel = "Web.QuickJump";
	private final String locHomeLnk = "//div[@id='footer']//a[@textContents='Home']";

	protected final Desktop desktop = new Desktop();
	protected final BrowserApplication browserApplication;
	protected final BrowserWindow browserWindow;

	public InsuranceMainPage() {
		browserApplication = desktop.find("/BrowserApplication");
		browserWindow = browserApplication.find("/BrowserWindow");
	}

	public HomePage gotoHomePage() {
		browserWindow.<DomLink>find(locHomeLnk).domClick();
		return new HomePage();
	}

	public AgentLookupPage gotoAgentLookup() {
		selectService("Agent Lookup");
		return new AgentLookupPage();
	}

	public QuotePage gotoAutoQuote() {
		selectService("Auto Quote");
		return new QuotePage();
	}

	private void selectService(String service) {
		desktop.<DomListBox>find(locQuickJumpSel).select(service);
	}

}
