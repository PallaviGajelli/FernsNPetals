package fernsNPetals.plants;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.BonsaiPlants;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

//Verify functionality of the 'Delete' button in Delivery details page
public class Fnp_Plants_022 extends TestBase{
	
	@Test
	public void Fnp_Plants_022() throws Throwable {
		try {
			
			
//			1.Launch the FNP Application  in the browser
			initialization();
			HomePage HomePage = new HomePage();
			HomePage = PageFactory.initElements(driver, HomePage.getClass());
			GiftPage GiftPage = new GiftPage();
			GiftPage = PageFactory.initElements(driver, GiftPage.getClass());
			BonsaiPlants BonsaiPlants = new BonsaiPlants();
			BonsaiPlants = PageFactory.initElements(driver, BonsaiPlants.getClass());
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
		//2.Click on the Plants  link
			HomePage.mouseHover("plantsmenu");
		//3.Click on Bonsai Plants link 
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", BonsaiPlants.BonsaiPlants);
		//4.Click on Bonsai Beauty
			js.executeScript("arguments[0].click();", BonsaiPlants.Marvellous_Bonsai_Plant);
		//5.Enter Area/pincode in the texbox
			GiftPage.navigateToCart(driver);
			Thread.sleep(2000);
			GiftPage.searchaddressbox.sendKeys("hyderabad"); 
		//6.Select suggestions under the textbox
			GiftPage.clickfirstAddressintheList(driver);
		//7.Click on Change Date Link
			Thread.sleep(2000);
			GiftPage.SelectDeliveryDate.click();
		//8.Select Delivery date
			GiftPage.selectDayAfterTomorrow(driver);
			Thread.sleep(2000);
		//9.Click on Buy Now button 
			GiftPage.click("buynowbutton");
			Thread.sleep(2000);
		//10.Click on Continue With Addon
			GiftPage.click("addoncheckbox");
			Thread.sleep(1000);
			GiftPage.click("addonbutton");
			Thread.sleep(1000);
//			11.In checkout login page,Click on email id 
//			12.Enter Valid mail id and click on continue button i.e Existing user
//			13.Enter Password and click on continue button
				CheckoutPage.loginFnP();
				Thread.sleep(3000);
//			14.Click on Delete button in delivery details page
			CheckoutPage.deleteProductatcheckout.click();
			Thread.sleep(1000);
//			*Note:Expected step1 has to verified
			CheckoutPage.verify("deleteProductalert");
			Thread.sleep(1000);
//			15.Click on yes button
			CheckoutPage.deleteProductalertYesBtn.click();
			Thread.sleep(1000);
//			*Note:Expected step2 has to verified
			CheckoutPage.verify("cartisEmptyMsg");
			CheckoutPage.verify("StartShoppingNowBtn");
//			16.Click on start shop now button
			CheckoutPage.StartShoppingNowBtn.click();
			Thread.sleep(1000);
			
//			*Note:Expected step3 has to verified
			String homeurl = driver.getCurrentUrl();
			Assert.assertEquals(homeurl,prop.getProperty("url"));
			System.out.println("you are at HomePage");
//			
//			1.Browser should displays an Alert message
//			'Are you sure you want to delete this item?'
//			2.Browser should displays an message 
//			'Your cart is empty' and shows start shopping
//			now button
//			3.Browser should navigate to Home page 
		
			
			
			
		}catch(Throwable e) {
			throw e;
		}
//		finally {
//			 driver.quit();
//			 Runtime rt =Runtime.getRuntime();
//			 Process proc = rt.exec("taskkill /im chrome.exe /f /t");
//		}
	}

}
