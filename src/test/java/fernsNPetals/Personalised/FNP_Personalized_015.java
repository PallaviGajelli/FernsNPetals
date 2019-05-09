package fernsNPetals.Personalised;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.AllPersonalisedGifts;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;
//Verify the functionality of the Proceed To Checkout button in the Delivery details page
public class FNP_Personalized_015 extends TestBase{
	@Test
	public void FNP_Personalized_015() throws Exception {
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
			GiftPage.searchaddressbox.sendKeys(Keys.ENTER);
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
//			12.In checkout login page,Click on email id i.e Existing user
//			13.Enter mail id and click on continue button
//			14.Enter Password and click on continue button
			CheckoutPage.loginFnP();
//			15.select prefix as ms.
			CheckoutPage.selectPrefixAsMs(driver);
//			16.Enter name in the texbox
//			17.Enter recipient's address
//			18.Enter landmark
//			19.Enter mobile number
//			20.Select Address type-Home
//			21.Enter Email
//			22.click on Save address button
			CheckoutPage.filladdressToDelivery(driver, "leena", "pune", "9876543210", "near temple", "test@gmail.Com");
//			23.Click on Free Message Card
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click();", CheckoutPage.FreeMessagecard);
			Thread.sleep(1000);
//			24.Select occasion as Birthday
			CheckoutPage.SelectOccasion.click();
			Thread.sleep(1000);
			CheckoutPage.Occasionbirthday.click();
			Thread.sleep(1000);
//			25.Select message on card
			CheckoutPage.SelectMessageonCard.click();
			Thread.sleep(2000);
			CheckoutPage.SelectfirstMessage.click();
			Thread.sleep(1000);
//			26.Enter Receiver name on card
//			27.Click on save button
			CheckoutPage.saveBtn.click();
			Thread.sleep(1000);
//			28.Click on check box Accept terms and conditions
//			29.Click on Proceed To Checkout button
			CheckoutPage.placeorder(driver);
			Thread.sleep(1000);
//			*Note:Expected step1 has to be verified
			CheckoutPage.verify("paymentOptionspage");
			
//			Browser should navigate 
//			payment page

			
			
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
