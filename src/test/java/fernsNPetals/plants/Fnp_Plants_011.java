package fernsNPetals.plants;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.BonsaiPlants;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

//Verify User able to view the Delivery Date in the gift booking window
public class Fnp_Plants_011 extends TestBase{
	
	@Test
	public void Fnp_Plants_011() throws InterruptedException {
	
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
		GiftPage.click("datetimeshipping");
		GiftPage.selectDayAfterTomorrow(driver);
		driver.quit();
		
//	8.Select Delivery date
//	*Note:Expected step1 has to be verified
//	
//	Browser should displays Delivery Date in the textbox

}
}
