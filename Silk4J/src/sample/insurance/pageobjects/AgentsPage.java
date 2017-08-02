/**
 * Copyright 2017 Micro Focus. All rights reserved. 
 * Portions Copyright 1992-2009 Borland Software Corporation (a Micro Focus company).
 */
package sample.insurance.pageobjects;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;

import com.borland.silktest.jtf.common.TruelogScreenshotMode;
import com.borland.silktest.jtf.xbrowser.DomElement;

public class AgentsPage extends InsuranceMainPage {

	public AgentsPage() {
		super();
		
		desktop.logInfo("Agents-Page", TruelogScreenshotMode.ActiveWindow);
		if (!browserWindow.getUrl().endsWith("/agent_lookup.jsf"))
			throw new IllegalStateException("This is not the agents page");
	}
	
	public AgentsPage validateAgentExists(String name) {
		Assert.assertTrue(findAgent(name));
		return this;
	}
	
	private boolean findAgent(String name) {
		List<DomElement> rows = browserWindow.<DomElement> findAll("//DIV[@class='x-grid3']//TABLE/TBODY/TR");
		Iterator<DomElement> it = rows.iterator();
		while (it.hasNext()) {
			DomElement lastName = it.next().find("/TD[2]");
			
			if (name.equals(lastName.getProperty("Text")))
				return true;
		}
		
		return false;
	}
}
