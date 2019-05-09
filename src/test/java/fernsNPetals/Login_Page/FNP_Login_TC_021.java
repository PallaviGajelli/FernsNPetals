package fernsNPetals.Login_Page;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.HomePage;
//Verify the BVA of OTP text box in login /sign up page  
//this is incompleate testcase step 8
public class FNP_Login_TC_021 extends TestBase {
	@Test
	public void FNP_Login_TC_021() throws Exception {
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
			Accounts.loginwithoptacc.click();
			Thread.sleep(1000);
//			8.Enter otp  lessthan 4 digits
			//////////////////////
//			user should be able to enter maximum of 4 characters in the otp field 
			
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
