package fernsNPetals.AllFiltersInCategoryPage;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.FlowersPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

public class TC_02 extends TestBase {

	// Verify functionality of Filters in category page
	@Test
	public void TC_02() throws Exception {
		try {

//				1. Launch the FNP Application  in the browser
			initialization();
			HomePage HomePage = new HomePage();
			HomePage = PageFactory.initElements(driver, HomePage.getClass());
			FlowersPage FlowersPage = new FlowersPage();
			FlowersPage = PageFactory.initElements(driver, FlowersPage.getClass());
			
//				2.Mouse over Anniversary link
			HomePage.mouseHover("anniversarymenu");
			FlowersPage.anniversary_flowers.click();
//				3.Mouse over Gift type and select roses
			FlowersPage.mouseHover("GiftTypeFlowers");
			FlowersPage.Roses.click();
//				Note:Expected step1 has to be verified
			//////////////////////////
//				4.Mouse over Occasion link
			HomePage.mouseHover("occassionsmenu");
//				Note:Expected step2 has to be verified
			FlowersPage.AnniversaryUnderOccation.isDisplayed();
			System.out.println("Anniversary Under Occation id displayed");
//				5.Mouse over the Delivery city
			FlowersPage.mouseHover("DeliveryCity");
//				6.Click on Banglore
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", FlowersPage.Bangalore);

//				Note:Expected step3 has to be verified
			Assert.assertEquals((FlowersPage.DeliveryCity.getText()), "Delivery City\nBangalore");
			System.out.println("It is displaying Selected city under Delivery city Link");
//				7.Click on Recommended drop down
			FlowersPage.recomendedDropDown.click();
//				8.Click on price Low to High
			FlowersPage.PriceLowtoHigh.click();
//				Note:Expected step4 has to be verified
			////////////////
//				9.Mouse over Price link
			FlowersPage.mouseHover("PriceAnniversary");
//				10.Click on 500+
			js.executeScript("arguments[0].click();", FlowersPage.Price500Plus);
			// FlowersPage.Price500Plus.click();
//				Note:Expected step5 has to be verified
			Thread.sleep(1000);
			Assert.assertEquals((FlowersPage.PriceAnniversary.getText()), "Price\nGBP 5.81 +");
			System.out.println("It is display the selected cost the under the price link");
//				
//				1.It should display the Roses for anniversary and display the all roses products in category page
//	          2.It should display the Anniversary under the occasions tab
//	          3.It should display under Delivery city Link Selected city is displays 
//	          4.It should display the product price from Low To high
//	          5. It should display the selected cost the under the price link.

		} catch (Exception e) {
			throw (e);
		}

		finally {
			driver.quit();
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec("taskkill /im chrome.exe /f /t");
		}
	}
}
