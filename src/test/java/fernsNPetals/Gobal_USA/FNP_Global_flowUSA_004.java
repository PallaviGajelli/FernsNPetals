package fernsNPetals.Gobal_USA;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.FlowersUSA;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;
//Verify UI of the Gift Booking window
public class FNP_Global_flowUSA_004 extends TestBase{
	@Test
	public void FNP_Global_flowUSA_004() throws Exception {
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
//			3.Click on any product 
		    js.executeScript("arguments[0].click();", FlowersUSA.LongStemRedRoses100);
			Thread.sleep(1000);
			GiftPage.navigateToCart(driver);
			Thread.sleep(1000);
			
//			Browser should display the following fields in the gift booking window:
//				Home>Send Roses to USA online>100 Long Stem Red Roses
		
//				100 Long Stem Red Roses image,reviews,cost
//				Area text box
//				ADD TO CART button
//				BUY NOW button
			Assert.assertEquals((GiftPage.TopHeadingProductName.getText()),"100 Long Stem Red Roses");
			System.out.println("Top Header On the Pic is displayed:"+GiftPage.TopHeadingProductName.getText());
		
			Assert.assertEquals((GiftPage.sideheadernextToPic.getText()), "100 Long Stem Red Roses");
			System.out.println("side header next To Pic is displayed:"+GiftPage.sideheadernextToPic.getText());
			
		
			Assert.assertEquals(GiftPage.Cost.isDisplayed(), true);
			System.out.println("cost of Product is displayed");
	
//			Assert.assertEquals(GiftPage.Reviews.isDisplayed(), true);
//			System.out.println("Reviews for Product is displayed");
		
			Assert.assertEquals(GiftPage.addtocartbutton.isDisplayed(), true);
			System.out.println("add to cart button is displayed");
		
			Assert.assertEquals(GiftPage.buynowbutton.isDisplayed(), true);
			System.out.println("buynowbutton is displayed");
		
			Assert.assertEquals(GiftPage.searchaddressbox.isDisplayed(), true);
			System.out.println("searchaddressbox is displayed");
			
			
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
