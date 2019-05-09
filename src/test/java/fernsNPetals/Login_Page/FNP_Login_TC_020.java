package fernsNPetals.Login_Page;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.HomePage;
//Verify functionality of Login without password button in log in /sign up page 
public class FNP_Login_TC_020 extends TestBase{
	@Test
	public void FNP_Login_TC_020() throws Exception {
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
//			5.Enter Valid mail id 
			Accounts.emailboxinaccounts.sendKeys("gajelli.pallavi@gmail.com");
			Thread.sleep(2000);
//			6.click on continue button
			Accounts.continuebtninAccounts.click();
			Thread.sleep(1000);
//			7.Click on Login without password button
			Accounts.continuebtninAccounts.click();
			Thread.sleep(1000);
//			8.leave the Enter code field empty
			Assert.assertEquals((Accounts.Passwordisrequiredacc.isDisplayed()), true);
			System.out.println("continue button in not in disable mode but giving error msg : password is required");
//			Browser should display continue button in disable mode
			
			
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
