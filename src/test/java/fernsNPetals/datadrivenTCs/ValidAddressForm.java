package fernsNPetals.datadrivenTCs;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



import fernsNPetals.base.TestBase;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;
import fernsNPetals.util.TestUtil;
//@Listeners(fernsNPetals.extentReportListener.ExtentReporterNG.class)
public class ValidAddressForm extends TestBase{

	HomePage HomePage;
	GiftPage GiftPage;
	TestUtil TestUtil;
   
	
	public ValidAddressForm() {
		super();
	}
	

	@BeforeTest
	public void setUp() throws InterruptedException 
	{
		initialization();
		HomePage = new HomePage();
		GiftPage = new GiftPage();
		TestUtil = new TestUtil(); 
	     HomePage=PageFactory.initElements(driver, HomePage.getClass());
	     HomePage.searchproduct("sleeping budha");
		
		
		Set<String>IDs= driver.getWindowHandles();
		  java.util.Iterator<String> iter=IDs.iterator();
		  String homewindow = iter.next(); 
		  String giftwindow = iter.next();
		 		  
		  driver.switchTo().window(giftwindow);
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
		  JavascriptExecutor js = (JavascriptExecutor) driver; 
		  js.executeScript("arguments[0].scrollIntoView();", GiftPage.Add_Delivery_Address);
			
		
		
		   
		  
	}
  
		  @Test(dataProvider="testdata")
		  public void addressform(String name,String address,String mobileno) throws InterruptedException  
		  {
				GiftPage.filladdressToDelivery(name,address,mobileno);
		        GiftPage.click("deleteaddress");
		        GiftPage.click("yesdelete");
			
	      }
		  
		  @DataProvider
			public Object[][] testdata(){
			  TestUtil=PageFactory.initElements(driver, TestUtil.getClass());
			  
			  Object data[][] = fernsNPetals.util.TestUtil.getTestData("address");
				return data;
			}

	

	
	
	  @AfterTest public void tearDown(){ 
		  driver.quit(); }
	 
	 

}
