package fernsNPetals.Gobal_USA;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.FlowersUSA;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;
//Verify User able to view the Delivery date & Time in the gift booking window
public class FNP_Global_flowUSA_009 extends TestBase{
	@Test
	public void FNP_Global_flowUSA_009() throws Exception {
		try {
			
//			1.Launch the FNP Application  in the browser
			initialization();
			HomePage HomePage=new HomePage();
			HomePage=PageFactory.initElements(driver, HomePage.getClass());
			FlowersUSA FlowersUSA=new FlowersUSA();
			FlowersUSA=PageFactory.initElements(driver, FlowersUSA.getClass());
			GiftPage GiftPage=new GiftPage();
			GiftPage=PageFactory.initElements(driver, GiftPage.getClass());
			JavascriptExecutor js = (JavascriptExecutor) driver;
//			2.Click on the GLOBAL  link
			HomePage.mouseHover("globalmenu");
			Thread.sleep(2000);
//			3.Click on  flowers USA link
			js.executeScript("arguments[0].click();", FlowersUSA.flowsersUSAunderGlobal);
			Thread.sleep(2000);
//			4.Click on any flower ex: 100 Long Stem Red Roses
			js.executeScript("arguments[0].click();", FlowersUSA.LongStemRedRoses100);
			Thread.sleep(1000);
			GiftPage.navigateToCart(driver);
//			5.Enter city in the textbox
			GiftPage.sendkeys("searchaddressbox", "Los Angeles");
			Thread.sleep(1000);
//			6.select the suggestions displayed under the texbox
			GiftPage.searchaddressbox.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
//			7.select shipping method as 
//			Mid Night Delivery
			GiftPage.SelectDeliveryDate.click();
			Thread.sleep(3000);
			GiftPage.NextDayDelivery.click();
			Thread.sleep(3000);
//			8.select delivery date
			GiftPage.allreadySelectedDate.click();
			String date=GiftPage.allreadySelectedDate.getText();
			Thread.sleep(3000);
//			Browser should displays selected time slot and current date in the text box.
			Assert.assertEquals((GiftPage.datetimeshipping.getText().contains(date)),true);
			Assert.assertEquals((GiftPage.datetimeshipping.getText().contains("Next Day Delivery")),true);
			System.out.println("Browser is displaying selected date and 'Next Day Delivery'in the text box.");
			
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
