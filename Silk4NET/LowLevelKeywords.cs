/**
 * Copyright 2013 Micro Focus. All rights reserved. 
 * Portions Copyright 1992-2009 Borland Software Corporation (a Micro Focus company).
 */

using Silk.KeywordDriven;
using SilkTest.Ntf;
using SilkTest.Ntf.XBrowser;

namespace InsuranceWeb
{
    public class LowLevelKeywords
    {
        [Keyword("Start default browser")]
        public void startBrowser()
        {
            Agent.ExecuteBaseState(new BrowserBaseState());
        }

        [Keyword("Start specific browser")]
        public void startBrowser(BrowserType browserType, string url)
        {
            Agent.ExecuteBaseState(new BrowserBaseState(browserType, url));
        }

        [Keyword("Set text")]
        public void SetText(string locator, string text)
        {
            var obj = Agent.Desktop.Find(locator);
            if (obj is DomTextField)
            {
                ((DomTextField)obj).SetText(text);
            }
        }

        [Keyword("Click")]
        public void Click(string locator)
        {
            var obj = Agent.Desktop.Find(locator);
            if (obj is IClickable)
            {
                ((IClickable)obj).Click();
            }
        }
        [Keyword()]
        public void Select(string locator, string value)
        {
            var obj = Agent.Desktop.Find(locator);
            if (obj is DomListBox)
            {
                ((DomListBox)obj).Select(value);
            }
        }

        [Keyword("Close browser")]
        public void CloseBrowser()
        {
            var obj = Agent.Desktop.Find("//BrowserApplication");

            if (obj is BrowserApplication)
            {
                ((BrowserApplication)obj).CloseSynchron();
            }
        }
    }
}
