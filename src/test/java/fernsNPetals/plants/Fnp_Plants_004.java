package fernsNPetals.plants;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.BonsaiPlants;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

//Verify UI of the Gift Booking window
public class Fnp_Plants_004 extends TestBase{
	
	@Test
	public void Fnp_Plants_004() throws InterruptedException {
//	1.Launch the FNP Application  in the browser
	initialization();
	HomePage HomePage= new HomePage();
	HomePage= PageFactory.initElements(driver, HomePage.getClass());
	GiftPage GiftPage= new GiftPage();
	GiftPage= PageFactory.initElements(driver, GiftPage.getClass());
	BonsaiPlants BonsaiPlants= new BonsaiPlants();
	BonsaiPlants= PageFactory.initElements(driver, BonsaiPlants.getClass());
//	2.Click on the Plants  link
	HomePage.mouseHover("plantsmenu");
	
//	3.Click on Bonsai Plants link 
	Thread.sleep(1000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", BonsaiPlants.BonsaiPlants);	
//	4.Click on Bonsai Beauty
	
	js.executeScript("arguments[0].click();", BonsaiPlants.Marvellous_Bonsai_Plant);
	
	Set<String>IDs= driver.getWindowHandles();
	java.util.Iterator<String> iter=IDs.iterator();
	String homewindow = iter.next(); 
	String cartwindow = iter.next();
	
    driver.switchTo().window(cartwindow);
//	
//	    Browser should display the following fields in the gift booking window:
//		a) Home> Bonsai Beauty 
    GiftPage.vrify("H_Marvellous_Bonsai_Plant");

    //		b) Bonsai Beauty,Cost,Reviews
    GiftPage.vrify("H_Marvellous_Bonsai_Plant");
    GiftPage.vrify("H2_Marvellous_Bonsai_Plant");
    GiftPage.vrify("Cost");
    GiftPage.vrify("Reviews");
    
//		c)View more details
    GiftPage.vrify("View_Product_Details");
//		d) Area/ pin code text box
    GiftPage.vrify("searchaddressbox");
//		e) ADD TO CART button
    GiftPage.vrify("addtocartbutton");
//		f) BUY NOW button
    GiftPage.vrify("buynowbutton");
    driver.quit();
 }
}
