package fernsNPetals.other;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.CheckoutPage;

public class dropDown extends TestBase{
	
	@Test
	public void dropDown() throws InterruptedException {
		
		initialization();
		CheckoutPage CheckoutPage=new CheckoutPage();
		CheckoutPage=PageFactory.initElements(driver, CheckoutPage.getClass());
		driver.get("https://www.fnp.com/control/checkout-page-rj/#/checkout-page?f=d");
		CheckoutPage.loginFnP();
		CheckoutPage.Prefix.click();
		//Actions action = new Actions(driver);
		//action.moveToElement(CheckoutPage.Prefix).build().perform(); 
//		Thread.sleep(2000);
//		CheckoutPage.click("Prefix");
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",CheckoutPage.PrefixMs);
		//CheckoutPage.click("PrefixMs");
		//Select select = new Select(CheckoutPage.Prefix); 
		//select.selectByVisibleText("Ms.");
		//select.selectByIndex(1);
		
	}

}
