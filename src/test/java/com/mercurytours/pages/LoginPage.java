package com.mercurytours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="userName")
	public WebElement username;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(name="login")
	public WebElement signin;
	
	public WebElement UserName() {
		return username;
	}
	
	public WebElement Password() {
		return password;
	}
	
	public WebElement SignIn() {
		return signin;
	}
}