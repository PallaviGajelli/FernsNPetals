package fernsNPetals.AllFiltersInCategoryPage;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.BonsaiPlants;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.FlowersPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

public class TC_01_to_04 extends TestBase{
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	@BeforeMethod
	public void setup() {
		
	}
//Verify user able to view the Filters in category page
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
	}
    
	
//Verify functionality of Filters in category page
	@Test
	public void TC_02() throws IOException {
		try {
			
//			1. Launch the FNP Application  in the browser
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
			FlowersPage.anniversary_flowers.click();
//			3.Mouse over Gift type and select roses
			FlowersPage.mouseHover("GiftTypeFlowers");
			FlowersPage.Roses.click();
//			Note:Expected step1 has to be verified
			//////////////////////////
//			4.Mouse over Occasion link
			HomePage.mouseHover("occassionsmenu");
//			Note:Expected step2 has to be verified
			FlowersPage.AnniversaryUnderOccation.isDisplayed();
			System.out.println("Anniversary Under Occation id displayed");
//			5.Mouse over the Delivery city
			FlowersPage.mouseHover("DeliveryCity");
//			6.Click on Banglore
			
			js.executeScript("arguments[0].click();", FlowersPage.Bangalore);
			
//			Note:Expected step3 has to be verified
			Assert.assertEquals((FlowersPage.DeliveryCity.getText()), "Delivery City\nBangalore");
			System.out.println("It is displaying Selected city under Delivery city Link");
//			7.Click on Recommended drop down
			FlowersPage.recomendedDropDown.click();
//			8.Click on price Low to High
			FlowersPage.PriceLowtoHigh.click();
//			Note:Expected step4 has to be verified
			////////////////
//			9.Mouse over Price link
			FlowersPage.mouseHover("PriceAnniversary");
//			10.Click on 500+
			js.executeScript("arguments[0].click();", FlowersPage.Price500Plus);
			//FlowersPage.Price500Plus.click();
//			Note:Expected step5 has to be verified
			Assert.assertEquals((FlowersPage.PriceAnniversary.getText()), "Price\nGBP 5.81 +");
			System.out.println("It is display the selected cost the under the price link");
//			
//			1.It should display the Roses for anniversary and display the all roses products in category page
//          2.It should display the Anniversary under the occasions tab
//          3.It should display under Delivery city Link Selected city is displays 
//          4.It should display the product price from Low To high
//          5. It should display the selected cost the under the price link.
			
			
		}catch(Exception e) {
		      throw(e);
		}
    }
	
//Verify user able to place a order by selecting filters in Category page	
	@Test
	public void TC_03() throws Exception {
	try {

			
			
		}catch(Exception e) {
		      throw(e);
		}
	}
	
//Verify user able to place a order by selecting filters in Category page With negative validations	
	@Test
	public void TC_04() throws IOException {
		try {
			
//			1. Launch the FNP Application  in the browser
//			2.Mouse over Anniversary link
//			3.Mouse over Gift type link
//			4.Click on Roses
//			5.Mouse over Occasion link
//			6.Mouse over the Delivery city
//			7.Click on Bangalore
//			8.Click on Recommended drop down
//			9.Click on price Low to High
//			10.Mouse over Price link
//			11.Click on 500+
//			12.select any product (EX:Elegance -Pink Rose Bouquet)
//			13.Enter area name and select delivery date
//			(Ex:select standard delivery date)
//			14. Click on Buy now  button
//			15. Click on Continue without addon-on
//			16.Enter Invalid Mail id and click on continue button
//			Note:Expected step1 has to be verified
//			17.Enter valid mail id and Password and click on continue button
//			18.Click on Add new address and leave the all fields empty and click on continue button
//			Note:Expected step2 has to be verified
//			19.Enter data in all fields and click on Save button.
//			20.Accept terms and conditions 
//			And click on Proceed to pay button
//			
//			1.It should validation message ‘Please
//			 Enter valid mail id’
//			2.It should display validation message ‘enter Recipients name’
//
//			3.It should display Thank you page
//			
//			1.https://www.fnp.com/
//				2.Area/city:Kondapur
//				3.Email id:testqa111@gamil.com
//				4.Password:testqa111
//				5.Name:chaya
//				6.Address:Madhapur
//				7.Mobile no:9876543210
//				8.Email:test@gmail.com
			
			
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
   
