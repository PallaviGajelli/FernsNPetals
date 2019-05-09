package fernsNPetals.Login_Page;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.HomePage;
//Verify Continue button functionality by entering Invalid maild and Valid password in log in /sign up page 
public class FNP_Login_TC_016 extends TestBase{
	@Test
	public void FNP_Login_TC_016() throws Exception {
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
			Thread.sleep(3000);
//			4.Click on the emaild textbox
//			5.Enter Invalid mail id in email textbox test123@mail.Com sdfsd@sdfsdf.com
			Accounts.emailboxinaccounts.sendKeys("sdfsd@sdfsdf.com");
			Thread.sleep(2000);
			Accounts.continuebtninAccounts.click();
			Thread.sleep(1000);
//			6.click on continue button
			Accounts.AccountsDetailsPage();
//			Browser should dispalay registration page
			
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
