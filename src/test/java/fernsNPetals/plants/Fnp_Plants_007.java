package fernsNPetals.plants;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.BonsaiPlants;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

//Verify User able to View the Product in the Cart page
public class Fnp_Plants_007 extends TestBase{
	@Test
	public void Fnp_Plants_007() throws InterruptedException {
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
	
	
//	*Note: Expected step1 has to be verified
//	
//	1.Browser should display the details about the product i.e
//	a)Product name with remove link
	GiftPage.vrify("Marvellous_Bonsai_Plant_AddedToCart");
	GiftPage.vrify("addonAddedToCart");
	GiftPage.vrify("delete_item_0");
	GiftPage.vrify("delete_item_1");
//	b)Send To
	GiftPage.vrify("SendTo");
//	c)Quantity 
	GiftPage.vrify("Quantity");
//	d)Amount
	GiftPage.vrify("Amount");
//	e)* Shipping charges to be displayed in the Order Summary page
	GiftPage.vrify("shippingChargesincart");
//	f)sub total 
	GiftPage.vrify("subtotalProduct");
	GiftPage.vrify("subtotaladdon");
//	g)Total
	//GiftPage.vrify("");
//	h)Proceed to Checkout button
	GiftPage.vrify("proceedToCheckoutinTheCartbtn");
//	i)Continue shopping button
    //driver.quit();
}
}

