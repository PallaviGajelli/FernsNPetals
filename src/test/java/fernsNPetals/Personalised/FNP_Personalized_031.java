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
public class FNP_Personalized_031 extends TestBase{
	@Test
	public void FNP_Personalized_031() throws Exception {
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
//			6.Select suggestions under the textbox
			Thread.sleep(1000);
			GiftPage.clickfirstAddressintheList(driver);
			Thread.sleep(1000);
//			7.Select Delivery date
			GiftPage.selectDate.click();
			Thread.sleep(1000);
			GiftPage.selectDayAfterTomorrow(driver);
			Thread.sleep(1000);
//			8.Select photo In between 100KB to 10MB
			js.executeScript("arguments[0].click();",GiftPage.selectPhoto);
			Thread.sleep(1000);
			Runtime.getRuntime().exec("C:\\Users\\sanjaygajelli\\eclipse-workspace\\FernsNPetals\\AutoITFiles\\selectPic.exe");
			Thread.sleep(2000);
//			9.Enter message in textbox
			////////////////
//			10.click on Add to cart button
			GiftPage.addtocartbutton.click();
//			11.click on continue without add-on
			Thread.sleep(2000);
			GiftPage.addonbutton.click();
			Thread.sleep(2000);
			GiftPage.proceedToCheckoutinTheCartbtn.click();
			Thread.sleep(2000);
//			12.In checkout login page,Click on email id 
//			13.Enter mail id and click on continue button
//			14.Enter Password and click on continue button
			CheckoutPage.loginFnP();
//			*Note:Expected step1 has to be verified
			CheckoutPage.Deliverydetailspageverificationwithoutaddon(driver);
//			
//
//1.Browser should navigate to Delivery details page
//shows the following fields:
//view details button
//Personalize Photo Cushion quantity and price
//Your photo on product
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
