package fernsNPetals.Login_Page;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.HomePage;
//Verify Continue button functionality by entering all the mandatory fields in log in /sign up page 
public class FNP_Login_TC_014 extends TestBase{
	@Test
	public void FNP_Login_TC_014() throws Exception {
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
			Accounts.emailboxinaccounts.sendKeys("");
			Thread.sleep(2000);
			Accounts.continuebtninAccounts.click();
			Thread.sleep(4000);
			
//			5.Enter  mail id
//			6.Enter name
//			7. Enter password
//			8. Click on continue button 
			Accounts.fillRegistrationForm();
//			Browser should navigate to Account details page
			Assert.assertEquals((driver.getCurrentUrl().contains("https://www.fnp.com/control/my-account")), true);
			System.out.println("Browser is navigating to the Account details page");
			
		}catch(Exception e) {
		      throw(e);
		}
//		finally {
//			 driver.quit();
//			 Runtime rt =Runtime.getRuntime();
//			 Process proc = rt.exec("taskkill /im chrome.exe /f /t");
//		}
	}
}
