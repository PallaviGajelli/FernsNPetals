package fernsNPetals.Currency;

import java.io.IOException;

import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
//Verify user able to view the selected currency  in Thank you page
public class TC_05 extends TestBase{
	@Test
	public void TC_05() throws IOException {
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
//			15.click on new address
//			16.Enter all fields and click on save address button
//			17.Click on terms and conditions and click on proceed to checkout button
//			
//			1.Browser should navigate to check out login page.
//			2.Browser should navigate to Delivery details page
//			3.Browser should display Thank you page with following fields:
//			Product with EUR price
//			
//			1.https://www.fnp.com/
//				2.Area/city:Kondapur
//				3.Emailid:testqa111@gamil.com
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
