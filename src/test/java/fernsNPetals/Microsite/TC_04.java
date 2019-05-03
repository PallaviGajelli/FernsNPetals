package fernsNPetals.Microsite;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.AllCakes;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

public class TC_04 extends TestBase {

	// functionalNegativeFlow :Verify user able to place a Order by using Product
	// from The micro site
	@Test
	public void functionalNegativeFlow() throws InterruptedException {
//	Test Steps	
//	1.Launch FNP Application in the browser
		initialization();
		Thread.sleep(2000);
		HomePage HomePage = new HomePage();
		HomePage = PageFactory.initElements(driver, HomePage.getClass());
		GiftPage GiftPage = new GiftPage();
		GiftPage = PageFactory.initElements(driver, GiftPage.getClass());
		AllCakes AllCakes = new AllCakes();
		AllCakes = PageFactory.initElements(driver, AllCakes.getClass());
		CheckoutPage CheckoutPage = new CheckoutPage();
		CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
//	2. Mouse over cakes link
		HomePage.mouseHover("cakesmenu");
		Thread.sleep(1000);
//	3. Click on All cakes link
		AllCakes.click("AllCakes");
		Thread.sleep(1000);
//	4.Scroll down the page Click on Egg less cake
		AllCakes.click("EgglessCake");
		Thread.sleep(2000);

//	5.Select city from delivery to options
		AllCakes.click("DeliveryCity");
		Thread.sleep(1000);
		AllCakes.click("hyderabad");
		Thread.sleep(2000);
//	6.Click on pineapple cake
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", AllCakes.PinappleCake);
		Thread.sleep(2000);
//	7.Enter area/pin code 
		Set<String> IDs = driver.getWindowHandles();
		java.util.Iterator<String> iter = IDs.iterator();
		String homewindow = iter.next();
		String giftwindow = iter.next();
		driver.switchTo().window(giftwindow);

		GiftPage.sendkeys("searchaddressbox", "Hyderabad");
		GiftPage.clickfirstAddressintheList(driver);
		Thread.sleep(2000);
//	8.Select shipping method
		js.executeScript("arguments[0].click();", GiftPage.FreeDelivery);
		Thread.sleep(2000);
//	9. 

//	10. Click on Buy now  button
		js.executeScript("arguments[0].click();", GiftPage.buynowbutton);
		Thread.sleep(2000);
//	11. Click on Continue without addon-on
		GiftPage.click("withoutaddonbutton");
		Thread.sleep(2000);
//	10.Enter Invalid Mail id and click on continue button
		CheckoutPage.sendkeys("loginEmailID", "sdfsdffczxzxcc");
		CheckoutPage.click("continuebutton");
		boolean invalidId= CheckoutPage.checklogin.isDisplayed();
		if (invalidId==true) {
			System.out.println("££££££££ this is invalid emailid alert £££££££££££££");
		}else {
			System.out.println("£££££££££££this is valid email ID £££££££££££££££");
		}

//	11.Enter valid mail id and Password and click on continue button
		CheckoutPage.sendkeys("loginEmailID", "testmeapp1@gmail.com");
		CheckoutPage.click("continuebutton");
//	Note:Expected step1 has to be verified

//	12.Click on Add new address and leave the all fields empty and click on continue button
		CheckoutPage.click("submitaddressbutton");
		CheckoutPage.alertValidation("nameisrequire");
		CheckoutPage.alertValidation("addisrequire");
		CheckoutPage.alertValidation("mobileisreqire");
//	Note:Expected step2 has to be verified
//	13.Enter data in all fields and click on Save button.
		CheckoutPage.filladdressToDelivery(driver,"chaya", "Madhapur", "9876543210");
//	14.Accept terms and conditions 
		CheckoutPage.placeorder(driver);
//	And click on Proceed to pay button

//	Expected Result
//	1.It should validation message ‘Please
//	 Enter valid mail id’
//	2.It should display validation message ‘enter Recipients name’

//	    Test Data
//	    1.https://www.fnp.com/
//		2.Area/Pincode:1112223
//		3.Existing user:
//		Mail Id: 12@mail.com
//		Pd: test123
//		4.Name:chaya
//		5.Address:Madhapur
//		6.Mobile no:9876543210
//		7.Email:test@gmail.com

	}
}
