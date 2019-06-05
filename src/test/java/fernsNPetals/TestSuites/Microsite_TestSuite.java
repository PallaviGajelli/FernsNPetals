package fernsNPetals.TestSuites;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.AllCakes;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;
import fernsNPetals.util.TestUtil;

@Listeners(fernsNPetals.extentReportListener.ExtentReporterNG.class)
public class Microsite_TestSuite extends TestBase {

	static ExtentTest logger;
	static ExtentReports report;
	public static String extentReport;
	public static String TimeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())
			.toString();

	@BeforeTest
	public void extent() {
		extentReport = "Microsite_TestSuite" + TimeStamp + ".html";
		report = new ExtentReports(extentReport);
	}

	@AfterTest
	public void flushExtent() {
		report.flush();
	}

	@BeforeMethod
	public void Setup() throws Exception {

		long start = System.currentTimeMillis();
//		1. Launch the FNP Application  in the browser
		initialization();
		long finish = System.currentTimeMillis();
		long Total_Time = (finish - start) / 1000;
		System.out.println("Page Load Time: " + Total_Time + " Seconds");

		if (Total_Time <= 3) {
			System.err.println("Application is loading as per expected responce time");

		} else {

			System.err.println("Application is not loading as per expected responce time");

		}
		System.out.println("Extent report path:" + extentReport);

		HomePage HomePage = new HomePage();
		HomePage = PageFactory.initElements(driver, HomePage.getClass());
		GiftPage GiftPage = new GiftPage();
		GiftPage = PageFactory.initElements(driver, GiftPage.getClass());
		AllCakes AllCakes = new AllCakes();
		AllCakes = PageFactory.initElements(driver, AllCakes.getClass());

//		2. Mouse over cakes link
		HomePage.mouseHover("cakesmenu");
		Thread.sleep(1000);

//		3. Click on All cakes link
		AllCakes.click("AllCakes");
		Thread.sleep(1000);

//      4.Click on Eggless cake	
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
		GiftPage.scrollDownToElementandClick(driver, AllCakes.PinappleCake);
		GiftPage.navigateToCart(driver);

//		7.Enter area/pincode 
		GiftPage.searchaddressbox.sendKeys("Hyderabad");
		Thread.sleep(1000);
		GiftPage.searchaddressbox.sendKeys(Keys.chord(Keys.ENTER));
		Thread.sleep(1000);

//		8.Select shipping method //scroll down to select 
		GiftPage.scrollDownToElementandClick(driver, GiftPage.FreeDelivery);
		Thread.sleep(1000);

	}

	@AfterMethod
	public void tearDown() throws IOException {
		// Delete evrything so that test suite can be reusable next time.

		driver.quit();
		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec("taskkill /im chrome.exe /f /t");
	}

	@Test(priority = 1)
	public void micrositeTC_01() throws InterruptedException {
		try {
			GiftPage GiftPage = new GiftPage();
			GiftPage = PageFactory.initElements(driver, GiftPage.getClass());
			AllCakes AllCakes = new AllCakes();
			AllCakes = PageFactory.initElements(driver, AllCakes.getClass());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			logger = report
					.startTest("TC_01:Verify user able to Add the product by selecting the Product from micro site");
//		9. Click on Add To Cart button
			js.executeScript("arguments[0].click();", GiftPage.addtocartbutton);
			Thread.sleep(2000);
//		10. Click on Continue without addons
			GiftPage.click("withoutaddonbutton");
			AllCakes.Assert("PinappleCakecartProduct", "Pineapple Cake Half kg");
			Thread.sleep(1000);
			System.out.println("£££££££££Product added to cart");
			logger.log(LogStatus.INFO, "micrositeTC_01 is passed");
		} catch (AssertionError e) {
			logger.log(LogStatus.INFO, "micrositeTC_01 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}
	}

	@Test(priority = 2)
	public void micrositeTC_02() throws InterruptedException {
		try {
			logger = report.startTest("TC_02:Verify functionality of buy Now button");
			GiftPage GiftPage = new GiftPage();
			GiftPage = PageFactory.initElements(driver, GiftPage.getClass());

//		10. Click on Buynow  button
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", GiftPage.buynowbutton);
			Thread.sleep(2000);
//		11. Click on Continue without addons
			GiftPage.click("withoutaddonbutton");

			// https://www.fnp.com/control/checkout-page-rj/#/checkout-page

//		Expected result 
//		It should display the checkout login page.
			String ckeckoutURL = driver.getCurrentUrl();
			Assert.assertEquals(ckeckoutURL, prop.getProperty("checkoutpage"));
			System.out.println("£££££££££££you are at checkout page");

			logger.log(LogStatus.INFO, "micrositeTC_02 is passed");
		} catch (AssertionError e) {
			logger.log(LogStatus.INFO, "micrositeTC_02 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}

	}

	@Test(priority = 3)
	public void micrositeTC_03() throws InterruptedException {
		try {
			logger = report
					.startTest("TC_03:Verify user able to place a Order by using Product from \r\n" + "The micro site");
			GiftPage GiftPage = new GiftPage();
			GiftPage = PageFactory.initElements(driver, GiftPage.getClass());
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());

//		10. Click on Buy now  button
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", GiftPage.buynowbutton);
			Thread.sleep(2000);

//		11. Click on Continue without addons
			GiftPage.click("withoutaddonbutton");
			Thread.sleep(2000);

//		12.Enter Existing email id
			CheckoutPage.sendkeys("loginEmailID", prop.getProperty("mailID"));
			CheckoutPage.click("continuebutton");

//		13.Enter Password and click on continue button
			CheckoutPage.sendkeys("pwd", prop.getProperty("pwd"));
			CheckoutPage.click("continuebutton");

//		Note:Expected step2 has to be verified
			String DD = CheckoutPage.orderenDeliveryDetails.getText();
			Assert.assertEquals(DD, "ORDER & DELIVERY DETAILS");
			System.out.println("££££££££££££££££££££Order & Delivery Details are displayed");

//		14.Click on Add new address and fill all mandatory fields
			CheckoutPage.filladdressToDelivery(driver, "chaya", "Madhapur", "9876543210");

//		Note:Expected step3 has to be verified
			Boolean saveadd = CheckoutPage.savedAdd.isDisplayed();
			if (saveadd == true) {
				System.out.println("£££££££££££ Displed the saved address in Delivery details page.");
			} else
				System.out.println("££££££££££££ Not displed the saved address in Delivery details page");
//		15. Accept terms and conditions and click on Proceed to pay  button
			CheckoutPage.placeorder(driver);
//		Note:Expected step4 has to be verified
			Boolean paymentOptions = CheckoutPage.paymentOptions.isDisplayed();
			if (paymentOptions == true) {
				System.out.println("£££££££££££ Displed the payment Options on the Delivery details page");
			} else
				System.out.println("££££££££££££ Not Displed the payment Options on the Delivery details page");
			logger.log(LogStatus.INFO, "micrositeTC_03 is passed");
		} catch (AssertionError e) {
			logger.log(LogStatus.INFO, "micrositeTC_03 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}
	}

	@Test(priority = 4)
	public void micrositeTC_04() throws InterruptedException {
		try {
			logger = report.startTest("TC_04:Verify user able to place a \r\n" + "Order by using Product from \r\n"
					+ "The micro site and verifying invalid email validation and verifying invalid delivery details validation");
			GiftPage GiftPage = new GiftPage();
			GiftPage = PageFactory.initElements(driver, GiftPage.getClass());
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
			JavascriptExecutor js = (JavascriptExecutor) driver;

//			10. Click on Buy now  button
			js.executeScript("arguments[0].click();", GiftPage.buynowbutton);
			Thread.sleep(2000);
//		11. Click on Continue without addon-on
			GiftPage.click("withoutaddonbutton");
			Thread.sleep(2000);
//		10.Enter Invalid Mail id and click on continue button
			CheckoutPage.sendkeys("loginEmailID", "sdfsdffczxzxcc");
			CheckoutPage.click("continuebutton");
			boolean invalidId = CheckoutPage.checklogin.isDisplayed();
			if (invalidId == true) {
				System.out.println("££££££££ this is invalid emailid alert £££££££££££££");
			} else {
				System.out.println("£££££££££££this is valid email ID £££££££££££££££");
			}

//		11.Enter valid mail id and Password and click on continue button
			CheckoutPage.sendkeys("loginEmailID", "testmeapp1@gmail.com");
			CheckoutPage.click("continuebutton");
//		Note:Expected step1 has to be verified

//		12.Click on Add new address and leave the all fields empty and click on continue button
			CheckoutPage.click("submitaddressbutton");
			CheckoutPage.alertValidation("nameisrequire");
			CheckoutPage.alertValidation("addisrequire");
			CheckoutPage.alertValidation("mobileisreqire");
//		Note:Expected step2 has to be verified
//		13.Enter data in all fields and click on Save button.
			CheckoutPage.filladdressToDelivery(driver, "chaya", "Madhapur", "9876543210");
//		14.Accept terms and conditions 
			CheckoutPage.placeorder(driver);
			logger.log(LogStatus.INFO, "micrositeTC_04 is passed");
		} catch (AssertionError e) {
			logger.log(LogStatus.INFO, "micrositeTC_04 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}

	}
}
