package fernsNPetals.plants;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.BonsaiPlants;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

//Verify 'Continue' button functionality with In-valid Password in Checkout log-in page
public class Fnp_Plants_019 extends TestBase {
	
	@Test
	public void Fnp_Plants_019() throws InterruptedException {
		
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
			GiftPage.click("datetimeshipping");
//		8.Select Delivery date
			GiftPage.selectDayAfterTomorrow(driver);
			Thread.sleep(2000);
//		9.Click on Buy Now button 
			GiftPage.click("buynowbutton");
//		10.Click on Continue With Addon
			GiftPage.click("addoncheckbox");
			GiftPage.click("addonbutton");
//		11.In checkout login page,Click on email id 
			
//		12.Enter mail id and click on continue button
			CheckoutPage.sendkeys("loginEmailID", prop.getProperty("mailID"));
			CheckoutPage.click("continuebutton");
//		13.Enter Invalid Password and click on continue button
			CheckoutPage.sendkeys("pwd","12345");
			CheckoutPage.click("continuebutton");
//		*Note:Expected step1 has to be verified
			CheckoutPage.verify("errorLogin");
			driver.quit();
//		
//		1.Browser should display an error message 'Invalid maild/Invalid Password'
		
		
	}

}
