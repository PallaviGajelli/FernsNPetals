package fernsNPetals.Login_Page;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.HomePage;
//Verify user able to login  into the Application with the "Google+  login' in log in /sign up page 
public class FNP_Login_TC_006 extends TestBase{
	@Test
	public void FNP_Login_TC_006() throws Exception {
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
//			4.Click on the Google+ link
			Accounts.Google.click();
			Thread.sleep(3000);
//			5.Enter Email and click on Next button
			Accounts.gmailEmailIdTextbox.sendKeys("");
			Thread.sleep(1000);
			Accounts.emailnextbtningoogle.click();
			Thread.sleep(1000);
//			6.Enter password and click on next button
			Accounts.passGoogle.sendKeys("");
			Thread.sleep(1000);
			Accounts.passGooglenextbtn.click();
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
