package fernsNPetals.TestSuites;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import fernsNPetals.base.TestBase;
import fernsNPetals.extentReportListener.ExtentReporterNG;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.FlowersPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;
import fernsNPetals.util.TestUtil;

public class Currency_TestSuite extends TestBase {
	static ExtentTest logger;
	static ExtentReports report;
	public static String extentReport;
	public static String TimeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())
			.toString();
	@BeforeTest
	public void FNP_FNP_Application_001() {
		extentReport = "Currency_TestSuite" + TimeStamp + ".html";
		report = new ExtentReports(extentReport);
		logger = report.startTest("Verifying browser launch");
	
		long start = System.currentTimeMillis();
//		1. Launch the FNP Application  in the browser
		initialization();
		long finish = System.currentTimeMillis();
		long Total_Time = (finish - start) / 1000;
		System.out.println("Page Load Time: " + Total_Time + " Seconds");
		
		if (Total_Time <= 3) {
			logger.log(LogStatus.INFO, "Application is loading as per expected responce time");
			System.err.println("Application is loading as per expected responce time");
			logger.log(LogStatus.INFO, "Page Load Time: " + Total_Time);
		} else {
			logger.log(LogStatus.INFO, "Application is not loading as per expected responce time");
			System.err.println("Application is not loading as per expected responce time");
			logger.log(LogStatus.INFO, "Page Load Time: " + Total_Time);
		}
		logger.log(LogStatus.INFO, "FNP_FNP Application _001 is passed");
		System.out.println("Extent report path:" +extentReport);
	}


	@AfterTest
	public void tearDown() throws IOException, InterruptedException {
		// Delete evrything so that test suite can be reusable next time.
		Thread.sleep(2000);
		report.flush();
		driver.quit();
//		Runtime rt = Runtime.getRuntime();
//		Process proc = rt.exec("taskkill /im chrome.exe /f /t");
	}

	@Test(priority = 1)
	public void CurrencyTC_01() throws InterruptedException {
		try {
			logger = report.startTest("CurrencyTC_01");
			logger.log(LogStatus.INFO, "TC_01:Verify  user able to select the Currency in scroll bar");
			HomePage HomePage = new HomePage();
			HomePage = PageFactory.initElements(driver, HomePage.getClass());
//			2.Mouse over the currency header
			HomePage.mouseHover("currency_sym");

//			3.Click on ‘EUR-Euro’
			HomePage.Euro.click();
//			
//			Browser should display the Currency EUR in header
			String s = HomePage.currency_sym.getText();
			Assert.assertEquals(s, "EUR");
			System.out.println("Browser is displaying the Currency EUR in header");
			logger.log(LogStatus.INFO, "Browser is displaying the Currency EUR in header");
			logger.log(LogStatus.INFO, "CurrencyTC_01 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "CurrencyTC_01 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}
	}

	@Test(priority = 2)
	public void CurrencyTC_02() throws InterruptedException {
		try {
			logger = report.startTest("CurrencyTC_02");
			logger.log(LogStatus.INFO, "TC_02:Verify user able to view the selected currency for products in PDP page");
			HomePage HomePage = new HomePage();
			HomePage = PageFactory.initElements(driver, HomePage.getClass());
			FlowersPage FlowersPage = new FlowersPage();
			FlowersPage = PageFactory.initElements(driver, FlowersPage.getClass());
			GiftPage GiftPage = new GiftPage();
			GiftPage = PageFactory.initElements(driver, GiftPage.getClass());

//			4.Mouse over ‘Anniversary ’ link
			HomePage.mouseHover("anniversarymenu");
//			5.Mouse over flowers
			FlowersPage.anniversary_flowers.click();
//			6.Click on ‘Vivd-Red Roses Bouquet ’
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", FlowersPage.VividRedRosesBouquet);
			GiftPage.navigateToCart(driver);
			Thread.sleep(2000);
//			 It should display following felds:
//				 a) product name
			String heading = GiftPage.itemheadingproductname.getText();
			Assert.assertEquals(heading, "Vivid - 10 Red Roses Bouquet");

//				 b) Euro currency symbol
			String crr = GiftPage.currsymbol.getText();
			Assert.assertEquals(crr, "EUR");

//				 c) Enter area pincode textfied and addtocart button,Buy now button
			GiftPage.vrify("searchaddressbox");
			GiftPage.vrify("addtocartbutton");
			GiftPage.vrify("buynowbutton");
			logger.log(LogStatus.INFO, "CurrencyTC_02 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "CurrencyTC_02 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}

	}

	@Test(priority = 3)
	public void CurrencyTC_03() throws InterruptedException {
		try {
			logger = report.startTest("CurrencyTC_03");
			logger.log(LogStatus.INFO, "TC_03:Verify user able to view the selected currency  in Add to cart page");
			HomePage HomePage = new HomePage();
			HomePage = PageFactory.initElements(driver, HomePage.getClass());
			FlowersPage FlowersPage = new FlowersPage();
			FlowersPage = PageFactory.initElements(driver, FlowersPage.getClass());
			GiftPage GiftPage = new GiftPage();
			GiftPage = PageFactory.initElements(driver, GiftPage.getClass());
			JavascriptExecutor js = (JavascriptExecutor) driver;

//			7.Enter Area
			GiftPage.searchaddressbox.sendKeys("Kondapur");
			Thread.sleep(1000);
			GiftPage.searchaddressbox.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
//			8.Select delivery date
			GiftPage.selectDate.click();
			// js.executeScript("arguments[0].click();", GiftPage.selectDate);
			Thread.sleep(2000);
			GiftPage.selectDayAfterTomorrow(driver);
//			9.Select shipping method as ‘Stanard delivery’
			js.executeScript("arguments[0].click();", GiftPage.StdDeliveryunderCalender);

//			10.Select time slot
			js.executeScript("arguments[0].click();", GiftPage.TSlot12to15undercalender);

//			11.Click on ‘ADD TO CART’ button
			js.executeScript("arguments[0].click();", GiftPage.addtocartbutton);

//			Note:Expected step1 has to be verified content
			String currencycheck = GiftPage.addonpriceonaddonPage.getText();

			Assert.assertEquals(currencycheck.contains("EUR"), true);
			System.out.println("Cart page is available with price for the product Amount price in EUR");
//			12.Click on cotinue with one addon
			Thread.sleep(1000);
			GiftPage.addoncheckbox.click();
			GiftPage.addonbutton.click();
			Thread.sleep(1000);
//			13.Click on the cart icon 
			GiftPage.cartbtn.click();
//			Note:Expected step2 has to be verified
			String crrencycheck1 = GiftPage.Amount.getText();
			Assert.assertEquals(crrencycheck1.contains("EUR"), true);
			System.out.println("Total Amount price is in EUR");

			String crrencycheck2 = GiftPage.subtotalProduct.getText();
			Assert.assertEquals(crrencycheck2.contains("EUR"), true);
			System.out.println("Sub total of product price is in EUR");

			String crrencycheck3 = GiftPage.subtotaladdon.getText();
			Assert.assertEquals(crrencycheck3.contains("EUR"), true);
			System.out.println("Sub total of addon price is in EUR");
			Thread.sleep(1000);
			GiftPage.delete_item_0.click();
			Thread.sleep(1000);
			GiftPage.deleteYesBtn.click();
			Thread.sleep(1000);
			GiftPage.CartClose.click();
			Thread.sleep(1000);
			logger.log(LogStatus.INFO, "CurrencyTC_03 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "CurrencyTC_03 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}
	}

	@Test(priority = 4)
	public void CurrencyTC_04() throws InterruptedException {
		try {
			logger = report.startTest("CurrencyTC_04");
			logger.log(LogStatus.INFO, "TC_04:Verify user able to view the selected currency in Delivery details page");
			HomePage HomePage = new HomePage();
			HomePage = PageFactory.initElements(driver, HomePage.getClass());
			FlowersPage FlowersPage = new FlowersPage();
			FlowersPage = PageFactory.initElements(driver, FlowersPage.getClass());
			GiftPage GiftPage = new GiftPage();
			GiftPage = PageFactory.initElements(driver, GiftPage.getClass());
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
//			11.Click on ‘Buy Now’ button
			js.executeScript("arguments[0].click();", GiftPage.buynowbutton);
//			12.Click on continue with one add-on
			Thread.sleep(2000);
			GiftPage.addoncheckbox.click();
			GiftPage.addonbutton.click();
			Thread.sleep(2000);
//			Note:Expected step1 has to be verified
			GiftPage.VerifyCheckoutPage(driver);
			Thread.sleep(2000);
//			13.Enter Email id and click on continue button
//			14.Enter Password and click on continue button
			CheckoutPage.loginFnP("Testbsurnameb@gmail.com","Bleena@123");
			Thread.sleep(2000);
//			Note:Expected step2 has to be verified
			CheckoutPage.checkCurrency("EUR");
			logger.log(LogStatus.INFO, "CurrencyTC_04 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "CurrencyTC_04 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}
	}

	@Test(priority = 5)
	public void CurrencyTC_05() throws InterruptedException {
		try {
			logger = report.startTest("CurrencyTC_05");
			logger.log(LogStatus.INFO, "TC_05:Verify user able to view the selected currency  in Thank you page");
			HomePage HomePage = new HomePage();
			HomePage = PageFactory.initElements(driver, HomePage.getClass());
			FlowersPage FlowersPage = new FlowersPage();
			FlowersPage = PageFactory.initElements(driver, FlowersPage.getClass());
			GiftPage GiftPage = new GiftPage();
			GiftPage = PageFactory.initElements(driver, GiftPage.getClass());
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());

//			Note:Expected step2 has to be verified
			CheckoutPage.verify("orderenDeliveryDetailsPage");
			Thread.sleep(1000);
//			15.click on new address
//			16.Enter all fields and click on save address button
			CheckoutPage.filladdressToDelivery(driver, "chaya", "Madhapur", "9876543210", "", "test@gmail.com");
			Thread.sleep(1000);
//			17.Click on terms and conditions and click on proceed to checkout button
			CheckoutPage.placeorder(driver);
			Thread.sleep(1000);
			CheckoutPage.paymentOptionspage.isDisplayed();
			System.out.println("paymentOptionspage is displayed");

			String a = CheckoutPage.PayBtnonPaymentOptions.getAttribute("class");
			Assert.assertEquals(a.contains("EUR"), true);
			System.out.println("Pay Btn on Payment Options is displyaed with currency EUR");
			logger.log(LogStatus.INFO, "CurrencyTC_05 is passed");
			CheckoutPage.deleteAddAndProductWithAddonFromCheckoutPage();
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "CurrencyTC_05 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}

	}

}
