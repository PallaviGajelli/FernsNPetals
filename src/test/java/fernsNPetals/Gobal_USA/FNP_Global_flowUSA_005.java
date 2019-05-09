package fernsNPetals.Gobal_USA;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.FlowersUSA;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;
//Verify the functionality of the Add To Cart button without entering a data
public class FNP_Global_flowUSA_005 extends TestBase{
	@Test
	public void FNP_Global_flowUSA_005() throws Exception {
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
			Thread.sleep(1000);
//			5.Leave the fields empty 
//			6.Click on ADD TO CART button
			GiftPage.addtocartbutton.click();
			Thread.sleep(1000);
//			*Note: Expected step1 has to be verified
			GiftPage.vrify("pincodealert");
//			1.Browser should display an error message 'Select Delivery Area To Continue'
			
			
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
