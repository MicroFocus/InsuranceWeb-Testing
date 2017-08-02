/**
 * Copyright 2017 Micro Focus. All rights reserved. 
 * Portions Copyright 1992-2009 Borland Software Corporation (a Micro Focus company).
 */
package sample.insurance.pageobjects;

import com.borland.silktest.jtf.common.TruelogScreenshotMode;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomTextField;

public class AgentLookupPage extends InsuranceMainPage {

	public AgentLookupPage() {
		super();
		
		desktop.logInfo("AgentLookup-Page", TruelogScreenshotMode.ActiveWindow);
		if (!browserWindow.getUrl().endsWith("/agent_lookup.jsf"))
			throw new IllegalStateException("This is not the agent lookup page");
	}
	
	public AgentsPage searchForAgentByName(String name) {
		browserWindow.<DomTextField>find("//INPUT[@id='name-search:lastName']").setText(name);
		browserWindow.<DomButton>find("//INPUT[@id='name-search:search-n*']").click();
		return new AgentsPage();
	}

}
