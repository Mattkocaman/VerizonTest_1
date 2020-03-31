package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import BasePage.BasePage;
import Utilities.Constants;
import Utilities.ElementUtil;

public class PhoneFeatures extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	
	
	By yellowColor= 	By.xpath("//div/label[contains(text(),'Green')]");
	By capasity=		By.xpath("//div/p[contains(text(),'256GB')]");
	By price=			By.xpath("//div/div[contains(text(),' Retail price')]");
	By continueBtn=		By.xpath("//div/button[@id='ATC-Btn']");
	By zipCode=			By.xpath("//div/input[@id='zipcode']");
	By confirmLocation=	By.xpath("//button[@type='submit']");
	By newCustomer=		By.xpath("//div/button[@aria-label='New Customer']");
	
	By lastPrice=			By.xpath("//p/span[contains(text(),'$849.99')]");
	
	
	public PhoneFeatures(WebDriver driver){
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	public String getTitle(){
		return elementUtil.waitForGetPageTitle(Constants.APPLE_IPHONE11_TITLE);
	}
	
	public void selectColor(){
		elementUtil.doClick(yellowColor);
	}
	public void selectCApasity(){
		elementUtil.doClick(capasity);
	}
	public void selectPrice(){
		elementUtil.doClick(price);
	}
	public void clickOnContinue(){
		elementUtil.doClick(continueBtn);
	}
	
	public void waitForZipPopUp(String zip){
		elementUtil.waitForElementPresent(zipCode);
		elementUtil.doSendKeys(zipCode, zip);
	}
	public void confirmLocation(){
		elementUtil.doClick(confirmLocation);
	}
	public void clickOnNewCustomer(){
		elementUtil.doClick(newCustomer);
	}
	
	public String getLastPrice(){
		return elementUtil.getElement(lastPrice).getText();
	}
	
	
}
