package fernsNPetals.Login_Page;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.HomePage;

public class FNP_FNP_Applications_002 extends TestBase{
	@Test
	public void FNP_FNP_Applications_002() throws IOException {
		try {
//			1. Launch the FNP Application  in the browser
			initialization();
			HomePage HomePage=new HomePage();
			HomePage=PageFactory.initElements(driver, HomePage.getClass());
//			Browser should display the Homepage
//			of the Application with the following fields in
//			the upper Right corner
		    HomePage.homepageverification();
//			1.Account
//			2.Cart
//			* Top of the page shows following fields:
//			Currency INR
//			Contact number
//			More option
//			* Left side of the page shows the following fields:
//			Fernsnpetals logo
//			search textbox
//			* Header toolbar shows with following fields:
//			FLOWERS
//			CAKES
//			PERSONALIZED
//			PLANTS
//			BIRTHDAY
//			ANNIVERSARY
//			OCCASSIONS
//			OTHER GIFTS
//			GLOBAL
			
			
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
