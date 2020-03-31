package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BasePage.BasePage;
import Utilities.Constants;
import Utilities.ElementUtil;


public class HomePage extends BasePage{

	
	WebDriver driver;
	ElementUtil elementUtil;

	
	By phones=By.xpath("//button[contains(text(),'Phones list')]");
	By smartPhones=By.id("thirdLevel00");
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	public  String getTitle(){
		return elementUtil.waitForGetPageTitle(Constants.HOME_PAGE_TITLE);
	}
	
	public void mouseOver(){
		WebElement element = driver.findElement(phones);
		Actions actions=new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	public void doClick(){
		elementUtil.doClick(smartPhones);
	}
	
	public SmartPhonePage goNextPage(){
		mouseOver();
		doClick();
		return  new SmartPhonePage(driver);
	}
	
	
}
