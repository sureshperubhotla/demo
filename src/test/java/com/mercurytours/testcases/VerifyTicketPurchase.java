package com.mercurytours.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mercurytours.pages.BookFlight;
import com.mercurytours.pages.FlightFinder;
import com.mercurytours.pages.LoginPage;
import com.mercurytours.pages.SelectFlight;

public class VerifyTicketPurchase {
	WebDriver driver = null;
	FlightFinder ff;
	LoginPage lp;
	SelectFlight sf;
	BookFlight bf;
	
	@BeforeTest
	public void setUp() {
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\G50-70\\Desktop\\BusyQA\\Selenium Jars\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		lp=new LoginPage(driver);
		ff=new FlightFinder(driver);
		sf=new SelectFlight(driver);
		bf=new BookFlight(driver);
		driver.get("http://newtours.demoaut.com/");		
	}
	
	@Test
	public void verifyLogin() {
		lp.UserName().sendKeys("tutorial");
		lp.Password().sendKeys("tutorial");
		lp.SignIn().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void verifyPurchase() {
		ff.TripType().click();
		ff.PassCount("1");
		ff.FromPort("London");
		ff.FromMonth("May");
		ff.FromDay("10");
		ff.ToPort("Zurich");
		ff.ToMonth("May");
		ff.ToDay("30");
		ff.ServiceClass().click();
		ff.Airline("No Preference");
		ff.FindFlights().click();
		
		sf.DepartFlight().click();
		sf.ReturnFlight().click();
		sf.ReserveFlight().click();
		
		bf.FirstName().sendKeys("Naresh");
		bf.LastName().sendKeys("Prajapati");
		bf.Meal("Vegetarian");
		bf.CreditCardType("American Express");
		bf.CreditNumber().sendKeys("123456789 ");
		bf.CrCardExpMonth("01");
		bf.CrCardExpYear("2000");
		bf.CrCardFirstName().sendKeys("Naresh");
		bf.CrCardLastName().sendKeys("Prajapati");
		bf.BillAddress().clear();
		bf.BillAddress().sendKeys("1200 Howard Street West");
		bf.BillCity().clear();
		bf.BillCity().sendKeys("London");
		bf.BillState().clear();
		bf.BillState().sendKeys("Ontario");
		bf.BillZip().clear();
		bf.BillZip().sendKeys("LX9 9V0");
		bf.BillCountry("CANADA");
		//bf.DelAddress().click();
		bf.BuyFlights().click();	
		
			String expectedText = "Your itinerary has been booked!";
			WebElement el=driver.findElement(By.xpath("//font[contains(text(),'Your ')]"));
			String actualText = el.getText();

			Assert.assertEquals(actualText,expectedText);
			
			/*if(expectedText.equals(actualText)) {
				System.out.println("Test passed : Your itinerary has been booked");
			}else {
				System.out.println("Ticket Purchase Unsuccessful:"+actualText);
			}*/
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}