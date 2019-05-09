package fernsNPetals.Login_Page;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.HomePage;
//Verify Continue button functionality by entering Valid maild and Invalid password in log in /sign up page 
public class FNP_Login_TC_015 extends TestBase{
	@Test
	public void FNP_Login_TC_015() throws Exception {
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
//			5.Enter Valid mail id in email textbox fnptest88@mail.Com 
			Accounts.emailboxinaccounts.sendKeys("testmeapp1@gmail.com");
			Thread.sleep(2000);
			Accounts.continuebtninAccounts.click();
			Thread.sleep(1000);
//			6.Enter Invalid password-smile123
			Accounts.passboxinAccounts.sendKeys("Smile123");
			Thread.sleep(1000);
//			7.Click on continue button
			Accounts.continuebtninAccounts.click();
			Thread.sleep(1000);
//			Browser should display an error message 
			Assert.assertEquals((Accounts.invalidEmailIDorPass.isDisplayed()), true);
			System.out.println("'Invalid Email id or Password'is displayed");
//			'Invalid Email id or Password'
			
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
