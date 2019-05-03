package fernsNPetals.plants;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.BonsaiPlants;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

//Verify functionality of the 'Change' button in delivery details page
public class Fnp_Plants_021 extends TestBase{
	
	@Test
	public void Fnp_Plants_021() throws Exception {
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
//			2.Click on the Plants  link
			HomePage.mouseHover("plantsmenu");
//			3.Click on Bonsai Plants link 
			BonsaiPlants.click("BonsaiPlants");
//			4.Click on Bonsai Beauty
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", BonsaiPlants.Marvellous_Bonsai_Plant);
//			5.Enter Area/pincode in the texbox
			GiftPage.navigateToCart(driver);
			GiftPage.sendkeys("searchaddressbox", "kondapur");
//			6.Select suggestions under the textbox
			GiftPage.clickfirstAddressintheList(driver);
//			7.Click on Change Date Link
			GiftPage.click("datetimeshipping");
//			8.Select Delivery date
			GiftPage.selectDayAfterTomorrow(driver);
			Thread.sleep(2000);
//			9.Click on Buy Now button 
			GiftPage.click("buynowbutton");
//			10.Click on Continue With Addon
			GiftPage.click("addoncheckbox");
			GiftPage.click("addonbutton");
//		11.In checkout login page,Click on email id 

//		12.Enter Valid mail id and click on continue button i.e Existing user
			CheckoutPage.sendkeys("loginEmailID", prop.getProperty("mailID"));
			CheckoutPage.click("continuebutton");
//		13.Enter Password and click on continue button
			CheckoutPage.sendkeys("pwd", prop.getProperty("pwd"));
			CheckoutPage.click("continuebutton");
//			14.Click Change button
			CheckoutPage.click("changebtn");
			
//			*Note:Expected step1 has to verified
			CheckoutPage.verify("selectDeliveryDate");
//			15.Select Delivery date
			CheckoutPage.selectTomorrow(driver);
//			*Note:Expected step2 has to verified
			CheckoutPage.verify("DeliveryDate");
//			
//			1.Browser should displays the calendar
//			2.Browser should displays the updated Delivery date in the delivery details page.
		
			
			
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
