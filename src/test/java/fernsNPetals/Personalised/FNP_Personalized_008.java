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
//Verify User able to Remove the Product in the Cart page
public class FNP_Personalized_008 extends TestBase {
	@Test
	public void FNP_Personalized_008() throws Exception {
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
//			9.Click on Add to cart button
			Thread.sleep(2000);
		    GiftPage.addtocartbutton.click();
			Thread.sleep(2000);
			GiftPage.addonbutton.click();
			Thread.sleep(2000);
			
//			10.Click on Cart lcon in header tool bar
			GiftPage.cartbtn.click();
			Thread.sleep(1000);
//			11.Click on Remove link
			GiftPage.delete_item_0.click();
			Thread.sleep(1000);
//			*Note:Expected step1 has to be verified
			Assert.assertEquals((GiftPage.deletedialog.getText().contains("Delete this Item?")), true);
			System.out.println("Delete this Item? dialog box is displayed ");
			Thread.sleep(1000);
			
			
//			12.Click on OK button
			GiftPage.deleteYesBtn.click();
			
//			*Note:Expected step2 has to be verified
			Thread.sleep(1000);
			Assert.assertEquals((GiftPage.urCartisEmpty.isDisplayed()), true); 
			System.out.println("Your cart is empty msg is displayed");
//			
//			1.Browser should displays an Alert message
//			'Are you sure you want to delete? ' 
//			2.Browser should display an window which shows an message i.e:
//			'Your cart is empty,so its sad  and lonely'
			
			
			
			
			
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
