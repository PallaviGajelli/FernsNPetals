package fernsNPetals.Universalsearch;

import java.awt.RenderingHints.Key;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

	//@Listeners(fernsNPetals.extentReportListener.ExtentReporterNG.class)
	public class TC_01 extends TestBase{
	
		public TC_01() {
			super();
		}
		

		@BeforeMethod
		public void setUp() {
			initialization();
		}
		
		@Test
		public static void negativeFlow() throws InterruptedException{
			 HomePage HomePage = new HomePage();
		     HomePage=PageFactory.initElements(driver, HomePage.getClass());
		     CheckoutPage CheckoutPage = new CheckoutPage();
		     CheckoutPage=PageFactory.initElements(driver, CheckoutPage.getClass());
		     GiftPage GiftPage = new GiftPage();
			 GiftPage=PageFactory.initElements(driver, GiftPage.getClass());
		     
			  HomePage.searchproduct("sleeping budha");
		
		      Set<String>IDs= driver.getWindowHandles();
			  java.util.Iterator<String> iter=IDs.iterator();
			  String homewindow = iter.next(); 
			  String giftwindow = iter.next();
			 		  
			  driver.switchTo().window(giftwindow);
			  
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
			  Thread.sleep(1000);
			  GiftPage.filladdToDelivery(driver,"Madhapur", "9876543210", "chaya");
			  Thread.sleep(3000);
			  GiftPage.placeorder();
			  CheckoutPage.validation(CheckoutPage.paymentOptionspage);
			  
////			  1. Launch the FNP Application  in the browser
//			  initialization();
//			  Thread.sleep(1000);
////			  2.Enter valid keyword (Ex:Buddha)
//			  HomePage.searchbox.sendKeys("sleeping budha");
//			  Thread.sleep(1000);
////			  3.Select any product
////			  (EX:Sleeping Buddha)
//			  HomePage.item.click();
//			  Thread.sleep(1000);
////			  4.Enter Invalid Area/Pin code in the textbox
//			  GiftPage.navigateToCart(driver);
//			  Thread.sleep(1000);
//			  GiftPage.searchaddressbox.sendKeys("11111122222223");
//			  Thread.sleep(1000);
////			  Note:Expected step1 has to be verified
//			  GiftPage.validation(GiftPage.addressSuggestions);
//			  GiftPage.searchaddressbox.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//			  GiftPage.searchaddressbox.sendKeys("solapur");
//			  GiftPage.clickfirstAddressintheList(driver);
//			  Thread.sleep(1000);
////			  5.Click on Buy now button 
//			  GiftPage.buynowbutton.click();
//			  Thread.sleep(1000);
////			  6.Click on continue with one Add-on
//			  GiftPage.addoncheckbox.click();
//			  Thread.sleep(1000);
//			  GiftPage.addonbutton.click();
//			  Thread.sleep(1000);
////			  7.Enter Invalid Mail id and click on continue button
////			  Note:Expected step2 has to be verified
//			  GiftPage.loginEmailID.sendKeys("asdfsdfasdfa");
//			  Thread.sleep(1000);
//			  GiftPage.loginEmailID.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//			  Thread.sleep(1000);
//			  GiftPage.login("testmeapp1@gmail.com", "test@2018");
////			  9.Click on Add new address and leave the all fields empty and click on continue button
//			  GiftPage.filladdToDelivery(driver,"", "", "");
//			  Thread.sleep(1000);
//			  GiftPage.alertValidation("nameisrequire");
//			  GiftPage.alertValidation("addisrequire");
//			  GiftPage.alertValidation("mobileisreqire");
//			  Thread.sleep(1000);
////			  10.Accept terms and conditions 
//			  GiftPage.filladdToDelivery(driver,"Madhapur", "9876543210", "chaya");
//			  Thread.sleep(1000);
////			  And click on Proceed to pay button
//			  GiftPage.placeorder();
//			  Thread.sleep(1000);
////			  Note:Expected step3 has to be verified
//			  CheckoutPage.validation(CheckoutPage.paymentOptionspage);
//			  
//			  
////			  1.It should not display the
////			  Suggestions under the textbox.
////			  2.It should validation message ‘Please
////			   Enter valid mail id’
////			  3.It should display the Payment Page
//			  
		}
			  
			

		

//		
//		  @AfterMethod public void tearDown(){ 
//			  driver.quit(); }
//		 

	}
