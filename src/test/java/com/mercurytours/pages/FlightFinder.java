package com.mercurytours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightFinder {
	WebDriver driver;
	
	public FlightFinder (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@value='roundtrip']")
	public WebElement triptype;
	
	@FindBy(name="passCount")
	public WebElement passcount;
		
	@FindBy(name="fromPort")
	public WebElement fromport;
		
	@FindBy(name="fromMonth")
	public WebElement frommonth;
	
	@FindBy(name="fromDay")
	public WebElement fromday;
	
	@FindBy(name="toPort")
	public WebElement toport;
	
	@FindBy(name="toMonth")
	public WebElement tomonth;
	
	@FindBy(name="toDay")
	public WebElement today;
	
	@FindBy(xpath="//input[@value='Business']")
	public WebElement serviceclass;
	
	@FindBy(name="airline")
	public WebElement airlinepreference;
	
	@FindBy(name="findFlights")
	public WebElement findflights;
	
	public WebElement TripType() {
		return triptype;
	}
	
	public void PassCount(String pcount) {
		Select pc = new Select(passcount);
		pc.selectByVisibleText(pcount);
		//return passcount;
	}
	
	public void FromPort(String fport) {
		Select fp=new Select(fromport);
		fp.selectByVisibleText(fport);
		//return fromport;
	}
	public void FromMonth(String fmonth) {
		Select fm=new Select(frommonth);
		fm.selectByVisibleText(fmonth);
		//return frommonth;
	}
	public void FromDay(String fday) {
		Select fd=new Select(fromday);
		fd.selectByVisibleText(fday);
		//return fromday;
	}
	public void ToPort(String tport) {
		Select tp=new Select(toport);
		tp.selectByVisibleText(tport);
		//return toport;
	}
	public void ToMonth(String tmonth) {
		Select tm=new Select(tomonth);
		tm.selectByVisibleText(tmonth);
		//return tomonth;
	}
	public void ToDay(String tday) {
		Select td=new Select(today);
		td.selectByVisibleText(tday);
		//return today;
	}
	
	public WebElement ServiceClass() {
		return serviceclass;
	}
	public void Airline(String air) {
		Select ai=new Select(airlinepreference);
		ai.selectByVisibleText(air);
	}
	public WebElement FindFlights() {
		return findflights;
	}
	

		
}
