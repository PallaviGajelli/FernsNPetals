package fernsNPetals.Currency;

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
//Verify user able to view the selected currency  in Thank you page
public class TC_05 extends TestBase{
	@Test
	public void TC_05() throws Exception {
		try {
			
//			1. Launch the FNP Application  in the browser
			initialization();
			HomePage HomePage= new HomePage();
			HomePage=PageFactory.initElements(driver, HomePage.getClass());
			FlowersPage FlowersPage=new FlowersPage();
			FlowersPage=PageFactory.initElements(driver, FlowersPage.getClass());
			GiftPage GiftPage=new GiftPage();
			GiftPage=PageFactory.initElements(driver, GiftPage.getClass());
			CheckoutPage CheckoutPage=new CheckoutPage();
			CheckoutPage=PageFactory.initElements(driver, CheckoutPage.getClass());
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
			Thread.sleep(1000);
		    GiftPage.selectDayAfterTomorrow(driver);
			//js.executeScript("arguments[0].click();", GiftPage.selectDate);
			Thread.sleep(2000);
//			9.Select shipping method as ‘Stanard delivery’
			js.executeScript("arguments[0].click();", GiftPage.StdDeliveryunderCalender);
//			10.Select time slot
			js.executeScript("arguments[0].click();", GiftPage.TSlot12to15undercalender);
//			11.Click on ‘Buy Now’ button
			js.executeScript("arguments[0].click();", GiftPage.buynowbutton);
//			12.Click on continue with one add-on
			Thread.sleep(1000);
			GiftPage.addoncheckbox.click();
			GiftPage.addonbutton.click();
//			Note:Expected step1 has to be verified
			GiftPage.VerifyCheckoutPage(driver);
//			13.Enter Email id and click on continue button
//			14.Enter Password and click on continue button
			CheckoutPage.loginFnP();
//			Note:Expected step2 has to be verified
			CheckoutPage.verify("orderenDeliveryDetailsPage");
			Thread.sleep(1000);
//			15.click on new address
//			16.Enter all fields and click on save address button
			CheckoutPage.filladdressToDelivery(driver, "chaya", "Madhapur", "9876543210", "", "test@gmail.com");
			Thread.sleep(1000);
//			17.Click on terms and conditions and click on proceed to checkout button
			CheckoutPage.placeorder(driver);
			Thread.sleep(1000);
			CheckoutPage.paymentOptionspage.isDisplayed();
			System.out.println("paymentOptionspage is displayed");
			
			String a=CheckoutPage.PayBtnonPaymentOptions.getAttribute("class");
			Assert.assertEquals(a.contains("EUR"), true);
			System.out.println("Pay Btn on Payment Options is displyaed with currency EUR");
			
//			
//			1.Browser should navigate to check out login page.
//			2.Browser should navigate to Delivery details page
//			3.Browser should display Thank you page with following fields:
//			Product with EUR price
//			
//			1.https://www.fnp.com/
//				2.Area/city:Kondapur
//				3.Emailid:testqa111@gamil.com
//				4.Password:testqa111
//				5.Name:chaya
//				6.Address:Madhapur
//				7.Mobile no:9876543210
//				8.Email:test@gmail.com
			
			
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
