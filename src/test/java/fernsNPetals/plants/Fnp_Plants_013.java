package fernsNPetals.plants;
//Verify Functionality of the 'Buy Now' button by entering Invalid Pin/ Area

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.BonsaiPlants;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

public class Fnp_Plants_013 extends TestBase{
	


	@Test
	public void Fnp_Plants_013() throws InterruptedException {
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
//	5.Enter Invalid  pin code in the textbox
		GiftPage.navigateToCart(driver);
		Thread.sleep(2000);
		GiftPage.sendkeys("searchaddressbox", "adsdsdhfaekfh");
		GiftPage.IsAddressintheListDisplayed(driver);
		System.out.println("Browser is not displaying suggestions under the textbox for invalid add");
//	*Note:Expected step2 has to be verified
//	6.click on buy now button
		Thread.sleep(1000);
		GiftPage.click("buynowbutton");
		Thread.sleep(1000);
		GiftPage.vrify("pincodealert");
		driver.quit();
		
//	
//	1.Area & pin code text box there no Suggestions are displayed
//	2 Browser should display an message
//	'Select Delivery Area To continue'

	}
}
