package fernsNPetals.Login_Page;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.HomePage;
//Verify the Functionality of the continue button in without entering a mail id in log in /sign up page 
public class FNP_Login_TC_007 extends TestBase{
	@Test
	public void FNP_Login_TC_007() throws Exception {
		try {
//			1.Launch Fnp application in the browser
			initialization();
			HomePage HomePage=new HomePage();
			HomePage=PageFactory.initElements(driver, HomePage.getClass());
			Accounts Accounts=new Accounts();
			Accounts=PageFactory.initElements(driver, Accounts.getClass());
//			3.Click on My Profile
			HomePage.mouseHover("accountbtn");
			Thread.sleep(1000);
			Accounts.MyProfile.click();
			Thread.sleep(1000);
//			4.Click on the emaild textbox
			Accounts.emailboxinaccounts.click();
//			5.Enter leave emaild field empty
//			6.Click on continue button
			Accounts.continuebtninAccounts.click();
//			Browser should display continue button in disable mode--it is showing error msg instade
			Assert.assertEquals((Accounts.EmailIDisrequired.isDisplayed()), true); 
			System.out.println("It is showing error msg:"+(Accounts.EmailIDisrequired.getText()));
			
			
			
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
