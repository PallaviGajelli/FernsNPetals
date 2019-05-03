package fernsNPetals.Microsite;
//Verify functionality of buy Now button

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.AllCakes;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;
import org.testng.Assert;

public class TC_02 extends TestBase {

	@Test
	public void FunctionalPositiveFlow2() throws InterruptedException {

//	Test Steps
//	1. Launch the FNP Application  in the browser
		initialization();
		HomePage HomePage = new HomePage();
		HomePage = PageFactory.initElements(driver, HomePage.getClass());
		GiftPage GiftPage = new GiftPage();
		GiftPage = PageFactory.initElements(driver, GiftPage.getClass());
		AllCakes AllCakes = new AllCakes();
		AllCakes = PageFactory.initElements(driver, AllCakes.getClass());
//	2. Mouse over cakes link
		HomePage.mouseHover("cakesmenu");
		Thread.sleep(1000);
//	3. Click on All cakes link
		AllCakes.click("AllCakes");
		Thread.sleep(1000);
//	4.Click on Eggless cake 
		AllCakes.click("EgglessCake");
		Thread.sleep(2000);

//	5.Select city from delivery to options
		AllCakes.click("DeliveryCity");
		Thread.sleep(1000);
		AllCakes.click("hyderabad");
		Thread.sleep(2000);
//	Note:Expected step1 has to be verified
		AllCakes.Assert("plpHeading", "Eggless Cakes to Hyderabad Online");
		System.out.println("£££££££££££Eggless Cakes to Hyderabad Online: title is validated");
		Thread.sleep(1000);
//	6.Click on pineapple cake
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", AllCakes.PinappleCake);
		Thread.sleep(2000);

		Set<String> IDs = driver.getWindowHandles();
		java.util.Iterator<String> iter = IDs.iterator();
		String homewindow = iter.next();
		String giftwindow = iter.next();
		driver.switchTo().window(giftwindow);
//	7.Enter area/pincode 
		GiftPage.sendkeys("searchaddressbox", "Hyderabad");
		GiftPage.clickfirstAddressintheList(driver);
		Thread.sleep(2000);

//	8.Select shipping method
		js.executeScript("arguments[0].click();", GiftPage.FreeDelivery);
		Thread.sleep(2000);
//	9. 

//	10. Click on Buynow  button
		js.executeScript("arguments[0].click();", GiftPage.buynowbutton);
		Thread.sleep(2000);
//	11. Click on Continue without addons
		GiftPage.click("withoutaddonbutton");
		
		//https://www.fnp.com/control/checkout-page-rj/#/checkout-page

//	Expected result 
//	It should display the checkout login page.
		String ckeckoutURL =driver.getCurrentUrl();
		Assert.assertEquals(ckeckoutURL, prop.getProperty("checkoutpage"));
		System.out.println("£££££££££££you are at checkout page");
		
		driver.close();
	}
}
