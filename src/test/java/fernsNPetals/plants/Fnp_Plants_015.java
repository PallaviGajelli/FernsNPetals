package fernsNPetals.plants;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.BonsaiPlants;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

//Verify UI of the Checkout Login page
public class Fnp_Plants_015 extends TestBase{
	
	@Test
	public void Fnp_Plants_015() throws InterruptedException {
		
//		1.Launch the FNP Application  in the browser
			initialization();
			HomePage HomePage = new HomePage();
			HomePage = PageFactory.initElements(driver, HomePage.getClass());
			GiftPage GiftPage = new GiftPage();
			GiftPage = PageFactory.initElements(driver, GiftPage.getClass());
			BonsaiPlants BonsaiPlants = new BonsaiPlants();
			BonsaiPlants = PageFactory.initElements(driver, BonsaiPlants.getClass());
			CheckoutPage CheckoutPage= new CheckoutPage();
			CheckoutPage=PageFactory.initElements(driver, CheckoutPage.getClass());
//		2.Click on the Plants  link
			HomePage.mouseHover("plantsmenu");
//		3.Click on Bonsai Plants link 
			BonsaiPlants.click("BonsaiPlants");
//		4.Click on Bonsai Beauty
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", BonsaiPlants.Marvellous_Bonsai_Plant);
//		5.Enter Area/pincode in the texbox
			GiftPage.navigateToCart(driver);
			GiftPage.sendkeys("searchaddressbox", "hyderabad");
//		6.Select suggestions under the textbox
			GiftPage.clickfirstAddressintheList(driver);
//		7.Click on Change Date Link
			GiftPage.click("SelectDeliveryDate");
//		8.Select Delivery date
			GiftPage.selectDayAfterTomorrow(driver);
			Thread.sleep(2000);
//		9.Click on Buy Now button 
			GiftPage.click("buynowbutton");
//		10.Click on Continue With Addon
			GiftPage.click("addoncheckbox");
			GiftPage.click("addonbutton");
//		*Note:Expected step1 has to be verified
			GiftPage.VerifyCheckoutPage(driver);

//		displays the following fields:
//		a)Email id textbox
			CheckoutPage.verify("loginEmailID");
//		b)continue button
			CheckoutPage.verify("continuebutton");
//		c)Facebook link
			CheckoutPage.verify("facebooklogin");
//		d)Google+ link
			CheckoutPage.verify("googlelogin");
//		e)Order & Delivery Details
			CheckoutPage.verify("orderenDeliveryDetails");
//		f)Payment options
			CheckoutPage.verify("paymentOptions");
			driver.quit();
		
			
			
			
			
			
			
			
	}

}
