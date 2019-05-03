package fernsNPetals.Currency;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.FlowersPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;
//Verify user able to view the selected currency  in Add to cart page
public class TC_03 extends TestBase {
	@Test
	public void TC_03() throws Exception {
		try {
			
//			1. Launch the FNP Application  in the browser
			initialization();
			HomePage HomePage= new HomePage();
			HomePage=PageFactory.initElements(driver, HomePage.getClass());
			FlowersPage FlowersPage=new FlowersPage();
			FlowersPage=PageFactory.initElements(driver, FlowersPage.getClass());
			GiftPage GiftPage=new GiftPage();
			GiftPage=PageFactory.initElements(driver, GiftPage.getClass());
//			2.Mouse over the currency header
			HomePage.mouseHover("currency_sym");
//			3.Click on ‘EUR-Euro’
			HomePage.Euro.click();
//			4.Mouse over ‘Anniversary ’ link
			HomePage.mouseHover("anniversarymenu");
//			5.Mouse over flowers
			FlowersPage.anniversary_flowers.click();
//			6.Click on ‘Vivd-Red Roses Bouquet ’
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", FlowersPage.VividRedRosesBouquet);
			GiftPage.navigateToCart(driver);
			Thread.sleep(2000);
//			7.Enter Area
			GiftPage.searchaddressbox.sendKeys("");
			
//			8.Select delivery date
//			9.Select shipping method as ‘Stanard delivery’
//			10.Select time slot
//			11.Click on ‘ADD TO CART’ button
//			Note:Expected step1 has to be verified
//			12.Click on cotinue with one addon
//			13.Click on the cart icon 
//			Note:Expected step2 has to be verified
//			
//
//1.Cart page should available with EUR price for the product I.e
//a)Amount price in EUR
//b) Sub total and Total price in EUR
			
			
			
		}catch(Exception e) {
		      throw(e);
		}
		finally {
			 driver.quit();
			 Runtime rt =Runtime.getRuntime();
			 Process proc = rt.exec("taskkill /im chrome.exe /f /t");
		}
	}

}
