package fernsNPetals.Currency;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.FlowersPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;
//Verify user able to view the selected currency for products in PDP page
public class TC_02 extends TestBase {
	@Test
	public void TC_02() throws Exception {
		try {
			
//			1. Launch the FNP Application  in the browser
			initialization();
			HomePage HomePage= new HomePage();
			HomePage=PageFactory.initElements(driver, HomePage.getClass());
			FlowersPage FlowersPage=new FlowersPage();
			FlowersPage=PageFactory.initElements(driver, FlowersPage.getClass());
			GiftPage GiftPage=new GiftPage();
			GiftPage=PageFactory.initElements(driver, GiftPage.getClass());
//			2.Mouse over the currency header
			HomePage.mouseHover("currency_sym");
			
//			3.Click on ‘EUR-Euro’
			HomePage.Euro.click();
//			4.Mouse over ‘Anniversary ’ link
			HomePage.mouseHover("anniversarymenu");
//			5.Mouse over flowers
			FlowersPage.anniversary_flowers.click();
//			6.Click on ‘Vivd-Red Roses Bouquet ’
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", FlowersPage.VividRedRosesBouquet);
			GiftPage.navigateToCart(driver);
			Thread.sleep(2000);
//			 It should display following felds:
//				 a) product name
			String heading=GiftPage.itemheadingproductname.getText();
			Assert.assertEquals(heading, "Vivid - 10 Red Roses Bouquet");
			
//				 b) Euro currency symbol
			String crr= GiftPage.currsymbol.getText();
			Assert.assertEquals(crr, "EUR");
			
//				 c) Enter area pincode textfied and addtocart button,Buy now button
			GiftPage.vrify("searchaddressbox");
			GiftPage.vrify("addtocartbutton");
			GiftPage.vrify("buynowbutton");
			
			
			
			
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
