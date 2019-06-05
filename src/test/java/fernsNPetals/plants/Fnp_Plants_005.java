package fernsNPetals.plants;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.BonsaiPlants;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

//Verify the functionality of the 'Add To Cart' button without entering data in gift booking window 
public class Fnp_Plants_005 extends TestBase{
	
	@Test
	public void Fnp_Plants_005() throws InterruptedException {
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
//	5.Leave the fields empty
		
//	6.Click on continue button
	    Thread.sleep(1000);
		GiftPage.buynowbutton.click();
		
//	*Note:Expected step1 has to be verified
	
//	1.Browser should display an  message 'select Delivery Area to continue'
		GiftPage.vrify("pincodealert");
		driver.quit();

}
}
