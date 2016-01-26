/**
 * Copyright 2013 Micro Focus. All rights reserved. 
 * Portions Copyright 1992-2009 Borland Software Corporation (a Micro Focus company).
 */

using SilkTest.Ntf;
using Silk.KeywordDriven;
using SilkTest.Ntf.XBrowser;
using Microsoft.VisualStudio.TestTools.UnitTesting;

public class Keywords
{
    public enum VehicleType
    {
        CAR, TRUCK
    }
    public enum Gender
    {
        MALE, FEMALE
    }
    public enum DrivingRecord
    {
        EXCELLENT, GOOD, FAIR, POOR
    }
    public enum FinancialInfo
    {
        OWN, FINANCED, LEASE
    }

    private readonly Desktop _desktop = Agent.Desktop;

    [Keyword("Start application", IsBaseState = true)]
    public void Start_application()
    {
        // Go to web page 'demo.borland.com/InsuranceWebExtJS'
        BrowserBaseState baseState = new BrowserBaseState();
        baseState.Execute();
    }

    [Keyword]
    public void Login(string email, string password)
    {
        BrowserWindow browserWindow = _desktop.BrowserWindow("Web");
        browserWindow.DomTextField("Login.EMail").SetText(email);
        browserWindow.DomTextField("Login.Password").SetText(password);
        browserWindow.DomButton("Login.Login").Click();
    }

    [Keyword("Login as default user")]
    public void SimpleLogin()
    {
        Login("john.smith@gmail.com", "john");
    }

    [Keyword("Select a service")]
    public void Select_a_service(string service)
    {
        BrowserWindow browserWindow = _desktop.BrowserWindow("Web");
        browserWindow.DomListBox("QuickJump").Select(service);
    }

    [Keyword("Search for all agents")]
    public void Search_for_all_agents()
    {
        BrowserWindow browserWindow = _desktop.BrowserWindow("Web");
        browserWindow.DomButton("SearchAll").Click();
    }

    [Keyword("Validate that Agent Walker exists")]
    public void Validate_that_Agent_Walker_exists()
    {
        BrowserWindow browserWindow = _desktop.BrowserWindow("Web");
        TestObject walker = browserWindow.Find("//DIV[@textContents='Walker']", new FindOptions(false, 5000));
        Assert.IsNotNull(walker);
    }

    [Keyword]
    public void Logout()
    {
        BrowserWindow browserWindow = _desktop.BrowserWindow("Web");
        browserWindow.DomLink("Home").Select();
        browserWindow.DomButton("Logout").Click();
    }

    [Keyword("Fill out user contact data")]
    public void Fill_out_user_contact_data(string zipCode, string email, VehicleType type)
    {
        BrowserWindow browserWindow = _desktop.BrowserWindow("Web");
        browserWindow.DomTextField("AutoQuote.ZipCode").SetText(zipCode);
        browserWindow.DomTextField("AutoQuote.EMail").SetText(email);

        switch (type)
        {
            case VehicleType.CAR:
                browserWindow.DomRadioButton("AutoQuote.Vehicle.Car").Select();
                break;
            case VehicleType.TRUCK:
                browserWindow.DomRadioButton("AutoQuote.Vehicle.Truck").Select();
                break;
        }
        browserWindow.DomButton("AutoQuote.Next").Click();
    }

    [Keyword("Fill out user details")]
    public void Fill_out_user_details(int age, Gender gender, DrivingRecord drivingRecord)
    {
        BrowserWindow browserWindow = _desktop.BrowserWindow("Web");
        browserWindow.DomTextField("AutoQuote.Age").SetText(age.ToString());
        switch (gender)
        {
            case Gender.MALE:
                browserWindow.DomElement("AutoQuote.Gender.Male").Click();
                break;
            case Gender.FEMALE:
                browserWindow.DomElement("AutoQuote.Gender.Female").Click();
                break;
        }

        switch (drivingRecord)
        {
            case DrivingRecord.EXCELLENT:
                browserWindow.DomElement("//INPUT[@id='autoquote:type:0']").Click();
                break;
            case DrivingRecord.GOOD:
                browserWindow.DomElement("//INPUT[@id='autoquote:type:1']").Click();
                break;
            case DrivingRecord.FAIR:
                browserWindow.DomElement("//INPUT[@id='autoquote:type:2']").Click();
                break;
            case DrivingRecord.POOR:
                browserWindow.DomElement("//INPUT[@id='autoquote:type:3']").Click();
                break;
        }

        browserWindow.DomButton("AutoQuote.Next").Click();
    }

    [Keyword("Fill out car details")]
    public void Fill_out_car_details(int year, string make, string type, FinancialInfo financialInfo)
    {
        BrowserWindow browserWindow = _desktop.BrowserWindow("Web");
        browserWindow.DomTextField("//INPUT[@id='autoquote:year']").SetText(year.ToString());
        
      
		browserWindow.DomElement("//IMG[@class='x-form-trigger x-for*']").DomClick();
		(browserWindow.Find(string.Format("//div[@textContents='{0}']", make)) as DomElement).Click();

		browserWindow.DomElement("//IMG[@class='x-form-trigger x-for*'][2]").DomClick();
		(browserWindow.Find(string.Format("//div[@textContents='{0}']", type)) as DomElement).Click();
		
        switch (financialInfo)
        {
            case FinancialInfo.OWN:
                browserWindow.DomRadioButton("//INPUT[@id='autoquote:finInfo:0']").Select();
                break;
            case FinancialInfo.FINANCED:
                browserWindow.DomRadioButton("//INPUT[@id='autoquote:finInfo:1']").Select();
                break;
            case FinancialInfo.LEASE:
                browserWindow.DomRadioButton("//INPUT[@id='autoquote:finInfo:2']").Select();
                break;
        }

        browserWindow.DomButton("AutoQuote.Next").Click();
    }

}