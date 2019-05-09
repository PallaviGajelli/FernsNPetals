package fernsNPetals.Personalised;

import java.io.IOException;

import org.apache.commons.lang.RandomStringUtils;
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
//Verify user able to Register with  unregistered  Email id in the checkout login/ Sign up page
public class FNP_Personalized_044 extends TestBase{
	@Test
	public void FNP_Personalized_044() throws Exception {
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
			Thread.sleep(3000);
//			9.Enter message in textbox
//			10.click on Buy Now button
			GiftPage.buynowbutton.click();
			Thread.sleep(2000);
//			11.click on continue without add-on
			GiftPage.withoutaddonbutton.click();
			Thread.sleep(1000);
			
//			12.Enter new email id and click on continue button i.e New mail id
			String randomString = RandomString();
			CheckoutPage.loginEmailID.sendKeys("testabcd"+randomString+"@abcd.com");
			Thread.sleep(1000);
			CheckoutPage.continuebutton.click();
//			*Note:Expected step1 has to be verified
			CheckoutPage.verify("registrationPage");
			Thread.sleep(1000);
//			13.Enter name
			CheckoutPage.regname.sendKeys("leena");
//			14.Enter mobile number
			CheckoutPage.regmobile.sendKeys("9876543210");
			Thread.sleep(1000);
//			15.Click on create password and enter 1234
			CheckoutPage.regPassword.sendKeys("1234");
			Thread.sleep(1000);
			CheckoutPage.continuebutton.click();
			Thread.sleep(1000);
//			*Note:Expected step2 has to be verified
			Assert.assertEquals((CheckoutPage.Atleast6characters.getText().contentEquals("At least 6 characters")), true);
			System.out.println("Browser should display an error message 'At least 6 characters'");
//			16.Enter 6 characters and click on continue button
			//CheckoutPage.regPassword.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			CheckoutPage.regPassword.sendKeys("123456");
			Thread.sleep(1000);
			CheckoutPage.continuebutton.click();
			Thread.sleep(1000);
//			*Note:Expected step3 has to be verified
			CheckoutPage.verify("orderenDeliveryDetailsPage");
//			1.Browser displays Registration window
//			2.Browser should display an error message
//			'At least 6 characters'
//			3.Browser should navigate to Order & Delivery details page
			
		}catch(Exception e) {
		      throw(e);
		}
		finally {
			 driver.quit();
			 Runtime rt =Runtime.getRuntime();
			 Process proc = rt.exec("taskkill /im chrome.exe /f /t");
		}
	}
	public static String RandomString()
	{
		int length = 5;
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		// System.out.println(generatedString);
		return generatedString;
	}
}
