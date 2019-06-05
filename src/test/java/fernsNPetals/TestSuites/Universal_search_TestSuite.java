package fernsNPetals.TestSuites;

import java.io.IOException;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.extentReportListener.ExtentReporterNG;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;
import fernsNPetals.util.TestUtil;
@Listeners(fernsNPetals.extentReportListener.ExtentReporterNG.class)
public class Universal_search_TestSuite extends TestBase{
	
	@BeforeMethod
	public static void launch() {  
	
		long start = System.currentTimeMillis();
        initialization();
		long finish = System.currentTimeMillis();
		long Total_Time = (finish - start) / 1000;
		System.out.println("Page Load Time: " + Total_Time + " Seconds");
		if (Total_Time <= 3)
		{
			System.err.println("Application is loading as per expected responce time");
			
		} else
		{
        System.err.println("Application is not loading as per expected responce time");
	    }
		System.out.println("Extent report path:"+ExtentReporterNG.reportLocation);
	}

	@AfterMethod
	public void tearDown() throws IOException
	{
		// Delete evrything so that test suite can be reusable next time.
		driver.quit();
		Runtime rt =Runtime.getRuntime();
		Process proc = rt.exec("taskkill /im chrome.exe /f /t");
	}
	
	@Test(priority=1)
	public void TC_01() throws InterruptedException {
		try {
			Logger log = Logger.getLogger("log4j");
			PropertyConfigurator.configure("log4j.properties");
			log.info("TC_01:Verify user able to place a order By selecting clicking on search button and validating with invalid pincode and invalid email id on checkout page");
	
		  HomePage HomePage = new HomePage();
	      HomePage=PageFactory.initElements(driver, HomePage.getClass());
	      HomePage.searchproduct("sleeping budha");
		
		
		  Set<String>IDs= driver.getWindowHandles();
		  java.util.Iterator<String> iter=IDs.iterator();
		  String homewindow = iter.next(); 
		  String giftwindow = iter.next();
		 		  
		  driver.switchTo().window(giftwindow);
		  GiftPage GiftPage = new GiftPage();
		  GiftPage=PageFactory.initElements(driver, GiftPage.getClass());
		  GiftPage.sendkeys("searchaddressbox","11111122222223");
		  GiftPage.click("buynowbutton");
		  GiftPage.alertValidation("pincodealert");
		  System.out.println("Pincode alert is validated");
		  GiftPage.searchaddressbox.clear();
		  GiftPage.sendkeys("searchaddressbox","solapu");
		  GiftPage.click("firstdynamicaddress");
		  GiftPage.click("buynowbutton");
		  GiftPage.click("addonbutton");
		  GiftPage.sendkeys("loginEmailID", "asdfsdfasdfa");
		  GiftPage.alertValidation("checklogin");
	      GiftPage.sendkeys("loginEmailID", prop.getProperty("mailID"));
		  GiftPage.click("continuebutton");
		  GiftPage.sendkeys("pwd", prop.getProperty("pwd"));
		  GiftPage.click("continuebutton");
		  GiftPage.filladdToDelivery(driver,"", "", "");
		  GiftPage.alertValidation("nameisrequire");
		  GiftPage.alertValidation("addisrequire");
		  GiftPage.alertValidation("mobileisreqire");
		  log.info("TC_01 is passed");
		
		}
		catch(Exception e) {
			Logger log = Logger.getLogger("log4j");
			PropertyConfigurator.configure("log4j.properties");
			log.debug("TC_01 is failed");	
			log.info ("Screenshot is taken and saved at :"+TestUtil.Screenshotlocation);
			log.info ("Exception occured is :"+e);
		}
	}
	
	@Test(priority=2)
	public void TC_02() throws InterruptedException {
		try {
			Logger log = Logger.getLogger("log4j");
			PropertyConfigurator.configure("log4j.properties");
		  log.info("TC_02:Verify user able to place a order By selecting clicking on search button");
		  HomePage HomePage = new HomePage();
	      HomePage=PageFactory.initElements(driver, HomePage.getClass());
	      HomePage.searchproduct("sleeping budha");
		
		
		  Set<String>IDs= driver.getWindowHandles();
		  java.util.Iterator<String> iter=IDs.iterator();
		  String homewindow = iter.next(); 
		  String giftwindow = iter.next();
		 		  
		  driver.switchTo().window(giftwindow);
		  GiftPage GiftPage = new GiftPage();
		  GiftPage=PageFactory.initElements(driver, GiftPage.getClass());
		  GiftPage.sendkeys("searchaddressbox","solapu");
		  GiftPage.click("firstdynamicaddress");
		  //GiftPage.scrooldownTo("buynowbutton");
		  GiftPage.click("buynowbutton");
		  GiftPage.click("addoncheckbox");
		  GiftPage.click("addonbutton");
		  GiftPage.sendkeys("loginEmailID", prop.getProperty("mailID"));
		  GiftPage.click("continuebutton");
		  GiftPage.sendkeys("pwd", prop.getProperty("pwd"));
		  GiftPage.click("continuebutton");
		  GiftPage.alertValidation("deliveryDetails");
		  GiftPage.filladdToDelivery(driver,"63 pachha peth solapur", "9876543210", "chaya");
	      log.info( "TC_02 is passed");
		}
		catch(Exception e) {
			Logger log = Logger.getLogger("log4j");
			PropertyConfigurator.configure("log4j.properties");
			log.debug("TC_02 is failed");	
			log.info ("Screenshot is taken and saved at :"+TestUtil.Screenshotlocation);
			log.info ("Exception occured for TC_02 :"+e);
		}
		
	}
	
	
}
