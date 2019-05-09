package fernsNPetals.MyAccount;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.HomePage;
//Verify the functionality of the Change password link by giving a  in Account page
public class FNP_MyAccount_TC_009 extends TestBase{
	@Test
	public void FNP_MyAccount_TC_009() throws Exception {
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
			Thread.sleep(1000);
//			8.Enter new password as current password ex:fnptest88
			Accounts.newpassword.sendKeys("0y19sQAR");
			Thread.sleep(1000);
//			9.Enter Verify new password
			Accounts.verifypassword.sendKeys("0y19sQAR");
			Thread.sleep(1000);
//			10.click on Save button
//			Browser should display an error messsage 
			Assert.assertEquals((Accounts.samePassErrorMsg.isDisplayed()), true);
			System.out.println("'Current password and New password should not match' Msg is displayed");
//			'Current password and New password should not match'
			
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
