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
			if (GiftPage.datetimeshipping.isDisplayed()) {
				GiftPage.datetimeshipping.click();	
			}else {
				GiftPage.SelectDeliveryDate.click();
			}
			Thread.sleep(1000);
		//8.Select Delivery date
			GiftPage.selectDayAfterTomorrow(driver);
			Thread.sleep(2000);
		//9.Click on Buy Now button 
			GiftPage.buynowbutton.click();
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
				Thread.sleep(1000);
//			14.Click Change button
			CheckoutPage.changebtn.click();
			Thread.sleep(1000);
			
//			*Note:Expected step1 has to verified
			CheckoutPage.verify("selectDeliveryDate");
			Thread.sleep(1000);
//			15.Select Delivery date
			CheckoutPage.SelectedDate.click();;
			Thread.sleep(2000);
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
