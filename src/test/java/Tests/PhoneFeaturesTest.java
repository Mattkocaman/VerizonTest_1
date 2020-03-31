package Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePage.BasePage;
import Pages.HomePage;
import Pages.PhoneFeatures;
import Pages.SmartPhonePage;
import Utilities.Constants;

public class PhoneFeaturesTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	SmartPhonePage smartPhonePage;
	PhoneFeatures phoneFeatures;
	SmartPhonesTest smartPhonesTest;
	
	@BeforeMethod
	public void setUp(){
		basePage=		new BasePage();
		prop=			basePage.initialize_properties();
		driver=			basePage.initialize_driver(prop);
		homePage=new HomePage(driver);
		smartPhonePage=homePage.goNextPage();	
		phoneFeatures=smartPhonePage.doClick();		
	}
	
	@Test(priority=1, description="Verify title")
	public void verifyTitle(){
		String title=	phoneFeatures.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.APPLE_IPHONE11_TITLE);
	}	
	@Test(priority=2,  description="Checking for selections")
	public void features(){
		phoneFeatures.selectColor();
		phoneFeatures.selectCApasity();
		phoneFeatures.selectPrice();
	}
	@Test(priority=3, description="Page 3 test")
	public void allInOne(){
		features();
		phoneFeatures.clickOnContinue();
		phoneFeatures.waitForZipPopUp(prop.getProperty("zip"));
		phoneFeatures.confirmLocation();
		phoneFeatures.clickOnNewCustomer();
	}
	
	@Test(priority=4,description="Run Test Start to Finish")
	public void checkPrice(){
		allInOne();
		String price1=phoneFeatures.getLastPrice();
		String price2=prop.getProperty("iphone11price");
		Assert.assertEquals(price1, price2);
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	
	
	
}
