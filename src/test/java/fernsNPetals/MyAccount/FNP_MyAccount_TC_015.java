package fernsNPetals.MyAccount;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.HomePage;
//Verify UI of the Add New Reminder link in Account page
public class FNP_MyAccount_TC_015 extends TestBase{
	@Test
	public void FNP_MyAccount_TC_015() throws Exception {
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
			Accounts.emailboxinaccounts.sendKeys("gajelli.pallavi@gmail.com");
			Thread.sleep(2000);
            Accounts.continuebtninAccounts.click();
			Thread.sleep(1000);
//			4.Enter password in the textbox
			Accounts.passboxinAccounts.sendKeys("0y19sQAR");
			Thread.sleep(1000);
//			5.click on continue button
			Accounts.continuebtninAccounts.click();
			Thread.sleep(1000);
//			7.click on Add New Reminders 
			Accounts.AddNewReminders.click();
			Thread.sleep(1000);
//			Browser should display the following fields:
			Accounts.AddNewReminderUIverification();
//				My Reminders
//				Add New Reminders
//				Name
//				Select occasion
//				Select date
//				Notes
//				cancel and save button
			
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
