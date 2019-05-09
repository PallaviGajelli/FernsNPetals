package fernsNPetals.Login_Page;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.HomePage;
//Verify the functionality of Resend link in the log in/sign up page 
public class FNP_Login_TC_022 extends TestBase{
	@Test
	public void FNP_Login_TC_022() throws Exception {
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
//			5.Enter Valid mail id and click on continue button
			Accounts.emailboxinaccounts.sendKeys("gajelli.pallavi@gmail.com");
			Thread.sleep(2000);
            Accounts.continuebtninAccounts.click();
			Thread.sleep(1000);
//			6.Click on Login without entering password
			Accounts.loginwithoptacc.click();
			Thread.sleep(33000);
//			7.Click on Resend OTP
//			WebDriverWait wait = new WebDriverWait(driver, 30);
//			wait.until(ExpectedConditions.visibilityOf(Accounts.ResendOTPacc));
			Accounts.ResendOTPacc.click();
			Thread.sleep(1000);
			Assert.assertEquals((Accounts.EntertheOTPsenttoacc.isEnabled()), true);
			System.out.println("Browser is displaying message Please Enter Verification code (OTP) sent to");

//			Browser should dispaly message'Your OTP has been sent'
			
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
