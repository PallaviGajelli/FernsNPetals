package fernsNPetals.plants;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.BonsaiPlants;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

//Verify 'Buy Now' button functionality with entering data by selection a Add-on
public class Fnp_Plants_014 extends TestBase{
	
	@Test
	public void Fnp_Plants_014() throws InterruptedException {
//		1.Launch the FNP Application  in the browser
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
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", BonsaiPlants.BonsaiPlants);
//	4.Click on Bonsai Beauty
		js.executeScript("arguments[0].click();", BonsaiPlants.Marvellous_Bonsai_Plant);
//	5.Enter Area/pincode in the texbox
		GiftPage.navigateToCart(driver);
		Thread.sleep(2000);
		GiftPage.searchaddressbox.sendKeys("hyderabad"); 
//	6.Select suggestions under the textbox
		GiftPage.clickfirstAddressintheList(driver);
//	7.Click on Change Date Link
		Thread.sleep(2000);
		GiftPage.datetimeshipping.click();
//	8.Select Delivery date
		GiftPage.selectDayAfterTomorrow(driver);
		Thread.sleep(2000);
//	9.Click on Buy Now button 
		GiftPage.click("buynowbutton");
		Thread.sleep(2000);
//	10.Click on Continue With Addon
		GiftPage.click("addoncheckbox");
		Thread.sleep(1000);
		GiftPage.click("addonbutton");
		Thread.sleep(1000);
//	*Note:Expected step1 has to be verified
		GiftPage.VerifyCheckoutPage(driver);
		driver.quit();
//	
//	1.Browser should navigate to Login/Sign
//	 up page
	
	}
}
