package fernsNPetals.Currency;

import java.io.IOException;

import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
//Verify user able to view the selected currency in Delivery details page
public class TC_04 extends TestBase{
	@Test
	public void TC_04() throws IOException {
		try {
			
//			1. Launch the FNP Application  in the browser
//			2.Mouse over the currency header
//			3.Click on ‘EUR-Euro’
//			4.Mouse over ‘Anniversary ’ link
//			5.Mouse over flowers
//			6.Click on ‘Vivd-Red Roses Bouquet ’
//			7.Enter Area
//			8.Select delivery date
//			9.Select shipping method as ‘Stanard delivery’
//			10.Select time slot
//			11.Click on ‘Buy Now’ button
//			12.Click on continue with one add-on
//			Note:Expected step1 has to be verified
//			13.Enter Email id and click on continue button
//			14.Enter Password and click on continue button
//			Note:Expected step2 has to be verified
//			
//			1.Browser should navigate to check out login page.
//			2.Browser should navigate to Delivery details page and displays following fields:
//			a) Product quantity with EUR price and Addon product quantity with EUR price
//			b)Right side of the page shows
//			'PRODUCT DETAILS’
//			Total product price in EUR 
//			Shipping charges in EUR
//			TOTAL price in EUR
			
			
			
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
