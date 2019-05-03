package fernsNPetals.Universalsearch;

import java.util.Set;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

	//@Listeners(fernsNPetals.extentReportListener.ExtentReporterNG.class)
	public class functionalNegativeFlow extends TestBase{
		HomePage HomePage;
		GiftPage GiftPage;
	   
		
		public functionalNegativeFlow() {
			super();
		}
		

		@BeforeMethod
		public void setUp() {
			initialization();
			HomePage = new HomePage();
			GiftPage = new GiftPage();
		
		}
		
		@Test
		public void negativeFlow() throws InterruptedException{
		     HomePage=PageFactory.initElements(driver, HomePage.getClass());
		     HomePage.searchproduct("sleeping budha");
			
			
			Set<String>IDs= driver.getWindowHandles();
			  java.util.Iterator<String> iter=IDs.iterator();
			  String homewindow = iter.next(); 
			  String giftwindow = iter.next();
			 		  
			  driver.switchTo().window(giftwindow);
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
			  
			  //aqGiftPage.placeorder();
			 // GiftPage.checkPGUrl();
		}
			  
			

		

		
		  @AfterMethod public void tearDown(){ 
			  driver.quit(); }
		 

	}
