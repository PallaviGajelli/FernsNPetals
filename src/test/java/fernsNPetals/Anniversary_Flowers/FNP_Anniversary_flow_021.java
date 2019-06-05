package fernsNPetals.Anniversary_Flowers;

import java.io.IOException;

import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
//Verify functionality of the 'Change' button in delivery details page
public class FNP_Anniversary_flow_021 extends TestBase{
	@Test
	public void FNP_Anniversary_flow_021() throws IOException {
		try {
			
//			1. Launch the FNP Application  in the browser
//			2. click on the Anniversary  link
//			3.click on  flowers link 
//			4.click on Colours Of Love
//			5.Enter Kondapur, Hyderabad (or) 500084 in  Area & City (or) PIN textbox
//			6. Select Kondapur, Hyderabad, Telangana, India in the suggestion 
//			7.select delivery date
//			8.select shipping method as 
//			Fixed Time Delivery
//			9.select time slot 15:00 - 16:00Hrs
//			10.click on BUY NOW button
//			11.click on continue with one add on
//			12.In checkout login page,Click on email id 
//			13.Enter mail id and click on continue button
//			14.Enter Password and click on continue button
//			15.click change button
//			*Note:Expected step1 has to verified
//			16.click on next day 
//			17.select shipping method fixed time delivery
//			18.select time slot 16:00-17:00
//			*Note:Expected step2 has to verified
//			
//			1.Browser should displays the calendar
//			2.Browser should displays the updated time time in the delivery details page.
//			
//			URL:https://www.fnp.com/
//				Area/Pin code:Kondapur,Hydrebad (or) 500084
//				Email id:abc123@gmail.com
//				Password:abc123
			
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
