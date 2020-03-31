package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import BasePage.BasePage;
import Utilities.Constants;
import Utilities.ElementUtil;

public class SmartPhonePage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	
	By iphone11= By.xpath("//a[@aria-label='Apple iPhone 11']");
	
	public SmartPhonePage(WebDriver driver){
		this.driver=driver;
		elementUtil =new ElementUtil(driver);
	}
	
	public String getTitle(){
		return elementUtil.waitForGetPageTitle(Constants.SMART_PHONES_TITLE);
	}
	
	public PhoneFeatures doClick(){
		elementUtil.doClick(iphone11);
		return new PhoneFeatures(driver);
	}
		
}
