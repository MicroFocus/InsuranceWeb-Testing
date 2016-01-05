[ ] // Copyright 2013 Micro Focus. All rights reserved. 
[ ] // Portions Copyright 1992-2009 Borland Software Corporation (a Micro Focus company).
[ ] 
[ ] const wDynamicMainWindow = WebBrowser
[ ] 
[-] window BrowserApplication WebBrowser
	[ ] locator "//BrowserApplication"
	[ ] 
	[ ] // Go to Options -> Application Configurations... to switch the browser
	[ ] // Alternatively set sDir and sCmdLine if you want to start a custom browser
	[ ] 
	[ ] // The working directory of the application when it is invoked
	[ ] // const sDir = "."
	[ ] 
	[ ] // The command line used to invoke the application
	[ ] // const sCmdLine = ""
	[ ] 
	[ ] // The start URL
	[ ] const sUrl = "demo.borland.com/InsuranceWebExtJS"
	[ ] 
	[ ] const bCloseOtherTabs = TRUE
	[ ] 
	[ ] // The list of windows the recovery system is to leave open
	[ ] // const lwLeaveOpenWindows = {?}
	[ ] // const lsLeaveOpenLocators = {?}
	[+] BrowserWindow BrowserWindow
		[ ] locator "//BrowserWindow"
		[+] DomTextField LoginFormEmail
			[ ] locator "input[@id='login-form:email']"
		[+] DomTextField LoginFormPassword
			[ ] locator "input[@id='login-form:password']"
		[+] DomButton LoginFormLogin
			[ ] locator "input[@id='login-form:login']"
		[+] DomListBox QuickLinkJumpMenu
			[ ] locator "select[@id='quick-link:jump-menu']"
		[+] DomTextField AutoquoteZipcode
			[ ] locator "input[@id='autoquote:zipcode']"
		[+] DomTextField AutoquoteeMail
			[ ] locator "input[@id='autoquote:e-mail']"
		[+] DomRadioButton AutoquoteVehicle0
			[ ] locator "input[@id='autoquote:vehicle:0']"
		[+] DomButton AutoquoteNext
			[ ] locator "input[@id='autoquote:next']"
		[+] DomTextField AutoquoteYear
			[ ] locator "input[@id='autoquote:year']"
		[+] DomElement DataImageGifBase6
			[ ] locator "img[@src='data:image/gif;base6*']"
		[+] DomElement Chrysler
			[ ] locator "div[@textContents='Chrysler']"
		[+] DomElement DataImageGifBase62
			[ ] locator "img[@src='data:image/gif;base6*'][2]"
		[+] DomElement Aspen
			[ ] locator "div[@textContents='Aspen']"
		[+] DomRadioButton AutoquoteFinInfo0
			[ ] locator "input[@id='autoquote:finInfo:0']"
		[+] DomElement USD106000
			[ ] locator "b[@textContents='USD 1.060,00']"
		[+] DomLink Home
			[ ] locator "a[@textContents='Home']"
		[+] DomButton LogoutFormLogout
			[ ] locator "input[@id='logout-form:logout']"
		[+] DomTextField AutoquoteAge
			[ ] locator "input[@id='autoquote:age']"
		[+] DomRadioButton AutoquoteGender0
			[ ] locator "input[@id='autoquote:gender:0']"
		[+] DomRadioButton AutoquoteType0
			[ ] locator "input[@id='autoquote:type:0']"
		[+] DomTextField NameSearchLastName
			[ ] locator "input[@id='name-search:lastName']"
		[+] DomButton NameSearchSearchn
			[ ] locator "input[@id='name-search:search-n*']"
		[-] DomElement Walker
			[ ] locator "div[@textContents='Walker']"
[ ] 
[ ] 
