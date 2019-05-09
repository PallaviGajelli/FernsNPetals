package fernsNPetals.Currency;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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
			GiftPage.searchaddressbox.sendKeys("Kondapur");
			Thread.sleep(1000);
			GiftPage.searchaddressbox.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
//			8.Select delivery date
			GiftPage.selectDate.click();
			//js.executeScript("arguments[0].click();", GiftPage.selectDate);
			Thread.sleep(2000);
		    GiftPage.selectDayAfterTomorrow(driver);
//			9.Select shipping method as ‘Stanard delivery’
			js.executeScript("arguments[0].click();", GiftPage.StdDeliveryunderCalender);
			
//			10.Select time slot
			js.executeScript("arguments[0].click();", GiftPage.TSlot12to15undercalender);
		
//			11.Click on ‘ADD TO CART’ button
			js.executeScript("arguments[0].click();", GiftPage.addtocartbutton);
			
//			Note:Expected step1 has to be verified content
			String currencycheck=GiftPage.addonpriceonaddonPage.getText();
			
			Assert.assertEquals(currencycheck.contains("EUR"), true);
			System.out.println("Cart page is available with price for the product Amount price in EUR");
//			12.Click on cotinue with one addon
			Thread.sleep(1000);
			GiftPage.addoncheckbox.click();
			GiftPage.addonbutton.click();
			Thread.sleep(1000);
//			13.Click on the cart icon 
			GiftPage.cartbtn.click();
//			Note:Expected step2 has to be verified
			String crrencycheck1=GiftPage.Amount.getText();
			Assert.assertEquals(crrencycheck1.contains("EUR"), true);
			System.out.println("Total Amount price is in EUR");
			
			String crrencycheck2=GiftPage.subtotalProduct.getText();
			Assert.assertEquals(crrencycheck2.contains("EUR"), true);
			System.out.println("Sub total of product price is in EUR");
			
			String crrencycheck3=GiftPage.subtotaladdon.getText();
			Assert.assertEquals(crrencycheck3.contains("EUR"), true);
			System.out.println("Sub total of addon price is in EUR");
			
			
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
