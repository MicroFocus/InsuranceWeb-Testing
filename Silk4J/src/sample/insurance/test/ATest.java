/**
 * Copyright 2017 Micro Focus. All rights reserved. 
 * Portions Copyright 1992-2009 Borland Software Corporation (a Micro Focus company).
 */
package sample.insurance.test;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.borland.silktest.jtf.BrowserBaseState;
import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.xbrowser.BrowserApplication;
import com.borland.silktest.jtf.xbrowser.BrowserWindow;

public abstract class ATest {

	protected static final Desktop desktop = new Desktop();

	protected static BrowserApplication browser;
	protected BrowserWindow browserWindow;

	@BeforeClass
	public static void baseState() {
		// Go to web page 'demo.borland.com/InsuranceExtJS'
		BrowserBaseState baseState = new BrowserBaseState();
		browser = baseState.execute(desktop);
	}

	@Before
	public void init() {
		browserWindow = browser.find("/BrowserWindow");
		browser.setActive();
	}

	@AfterClass
	public static void closeBrowser() {
		browser.close();
	}

}
