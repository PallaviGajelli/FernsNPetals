package fernsNPetals.Gobal_USA;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.FlowersUSA;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;
//Verify User able to View the Product in the Cart page.
public class FNP_Global_flowUSA_007 extends TestBase{
	@Test
	public void FNP_Global_flowUSA_007() throws Exception {
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
			Thread.sleep(1000);
//			7.select shipping method as 
//			Mid Night Delivery----this option is not available
			GiftPage.SelectDeliveryDate.click();
			Thread.sleep(1000);
			GiftPage.NextDayDelivery.click();
			Thread.sleep(1000);
//			8.select delivery date
			GiftPage.allreadySelectedDate.click();
			Thread.sleep(3000);
//			9.Click on Add to cart button
			GiftPage.addtocartbutton.click();
			Thread.sleep(3000);
			
//			*Note:Expected step1 has to be verified
			GiftPage.cartbtn.click();
			Thread.sleep(1000);
//			*Note: Expected step1 has to be verified
			GiftPage.cartverification("100 Long Stem Red Roses");
//			1.Browser should display the details about the product i.e
//			Product name with remove link
//			Send To
//			Quantity 
//			Amount
//			* Shipping charges to be displayed in the Order Summary page
//			sub total 
//			Total
//			Proceed to Checkout button
//			Continue shopping button
			
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
