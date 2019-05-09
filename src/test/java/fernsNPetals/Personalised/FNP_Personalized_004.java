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
//Verify UI of the Gift Booking window
public class FNP_Personalized_004 extends TestBase{
	@Test
	public void FNP_Personalized_004() throws Exception {
		try {

//			1. Launch the FNP Application  in the browser
			initialization();
			HomePage HomePage=new HomePage();
			HomePage=PageFactory.initElements(driver, HomePage.getClass());
			AllPersonalisedGifts AllPersonalisedGifts=new AllPersonalisedGifts();
			AllPersonalisedGifts=PageFactory.initElements(driver, AllPersonalisedGifts.getClass());
			GiftPage GiftPage=new GiftPage();
			GiftPage=PageFactory.initElements(driver, GiftPage.getClass());
			CheckoutPage CheckoutPage=new CheckoutPage();
			CheckoutPage=PageFactory.initElements(driver, CheckoutPage.getClass());
//			2. Click on the Personalized  link
			HomePage.mouseHover("personalizedmenu");
//			3.Click on  All Personalised Gifts link
			AllPersonalisedGifts.allPersonalisedGiftsunderpersonalise.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", AllPersonalisedGifts.lamps);
			
			
//			4.Click on Glow Your Memory Personalized Lamp
			js.executeScript("arguments[0].click();", AllPersonalisedGifts.ShiningMemoryPersonalizedLamp);
			GiftPage.navigateToCart(driver);
			Thread.sleep(1000);
			GiftPage.giftwindowVerification("Shining Memory Personalized Lamp");
//			Browser should display the following fields in the gift booking window:
//				a) Home> Glow Your Memory Personalized Lamp  Shining Memory Personalized Lamp
			
//				b) Glow Your Memory Personalized Lamp,Cost,Reviews
//				c) Area/ pin code text box
//				d) ADD TO CART button
//				e) BUY NOW button
			
			
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
