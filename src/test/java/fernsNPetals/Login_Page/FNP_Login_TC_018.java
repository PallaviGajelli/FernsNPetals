package fernsNPetals.Login_Page;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.HomePage;
//Verify the Functionality of the forget password textbox in log in /sign up page 
public class FNP_Login_TC_018 extends TestBase{
	@Test
	public void FNP_Login_TC_018() throws Exception {
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
			Accounts.continuebtninAccounts.click();
			Thread.sleep(1000);
//			6.Click on the forget password link
			Accounts.forgetpassacc.click();
//			Note:Expected step1 has to be verified
			Assert.assertEquals((Accounts.forgotpassMsgacc.isDisplayed()), true);
			System.out.println("Browser is displaying an pop-up message:We have shared a new password on above mail id");
			Thread.sleep(1000);
//			7.Click on the OK button
			Accounts.forgotokacc.click();
//			8.Enter the password in 20 secs
//			9.Click on continue button
//			Note:Expected step2 has to be verified
//			1.Browser should display an pop-up message
//			i.e "We have shared a new password on above mail id"
//			2.Browser should navigate to Account details page
			
			
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
