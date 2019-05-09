package fernsNPetals.Personalised;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.AllPersonalisedGifts;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

public class FNP_Personalized_007 extends TestBase{
	@Test
	public void FNP_Personalized_007() throws Exception {
		try {
			
//			1.Launch the FNP Application  in the browser
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
			GiftPage.searchaddressbox.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
//			7.Select Delivery date
			GiftPage.datetimeshipping.click();
			Thread.sleep(2000);
			GiftPage.selectDayAfterTomorrow(driver);
			Thread.sleep(2000);
//			8.Select Photo is greater than10MB or lessthan 100KB
			Assert.assertEquals((GiftPage.selectPhoto.getText().contains("File size between 100KB - 10MB. Only JPG or PNG.")), true );
			System.out.println("'File size between 100KB-10MB.only JPG or PNG' msg is displyaed in select photo btn");
			
			Thread.sleep(2000);
			GiftPage.selectPhoto.click();
			Thread.sleep(1000);
			
			
//			*Note:Expected step1 has to be verified
//			9.Select photo In between 100KB to 10MB
			Runtime.getRuntime().exec("C:\\Users\\sanjaygajelli\\eclipse-workspace\\FernsNPetals\\AutoITFiles\\selectPic.exe");
//			10.Click on Add To Cart Button
			Thread.sleep(2000);
		    GiftPage.addtocartbutton.click();
			Thread.sleep(2000);
			GiftPage.addonbutton.click();
			Thread.sleep(2000);
			GiftPage.cartbtn.click();
			Thread.sleep(2000);
//			10.Click on Cart lcon in header tool bar
			GiftPage.cartverification("Shining Memory Personalized Lamp");
//			*Note: Expected step1 has to be verified
			
//			1.Browser should display the details about the product i.e
//			Product name with remove link
//			Send To
//			Quantity 
//			Amount
//			* Shipping charges to be displayed in the Order Summary page
//			sub total 
//			Total
//			Proceed to Checkout button
//			Continue shopping button
			
			
		}catch(Exception e) {
		      throw(e);
		}
//		finally {
//			 driver.quit();
//			 Runtime rt =Runtime.getRuntime();
//			 Process proc = rt.exec("taskkill /im chrome.exe /f /t");
//		}
	}
	

}
