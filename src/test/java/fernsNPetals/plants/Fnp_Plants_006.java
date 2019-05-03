package fernsNPetals.plants;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.BonsaiPlants;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

//Verify the functionality of the 'Add To Cart' button by entering data by selecting Add-on
public class Fnp_Plants_006 extends TestBase {

	@Test
	public void Fnp_Plants_006() throws InterruptedException {

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

		Set<String> IDs = driver.getWindowHandles();
		java.util.Iterator<String> iter = IDs.iterator();
		String homewindow = iter.next();
		String cartwindow = iter.next();

		driver.switchTo().window(cartwindow);
//	5.Enter Area/pincode in the texbox
		GiftPage.sendkeys("searchaddressbox", "hyderabad");

//	6.Select suggestions under the textbox
		GiftPage.clickfirstAddressintheList(driver);
//	7.Click on Change Date Link
		// GiftPage.click("datetimeshipping");
//	8.Select Delivery date
		// GiftPage.selectDayAfterTomorrow();
//	9.Click on Add To Cart Button
		GiftPage.click("addtocartbutton");
//	10.Click on continue with Addon
		GiftPage.click("addoncheckbox");

		GiftPage.click("addonbutton");
//	*Note:Expected step1 has to be verified
//	
//	1.Browser should display the added product in the Cart
		GiftPage.vrify("Marvellous_Bonsai_Plant_AddedToCart");
		GiftPage.vrify("addonAddedToCart");

		//driver.quit();

	}
}
