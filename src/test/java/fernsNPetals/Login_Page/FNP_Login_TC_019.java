package fernsNPetals.Login_Page;

import java.io.IOException;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.HomePage;
//Verify functionality of Login without password button in log in /sign up page 
public class FNP_Login_TC_019 extends TestBase{
	@Test
	public void FNP_Login_TC_019() throws Exception {
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
			Assert.assertEquals((Accounts.EntertheOTPsenttoacc.isDisplayed()), true);
			System.out.println("Browser is displaying message Please Enter Verification code (OTP) sent to");
//			Note:Expected step1 has to be verified
//			8.Enter code and click on continue button
			/////////this is incompleate
//			Note:Expected step2 has to be verified
//			1.Browser should display message "Please Enter Verification code (OTP) sent to:abc123@mail.Com & xxxxxx3210" and see enter code text field  and resend button
//			2.Browser should naavigate Acccout details page
			
			
			
		}catch(Exception e) {
		      throw(e);
		}
		finally {
			 driver.quit();
			 Runtime rt =Runtime.getRuntime();
			 Process proc = rt.exec("taskkill /im chrome.exe /f /t");
		}
	}
	
	public static String RandomString()
	{
		int length = 5;
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		// System.out.println(generatedString);
		return generatedString;
	}
}
