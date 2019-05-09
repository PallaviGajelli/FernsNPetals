package fernsNPetals.Personalised;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.AllPersonalisedGifts;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;
//Verify 'Buy Now' button functionality by Entering data with selecting Add-on
public class FNP_Personalized_026 extends TestBase{
	@Test
	public void FNP_Personalized_026() throws Exception {
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
			js.executeScript("arguments[0].click();", AllPersonalisedGifts.Cushions);
//			4.Click on Personalize Photo Cushion
			js.executeScript("arguments[0].click();", AllPersonalisedGifts.PersonalisedPhotographCushion);
			GiftPage.navigateToCart(driver);
			Thread.sleep(2000);
//			5.Enter Area/pincode in the textbox
			GiftPage.searchaddressbox.sendKeys("delhi");
			Thread.sleep(1000);
//			6.Select suggestions under the textbox
			GiftPage.clickfirstAddressintheList(driver);
			Thread.sleep(1000);
//			7.Select Delivery date
			GiftPage.selectDate.click();
			Thread.sleep(1000);
			GiftPage.selectDayAfterTomorrow(driver);
			Thread.sleep(1000);
//			8.Select photo between 100KB-10MB
			GiftPage.selectPhoto.click();
			Thread.sleep(1000);
			Runtime.getRuntime().exec("C:\\Users\\sanjaygajelli\\eclipse-workspace\\FernsNPetals\\AutoITFiles\\selectPic.exe");
			Thread.sleep(2000);

//			11.Enter message in textbox
//			12.click on Buy Now button
			GiftPage.buynowbutton.click();
			Thread.sleep(2000);
//			13.click on continue without add-on
			GiftPage.addonbutton.click();
			Thread.sleep(1000);
//			*Note:Expected step1 has to be verified
			GiftPage.VerifyCheckoutPage(driver);
//			Browser should navigate to Login/Sign up page
			
			
			
			
			
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
