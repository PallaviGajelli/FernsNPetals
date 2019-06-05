package fernsNPetals.Anniversary_Flowers;

import java.io.IOException;

import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
//Verify user is able to launch the FNP Application 
public class FNP_Anniversary_flow_001 extends TestBase{
	@Test
	public void FNP_Anniversary_flow_001() throws IOException {
		try {

//			1. Launch the FNP Application  in the browser
//			
//			User should be able to launch the FNP application 




			
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
