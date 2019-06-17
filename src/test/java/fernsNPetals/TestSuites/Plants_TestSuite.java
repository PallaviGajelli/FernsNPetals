package fernsNPetals.TestSuites;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.BonsaiPlants;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;
import fernsNPetals.util.TestUtil;

public class Plants_TestSuite extends TestBase {
	static ExtentTest logger;
	static ExtentReports report;
	public static String extentReport;
	public static String TimeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime())
			.toString();
	@BeforeTest
	public void FNP_FNP_Application_001() {
		extentReport = "Plants_TestSuite" + TimeStamp + ".html";
		report = new ExtentReports(extentReport);
		logger = report.startTest("FNP_FNP_Application_001");
		logger.log(LogStatus.INFO, "FNP_FNP Application _001:");
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
			logger.log(LogStatus.WARNING, "Application is not loading as per expected responce time");
			System.err.println("Application is not loading as per expected responce time");
			logger.log(LogStatus.INFO, "Page Load Time: " + Total_Time);
		}
		logger.log(LogStatus.INFO, "FNP_FNP Application _001 is passed");
		System.out.println("Extent report path:" +extentReport);
	}

	


	@AfterTest
	public void tearDown() throws IOException {
		// Delete evrything so that test suite can be reusable next time.
      report.flush();
		driver.quit();
//		Runtime rt = Runtime.getRuntime();
//		Process proc = rt.exec("taskkill /im chrome.exe /f /t");
	}
	
	@Test(priority = 1)
	public void FNP_FNP_Application_002() throws InterruptedException {
		try {
			logger = report.startTest("FNP_FNP_Application_002");
			logger.log(LogStatus.INFO, "FNP_FNP Application _002:");
			HomePage HomePage =new HomePage();
			HomePage=PageFactory.initElements(driver, HomePage.getClass());
			
			HomePage.homepageverification();
			logger.log(LogStatus.INFO, "FNP_FNP Application _002 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "FNP_FNP Application _002 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}
	}

	@Test(priority = 2)
	public void Fnp_Plants_003() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_003");
			logger.log(LogStatus.INFO, "Fnp_Plants_003:");
			HomePage HomePage= new HomePage();
			HomePage= PageFactory.initElements(driver, HomePage.getClass());
			BonsaiPlants BonsaiPlants= new BonsaiPlants();
			BonsaiPlants= PageFactory.initElements(driver, BonsaiPlants.getClass());
//		2.mouse hover the Plants  link
			HomePage.mouseHover("plantsmenu");
//		3.Click on Bonsai Plants link
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", BonsaiPlants.BonsaiPlants);	
			
//		4.Click on any product 
		    js.executeScript("arguments[0].click();", BonsaiPlants.Marvellous_Bonsai_Plant);
			//BonsaiPlants.click("Marvellous_Bonsai_Plant");
//		Ex: Bonsai Beauty
	//	
//		Browser should navigate to Gift Booking window
			Set<String>IDs= driver.getWindowHandles();
			java.util.Iterator<String> iter=IDs.iterator();
			String homewindow = iter.next(); 
			String cartwindow = iter.next();
			
		driver.switchTo().window(cartwindow);
		String url =driver.getCurrentUrl();
		boolean a=url.contains("https://www.fnp.com/gift/marvellous-bonsai-plant");
		if (a==true) {
			System.out.println("you are at gift  page");
		}else {
			System.out.println("you are at other than gift  page");
		}

			logger.log(LogStatus.INFO, "Fnp_Plants_003 is passed");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_003 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}
	}

	@Test(priority = 3)
	public void Fnp_Plants_004() throws InterruptedException {
		try {
			
			logger = report.startTest("Fnp_Plants_004");
			logger.log(LogStatus.INFO, "Fnp_Plants_004:");
			GiftPage GiftPage=new GiftPage();
			GiftPage=PageFactory.initElements(driver, GiftPage.getClass());
			GiftPage.vrify("H_Marvellous_Bonsai_Plant");
 //		b) Bonsai Beauty,Cost,Reviews
		    GiftPage.vrify("H_Marvellous_Bonsai_Plant");
		    GiftPage.vrify("H2_Marvellous_Bonsai_Plant");
		    GiftPage.vrify("Cost");
		    GiftPage.vrify("Reviews");
		    
//				c)View more details
		    GiftPage.vrify("View_Product_Details");
//				d) Area/ pin code text box
		    GiftPage.vrify("searchaddressbox");
//				e) ADD TO CART button
		    GiftPage.vrify("addtocartbutton");
//				f) BUY NOW button
		    GiftPage.vrify("buynowbutton");

			logger.log(LogStatus.INFO, "Fnp_Plants_004 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_004 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}

	}

	@Test(priority = 4)
	public void Fnp_Plants_005() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_005");
			logger.log(LogStatus.INFO, "Fnp_Plants_005:");
			GiftPage GiftPage=new GiftPage();
			GiftPage=PageFactory.initElements(driver, GiftPage.getClass());
//			6.Click on continue button
			Thread.sleep(1000);
			GiftPage.buynowbutton.click();
			Thread.sleep(1000);
//		*Note:Expected step1 has to be verified
//		1.Browser should display an  message 'select Delivery Area to continue'
			GiftPage.vrify("pincodealert");
			logger.log(LogStatus.INFO, "Fnp_Plants_005 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_005 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
			
		}
	}
	@Test(priority = 5)
	public void Fnp_Plants_006() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_006");
	        logger.log(LogStatus.INFO, "Fnp_Plants_006:");
	        GiftPage GiftPage=new GiftPage();
			GiftPage=PageFactory.initElements(driver, GiftPage.getClass());
//			5.Enter Area/pincode in the texbox
			 Thread.sleep(1000);
			GiftPage.searchaddressbox.sendKeys("hyderabad"); 

//		6.Select suggestions under the textbox
			GiftPage.clickfirstAddressintheList(driver);
			Thread.sleep(1000);
//		7.Click on Change Date Link
			// GiftPage.click("datetimeshipping");
//		8.Select Delivery date
			// GiftPage.selectDayAfterTomorrow();
//		9.Click on Add To Cart Button
			GiftPage.addtocartbutton.click();
			Thread.sleep(2000);
//		10.Click on continue with Addon
			GiftPage.addoncheckbox.click();

			GiftPage.addonbutton.click();
			Thread.sleep(1000);
//		*Note:Expected step1 has to be verified
	//	
//		1.Browser should display the added product in the Cart
			GiftPage.vrify("Marvellous_Bonsai_Plant_AddedToCart");
			GiftPage.vrify("addonAddedToCart");
				
			logger.log(LogStatus.INFO, "Fnp_Plants_006 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_006 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}

	}
	@Test(priority = 6)
	public void Fnp_Plants_007() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_007");
			logger.log(LogStatus.INFO, "Fnp_Plants_007:");
			GiftPage GiftPage= new GiftPage();
			GiftPage= PageFactory.initElements(driver, GiftPage.getClass());
//			1.Browser should display the details about the product i.e
//			a)Product name with remove link
			GiftPage.vrify("Marvellous_Bonsai_Plant_AddedToCart");
			GiftPage.vrify("addonAddedToCart");
			GiftPage.vrify("delete_item_0");
			GiftPage.vrify("delete_item_1");
//			b)Send To
			GiftPage.vrify("SendTo");
//			c)Quantity 
			GiftPage.vrify("Quantity");
//			d)Amount
			GiftPage.vrify("Amount");
//			e)* Shipping charges to be displayed in the Order Summary page
			GiftPage.vrify("shippingChargesincart");
//			f)sub total 
			GiftPage.vrify("subtotalProduct");
			GiftPage.vrify("subtotaladdon");
//			g)Total
			//GiftPage.vrify("");
//			h)Proceed to Checkout button
			GiftPage.vrify("proceedToCheckoutinTheCartbtn");
			
			logger.log(LogStatus.INFO, "Fnp_Plants_007 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_007 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}
	}
	@Test(priority = 7)
	public void Fnp_Plants_008() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_008");
			logger.log(LogStatus.INFO, "Fnp_Plants_008:Verify User able to Remove the Product in the Cart page");
			GiftPage GiftPage= new GiftPage();
			GiftPage= PageFactory.initElements(driver, GiftPage.getClass());
//			11.Click on Cart lcon in header tool bar
			GiftPage.cartbtn.click();
//			12.Click on Remove link
			GiftPage.delete_item_0.click();
//			*Note:Expected step1 has to be verified
			GiftPage.deletedialog.click();
//			13.Click on OK button 
			GiftPage.deleteYesBtn.click();
//			*Note:Expected step2 has to be verified
			GiftPage.urCartisEmpty.click();
			Thread.sleep(2000);
			GiftPage.CartClose.click();
			
			logger.log(LogStatus.INFO, "Fnp_Plants_008 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_008 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}

	}

	@Test(priority = 8)
	public void Fnp_Plants_009() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_009");
			logger.log(LogStatus.INFO, "Fnp_Plants_009:Verify user able to Edit the pin code in Gift booking window");
			GiftPage GiftPage= new GiftPage();
			GiftPage= PageFactory.initElements(driver, GiftPage.getClass());
			GiftPage.searchaddressbox.clear();
			Thread.sleep(1000);
		    GiftPage.searchaddressbox.sendKeys("500084"); 

//		*Note:Executed step1 has to be verified
			boolean add=GiftPage.hybd500084.getText().contentEquals("Hyderabad, Telangana, India");
			Assert.assertEquals(add, true);
			//GiftPage.hybd500084.click();
			System.out.println("Browser is displaying suggestions under the textbox for valid add");

//		6.Clear the data and enter Invalid pin code
			GiftPage.searchaddressbox.clear();
			Thread.sleep(1000);
			GiftPage.sendkeys("searchaddressbox", "dfgdgdeg");	
//		*Note:Executed step2 has to be verified
			GiftPage.IsAddressintheListDisplayed(driver);
			System.out.println("Browser is not displaying suggestions under the textbox for invalid add");
			
//		7.Clear the data and Enter pin 533249
			
			GiftPage.searchaddressbox.clear();
			Thread.sleep(1000);
			GiftPage.sendkeys("searchaddressbox", "533249");
			//GiftPage.searchaddressbox.sendKeys("533249"); 	
//		*Note:Executed step3 has to be verified.
			boolean add2=GiftPage.hybd533249.getText().contentEquals("Andhra Pradesh, India");
			Assert.assertEquals(add2, true);
			System.out.println("Browser is displaying suggestions under the textbox for valid add");
			//GiftPage.click("hybd533249");
		    logger.log(LogStatus.INFO, "Fnp_Plants_009 is passed");
		} catch (Throwable  e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_009 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}
	}
	
	@Test(priority = 9)
	public void Fnp_Plants_013() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_013");
			logger.log(LogStatus.INFO, "Fnp_Plants_013:Verify Functionality of the 'Buy Now' button by entering Invalid Pin/ Area");
			GiftPage GiftPage= new GiftPage();
			GiftPage= PageFactory.initElements(driver, GiftPage.getClass());
//			5.Enter Invalid  pin code in the textbox
			GiftPage.searchaddressbox.clear();
			Thread.sleep(1000);
			GiftPage.sendkeys("searchaddressbox", "adsdsdhfaekfh");
			GiftPage.IsAddressintheListDisplayed(driver);
			System.out.println("Browser is not displaying suggestions under the textbox for invalid add");
//		*Note:Expected step2 has to be verified
//		6.click on buy now button
			Thread.sleep(1000);
			GiftPage.click("buynowbutton");
			Thread.sleep(1000);
			GiftPage.vrify("pincodealert");
			logger.log(LogStatus.INFO, "Fnp_Plants_013 is passed");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_013 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
		}
	}

	@Test(priority = 10)
	public void Fnp_Plants_010() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_010");
			logger.log(LogStatus.INFO, "Fnp_Plants_010:Verify 'Buy Now' button functionality without Entering data in gift booking window");
			GiftPage GiftPage= new GiftPage();
			GiftPage= PageFactory.initElements(driver, GiftPage.getClass());
//			6.Click on Buy Now button
			GiftPage.searchaddressbox.clear();
			Thread.sleep(1000);
			GiftPage.buynowbutton.click();
//		*Note:Expected step1 has to be verified
//		Browser should display message 'Select Delivery area to continue'
			GiftPage.vrify("pincodealert");
			logger.log(LogStatus.INFO, "Fnp_Plants_010 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_010 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}

	}
	@Test(priority = 11)
	public void Fnp_Plants_011() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_011");
			logger.log(LogStatus.INFO, "Fnp_Plants_011:Verify User able to view the Delivery Date in the gift booking window");
			GiftPage GiftPage= new GiftPage();
			GiftPage= PageFactory.initElements(driver, GiftPage.getClass());
			Thread.sleep(1000);
			GiftPage.searchaddressbox.sendKeys("hyderabad"); 
			Thread.sleep(1000);
//		6.Select suggestions under the textbox
			GiftPage.clickfirstAddressintheList(driver);
			Thread.sleep(1000);
//		7.Click on Change Date Link
			if (GiftPage.datetimeshipping.isDisplayed()) {
				GiftPage.datetimeshipping.click();	
			}else {
				GiftPage.SelectDeliveryDate.click();
			}
			
			Thread.sleep(1000);
			GiftPage.selectDayAfterTomorrow(driver);
			logger.log(LogStatus.INFO, "Fnp_Plants_011 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_011 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}
	}
	@Test(priority = 12)
	public void Fnp_Plants_012() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_012");
			logger.log(LogStatus.INFO, "Fnp_Plants_012:Verify 'Buy Now' button functionality without selecting Addon");
			GiftPage GiftPage= new GiftPage();
			GiftPage= PageFactory.initElements(driver, GiftPage.getClass());
//			9.Click on Buy Now button
			Thread.sleep(1000);
			GiftPage.buynowbutton.click();
			Thread.sleep(2000);
//		10.Click on Continue Without Addon
			GiftPage.withoutaddonbutton.click();
			Thread.sleep(1000);
//		*Note:Expected step1 has to be verified
//		1.Browser should navigate to Login/Sign
//		 up page
		GiftPage.VerifyCheckoutPage(driver);
			logger.log(LogStatus.INFO, "Fnp_Plants_012 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_012 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}

	}
	
	@Test(priority = 13)
	public void Fnp_Plants_014() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_014");
			logger.log(LogStatus.INFO, "Fnp_Plants_014:Verify 'Buy Now' button functionality with entering data by selection a Add-on");
			GiftPage GiftPage= new GiftPage();
			GiftPage= PageFactory.initElements(driver, GiftPage.getClass());
			driver.navigate().back();
			Thread.sleep(2000);
			GiftPage.cartbtn.click();
			GiftPage.delete_item_0.click();
			GiftPage.deleteYesBtn.click();
			Thread.sleep(1000);
			GiftPage.CartClose.click();
			Thread.sleep(1000);
//			9.Click on Buy Now button 
			GiftPage.click("buynowbutton");
			Thread.sleep(2000);
//		10.Click on Continue With Addon
			GiftPage.click("addoncheckbox");
			Thread.sleep(1000);
			GiftPage.click("addonbutton");
			Thread.sleep(2000);
//		*Note:Expected step1 has to be verified
			GiftPage.VerifyCheckoutPage(driver);
			logger.log(LogStatus.INFO, "Fnp_Plants_014 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_004 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}

	}
	@Test(priority = 14)
	public void Fnp_Plants_015() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_015");
			logger.log(LogStatus.INFO, "Fnp_Plants_015:Verify UI of the Checkout Login page");
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
			Thread.sleep(1000);
			CheckoutPage.checkoutPageVerification();
			logger.log(LogStatus.INFO, "Fnp_Plants_015 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_015 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}
	}

	@Test(priority = 15)
	public void Fnp_Plants_016() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_016");
			logger.log(LogStatus.INFO, "Fnp_Plants_016:Verify user able to Register with  Un-registered  Email id in the checkout login/ Sign up page");
			Thread.sleep(1000);
			
//need new loginid every time
			logger.log(LogStatus.INFO, "Fnp_Plants_016 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_016 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}

	}


	@Test(priority = 16)
	public void Fnp_Plants_017() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_017");
			logger.log(LogStatus.INFO, "Fnp_Plants_017:Verify 'Continue' button functionality with Invalid mail id  in Checkout log-in page");
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
//			11.In checkout login page,Click on email id.
				CheckoutPage.loginEmailID.click();
//			12.Enter  Invalid email id and click on continue button
				CheckoutPage.loginEmailID.sendKeys("@fnp.Com"); 
				CheckoutPage.continuebutton.click();
//				1.Browser should Remains same with entered data
				boolean link=driver.getCurrentUrl().contentEquals(prop.getProperty("checkoutpage"));
				Assert.assertEquals(link, true);
				System.out.println("Browser Remained same with entered data");
			logger.log(LogStatus.INFO, "Fnp_Plants_017 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_017 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}
	}
	// this test case is repeated in Fnp_Plants_020
//		@Test(priority = 17)
//		public void Fnp_Plants_018() throws InterruptedException {
//			try {
//				logger = report.startTest("Fnp_Plants_018");
//				logger.log(LogStatus.INFO, "Fnp_Plants_018:Verify 'Continue' button functionality with Valid mail id  in Checkout log-in page");
//				CheckoutPage CheckoutPage = new CheckoutPage();
//				CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
////				11.In checkout login page,Click on email id 
////				12.Enter Valid mail id and click on continue button i.e Existing user
//				CheckoutPage.loginEmailID.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//				Thread.sleep(1000);
//				CheckoutPage.loginFnP();
////				*Note:Expected step1 has to be verified
//				CheckoutPage.verify("orderenDeliveryDetailsPage");
	//
//				logger.log(LogStatus.INFO, "Fnp_Plants_018 is passed");
//			} catch (Throwable e) {
//				logger.log(LogStatus.INFO, "Fnp_Plants_018 is failed");
//				logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
//				logger.log(LogStatus.INFO, "Exception occured is :" + e);
//				throw e;
//			}
	//
//		}

		@Test(priority = 17)
		public void Fnp_Plants_019() throws InterruptedException {
			try {
				logger = report.startTest("Fnp_Plants_019");
				logger.log(LogStatus.INFO, "Fnp_Plants_019:Verify 'Continue' button functionality with In-valid Password in Checkout log-in page");
				CheckoutPage CheckoutPage = new CheckoutPage();
				CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
//				12.Enter mail id and click on continue button
				    CheckoutPage.loginEmailID.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				    Thread.sleep(1000);
					CheckoutPage.loginEmailID.sendKeys(prop.getProperty("mailID")); 
					Thread.sleep(1000);
					CheckoutPage.continuebutton.click();
					Thread.sleep(1000);
//				13.Enter Invalid Password and click on continue button
					CheckoutPage.pwd.sendKeys("12345"); 
					Thread.sleep(1000);
					CheckoutPage.continuebutton.click();
					Thread.sleep(1000);
//				*Note:Expected step1 has to be verified
					CheckoutPage.verify("errorLogin");
				logger.log(LogStatus.INFO, "Fnp_Plants_019 is passed");
			} catch (Throwable e) {
				logger.log(LogStatus.FAIL, "Fnp_Plants_019 is failed");
				logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
				logger.log(LogStatus.ERROR, "Exception occured is :" + e);
				throw e;
			}
		}
		@Test(priority = 18)
		public void Fnp_Plants_020() throws InterruptedException {
			try {
				logger = report.startTest("Fnp_Plants_020");
				logger.log(LogStatus.INFO, "Fnp_Plants_020:Verify UI of the Delivery Details page");
				CheckoutPage CheckoutPage = new CheckoutPage();
				CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
				Thread.sleep(1000);
				CheckoutPage.editloginEmailID.click();
				Thread.sleep(1000);
				CheckoutPage.loginEmailID.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				Thread.sleep(1000);
				CheckoutPage.loginFnP("Testcsurnamec@gmail.com","Cleena@123");
				Thread.sleep(1000);
//			*Note:Expected step1 has to be verified
				CheckoutPage.verify("orderenDeliveryDetailsPage");

		//1.Browser should navigate to Order & Delivery details page
		//shows the following fields:
		//a)Bonsai Beauty with quantity and price
				CheckoutPage.verify("MarvellousBonsaiPlantPriceandQty");
		//b)Delivery date and time
				CheckoutPage.verify("Deliverydateandtime");
		//c)Change button
				CheckoutPage.verify("changebtn");
		//d)Addon 
				CheckoutPage.verify("addon");
		//e)Add Delivery address
				CheckoutPage.verify("addnewaddress");
		//f)Free Message card
				
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("arguments[0].scrollIntoView();", CheckoutPage.FreeMessagecard);
				CheckoutPage.verify("FreeMessagecard");
		//g)senders details 
				CheckoutPage.verify("sendersdetails");
				logger.log(LogStatus.INFO, "Fnp_Plants_020 is passed");
			} catch (Throwable e) {
				logger.log(LogStatus.FAIL, "Fnp_Plants_020 is failed");
				logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
				logger.log(LogStatus.ERROR, "Exception occured is :" + e);
				throw e;
			}

		}

	@Test(priority = 19)
	public void Fnp_Plants_021() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_021");
			logger.log(LogStatus.INFO, "Fnp_Plants_021:Verify functionality of the 'Change' button in delivery details page");
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
//			14.Click Change button
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", CheckoutPage.changebtn);
			//CheckoutPage.changebtn.click();
			Thread.sleep(1000);
			
//			*Note:Expected step1 has to verified
			CheckoutPage.verify("selectDeliveryDate");
			Thread.sleep(1000);
//			15.Select Delivery date
			CheckoutPage.SelectedDate.click();;
			Thread.sleep(2000);
//			*Note:Expected step2 has to verified
			CheckoutPage.verify("DeliveryDate");
			logger.log(LogStatus.INFO, "Fnp_Plants_021 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_021 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}
	}

	

	@Test(priority = 20)
	public void Fnp_Plants_023() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_023");
            logger.log(LogStatus.INFO, "Fnp_Plants_023:Verify User able to view the sender's details  in the Delivery details page");
            CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
			Thread.sleep(1000);
//			Browser should navigate Order & Delivery details page
			CheckoutPage.verify("orderenDeliveryDetailsPage");
//			it shows following fields 
//			Sender's details
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].scrollIntoView();",CheckoutPage.SendersDetailsheading);
			Thread.sleep(1000);
			CheckoutPage.verify("sendersdetails");
			logger.log(LogStatus.INFO, "Fnp_Plants_023 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_023 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}
	}

	@Test(priority = 21)
	public void Fnp_Plants_024() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_024");
			logger.log(LogStatus.INFO, "Fnp_Plants_024:Verify the functionality of the 'Save Address' button without Entering data in Delivery details page");
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
			Thread.sleep(1000);
//			JavascriptExecutor js1 = (JavascriptExecutor) driver;
//			js1.executeScript("arguments[0].scrollouttoView();",CheckoutPage.SendersDetailsheading);
//			16.Click on the save address button
			CheckoutPage.filladdressToDelivery(driver, "", "", "");
//			*Note:Expected step1 has to be verified
			CheckoutPage.verify("EmptyAddressAlertMsg");
			logger.log(LogStatus.INFO, "Fnp_Plants_024 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_024 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}

	}

	@Test(priority = 22)
	public void Fnp_Plants_025() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_025");
			logger.log(LogStatus.INFO, "Fnp_Plants_025:Verify the BVA of recipients name field in delivery details page");
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
			Thread.sleep(1000);
//			14.Select Prefix as-Ms
		    JavascriptExecutor js1 = (JavascriptExecutor) driver;
		    js1.executeScript("arguments[0].scrollIntoView();", CheckoutPage.Add_Delivery_Address);
		    
		    CheckoutPage.selectPrefixAsMs(driver);

//			15.Enter Name in the text field
		    CheckoutPage.sendkeys("rname", "akshya kjrl");
//			*Note:Expected step1 has to be verified
		    String name=CheckoutPage.rname.getAttribute("value");
		    Assert.assertEquals(name, "akshya kjrl");
		    System.out.println("Browser is displaying Recipients Name in the text field");
			logger.log(LogStatus.INFO, "Fnp_Plants_025 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_025 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}
	}

	@Test(priority = 23)
	public void Fnp_Plants_026() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_026");
			logger.log(LogStatus.INFO, "Fnp_Plants_026:Verify the functionality  of recipients name field in delivery details page");
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
			Thread.sleep(1000);
			CheckoutPage.sendkeys("rname", (Keys.chord(Keys.CONTROL, "a", Keys.DELETE)));
			Thread.sleep(1000);
//			15.Enter Name in the text field
		    CheckoutPage.sendkeys("rname", "chaya sree");
//			*Note:Expected step1 has to be verified
		    String name=CheckoutPage.rname.getAttribute("value");
		    Assert.assertEquals(name, "chaya sree");
		    System.out.println("Browser is displaying Recipients Name in the text field");
			logger.log(LogStatus.INFO, "Fnp_Plants_026 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_026 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}

	}

	@Test(priority = 24)
	public void Fnp_Plants_027() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_027");
			logger.log(LogStatus.INFO, "Fnp_Plants_027:");
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
			Thread.sleep(1000);
			CheckoutPage.sendkeys("rname", (Keys.chord(Keys.CONTROL, "a", Keys.DELETE)));
			Thread.sleep(1000);
//			15.Enter Name in the text field
		    CheckoutPage.sendkeys("rname", "ADSFdfdf5434/@#$%^&*(%^&/878745845");
//			*Note:Expected step1 has to be verified
		    String name=CheckoutPage.rname.getAttribute("value");
		    Assert.assertEquals(name, "ADSFdfdf5434/@#$%^&*(%^&/878745845");
		    System.out.println("Browser is displaying Recipients Name in the text field");
			logger.log(LogStatus.INFO, "Fnp_Plants_027 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_027 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}
	}

	@Test(priority = 25)
	public void Fnp_Plants_028() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_028");
			logger.log(LogStatus.INFO, "Fnp_Plants_028:Verify the functionality  of recipients  Address field in delivery details page");
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
			Thread.sleep(1000);
//		    16.Enter Recipients address
		    CheckoutPage.sendkeys("raddress", "Ammerpet");
		    String addname=CheckoutPage.raddress.getAttribute("value");
		    Assert.assertEquals(addname, "Ammerpet");
		    System.out.println("Browser is displaying Recipients Address in the text field");
		    
//			17.Enter landmark
		    CheckoutPage.sendkeys("landmark", "Saradhi studio behind,near value mart");

			logger.log(LogStatus.INFO, "Fnp_Plants_028 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_028 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}

	}

	@Test(priority = 26)
	public void Fnp_Plants_029() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_029");
			logger.log(LogStatus.INFO, "Fnp_Plants_029:Verify the functionality  of recipients  Address field in delivery details page");
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
			Thread.sleep(1000);
//			15.Enter Name in the text field
			CheckoutPage.sendkeys("rname", (Keys.chord(Keys.CONTROL, "a", Keys.DELETE)));
			Thread.sleep(1000);
		    CheckoutPage.sendkeys("rname", "chaya sree");
//			16.Enter Invalid  Recipients address like special characters,alphanumerical
		    CheckoutPage.sendkeys("raddress", (Keys.chord(Keys.CONTROL, "a", Keys.DELETE)));
		    Thread.sleep(1000);
		    CheckoutPage.sendkeys("raddress", "@#$@#$%$#%$#^");
		    Thread.sleep(1000);
		    
//			17.Enter landmark
//			*Note:Expected step1 has to be verified
		    String addname=CheckoutPage.raddress.getAttribute("value");
		    Assert.assertEquals(addname, "@#$@#$%$#%$#^");
		    System.out.println("Browser is displaying Recipients Address in the text field");
			logger.log(LogStatus.INFO, "Fnp_Plants_029 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_029 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}
	}

	@Test(priority = 27)
	public void Fnp_Plants_030() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_030");
			logger.log(LogStatus.INFO, "Fnp_Plants_030:Verify the functionality  of recipients  mobile number field in delivery details page");
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
			Thread.sleep(1000);
//		    16.Enter Recipients address
		    CheckoutPage.sendkeys("raddress", (Keys.chord(Keys.CONTROL, "a", Keys.DELETE)));
		    Thread.sleep(1000);
		    CheckoutPage.sendkeys("raddress", "Ammerpet");
	   
//			17.Enter landmark
		    CheckoutPage.sendkeys("landmark", "Saradhi studio behind,near value mart");
//			18.Enter mobile number
		    CheckoutPage.sendkeys("rmobileno", "9876543210");
		    String addmobileno=CheckoutPage.rmobileno.getAttribute("value");
		    Assert.assertEquals(addmobileno, "9876543210");
		    System.out.println("Browser is displaying Recipients mobile no in the text field");
			logger.log(LogStatus.INFO, "Fnp_Plants_030 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_030 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}

	}

	@Test(priority = 28)
	public void Fnp_Plants_031() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_031");
			logger.log(LogStatus.INFO, "Fnp_Plants_031:Verify the functionality  of recipients  mobile number field by Entering Invalid mobile number");
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
			Thread.sleep(1000);
//			18.Enter mobile number less than 10 digits
			CheckoutPage.sendkeys("rmobileno", (Keys.chord(Keys.CONTROL, "a", Keys.DELETE)));
			Thread.sleep(1000);
		    CheckoutPage.sendkeys("rmobileno", "9876");
		    CheckoutPage.verify("invalidrMobile");
			logger.log(LogStatus.INFO, "Fnp_Plants_031 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_031 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}
	}

	@Test(priority = 29)
	public void Fnp_Plants_032() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_032");
			logger.log(LogStatus.INFO, "Fnp_Plants_032:Verify the functionality  of recipient Email field  in delivery details page");
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
			Thread.sleep(1000);
//			19.Enter Email id textbox
		    WebDriverWait wait = new WebDriverWait(driver, 10);
		    wait.until(ExpectedConditions.elementToBeClickable(CheckoutPage.rEmailIdOptional));
		    CheckoutPage.sendkeys("rEmailIdOptional","test@gmail.Com");
			
//			Browser should display the mail id in the textbox
		    String remail=CheckoutPage.rEmailIdOptional.getAttribute("value");
		    Assert.assertEquals(remail, "test@gmail.com");
		    System.out.println("Browser is displaying Recipients email id in the text field");
			logger.log(LogStatus.INFO, "Fnp_Plants_032 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_032 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}

	}

	@Test(priority = 30)
	public void Fnp_Plants_033() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_033");
			logger.log(LogStatus.INFO, "Fnp_Plants_033:Verify the functionality  of Save Address button by entering Invalid data in delivery details page");
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
			Thread.sleep(1000);
//			14.Click on Save Address button
			CheckoutPage.sendkeys("rname", (Keys.chord(Keys.CONTROL, "a", Keys.DELETE)));
			CheckoutPage.sendkeys("raddress", (Keys.chord(Keys.CONTROL, "a", Keys.DELETE)));
			CheckoutPage.sendkeys("rmobileno", (Keys.chord(Keys.CONTROL, "a", Keys.DELETE)));
			Thread.sleep(1000);
		    CheckoutPage.filladdressToDelivery(driver, "DS@!#9887test", "AGRA kjd@#% 989090", "98765432");
//			*Note:Expected step1 has to be verified
		    CheckoutPage.verify("invalidrMobile");
			logger.log(LogStatus.INFO, "Fnp_Plants_033 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_033 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}
	}

	@Test(priority = 31)
	public void Fnp_Plants_034() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_034");
			logger.log(LogStatus.INFO, "Fnp_Plants_034:Verify the functionality  of Save Address button by entering Valid data in delivery details page");
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
			Thread.sleep(1000);
//			20.Click on Save Address button
			CheckoutPage.sendkeys("rname", (Keys.chord(Keys.CONTROL, "a", Keys.DELETE)));
			CheckoutPage.sendkeys("raddress", (Keys.chord(Keys.CONTROL, "a", Keys.DELETE)));
			CheckoutPage.sendkeys("rmobileno", (Keys.chord(Keys.CONTROL, "a", Keys.DELETE)));
			CheckoutPage.sendkeys("landmark", (Keys.chord(Keys.CONTROL, "a", Keys.DELETE)));
			CheckoutPage.sendkeys("rEmailIdOptional", (Keys.chord(Keys.CONTROL, "a", Keys.DELETE)));
			Thread.sleep(1000);
		    CheckoutPage.filladdressToDelivery(driver, "chaya sree", "Ammerpet", "9876543210","Saradhi studio behind,near value mart","test@gmail.Com");
//			*Note:Expected step1 has to be verified
		    JavascriptExecutor js1 = (JavascriptExecutor) driver;
		    js1.executeScript("arguments[0].scrollIntoView();", CheckoutPage.savedAddselected);
		    CheckoutPage.verify("savedAddselected");

			logger.log(LogStatus.INFO, "Fnp_Plants_034 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_034 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}

	}

	@Test(priority = 32)
	public void Fnp_Plants_035() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_035");
			logger.log(LogStatus.INFO, "Fnp_Plants_035:Verify User able to Edit the Address in the Delivery details page");
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
			Thread.sleep(1000);
//			21.Click on Edit button
		    CheckoutPage.click("editsavedAddBtn");
//			*Note:Expected step1 has to be verified
		    CheckoutPage.verify("editsavedAddpage");
//			22.Change name
		    Thread.sleep(1000);
		    JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].scrollIntoView();",CheckoutPage.rname);
		    //CheckoutPage.rname.clear();
			CheckoutPage.rname.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			Thread.sleep(1000);
		    CheckoutPage.sendkeys("rname", "sri lasya");
//			23.Change number
		    CheckoutPage.rmobileno.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		    Thread.sleep(1000);
		    CheckoutPage.sendkeys("rmobileno", "7894562310");
//			24.Click on Save Button
		    CheckoutPage.click("submitaddressbutton");
//			*Note:Expected step2 has to be verified
		    String chanedDetails=CheckoutPage.savedaddDetails.getText();
     		Assert.assertEquals(chanedDetails, "Sri Lasya7894562310");
     		System.out.println("Changed name and mobile no is displayed");

			logger.log(LogStatus.INFO, "Fnp_Plants_035 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_035 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}
	}

	@Test(priority = 33)
	public void Fnp_Plants_036() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_036");
			logger.log(LogStatus.INFO, "Fnp_Plants_036:Verify the user able to write the message on card");
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
			Thread.sleep(1000);
//			21.Click on Free Message card
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].click();", CheckoutPage.FreeMessagecard);
		  
//			22.Select occasion as Birthday
		    CheckoutPage.SelectOccasion.click();
		    CheckoutPage.Occasionbirthday.click();
		    
//			23.Click on Save Button
		    CheckoutPage.saveBtn.click();
//			*Note:Expected step1 has to be verified
		    CheckoutPage.MessageCannotBeEmpty.isDisplayed();
		    System.out.println("Select Message is displayed");
//			24.write message on card
		    CheckoutPage.SelectMessageonCard.click();
		    CheckoutPage.SelectfirstMessage.click();
		    
//			25.Click on save button
		    CheckoutPage.saveBtn.click();
//			*Note:Expected step2 has to be verified
		    CheckoutPage.msgoncard.isDisplayed();
		    System.out.println("msg is dispayed on the card");

			logger.log(LogStatus.INFO, "Fnp_Plants_036 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_036 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}

	}

	@Test(priority = 34)
	public void Fnp_Plants_037() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_037");
			logger.log(LogStatus.INFO, "Fnp_Plants_037:Verify the functionality of the Proceed To Checkout button in delivery details page");
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
			Thread.sleep(1000);
//			26.Click on Proceed To Checkout button
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].click();", CheckoutPage.proceedtocheckout);
		    //CheckoutPage.proceedtocheckout.click();
//			*Note:Expected step1 has to be verified 
		    CheckoutPage.Yourconsentisrequired.isDisplayed();
		    System.out.println("Your consent is required msg is dispayed");
     		logger.log(LogStatus.INFO, "Fnp_Plants_037 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_037 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}
	}

	@Test(priority = 35)
	public void Fnp_Plants_038() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_038");
			logger.log(LogStatus.INFO, "Fnp_Plants_038:Verify the functionality of the Proceed To Checkout button in delivery details page");
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
			Thread.sleep(1000);
//			26.Click on Check box Accept Terms&Conditions
		    CheckoutPage.placeorder(driver);
//			27.Click on Proceed To Checkout button
//			*Note:Expected step1 has to be verified 
		    CheckoutPage.paymentOptionspage.isDisplayed();
		    System.out.println("payment Options page is displayed");

			logger.log(LogStatus.INFO, "Fnp_Plants_038 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_038 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}

	}
	@Test(priority = 36)
	public void Fnp_Plants_022() throws InterruptedException {
		try {
			logger = report.startTest("Fnp_Plants_022");
			logger.log(LogStatus.INFO, "Fnp_Plants_022:Verify functionality of the 'Delete' button in Delivery details page");
			
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
			Thread.sleep(1000);
			CheckoutPage.editSavedProduct.click();
			Thread.sleep(1000);
//			14.Click on Delete button in delivery details page
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", CheckoutPage.deleteProductatcheckout);
			//CheckoutPage.deleteProductatcheckout.click();
			Thread.sleep(1000);
//			*Note:Expected step1 has to verified
			CheckoutPage.verify("deleteProductalert");
			Thread.sleep(1000);
//			15.Click on yes button
			CheckoutPage.deleteProductalertYesBtn.click();
			Thread.sleep(1000);
//			*Note:Expected step2 has to verified
			CheckoutPage.verify("cartisEmptyMsg");
			CheckoutPage.verify("StartShoppingNowBtn");
//			16.Click on start shop now button
			CheckoutPage.StartShoppingNowBtn.click();
			Thread.sleep(1000);
			
//			*Note:Expected step3 has to verified
			String homeurl = driver.getCurrentUrl();
			Assert.assertEquals(homeurl,prop.getProperty("url"));
			System.out.println("you are at HomePage");
			logger.log(LogStatus.INFO, "Fnp_Plants_022 is passed");
		} catch (Throwable e) {
			logger.log(LogStatus.FAIL, "Fnp_Plants_022 is failed");
			logger.log(LogStatus.INFO, "Screenshot is taken and saved at :" + TestUtil.Screenshotlocation);
			logger.log(LogStatus.ERROR, "Exception occured is :" + e);
			throw e;
		}

	}

}
