package fernsNPetals.AllFiltersInCategoryPage;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
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
		GiftPage GiftPage = new GiftPage();
		GiftPage = PageFactory.initElements(driver, GiftPage.getClass());
		FlowersPage FlowersPage = new FlowersPage();
		FlowersPage = PageFactory.initElements(driver, FlowersPage.getClass());
		CheckoutPage CheckoutPage = new CheckoutPage();
		CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
			
//			2.Mouse over Anniversary link
			HomePage.mouseHover("anniversarymenu");
//			3.Click on flowers
			FlowersPage.anniversary_flowers.click();
//			
//			It should display the category page with
//			Filters:
//			a) Home>All flowers>Anniversary Flowers
			FlowersPage.breadcrumb_wrapper.isDisplayed();
			System.out.println("breadcrumb-wrapper:Home>All flowers>Anniversary Flowers is displayed");
//			b) Recommended drop down
			FlowersPage.recomendedDropDown.isDisplayed();
			System.out.println("recomended Drop Down is displayed");
//			c)Gift type link with flowers tab
			FlowersPage.GiftTypeFlowers.isDisplayed();
			System.out.println("Gift type link with flowers tab is displayed");
//			d)Occasion link with Anniversary
			FlowersPage. OccasionAnniversary.isDisplayed();
			System.out.println("Occasion link with Anniversary is displayed");
//			e)Delivery city link
			FlowersPage.DeliveryCity.isDisplayed();
			System.out.println("Delivery city link is displayed");
//			f) Price
			FlowersPage.PriceAnniversary.isDisplayed();
			System.out.println("price is displayed");
			
			
			
			
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
