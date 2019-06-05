package fernsNPetals.AllFiltersInCategoryPage;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.FlowersPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;
//Verify user able to view the Filters in category page
public class TC_01 extends TestBase {

	@Test
	public void TC_01() throws IOException {
		try {
//1. Launch the FNP Application  in the browser
	        initialization();
		HomePage HomePage = new HomePage();
		HomePage = PageFactory.initElements(driver, HomePage.getClass());
		FlowersPage FlowersPage = new FlowersPage();
		FlowersPage = PageFactory.initElements(driver, FlowersPage.getClass());
		
			
//			2.Mouse over Anniversary link
			HomePage.mouseHover("anniversarymenu");
//			3.Click on flowers
			FlowersPage.anniversary_flowers.click();
//			
//			It should display the category page with
//			Filters:
			FlowersPage.verifyFiltersInCategoryPage();

		}catch(Exception e) {
		      throw(e);
		}
		finally {
			 driver.quit();
			 Runtime rt =Runtime.getRuntime();
			 Process proc = rt.exec("taskkill /im chrome.exe /f /t");
		}
	}
}
