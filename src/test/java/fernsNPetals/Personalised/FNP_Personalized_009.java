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

//Verify user able to Edit the pin code in Gift booking window
public class FNP_Personalized_009 extends TestBase {
	
	@Test
	public void FNP_Personalized_009() throws Exception {
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
//			5.Enter valid pin-code in text box
			GiftPage.searchaddressbox.sendKeys("500084");
			Thread.sleep(1000);

			Assert.assertEquals((GiftPage.hybd500084.getText().contains("Hyderabad, Telangana, India")), true);
//			*Note:Executed step1 has to be verified
			System.out.println("Browser is displaying suggestions under the pin code textbox: 500084,Hyderabad,Telngana,India ");
//			6.Clear the data and enter Invalid pin code
			GiftPage.searchaddressbox.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Thread.sleep(1000);
			GiftPage.searchaddressbox.sendKeys("sdfgsdfgs");
			Thread.sleep(1000);
//			*Note:Executed step2 has to be verified
			Assert.assertEquals((GiftPage.addressSuggestions.getText().isEmpty()), true);
			System.out.println("Browser is not displaying suggestions under the pin code textbox ");
			Thread.sleep(1000);
//			7.Clear the data and Enter pin 533249
			GiftPage.searchaddressbox.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Thread.sleep(1000);
			GiftPage.searchaddressbox.sendKeys("533249");
			Thread.sleep(1000);
			
			Assert.assertEquals((GiftPage.hybd533249.getText().contains("Andhra Pradesh, India")), true);
			System.out.println("Browser is displaying suggestions under the pin code textbox: 533249,AndharPradesh,India ");
			
//			*Note:Executed step3 has to be verified.
			
//			1.Browser should display suggestions under the pin code textbox
//			500084,Hyderabad,Telngana,India
//			2.Browser should not display any suggestions
//			3.Browser should display suggestions under the textbox
//			533249,AndharPradesh,India
			
			
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
