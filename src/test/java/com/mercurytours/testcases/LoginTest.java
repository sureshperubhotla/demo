package com.mercurytours.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mercurytours.pages.LoginPage;
import com.mercurytours.utils.ReadExcel;

public class LoginTest {
	WebDriver driver;
	LoginPage lp;
	ReadExcel config;

	@BeforeMethod
	public void setUp() {
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\G50-70\\Desktop\\BusyQA\\Selenium Jars\\geckodriver.exe");
		//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		lp=new LoginPage(driver);
		driver.get("http://newtours.demoaut.com/");	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test (dataProvider="credentials")
	public void verifyLogin(String username, String password) {
		lp.SignIn().click();		
		lp.UserName().sendKeys(username);
		lp.Password().sendKeys(password);
		lp.SignIn().click();
		
			String expectedTitlePage = "Find a Flight: Mercury Tours:";
			String actualTitlePage = driver.getTitle();
			
			Assert.assertEquals(actualTitlePage,expectedTitlePage);
			driver.quit();
		}
	
	@DataProvider(name="credentials")
	public Object[][] passData() {
		
		config = new ReadExcel(System.getProperty("user.dir")+"\\src\\test\\java\\com\\mercurytours\\properties\\TestData.xlsx");
				
		int rows=config.sheet.getPhysicalNumberOfRows();
		System.out.println(rows);
		int col=config.sheet.getRow(0).getLastCellNum();
		System.out.println(col);
		int rowNum;
		int colNum;
		
		Object[][] data1 = new Object[rows-1][col];
			
		for(rowNum=1; rowNum<rows; rowNum++)
		{
			for(colNum=0; colNum<col; colNum++)
			{
				System.out.print(config.getData(0, rowNum, colNum)+"||");
				data1[rowNum-1][colNum] = config.getData(0, rowNum, colNum);
			}
			System.out.println();
		}
		return data1;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}