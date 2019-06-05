
package fernsNPetals.TestSuites;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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
import fernsNPetals.extentReportListener.ExtentReporterNG;
import fernsNPetals.other.loggerTest;
import fernsNPetals.pages.AllCakes;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.FlowersPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;
import fernsNPetals.util.TestUtil;

//@Listeners(fernsNPetals.extentReportListener.ExtentReporterNG.class)
public class All_filters_in_category_page_TestSuite extends TestBase {

	static ExtentReports report;
	static ExtentTest logger;
	public static String extentReport;
	public static String TimeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())
			.toString();

	@BeforeTest
	public void extent() {
		extentReport = "All_filters_in_category_page_TestSuite" + TimeStamp + ".html";
		// prop.getProperty("ExtentReports")
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

	}

	@AfterMethod
	public void tearDown() throws IOException {
		// Delete evrything so that test suite can be reusable next time.

		driver.quit();
		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec("taskkill /im chrome.exe /f /t");
	}

	@Test(priority = 1)
	public void All_filters_in_category_pageTC_01() throws InterruptedException, IOException {
		try {

			logger = report.startTest("TC_01:Verify user able to view the \r\n" + " Filters in category page");
			HomePage HomePage = new HomePage();
			HomePage = PageFactory.initElements(driver, HomePage.getClass());
			FlowersPage FlowersPage = new FlowersPage();
			FlowersPage = PageFactory.initElements(driver, FlowersPage.getClass());

//				2.Mouse over Anniversary link
			HomePage.mouseHover("anniversarymenu");
//				3.Click on flowers
			FlowersPage.anniversary_flowers.click();
//				
//				It should display the category page with
//				Filters:
			FlowersPage.verifyFiltersInCategoryPage();

			logger.log(LogStatus.INFO, "All_filters_in_category_pageTC_01 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.INFO, "All_filters_in_category_pageTC_01 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}

	}

	@Test(priority = 2)
	public void All_filters_in_category_pageTC_02() throws InterruptedException {
		try {
			logger = report.startTest("TC_02:Verify functionality of \r\n" + " Filters in category page");
			HomePage HomePage = new HomePage();
			HomePage = PageFactory.initElements(driver, HomePage.getClass());
			FlowersPage FlowersPage = new FlowersPage();
			FlowersPage = PageFactory.initElements(driver, FlowersPage.getClass());

//				2.Mouse over Anniversary link
			HomePage.mouseHover("anniversarymenu");
			FlowersPage.anniversary_flowers.click();
//				3.Mouse over Gift type and select roses
			FlowersPage.mouseHover("GiftTypeFlowers");
			FlowersPage.Roses.click();
//				Note:Expected step1 has to be verified
			//////////////////////////
//				4.Mouse over Occasion link
			HomePage.mouseHover("occassionsmenu");
//				Note:Expected step2 has to be verified
			FlowersPage.AnniversaryUnderOccation.isDisplayed();
			System.out.println("Anniversary Under Occation id displayed");
//				5.Mouse over the Delivery city
			FlowersPage.mouseHover("DeliveryCity");
//				6.Click on Banglore
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", FlowersPage.Bangalore);

//				Note:Expected step3 has to be verified
			Assert.assertEquals((FlowersPage.DeliveryCity.getText()), "Delivery City\nBangalore");
			System.out.println("It is displaying Selected city under Delivery city Link");
//				7.Click on Recommended drop down
			FlowersPage.recomendedDropDown.click();
//				8.Click on price Low to High
			FlowersPage.PriceLowtoHigh.click();
//				Note:Expected step4 has to be verified
			////////////////
//				9.Mouse over Price link
			FlowersPage.mouseHover("PriceAnniversary");
//				10.Click on 500+
			js.executeScript("arguments[0].click();", FlowersPage.Price500Plus);
			// FlowersPage.Price500Plus.click();
//				Note:Expected step5 has to be verified
			Thread.sleep(1000);
			Assert.assertEquals((FlowersPage.PriceAnniversary.getText()), "Price\nGBP 5.81 +");
			System.out.println("It is display the selected cost the under the price link");

			logger.log(LogStatus.INFO, "All_filters_in_category_pageTC_02 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.INFO, "All_filters_in_category_pageTC_02 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}

	}

	@Test(priority = 3)
	public void All_filters_in_category_pageTC_03() throws InterruptedException {
		try {
			logger = report.startTest( "TC_03:Verify user able to place a \r\n" + 
					"order by selecting filters in \r\n" + 
					"Category page");
			HomePage HomePage = new HomePage();
			HomePage = PageFactory.initElements(driver, HomePage.getClass());
			GiftPage GiftPage = new GiftPage();
			GiftPage = PageFactory.initElements(driver, GiftPage.getClass());
			FlowersPage FlowersPage = new FlowersPage();
			FlowersPage = PageFactory.initElements(driver, FlowersPage.getClass());
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
//			2.Mouse over Anniversary link
			HomePage.mouseHover("anniversarymenu");
			FlowersPage.anniversary_flowers.click();
//			3.Mouse over Gift type link
//			4.Click on Roses
			FlowersPage.mouseHover("GiftTypeFlowers");
			FlowersPage.Roses.click();
//			5.Mouse over Occasion link
			HomePage.mouseHover("occassionsmenu");
			FlowersPage.AnniversaryUnderOccation.isDisplayed();
			System.out.println("Anniversary Under Occation id displayed");
//			6.Mouse over the Delivery city
			FlowersPage.mouseHover("DeliveryCity");
//			7.Click on Bangalore
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", FlowersPage.Bangalore);
			Assert.assertEquals((FlowersPage.DeliveryCity.getText()), "Delivery City\nBangalore");
			System.out.println("It is displaying Selected city under Delivery city Link");
//			8.Click on Recommended drop down
			FlowersPage.recomendedDropDown.click();
//			9.Click on price Low to High
			FlowersPage.PriceLowtoHigh.click();
//			10.Mouse over Price link
			FlowersPage.mouseHover("PriceAnniversary");
//			11.Click on 500+
			FlowersPage.Price500Plus.click();
			Thread.sleep(2000);
			Assert.assertEquals((FlowersPage.PriceAnniversary.getText()), "Price\nGBP 5.81 +");
			System.out.println("It is display the selected cost the under the price link");
//			Note:Expected step1 has to be verified
			//////////////////////
//			14.select any product (EX:Elegance -Pink Rose Bouquet)
			Thread.sleep(1000);
			js.executeScript("arguments[0].click();", FlowersPage.ElegancePinkRosesBouquet);
			
//			15.Enter area name and select delivery date
			GiftPage.navigateToCart(driver);
			GiftPage.sendkeys("searchaddressbox", "kondapur");
			GiftPage.searchaddressbox.sendKeys(Keys.ENTER);
			Assert.assertEquals((GiftPage.searchaddressbox.getAttribute("value")), "Kondapur, Hyderabad, Telangana, India");
			System.out.println("Area name is displayed in the text field");
			//GiftPage.clickfirstAddressintheList(driver);
			Thread.sleep(2000);
			//GiftPage.click("SelectDeliveryDate");
			//GiftPage.selectDayAfterTomorrow(driver);
//			(Ex:select standard delivery date)
			
//			Note:Expected step2 has to be verified
			
//			16.Click on Buy Now button
			js.executeScript("arguments[0].click();", GiftPage.buynowbutton);
			Thread.sleep(2000);
			//GiftPage.click("buynowbutton");
//			17.Click on Continue with one add-on
			GiftPage.click("addoncheckbox");
			GiftPage.click("addonbutton");
//			18.Enter Email id on click on continue button
			Thread.sleep(2000);
			CheckoutPage.sendkeys("loginEmailID", prop.getProperty("mailID"));
			CheckoutPage.click("continuebutton");
//			19.Enter Password and click on continue button
			CheckoutPage.sendkeys("pwd", prop.getProperty("pwd"));
			CheckoutPage.click("continuebutton");
//			20.Click on Add new address and all details and click on save address
			//CheckoutPage.click("addnewaddress");
			CheckoutPage.filladdressToDelivery(driver, "chaya", "Madhapur", "9876543210", "", "test@gmail.com");
			
//			21.Accept terms and conditions 
//			22.Click on Proceed to check out button
			CheckoutPage.placeorder(driver);
			CheckoutPage.paymentOptionspage.isDisplayed();
			System.out.println("Browser is navigate to Payment page");
		
			logger.log(LogStatus.INFO, "All_filters_in_category_pageTC_03 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.INFO, "All_filters_in_category_pageTC_03 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}
	}

	@Test(priority = 4)
	public void All_filters_in_category_pageTC_04() throws InterruptedException {
		try {
			logger = report.startTest("TC_04:Verify user able to place a \r\n" + "order by selecting filters in \r\n"
					+ "Category page With negative validations");
			HomePage HomePage = new HomePage();
			HomePage = PageFactory.initElements(driver, HomePage.getClass());
			GiftPage GiftPage = new GiftPage();
			GiftPage = PageFactory.initElements(driver, GiftPage.getClass());
			FlowersPage FlowersPage = new FlowersPage();
			FlowersPage = PageFactory.initElements(driver, FlowersPage.getClass());
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
//			2.Mouse over Anniversary link
			HomePage.mouseHover("anniversarymenu");
			FlowersPage.anniversary_flowers.click();
//			3.Mouse over Gift type link
			FlowersPage.mouseHover("GiftTypeFlowers");

//			4.Click on Roses
			FlowersPage.Roses.click();
//			5.Mouse over Occasion link
			HomePage.mouseHover("occassionsmenu");
			FlowersPage.AnniversaryUnderOccation.isDisplayed();
			System.out.println("Anniversary Under Occation id displayed");
//			6.Mouse over the Delivery city
			FlowersPage.mouseHover("DeliveryCity");
//			7.Click on Bangalore
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", FlowersPage.Bangalore);
			Assert.assertEquals((FlowersPage.DeliveryCity.getText()), "Delivery City\nBangalore");
			System.out.println("It is displaying Selected city under Delivery city Link");
//			8.Click on Recommended drop down
			FlowersPage.recomendedDropDown.click();
//			9.Click on price Low to High
			FlowersPage.PriceLowtoHigh.click();
//			10.Mouse over Price link
			FlowersPage.mouseHover("PriceAnniversary");
//			11.Click on 500+
			FlowersPage.Price500Plus.click();

//			12.select any product (EX:Elegance -Pink Rose Bouquet)
			Thread.sleep(1000);
			js.executeScript("arguments[0].click();", FlowersPage.ElegancePinkRosesBouquet);
//			13.Enter area name and select delivery date
			GiftPage.navigateToCart(driver);
			GiftPage.sendkeys("searchaddressbox", "kondapur");
			Thread.sleep(1000);
			GiftPage.searchaddressbox.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
//			(Ex:select standard delivery date)
//			14. Click on Buy now  button
			js.executeScript("arguments[0].click();", GiftPage.buynowbutton);
			Thread.sleep(2000);
//			15. Click on Continue without addon-on
			GiftPage.click("addonbutton");
//			16.Enter Invalid Mail id and click on continue button
			CheckoutPage.sendkeys("loginEmailID", "sdadfdaedQWD");
			CheckoutPage.click("continuebutton");
			CheckoutPage.verify("checklogin");
			CheckoutPage.loginEmailID.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Thread.sleep(1000);
//			Note:Expected step1 has to be verified
//			17.Enter valid mail id and Password and click on continue button
			CheckoutPage.sendkeys("loginEmailID", prop.getProperty("mailID"));
			CheckoutPage.click("continuebutton");
			CheckoutPage.sendkeys("pwd", prop.getProperty("pwd"));
			CheckoutPage.click("continuebutton");
			Thread.sleep(1000);
//			18.Click on Add new address and leave the all fields empty and click on continue button
			CheckoutPage.filladdressToDelivery(driver, "", "", "", "", "");
			Thread.sleep(1000);
//			Note:Expected step2 has to be verified
			CheckoutPage.verify("EmptyAddressAlertMsg");
//			19.Enter data in all fields and click on Save button.
			CheckoutPage.filladdressToDelivery(driver, "chaya", "Madhapur", "9876543210", "", "test@gmail.com");
			Thread.sleep(1000);
//			20.Accept terms and conditions 
//			And click on Proceed to pay button
			CheckoutPage.placeorder(driver);
			CheckoutPage.paymentOptionspage.isDisplayed();
			System.out.println("Browser is navigate to Payment page");

			logger.log(LogStatus.INFO, "All_filters_in_category_pageTC_04 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.INFO, "All_filters_in_category_pageTC_04 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}

	}

}
