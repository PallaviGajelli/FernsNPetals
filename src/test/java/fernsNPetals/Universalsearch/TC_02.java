package fernsNPetals.Universalsearch;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.Set;


import fernsNPetals.base.TestBase;
import fernsNPetals.pages.HomePage;
import fernsNPetals.pages.GiftPage;
//@Listeners(fernsNPetals.extentReportListener.ExtentReporterNG.class)
public class TC_02 extends TestBase{

	public TC_02() {
		super();
	}
	

	@BeforeMethod
	public void setUp() {
		initialization();
	}
	
	@Test
	public static void positiveFlow() throws InterruptedException{
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
	}
		  
		

	

	
	  @AfterMethod public void tearDown(){ 
		  driver.quit(); }
	 

}
