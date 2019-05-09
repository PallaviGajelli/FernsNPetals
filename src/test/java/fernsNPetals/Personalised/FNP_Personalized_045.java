package fernsNPetals.Personalised;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.AllPersonalisedGifts;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;
//Verify UI of the Delivery Details page
public class FNP_Personalized_045 extends TestBase{
	@Test
	public void FNP_Personalized_045() throws Exception {
		try {
			
//			11.Launch the FNP Application  in the browser
			initialization();
			HomePage HomePage=new HomePage();
			HomePage=PageFactory.initElements(driver, HomePage.getClass());
			AllPersonalisedGifts AllPersonalisedGifts=new AllPersonalisedGifts();
			AllPersonalisedGifts=PageFactory.initElements(driver, AllPersonalisedGifts.getClass());
			GiftPage GiftPage=new GiftPage();
			GiftPage=PageFactory.initElements(driver, GiftPage.getClass());
			CheckoutPage CheckoutPage=new CheckoutPage();
			CheckoutPage=PageFactory.initElements(driver, CheckoutPage.getClass());
//			2.Click on the Personalized  link
			HomePage.mouseHover("personalizedmenu");
//			3.Click on  All Personalised Gifts link 
			AllPersonalisedGifts.allPersonalisedGiftsunderpersonalise.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", AllPersonalisedGifts.lamps);
//			4.Click on Glow Your Memory Personalized Lamp
			js.executeScript("arguments[0].click();", AllPersonalisedGifts.ShiningMemoryPersonalizedLamp);
			GiftPage.navigateToCart(driver);
			Thread.sleep(1000);
//			5.Enter Area/pincode in the texbox
			GiftPage.searchaddressbox.sendKeys("kondapur");
			Thread.sleep(1000);
			
//			6.Select suggestions under the textbox
			GiftPage.clickfirstAddressintheList(driver);
			Thread.sleep(2000);
//			7.Select Delivery date
			GiftPage.datetimeshipping.click();
			Thread.sleep(2000);
			GiftPage.selectDayAfterTomorrow(driver);
			Thread.sleep(2000);
//			8.Select photo in between 100KB-10MB
			GiftPage.selectPhoto.click();
			Thread.sleep(1000);
			Runtime.getRuntime().exec("C:\\Users\\sanjaygajelli\\eclipse-workspace\\FernsNPetals\\AutoITFiles\\selectPic.exe");
			Thread.sleep(2000);
//			10.Click on Buy Now button
			GiftPage.buynowbutton.click();
			Thread.sleep(2000);
//			11.Click on continue with one Add-on
			GiftPage.addoncheckbox.click();
			Thread.sleep(1000);
			GiftPage.addonbutton.click();
			Thread.sleep(2000);
//			11.In checkout login page,Click on email id i.e Existing user
//			12.Enter mail id and click on continue button
//			13.Enter Password and click on continue button
			CheckoutPage.loginFnP();
//			*Note:Expected step1 has to be verified
			CheckoutPage.Deliverydetailspageverification(driver);

//1.Browser should navigate to Delivery details page
//shows the following fields:
//view details button
//Shining Memory Personalized Lamp and price with delete button
//Your message on product
//add-on with quantity and price
//To be delivered between Delivery date and time
//Change button
//Add Delivery address
//Free Message card
//senders details 
//Proceed To checkout button
			
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
