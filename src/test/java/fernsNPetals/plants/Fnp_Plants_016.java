package fernsNPetals.plants;
//Verify user able to Register with  Un-registered  Email id in the checkout login/ Sign up page

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.BonsaiPlants;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

public class Fnp_Plants_016 extends TestBase {

	@Test
	public void Fnp_Plants_016() throws InterruptedException {
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
//	11.In checkout login page,Click on email id.
			CheckoutPage.click("loginEmailID");
//	12.Enter new email id and click on continue button
			//CheckoutPage.sendkeys("loginEmailID", prop.getProperty(mailID));
//	*Note:Expected step1 has to be verified
//	13.Enter name
//	14.Enter mobile number
//	15.Click on create password and enter 1234
//	*Note:Expected step2 has to be verified
//	16.Enter 6 characters and click on continue button
//	*Note:Expected step3 has to be verified
//	
//	1.Browser displays Registration window
//	2.Browser should display an error message
//	'At least 6 characters'
//	3.Browser should navigate to Order & Delivery details page
			driver.quit();
	}
}
