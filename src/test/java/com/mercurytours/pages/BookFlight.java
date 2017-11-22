package com.mercurytours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookFlight {
	
	WebDriver driver;
	
	public BookFlight(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="passFirst0")
	public WebElement firstname;
	
	@FindBy(name="passLast0")
	public WebElement lastname;
	
	@FindBy(name="pass.0.meal")
	public WebElement meal;
	
	@FindBy(name="creditCard")
	public WebElement creditcard;
	
	@FindBy(name="creditnumber")
	public WebElement creditnumber;
	
	@FindBy(name="cc_exp_dt_mn")
	public WebElement ccexpmn;
	
	@FindBy(name="cc_exp_dt_yr")
	public WebElement ccexpyr;
	
	@FindBy(name="cc_frst_name")
	public WebElement ccfirstname;
	
	@FindBy(name="cc_last_name")
	public WebElement cclastname;
	
	@FindBy(name="billAddress1")
	public WebElement billadd;
	
	@FindBy(name="billCity")
	public WebElement billcity;
	
	@FindBy(name="billState")
	public WebElement billstate;
	
	@FindBy(name="billZip")
	public WebElement billzip;
	
	@FindBy(name="billCountry")
	public WebElement billcountry;
	
	@FindBy(xpath="\"//input[@name='ticketless']\")[1]")
	public WebElement deladd;
	
	@FindBy(name="buyFlights")
	public WebElement buyflights;
	
	public WebElement FirstName() {
		return firstname;
	}
	
	public WebElement LastName() {
		return lastname;
	}
	
	public void Meal(String meals) {
		Select meal1=new Select(meal);
		meal1.selectByVisibleText(meals);
	}
	
	public void CreditCardType(String cardtype) {
		Select type=new Select(creditcard);
		type.selectByVisibleText(cardtype);
	}
	
	public WebElement CreditNumber() {
		return creditnumber;
	}
	
	public void CrCardExpMonth(String cexpm) {
		Select ccexp=new Select(ccexpmn);
		ccexp.selectByVisibleText(cexpm);
	}
	
	public void CrCardExpYear(String cexpy) {
		Select ccexpy=new Select(ccexpyr);
		ccexpy.selectByVisibleText(cexpy);
	}
	
	public WebElement CrCardFirstName() {
		return ccfirstname;
	}
	
	public WebElement CrCardLastName() {
		return cclastname;
	}
	
	public WebElement BillAddress() {
		return billadd;
	}
	
	public WebElement BillCity() {
		return billcity;
	}
	
	public WebElement BillState() {
		return billstate;
	}
	
	public WebElement BillZip() {
		return billzip;
	}
	
	public void BillCountry(String country) {
		Select bcountry=new Select(billcountry);
		bcountry.selectByVisibleText(country);
	}
	
	public WebElement DelAddress() {
		return deladd;
	}
	
	public WebElement BuyFlights() {
		return buyflights;
	}
}
