package fernsNPetals.Personalised;

import java.io.IOException;

import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
//Verify BVA of message textbox
//ignored this test case as functionality is changed.
public class FNP_Personalized_039 extends TestBase{
	@Test
	public void FNP_Personalized_039() throws IOException {
		try {
			
			
			
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
