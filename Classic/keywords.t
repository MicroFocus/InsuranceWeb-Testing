[ ] // Copyright 2013 Micro Focus. All rights reserved. 
[ ] // Portions Copyright 1992-2009 Borland Software Corporation (a Micro Focus company).
[ ] 
[-] keyword login(string userName, string password) alias "Login"
	[ ] WebBrowser.BrowserWindow.LoginFormEmail.Click()
	[ ] WebBrowser.BrowserWindow.LoginFormEmail.SetText(userName)
	[ ] WebBrowser.BrowserWindow.LoginFormPassword.SetText(password)
	[ ] WebBrowser.BrowserWindow.LoginFormLogin.Click()
[ ] 
[-] keyword go_to_Auto_Quote() alias "Go to Auto Quote"
	[ ] WebBrowser.BrowserWindow.QuickLinkJumpMenu.Select("Auto Quote")
[ ] 
[-] keyword fill_in_initial_data() alias "Fill in initial data"
	[ ] WebBrowser.BrowserWindow.AutoquoteZipcode.SetText("4020")
	[ ] WebBrowser.BrowserWindow.AutoquoteeMail.Click()
	[ ] WebBrowser.BrowserWindow.AutoquoteeMail.SetText("john.smith@gmail.com")
	[ ] WebBrowser.BrowserWindow.AutoquoteVehicle0.Select()
	[ ] WebBrowser.BrowserWindow.AutoquoteNext.Click()
	[ ] 
[-] keyword fill_in_car_data() alias "Fill in car data"
	[ ] WebBrowser.BrowserWindow.AutoquoteYear.Click()
	[ ] WebBrowser.BrowserWindow.AutoquoteYear.SetText("1999")
	[ ] WebBrowser.BrowserWindow.DataImageGifBase6.Click()
	[ ] WebBrowser.BrowserWindow.Chrysler.Click()
	[ ] WebBrowser.BrowserWindow.DataImageGifBase62.Click()
	[ ] WebBrowser.BrowserWindow.Aspen.Click()
	[ ] WebBrowser.BrowserWindow.AutoquoteFinInfo0.Select()
	[ ] WebBrowser.BrowserWindow.AutoquoteNext.Click()
[ ] 
[-] keyword validate_quote() alias "Validate quote"
	[-] WebBrowser.BrowserWindow.USD106000.VerifyProperties({...})
		[ ] ""
		[-] {...}
				[ ] {"Text",		"USD 1.060,00"}
[ ] 
[-] keyword go_to_home_page() alias "Go to home page"
	[ ] WebBrowser.BrowserWindow.Home.Click()
[ ] 
[-] keyword logout() alias "Logout"
	[ ] WebBrowser.BrowserWindow.LogoutFormLogout.Click()
[ ] 
[-] keyword fill_in_personal_data() alias "Fill in personal data"
	[ ] WebBrowser.BrowserWindow.AutoquoteAge.Click()
	[ ] WebBrowser.BrowserWindow.AutoquoteAge.SetText("27")
	[ ] WebBrowser.BrowserWindow.AutoquoteGender0.Select()
	[ ] WebBrowser.BrowserWindow.AutoquoteType0.Select()
	[ ] WebBrowser.BrowserWindow.AutoquoteNext.Click()
[ ] 
[-] keyword go_to_Agent_Lookup() alias "Go to Agent Lookup"
	[ ] WebBrowser.BrowserWindow.QuickLinkJumpMenu.Select("Agent Lookup")
[ ] 
[-] keyword void SearchForAgentWalker() alias "Search for Agent Walker"
	[ ] WebBrowser.BrowserWindow.NameSearchLastName.Click()
	[ ] WebBrowser.BrowserWindow.NameSearchLastName.SetText("Walker")
	[ ] WebBrowser.BrowserWindow.NameSearchSearchn.Click()
	[ ] 
[-] keyword void VerifyAgentWalkerExists() alias "Verify Agent Walker exists"
	[-] WebBrowser.BrowserWindow.Walker.VerifyProperties({...})
			[ ] ""
			[-] {...}
					[ ] {"Text",		"Walker"}
	[ ] 
[-] keyword void CloseApplication() alias "Close application"
	[ ] WebBrowser.Close()
