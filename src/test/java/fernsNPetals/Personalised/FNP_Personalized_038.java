package fernsNPetals.Personalised;

import java.io.IOException;

import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
//Verify the functionality of write your message textbox 
//ignored this test case as functionality is changed.
public class FNP_Personalized_038 extends TestBase {
	@Test
	public void FNP_Personalized_038() throws IOException {
		try {
			
//			1.Launch the FNP Application  in the browser
//			2.Click on the Personalized  link
//			3.Click on  All Personalised Gifts link 
//			4.Click on Shining Memory Personalized Lamp
//			5.Enter Area/pincode in the textbox
//			6.Select suggestions under the textbox
//			7.Select Delivery date
//			8.Leave the field write message textbox empty
//			9.Click on Buy Now button
//			*Note:Expected step1 has to be verified
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
