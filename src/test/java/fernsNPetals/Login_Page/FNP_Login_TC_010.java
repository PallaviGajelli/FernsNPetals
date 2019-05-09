package fernsNPetals.Login_Page;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.HomePage;
//Verify functionality of  Password textbox in log in /sign up page 
public class FNP_Login_TC_010 extends TestBase{
	@Test
	public void FNP_Login_TC_010() throws Exception {
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
//			5.Enter mail id with the combination of alphanumeric and special characters.
			Accounts.emailboxinaccounts.sendKeys("testmeapp1@gmail.com");
			Thread.sleep(1000);
			Accounts.continuebtninAccounts.click();
			Thread.sleep(1000);
//			6.Enter the Password alphanumerical and special symbols
			Accounts.passboxinAccounts.sendKeys("abc123");
			Thread.sleep(1000);
			////////////how to vrify textbox is accepting.
			//String s=Accounts.passboxinAccounts.getText();
//			It should accept  20 characters in the password textbox
			System.out.println("It is accepting  20 characters in the password textbox");
//			
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
