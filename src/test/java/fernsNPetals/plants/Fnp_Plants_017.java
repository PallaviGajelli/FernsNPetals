package fernsNPetals.plants;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.BonsaiPlants;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

//Verify 'Continue' button functionality with Invalid mail id  in Checkout log-in page
public class Fnp_Plants_017 extends TestBase{

	@Test
	public void Fnp_Plants_017() throws InterruptedException {
		
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
			GiftPage.sendkeys("searchaddressbox", "kondapur");
//		6.Select suggestions under the textbox
			GiftPage.clickfirstAddressintheList(driver);
//		7.Click on Change Date Link
			GiftPage.click("datetimeshipping");
			Thread.sleep(1000);
//		8.Select Delivery date
			GiftPage.selectDayAfterTomorrow(driver);
			Thread.sleep(2000);
//		9.Click on Buy Now button 
			GiftPage.click("buynowbutton");
//		10.Click on Continue With Addon
			GiftPage.click("addoncheckbox");
			GiftPage.click("addonbutton");
//		11.In checkout login page,Click on email id.
			CheckoutPage.click("loginEmailID");
//		12.Enter  Invalid email id and click on continue button
			CheckoutPage.sendkeys("loginEmailID", "@fnp.Com");
			CheckoutPage.click("continuebutton");
//		
//		1.Browser should Remains same with entered data
			boolean link=driver.getCurrentUrl().contentEquals(prop.getProperty("checkoutpage"));
			Assert.assertEquals(link, true);
			System.out.println("Browser Remained same with entered data");
			driver.quit();
		
	}
}
