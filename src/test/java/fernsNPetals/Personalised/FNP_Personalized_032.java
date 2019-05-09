package fernsNPetals.Personalised;

import java.io.IOException;

import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;

public class FNP_Personalized_032 extends TestBase {
	@Test
	public void FNP_Personalized_032() throws IOException {
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
