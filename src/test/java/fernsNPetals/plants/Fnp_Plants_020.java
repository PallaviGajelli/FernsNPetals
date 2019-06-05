package fernsNPetals.plants;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.BonsaiPlants;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

//Verify UI of the Delivery Details page
public class Fnp_Plants_020 extends TestBase {

	@Test
	public void Fnp_Plants_020() throws InterruptedException, IOException {
try {
//	1.Launch the FNP Application  in the browser
	initialization();
	HomePage HomePage = new HomePage();
	HomePage = PageFactory.initElements(driver, HomePage.getClass());
	GiftPage GiftPage = new GiftPage();
	GiftPage = PageFactory.initElements(driver, GiftPage.getClass());
	BonsaiPlants BonsaiPlants = new BonsaiPlants();
	BonsaiPlants = PageFactory.initElements(driver, BonsaiPlants.getClass());
	CheckoutPage CheckoutPage = new CheckoutPage();
	CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
//2.Click on the Plants  link
	HomePage.mouseHover("plantsmenu");
//3.Click on Bonsai Plants link 
	Thread.sleep(1000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", BonsaiPlants.BonsaiPlants);
//4.Click on Bonsai Beauty
	js.executeScript("arguments[0].click();", BonsaiPlants.Marvellous_Bonsai_Plant);
//5.Enter Area/pincode in the texbox
	GiftPage.navigateToCart(driver);
	Thread.sleep(2000);
	GiftPage.searchaddressbox.sendKeys("hyderabad"); 
//6.Select suggestions under the textbox
	GiftPage.clickfirstAddressintheList(driver);
//7.Click on Change Date Link
	Thread.sleep(2000);
	GiftPage.datetimeshipping.click();
//8.Select Delivery date
	GiftPage.selectDayAfterTomorrow(driver);
	Thread.sleep(2000);
//9.Click on Buy Now button 
	GiftPage.click("buynowbutton");
	Thread.sleep(2000);
//10.Click on Continue With Addon
	GiftPage.click("addoncheckbox");
	Thread.sleep(1000);
	GiftPage.click("addonbutton");
	Thread.sleep(1000);
//	11.In checkout login page,Click on email id 
//	12.Enter Valid mail id and click on continue button i.e Existing user
//	13.Enter Password and click on continue button
		CheckoutPage.loginFnP();
		Thread.sleep(1000);
//	*Note:Expected step1 has to be verified
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
		CheckoutPage.verify("sendersdetails");}
catch(Exception e) {
	throw(e);
	
}
//finally 
//{
//	driver.quit();
//	 Runtime rt =Runtime.getRuntime();
//	 Process proc = rt.exec("taskkill /im chrome.exe /f /t");
//}
//1.URL:https://www.fnp.com/
//2.Area/pincode:kondapur/500084
//3.Email id:abc123@gmail.Com
//4.Password:abc123
		

	}

}
