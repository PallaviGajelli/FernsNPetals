package fernsNPetals.Gobal_USA;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.FlowersUSA;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;
//Verify user able to select the product from the header tool bar
public class FNP_Global_flowUSA_003 extends TestBase{
	@Test
	public void FNP_Global_flowUSA_003() throws Exception {
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
			//FlowersUSA.flowsersUSAunderGlobal.click();
			Thread.sleep(2000);
//			3.Click on any product 
			
			js.executeScript("arguments[0].click();", FlowersUSA.LongStemRedRoses100);
			Thread.sleep(1000);
			GiftPage.navigateToCart(driver);
//			Ex: 100 Long Stem Red Roses
			GiftPage.verifyGiftPageUrl(driver, "100-long-stem-red-roses");
//			Browser should navigate to Gift Booking window
			
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
