package fernsNPetals.Personalised;

import java.io.IOException;

import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
//Verify the functionality of with empty message textbox 
//ignored this testcase .Unable to find this functionality.
public class FNP_Personalized_023 extends TestBase{
	@Test
	public void FNP_Personalized_023() throws IOException {
		try {
		
//			1.Launch the FNP Application  in the browser
//			2.Click on the Personalized  link
//			3.Click on  All Personalised Gifts link 
//			4.Click on Personalize Photo Cushion
//			5.Enter Area/pincode in the textbox
//			6.Select suggestions under the textbox
//			7.Select Delivery date
//			8.Select photo between 100KB-10MB
//			9.Click on Buy Now button
//			*Note:Expected step1 has to be verified
//
//			1.Browser should display an message 'please enter your message'
			
			
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
