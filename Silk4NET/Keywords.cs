/**
 * Copyright 2013 Micro Focus. All rights reserved. 
 * Portions Copyright 1992-2009 Borland Software Corporation (a Micro Focus company).
 */

using SilkTest.Ntf;
using Silk.KeywordDriven;
using SilkTest.Ntf.XBrowser;
using Microsoft.VisualStudio.TestTools.UnitTesting;

public class Keywords {
  public enum VehicleType {
    CAR, TRUCK
  }
  public enum Gender {
    MALE, FEMALE
  }
  public enum DrivingRecord {
    EXCELLENT, GOOD, FAIR, POOR
  }
  public enum FinancialInfo {
    OWN, FINANCED, LEASE
  }

  private readonly Desktop _desktop = Agent.Desktop;

  [Keyword("Start application", IsBaseState = true)]
  public void Start_application() {
    // Go to web page 'demo.borland.com/InsuranceWebExtJS'
    BrowserBaseState baseState = new BrowserBaseState();
    baseState.Execute();
  }

  [Keyword]
  public void Login(string email, string password) {
    BrowserApplication webBrowser = _desktop.BrowserApplication("demo_borland_com");

    BrowserWindow browserWindow = webBrowser.BrowserWindow("BrowserWindow");
    browserWindow.DomTextField("login-form email").Click();
    browserWindow.DomTextField("login-form email").SetText(email);
    browserWindow.DomTextField("login-form password").Click();
    browserWindow.DomTextField("login-form password").SetText(password);
    browserWindow.DomButton("login-form login").Click();
  }

  [Keyword("Login as default user")]
  public void SimpleLogin() {
    Login("john.smith@gmail.com", "john");
  }

  [Keyword("Select a service")]
  public void Select_a_service(string service) {
    BrowserApplication webBrowser = _desktop.BrowserApplication("demo_borland_com");

    BrowserWindow browserWindow = webBrowser.BrowserWindow("BrowserWindow");
    browserWindow.DomListBox("quick-link jump-menu").Select(service);
  }

  [Keyword("Search for all agents")]
  public void Search_for_all_agents() {
    BrowserApplication webBrowser = _desktop.BrowserApplication("demo_borland_com");

    BrowserWindow browserWindow = webBrowser.BrowserWindow("BrowserWindow");
    browserWindow.DomButton("show-all search-all").Click();
  }

  [Keyword("Validate that Agent Walker exists")]
  public void Validate_that_Agent_Walker_exists() {
    BrowserApplication webBrowser = _desktop.BrowserApplication("demo_borland_com");

    BrowserWindow browserWindow = webBrowser.BrowserWindow("BrowserWindow");
    Assert.AreEqual("Walker", browserWindow.DomElement("Walker").Text);
  }

  [Keyword]
  public void Logout() {
    BrowserApplication webBrowser = _desktop.BrowserApplication("demo_borland_com");

    var homeLink = webBrowser.Find("BrowserWindow.http   demo borland com InsuranceWebExtJS index jsf", new FindOptions(false)) as DomLink;

    if (homeLink != null) {
      homeLink.Select();
    }

    BrowserWindow browserWindow = webBrowser.BrowserWindow("BrowserWindow");
    browserWindow.DomButton("logout-form logout").Click();
  }

  [Keyword("Fill out user contact data")]
  public void Fill_out_user_contact_data(string zipCode, string email, VehicleType type) {
    BrowserApplication webBrowser = _desktop.BrowserApplication("demo_borland_com");

    BrowserWindow browserWindow = webBrowser.BrowserWindow("BrowserWindow");
    browserWindow.DomTextField("autoquote zipcode").SetText(zipCode);
    browserWindow.DomTextField("autoquote e-mail").SetText(email);

    switch (type) {
      case VehicleType.CAR:
        browserWindow.DomRadioButton("Car").Select();
        break;
      case VehicleType.TRUCK:
        browserWindow.DomRadioButton("Truck").Select();
        break;
    }
    browserWindow.DomButton("autoquote next").Click();
  }

  [Keyword("Fill out user details")]
  public void Fill_out_user_details(int age, Gender gender, DrivingRecord drivingRecord) {
    BrowserApplication webBrowser = _desktop.BrowserApplication("demo_borland_com");

    BrowserWindow browserWindow = webBrowser.BrowserWindow("BrowserWindow");
    browserWindow.DomTextField("autoquote age").SetText(age.ToString());
    switch (gender) {
      case Gender.MALE:
        browserWindow.DomElement("Male").Click();
        break;
      case Gender.FEMALE:
        browserWindow.DomElement("Female").Click();
        break;
    }

    switch (drivingRecord) {
      case DrivingRecord.EXCELLENT:
        browserWindow.DomElement("Excellent").Click();
        break;
      case DrivingRecord.GOOD:
        browserWindow.DomElement("Good").Click();
        break;
      case DrivingRecord.FAIR:
        browserWindow.DomElement("Fair").Click();
        break;
      case DrivingRecord.POOR:
        browserWindow.DomElement("Poor").Click();
        break;
    }

    browserWindow.DomButton("autoquote next").Click();
  }

  [Keyword("Fill out car details")]
  public void Fill_out_car_details(int year, string make, string type, FinancialInfo financialInfo) {
    BrowserApplication webBrowser = _desktop.BrowserApplication("demo_borland_com");

    BrowserWindow browserWindow = webBrowser.BrowserWindow("BrowserWindow");
    browserWindow.DomTextField("autoquote year").SetText(year.ToString());
    browserWindow.DomElement("data image gif;base6").Click();

    (browserWindow.Find(string.Format("//div[@textContents='{0}']", make)) as DomElement).Click();

    browserWindow.DomElement("data image gif;base62").Click();

    (browserWindow.Find(string.Format("//div[@textContents='{0}']", type)) as DomElement).Click();

    switch (financialInfo) {
      case FinancialInfo.OWN:
        browserWindow.DomRadioButton("Own").Select();
        break;
      case FinancialInfo.FINANCED:
        browserWindow.DomRadioButton("Financed").Select();
        break;
      case FinancialInfo.LEASE:
        browserWindow.DomRadioButton("Lease").Select();
        break;
    }

    browserWindow.DomButton("autoquote next").Click();
  }

}