package fernsNPetals.Login_Page;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.HomePage;
//Verify user able to login into the Application with the 'Facebook login' in log in /sign up page 
public class FNP_Login_TC_005 extends TestBase{
	@Test
	public void FNP_Login_TC_005() throws Exception {
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
			Thread.sleep(1000);
//			4.Click on the Facebook link
			Accounts.Facebook.click();
			Thread.sleep(1000);
//			5. Enter mobile number
			Accounts.emailOrPhone.sendKeys("");
			Thread.sleep(1000);
//			6.Enter Password and click on Login button
			Accounts.pass.sendKeys("");
			Thread.sleep(1000);
			Accounts.loginbutton.click();
			Thread.sleep(1000);
//			Browser should navigate to the Account details page
			Accounts.AccountsDetailsPage();
			
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
