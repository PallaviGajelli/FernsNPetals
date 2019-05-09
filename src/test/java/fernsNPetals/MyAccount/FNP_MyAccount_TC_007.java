package fernsNPetals.MyAccount;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.HomePage;
//Verify UI of the Cahnge password link inAccount page
public class FNP_MyAccount_TC_007 extends TestBase{
	@Test
	public void FNP_MyAccount_TC_007() throws Exception {
		try {
			
//			1.Launch Fnp application in the browser
			initialization();
			HomePage HomePage=new HomePage();
			HomePage=PageFactory.initElements(driver, HomePage.getClass());
			Accounts Accounts=new Accounts();
			Accounts=PageFactory.initElements(driver, Accounts.getClass());
//			2.click on Account
			HomePage.mouseHover("accountbtn");
			Thread.sleep(1000);
			Accounts.MyProfile.click();
			Thread.sleep(3000);
//			3.Enter mail id in the textbox
			Accounts.emailboxinaccounts.sendKeys("testmeapp1@gmail.com");
			Thread.sleep(2000);
            Accounts.continuebtninAccounts.click();
			Thread.sleep(1000);
//			4.Enter password in the textbox
			Accounts.passboxinAccounts.sendKeys("test@2018");
			Thread.sleep(1000);
//			5.click on continue button
			Accounts.continuebtninAccounts.click();
			Thread.sleep(1000);
//			6.click on change password link in account page
			Accounts.ChangePasswordinMyPro.click();
			Thread.sleep(1000);
//			Browser should display an window with following fields 
			Accounts.ChangePassUIverification();
//			*Current Password
//			*New Password
//			*Verify New Password
//			cancel and save button
			
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
