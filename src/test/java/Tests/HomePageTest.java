package Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePage.BasePage;
import Pages.HomePage;
import Utilities.Constants;

public class HomePageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	HomePage homePage;
	


	@BeforeMethod
	public void setup(){
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);		
		homePage= new HomePage(driver);
	}
	
	@Test(priority=1,description="Get home page title")
	public void checkTitle(){
		String title = homePage.getTitle();
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority=2,description="Open & select main page dropDown menu")
	public void invisibleDropDownSelect(){
		homePage.mouseOver();
		homePage.doClick();
	}
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}	
}
