package com.mercurytours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFlight {
	WebDriver driver;
	
	public SelectFlight(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@value='Blue Skies Airlines$361$271$7:10']")
	public WebElement departflight;
	
	@FindBy(xpath="//input[@value='Unified Airlines$633$303$18:44']")
	public WebElement returnflight;
	
	@FindBy(name="reserveFlights")
	public WebElement reserveflights;
	
	public WebElement DepartFlight() {
		return departflight;
	}
	
	public WebElement ReturnFlight() {
		return returnflight;
	}
	
	public WebElement ReserveFlight() {
		return reserveflights;
	}
}