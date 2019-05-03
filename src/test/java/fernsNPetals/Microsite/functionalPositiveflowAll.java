package fernsNPetals.Microsite;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.AllCakes;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

public class functionalPositiveflowAll extends TestBase {
	HomePage HomePage;
	GiftPage GiftPage;
	AllCakes AllCakes;
	CheckoutPage CheckoutPage;

	@BeforeMethod
	public void setup() throws InterruptedException {
//		Test Steps
//	    1. Launch the FNP Application  in the browser
		initialization();
		HomePage = new HomePage();
		HomePage = PageFactory.initElements(driver, HomePage.getClass());
		GiftPage = new GiftPage();
		GiftPage = PageFactory.initElements(driver, GiftPage.getClass());
		AllCakes = new AllCakes();
		AllCakes = PageFactory.initElements(driver, AllCakes.getClass());
		CheckoutPage = new CheckoutPage();
		CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());

//		2. Mouse over cakes link
		HomePage.mouseHover("cakesmenu");
		Thread.sleep(1000);
//		3. Click on All cakes link
		AllCakes.click("AllCakes");
		Thread.sleep(1000);
//		4.Click on Eggless cake
		AllCakes.click("EgglessCake");
		Thread.sleep(2000);

//		5.Select city from delivery to options
		AllCakes.click("DeliveryCity");
		Thread.sleep(1000);
		AllCakes.click("hyderabad");
		Thread.sleep(2000);
//		Note:Expected step1 has to be verified
		AllCakes.Assert("plpHeading", "Eggless Cakes to Hyderabad Online");
		System.out.println("£££££££££££Eggless Cakes to Hyderabad Online: title is validated");
		Thread.sleep(1000);

//		6.Click on pineapple cake
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", AllCakes.PinappleCake);

		Thread.sleep(2000);

		Set<String> IDs = driver.getWindowHandles();
		java.util.Iterator<String> iter = IDs.iterator();
		String homewindow = iter.next();
		String giftwindow = iter.next();
		driver.switchTo().window(giftwindow);

//		7.Enter area/pincode 
		GiftPage.sendkeys("searchaddressbox", "Hyderabad");
		GiftPage.clickfirstAddressintheList(driver);
		Thread.sleep(2000);

	}

	@Test(priority = 1) // Verify user able to Add the product by selecting the Product from micro site
	public void flow1() throws InterruptedException {
		// 8.Select shipping method //scroll down to select
		System.out.println("=============flow1==============");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", GiftPage.FreeDelivery);
		Thread.sleep(1000);

//	9. Click on Add To Cart button
		js.executeScript("arguments[0].click();", GiftPage.addtocartbutton);
		Thread.sleep(2000);

//	10. Click on Continue without addons
		GiftPage.click("withoutaddonbutton");
		AllCakes.Assert("PinappleCakecartProduct", "Pineapple Cake Half kg");
		Thread.sleep(1000);
		System.out.println("£££££££££Product added to cart");
	}

	@Test(priority = 2) // Verify functionality of buy Now button
	public void flow2() throws InterruptedException {
		System.out.println("=============flow2==============");
//8.Select shipping method
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", GiftPage.FreeDelivery);
		Thread.sleep(2000);
//9. 

//10. Click on Buynow  button
		js.executeScript("arguments[0].click();", GiftPage.buynowbutton);
		Thread.sleep(2000);
//11. Click on Continue without addons
		GiftPage.click("withoutaddonbutton");

		// https://www.fnp.com/control/checkout-page-rj/#/checkout-page

//Expected result 
//It should display the checkout login page.
		String ckeckoutURL = driver.getCurrentUrl();
		Assert.assertEquals(ckeckoutURL, prop.getProperty("checkoutpage"));
		System.out.println("£££££££££££you are at checkout page");

	}

	@Test(priority = 3) // Verify user able to place a Order by using Product from The micro site
	public void flow3() throws InterruptedException {

		System.out.println("=============flow3==============");	
//	10. Click on Buy now  button
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", GiftPage.buynowbutton);
		Thread.sleep(2000);

//	11. Click on Continue without addons
		GiftPage.click("withoutaddonbutton");
		Thread.sleep(2000);

//	12.Enter Existing email id
		CheckoutPage.sendkeys("loginEmailID", prop.getProperty("mailID"));
		CheckoutPage.click("continuebutton");

//	13.Enter Password and click on continue button
		CheckoutPage.sendkeys("pwd", prop.getProperty("pwd"));
		CheckoutPage.click("continuebutton");

//	Note:Expected step2 has to be verified
		String DD = CheckoutPage.orderenDeliveryDetails.getText();
		Assert.assertEquals(DD, "ORDER & DELIVERY DETAILS");
		System.out.println("££££££££££££££££££££Order & Delivery Details are displayed");

//	14.Click on Add new address and fill all mandatory fields
		CheckoutPage.filladdressToDelivery(driver, "chaya", "Madhapur", "9876543210");

//	Note:Expected step3 has to be verified
		Boolean saveadd = CheckoutPage.savedAdd.isDisplayed();
		if (saveadd == true) {
			System.out.println("£££££££££££ Displed the saved address in Delivery details page.");
		} else
			System.out.println("££££££££££££ Not displed the saved address in Delivery details page");
//	15. Accept terms and conditions and click on Proceed to pay  button
		CheckoutPage.placeorder(driver);
//	Note:Expected step4 has to be verified
		Boolean paymentOptions = CheckoutPage.paymentOptions.isDisplayed();
		if (paymentOptions == true) {
			System.out.println("£££££££££££ Displed the payment Options on the Delivery details page");
		} else
			System.out.println("££££££££££££ Not Displed the payment Options on the Delivery details page");
	}

	@AfterMethod
	public void closeall() {

		driver.quit();

	}

}
