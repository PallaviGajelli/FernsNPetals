package fernsNPetals.Login_Page;

import java.io.IOException;

import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;

public class FNP_FNP_Applications_001 extends TestBase{
	@Test
	public void FNP_FNP_Applications_001() throws IOException {
		try {
			
			initialization();
			System.out.println("User is able to launch the FNP application ");
			
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
