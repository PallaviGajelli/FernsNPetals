package fernsNPetals.MyAccount;

import java.io.IOException;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.HomePage;
//Verify the functionality of the Change password link in Account page
public class FNP_MyAccount_TC_008 extends TestBase{
	@Test
	public void FNP_MyAccount_TC_008() throws Exception {
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
//			6.click on change password link in account page
			Accounts.ChangePasswordinMyPro.click();
			Thread.sleep(1000);
//			7.Enter current password
			Accounts.currentpassword.sendKeys("0y19sQAR");
//			8.Enter new password
			String randompass = Accounts.RandomString();
			Accounts.newpassword.sendKeys(randompass);
//			9.Enter Verify new password
			Accounts.verifypassword.sendKeys(randompass);
			String changedPass = randompass;
			System.out.println("random password generated:"+changedPass);
			Thread.sleep(1000);
//			10.click on Save button
			Accounts.savebtn.click();
			Thread.sleep(2000);
//			Browser should display an message 
			Assert.assertEquals((Accounts.successfulChangeOfPassmsg.isDisplayed()), true);
			System.out.println("'Done! From now on, you can start signing in with your new password' Msg is displayed");
//			'Done! From now on, you can start 
//			signing in with your new password'
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
	
	
