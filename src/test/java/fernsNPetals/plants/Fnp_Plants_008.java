package fernsNPetals.plants;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.BonsaiPlants;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

//Verify User able to Remove the Product in the Cart page
public class Fnp_Plants_008 extends TestBase {
	
	@Test
	public void Fnp_Plants_008() throws InterruptedException {
//	1.Launch the FNP Application  in the browser
	initialization();
	HomePage HomePage = new HomePage();
	HomePage = PageFactory.initElements(driver, HomePage.getClass());
	GiftPage GiftPage = new GiftPage();
	GiftPage = PageFactory.initElements(driver, GiftPage.getClass());
	BonsaiPlants BonsaiPlants = new BonsaiPlants();
	BonsaiPlants = PageFactory.initElements(driver, BonsaiPlants.getClass());
//	2.Click on the Plants  link
	HomePage.mouseHover("plantsmenu");
//	3.Click on Bonsai Plants link 
	BonsaiPlants.click("BonsaiPlants");
//	4.Click on Bonsai Beauty
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", BonsaiPlants.Marvellous_Bonsai_Plant);
//	5.Enter Area/pincode in the texbox
	Set<String> IDs = driver.getWindowHandles();
	java.util.Iterator<String> iter = IDs.iterator();
	String homewindow = iter.next();
	String cartwindow = iter.next();

	driver.switchTo().window(cartwindow);
	GiftPage.sendkeys("searchaddressbox", "hyderabad");
	
//	6.Select suggestions under the textbox
	GiftPage.clickfirstAddressintheList(driver);
	
//	7.Click on Change Date Link
	
//	8.Select Delivery date
//	9.Click on Add To Cart Button
	GiftPage.click("addtocartbutton");
//	10.Click on Continue with Add-on
	GiftPage.click("addoncheckbox");
	GiftPage.click("addonbutton");
//	11.Click on Cart lcon in header tool bar
	GiftPage.click("cartbtn");
//	12.Click on Remove link
	GiftPage.click("delete_item_0");
//	*Note:Expected step1 has to be verified
	GiftPage.vrify("deletedialog");
//	13.Click on OK button 
	GiftPage.click("deleteYesBtn");
//	*Note:Expected step2 has to be verified
	GiftPage.vrify("urCartisEmpty");
	driver.quit();
//	1.Browser should displays an Alert message
//	'Are you sure you want to delete? ' 
//	2.Browser should display an window which shows an message i.e:
//	'Your cart is empty,so its sad  and lonely'

}
}
