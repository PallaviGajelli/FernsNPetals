package fernsNPetals.AllFiltersInCategoryPage;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.FlowersPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

public class TC_04 extends TestBase {
	
		@Test
		public void TC_04() throws Exception {
			
	try {
//		1. Launch the FNP Application  in the browser
		initialization();
		HomePage HomePage = new HomePage();
		HomePage = PageFactory.initElements(driver, HomePage.getClass());
		GiftPage GiftPage = new GiftPage();
		GiftPage = PageFactory.initElements(driver, GiftPage.getClass());
		FlowersPage FlowersPage = new FlowersPage();
		FlowersPage = PageFactory.initElements(driver, FlowersPage.getClass());
		CheckoutPage CheckoutPage = new CheckoutPage();
		CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
//		2.Mouse over Anniversary link
		HomePage.mouseHover("anniversarymenu");
	    FlowersPage.anniversary_flowers.click();
	    Thread.sleep(2000);
///////////changed	
////		3.Mouse over Gift type link
//		FlowersPage.mouseHover("GiftTypeFlowers");
//		
////		4.Click on Roses
//		FlowersPage.Roses.click();
		
////		5.Mouse over Occasion link
//		HomePage.mouseHover("occassionsmenu");
//		FlowersPage.AnniversaryUnderOccation.isDisplayed();
//		System.out.println("Anniversary Under Occation id displayed");
////////////////////
//		6.Mouse over the Delivery city
		FlowersPage.mouseHover("DeliveryCity");
//		7.Click on Bangalore
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", FlowersPage.Bangalore);
		Assert.assertEquals((FlowersPage.DeliveryCity.getText()), "Delivery City\nBangalore");
		System.out.println("It is displaying Selected city under Delivery city Link");
//		8.Click on Recommended drop down
		FlowersPage.recomendedDropDown.click();
//		9.Click on price Low to High
		FlowersPage.PriceLowtoHigh.click();
//		10.Mouse over Price link
		FlowersPage.mouseHover("PriceAnniversary");
//		11.Click on 500+
		FlowersPage.Price500Plus.click();
		
//		12.select any product (EX:Elegance -Pink Rose Bouquet)
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", FlowersPage.ElegancePinkRosesBouquet);
//		13.Enter area name and select delivery date
		GiftPage.navigateToCart(driver);
		GiftPage.sendkeys("searchaddressbox", "kondapur");
		Thread.sleep(1000);
		GiftPage.searchaddressbox.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
//		(Ex:select standard delivery date)
//		14. Click on Buy now  button
		js.executeScript("arguments[0].click();", GiftPage.buynowbutton);
		Thread.sleep(2000);
//		15. Click on Continue without addon-on
		GiftPage.click("addonbutton");
//		16.Enter Invalid Mail id and click on continue button
		CheckoutPage.sendkeys("loginEmailID", "sdadfdaedQWD");
		CheckoutPage.click("continuebutton");
		CheckoutPage.verify("checklogin");
		CheckoutPage.loginEmailID.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));	 
		  Thread.sleep(1000);
//		Note:Expected step1 has to be verified
//		17.Enter valid mail id and Password and click on continue button
		CheckoutPage.loginFnP("Testbsurnameb@gmail.com","Bleena@123");
		Thread.sleep(1000);
//		18.Click on Add new address and leave the all fields empty and click on continue button
		CheckoutPage.filladdressToDelivery(driver, "", "", "", "", "");
		Thread.sleep(1000);
//		Note:Expected step2 has to be verified
		CheckoutPage.verify("EmptyAddressAlertMsg");
//		19.Enter data in all fields and click on Save button.
		CheckoutPage.filladdressToDelivery(driver, "chaya", "Madhapur", "9876543210", "", "test@gmail.com");
		Thread.sleep(1000);
//		20.Accept terms and conditions 
//		And click on Proceed to pay button
		CheckoutPage.placeorder(driver);
		CheckoutPage.paymentOptionspage.isDisplayed();
		System.out.println("Browser is navigate to Payment page");
		Thread.sleep(1000);
		CheckoutPage.deleteAddAndProductWithoutaddonFromCheckout();
//		
//		1.It should validation message ‘Please
//		 Enter valid mail id’
//		2.It should display validation message ‘enter Recipients name’
//
//		3.It should display Thank you page
//		
//		1.https://www.fnp.com/
//			2.Area/city:Kondapur
//			3.Email id:testqa111@gamil.com
//			4.Password:testqa111
//			5.Name:chaya
//			6.Address:Madhapur
//			7.Mobile no:9876543210
//			8.Email:test@gmail.com
		
		
		
	}catch(Exception e) {
	      throw(e);
	}
//finally {
//		 driver.quit();
//		 Runtime rt =Runtime.getRuntime();
//		 Process proc = rt.exec("taskkill /im chrome.exe /f /t");
//	}
}

}
