package Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePage.BasePage;
import Pages.HomePage;
import Pages.SmartPhonePage;
import Utilities.Constants;

public class SmartPhonesTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	SmartPhonePage smartPhonePage;
	
	HomePage homePage;
	
	@BeforeMethod
	public void setUp(){
		basePage=new BasePage();
		prop=basePage.initialize_properties();
		driver=basePage.initialize_driver(prop);		
		homePage=new HomePage(driver);
		smartPhonePage=homePage.goNextPage();
	}
	
	@Test(priority=1,description="Get home page title")
	public void  getTitle(){
		String title=smartPhonePage.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.SMART_PHONES_TITLE);
	}
	@Test(priority=2,description="Click on Iphone 11")
	public void clickIphone11(){
		smartPhonePage.doClick();
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
		
}
