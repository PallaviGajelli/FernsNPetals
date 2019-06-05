package fernsNPetals.Microsite;
//Verify user able to Add the product by selecting the Product from micro site

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.AllCakes;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;


public class TC_01 extends TestBase{
	
	@Test
	public void functionalPositiveFlow1()throws InterruptedException{
        
		
//		1. Launch the FNP Application  in the browser
		initialization();
		HomePage HomePage = new HomePage(); 
		HomePage=PageFactory.initElements(driver,HomePage.getClass());
		GiftPage GiftPage= new GiftPage();
		GiftPage=PageFactory.initElements(driver,GiftPage.getClass());
		AllCakes AllCakes= new AllCakes();
		AllCakes=PageFactory.initElements(driver,AllCakes.getClass());

//		2. Mouse over cakes link
		HomePage.mouseHover("cakesmenu");
		Thread.sleep(1000);

//		3. Click on All cakes link
		AllCakes.click("AllCakes");
		Thread.sleep(1000);
		
//      4.Click on Eggless cake	
		AllCakes.click("EgglessCake");
        Thread.sleep(2000);
   
  
//		5.Select city from delivery to options
		AllCakes.click("DeliveryCity");
		Thread.sleep(1000);
		AllCakes.click("hyderabad");
		Thread.sleep(2000);
		
//		Note:Expected step1 has to be verified
		AllCakes.Assert("plpHeading", "Eggless Cakes to Hyderabad Online");
		System.out.println("£££££££££££Eggless Cakes to Hyderabad Online: title is validated");
		Thread.sleep(1000);
		
//		6.Click on pineapple cake
		
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].click();", AllCakes.PinappleCake);
	
		 /*
		 * Actions action = new Actions(driver);
		 * action.moveToElement(AllCakes.PinappleCake).click(AllCakes.PinappleCake).
		 * build().perform(); Thread.sleep(2000);
		 */
		
		Set<String>IDs= driver.getWindowHandles();
		java.util.Iterator<String> iter=IDs.iterator();
		String homewindow = iter.next(); 
		String giftwindow = iter.next();
		driver.switchTo().window(giftwindow);

//		7.Enter area/pincode 
		GiftPage.searchaddressbox.sendKeys("Hyderabad");
		GiftPage.clickfirstAddressintheList(driver);
		Thread.sleep(2000);
		
//		8.Select shipping method //scroll down to select 
	    js.executeScript("arguments[0].click();", GiftPage.FreeDelivery);
	    Thread.sleep(1000);
		
//		9. Click on Add To Cart button
		  js.executeScript("arguments[0].click();", GiftPage.addtocartbutton);
		  Thread.sleep(2000);
	
//		10. Click on Continue without addons
		GiftPage.click("withoutaddonbutton");
		AllCakes.Assert("PinappleCakecartProduct", "Pineapple Cake Half kg");
		Thread.sleep(1000);
		System.out.println("£££££££££Product added to cart");
		
		driver.close();
	
//	Expected Result
//	1.It should display the category page 
//	With the following fields:
//	a) Online Cake Delivery in Hyderabad
//	b) Home>Cakes Online>Cakes to
//	Hyderabad
//
//	2.It should display the added product from
//	The cart

	
	}
}
