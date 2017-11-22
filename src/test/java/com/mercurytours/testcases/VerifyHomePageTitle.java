package com.mercurytours.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyHomePageTitle {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\G50-70\\Desktop\\BusyQA\\Selenium Jars\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void pageTitle() {
		
		String expectedTitle="Welcome: Mercury Tours";
		String actualTitle=driver.getTitle();
		
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Test Passed");
		}else {
			System.out.println("Test Failed");
		}
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}