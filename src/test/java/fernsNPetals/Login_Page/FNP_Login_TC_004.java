package fernsNPetals.Login_Page;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.HomePage;
//Verify UI of the log in /sign up page
public class FNP_Login_TC_004 extends TestBase{
	@Test
	public void FNP_Login_TC_004() throws Exception {
		try {

//			1.Launch Fnp application in the browser
			initialization();
			HomePage HomePage=new HomePage();
			HomePage=PageFactory.initElements(driver, HomePage.getClass());
			Accounts Accounts=new Accounts();
			Accounts=PageFactory.initElements(driver, Accounts.getClass());
//			2.Mouse over the Account icon
			HomePage.mouseHover("accountbtn");
			Thread.sleep(1000);
//			3.Click on My Profile
			Accounts.MyProfile.click();
//			Browser should navigate to Login /Sign Up page and displays the 
			
//			following Logins:
			Accounts.AccountPageVerification();
//			1) Social network login with Facebook and Gmail 
//			2) Guest login Email and continue buttons 
			
			
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
