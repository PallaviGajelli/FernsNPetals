package fernsNPetals.plants;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.BonsaiPlants;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

//Verify 'Buy Now' button functionality without Entering data in gift booking window
public class Fnp_Plants_010 extends TestBase{
	
	@Test
	public void Fnp_Plants_010() throws InterruptedException {
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
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", BonsaiPlants.BonsaiPlants);
//	4.Click on Bonsai Beauty
		
		js.executeScript("arguments[0].click();", BonsaiPlants.Marvellous_Bonsai_Plant);
		GiftPage.navigateToCart(driver);
		Thread.sleep(2000);
//	5.leave the fields empty
		
//	6.Click on Buy Now button
		GiftPage.click("buynowbutton");
//	*Note:Expected step1 has to be verified
//	
//	Browser should display message 'Select Delivery area to continue'
		GiftPage.vrify("pincodealert");
		driver.quit();

}
}
