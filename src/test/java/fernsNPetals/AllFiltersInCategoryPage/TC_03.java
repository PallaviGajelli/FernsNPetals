package fernsNPetals.AllFiltersInCategoryPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.FlowersPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

public class TC_03 extends TestBase {
	
	//Verify user able to place a order by selecting filters in Category page	
		@Test
		public void TC_03() throws Exception {
			try {
				
//				1. Launch the FNP Application  in the browser
				initialization();
				HomePage HomePage = new HomePage();
				HomePage = PageFactory.initElements(driver, HomePage.getClass());
				GiftPage GiftPage = new GiftPage();
				GiftPage = PageFactory.initElements(driver, GiftPage.getClass());
				FlowersPage FlowersPage = new FlowersPage();
				FlowersPage = PageFactory.initElements(driver, FlowersPage.getClass());
				CheckoutPage CheckoutPage = new CheckoutPage();
				CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
//				2.Mouse over Anniversary link
				HomePage.mouseHover("anniversarymenu");
				FlowersPage.anniversary_flowers.click();
//				3.Mouse over Gift type link
//				4.Click on Roses
				FlowersPage.mouseHover("GiftTypeFlowers");
				FlowersPage.Roses.click();
//				5.Mouse over Occasion link
				HomePage.mouseHover("occassionsmenu");
				FlowersPage.AnniversaryUnderOccation.isDisplayed();
				System.out.println("Anniversary Under Occation id displayed");
//				6.Mouse over the Delivery city
				FlowersPage.mouseHover("DeliveryCity");
//				7.Click on Bangalore
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", FlowersPage.Bangalore);
				Assert.assertEquals((FlowersPage.DeliveryCity.getText()), "Delivery City\nBangalore");
				System.out.println("It is displaying Selected city under Delivery city Link");
//				8.Click on Recommended drop down
				FlowersPage.recomendedDropDown.click();
//				9.Click on price Low to High
				FlowersPage.PriceLowtoHigh.click();
//				10.Mouse over Price link
				FlowersPage.mouseHover("PriceAnniversary");
//				11.Click on 500+
				FlowersPage.Price500Plus.click();
				Thread.sleep(2000);
				Assert.assertEquals((FlowersPage.PriceAnniversary.getText()), "Price\nGBP 5.81 +");
				System.out.println("It is display the selected cost the under the price link");
//				Note:Expected step1 has to be verified
				//////////////////////
//				14.select any product (EX:Elegance -Pink Rose Bouquet)
				Thread.sleep(1000);
				js.executeScript("arguments[0].click();", FlowersPage.ElegancePinkRosesBouquet);
				
//				15.Enter area name and select delivery date
				GiftPage.navigateToCart(driver);
				GiftPage.sendkeys("searchaddressbox", "kondapur");
				GiftPage.searchaddressbox.sendKeys(Keys.ENTER);
				Assert.assertEquals((GiftPage.searchaddressbox.getAttribute("value")), "Kondapur, Hyderabad, Telangana, India");
				System.out.println("Area name is displayed in the text field");
				//GiftPage.clickfirstAddressintheList(driver);
				Thread.sleep(2000);
				//GiftPage.click("SelectDeliveryDate");
				//GiftPage.selectDayAfterTomorrow(driver);
//				(Ex:select standard delivery date)
				
//				Note:Expected step2 has to be verified
				
//				16.Click on Buy Now button
				js.executeScript("arguments[0].click();", GiftPage.buynowbutton);
				Thread.sleep(2000);
				//GiftPage.click("buynowbutton");
//				17.Click on Continue with one add-on
				GiftPage.click("addoncheckbox");
				GiftPage.click("addonbutton");
//				18.Enter Email id on click on continue button
				Thread.sleep(2000);
				CheckoutPage.sendkeys("loginEmailID", prop.getProperty("mailID"));
				CheckoutPage.click("continuebutton");
//				19.Enter Password and click on continue button
				CheckoutPage.sendkeys("pwd", prop.getProperty("pwd"));
				CheckoutPage.click("continuebutton");
//				20.Click on Add new address and all details and click on save address
				//CheckoutPage.click("addnewaddress");
				CheckoutPage.filladdressToDelivery(driver, "chaya", "Madhapur", "9876543210", "", "test@gmail.com");
				
//				21.Accept terms and conditions 
//				22.Click on Proceed to check out button
				CheckoutPage.placeorder(driver);
				CheckoutPage.paymentOptionspage.isDisplayed();
				System.out.println("Browser is navigate to Payment page");
//				
//				1.It should displays the all selected filters in for the
//				 Category page.
	//
//				2.Area name should displays in the text field.
	//
	//
//				3)Browser should navigate to Payment page
	//
//				4)It should display Thank you page with order id
	//

				
				
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
