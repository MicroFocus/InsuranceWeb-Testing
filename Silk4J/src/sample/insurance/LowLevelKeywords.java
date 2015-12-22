/**
 * Copyright 2013 Micro Focus. All rights reserved. 
 * Portions Copyright 1992-2009 Borland Software Corporation (a Micro Focus company).
 */
package sample.insurance;

import org.junit.Assert;

import com.borland.silk.keyworddriven.annotations.Argument;
import com.borland.silk.keyworddriven.annotations.Keyword;
import com.borland.silk.keyworddriven.annotations.KeywordGroup;
import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.TestObject;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomTextField;

@KeywordGroup("API")
public class LowLevelKeywords {
	private Desktop desktop = new Desktop();

	@Keyword("click")
	public void click(@Argument("Locator or ObjectMapID") String identifier) {
		desktop.<DomElement> find(identifier).click();
	}

	@Keyword("setText")
	public void setText(@Argument("Locator or ObjectMapID") String identifier, @Argument("text") String text) {
		TestObject obj = desktop.find(identifier);
		if (obj instanceof DomTextField)
			desktop.<DomTextField> find(identifier).setText(text);
		else
		desktop.<DomElement> find(identifier).typeKeys(text);
	}

	@Keyword("validate")
	public void validate(@Argument("Locator or ObjectMapID") String identifier, @Argument("property") String property, @Argument("expected results") String expectedValue) {
		Assert.assertEquals(expectedValue, desktop.<DomElement> find(identifier).getProperty(property));
	}

	@Keyword("select")
	public void select(@Argument("Locator or ObjectMapID") String identifier, @Argument("item") String item) {
		TestObject obj = desktop.find(identifier);
		if (obj instanceof DomListBox) {
			((DomListBox) obj).select(item);
		} else {
			obj.getParent().<DomElement> find("/IMG").click();
			desktop.<DomElement> find("//DIV[@textContents='" + item + "']").click();
		}
	}
}
