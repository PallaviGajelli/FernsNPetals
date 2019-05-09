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
//Verify the functionality of the Add To Cart button with entering data by selecting Add-on
public class FNP_Personalized_036 extends TestBase{
	@Test
	public void FNP_Personalized_036() throws Exception {
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
//			4.Click on Shining Memory Personalized Lamp 
			js.executeScript("arguments[0].click();", AllPersonalisedGifts.ShiningMemoryPersonalizedLamp);
			GiftPage.navigateToCart(driver);
			Thread.sleep(2000);
//			5.Enter Area/pincode in the textbox
			GiftPage.searchaddressbox.sendKeys("Kondapur");
			Thread.sleep(1000);
//			6.Select suggestions under the textbox
			GiftPage.clickfirstAddressintheList(driver);
			Thread.sleep(1000);
//			7.Select Delivery date
			GiftPage.datetimeshipping.click();
			Thread.sleep(2000);
			GiftPage.selectDayAfterTomorrow(driver);
			Thread.sleep(2000);
//			8.Enter message in the textbox
			GiftPage.selectPhoto.click();
			Thread.sleep(1000);
			Runtime.getRuntime().exec("C:\\Users\\sanjaygajelli\\eclipse-workspace\\FernsNPetals\\AutoITFiles\\selectPic.exe");
			Thread.sleep(2000);
//			9.click on Add To Cart button
			GiftPage.addtocartbutton.click();
			Thread.sleep(3000);
//			10.Click on continue with Add-on
			GiftPage.withoutaddonbutton.click();
			Thread.sleep(2000);
//			*Note:Expected step1 has to be verified
			GiftPage.vrify("product_AddedToCart");
//			Browser should display the Added product in the Cart 
			
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
