package fernsNPetals.Login_Page;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.HomePage;
//Verify user able to register with unregistered email id in log in /sign up page 
public class FNP_Login_TC_012 extends TestBase{
	@Test
	public void FNP_Login_TC_012() throws Exception {
		try {
//			
//			1.Launch Fnp application in the browser
			initialization();
			HomePage HomePage=new HomePage();
			HomePage=PageFactory.initElements(driver, HomePage.getClass());
			Accounts Accounts=new Accounts();
			Accounts=PageFactory.initElements(driver, Accounts.getClass());
//			CheckoutPage CheckoutPage=new CheckoutPage();
//			CheckoutPage=PageFactory.initElements(driver, CheckoutPage.getClass());
//			2.Mouse over the Account icon
			HomePage.mouseHover("accountbtn");
			Thread.sleep(1000);
//			3.Click on My Profile
			Accounts.MyProfile.click();
			Thread.sleep(3000);
//			4.Click on the emaild textbox
//			5.Enter New mail id in the mail text box
			Accounts.emailboxinaccounts.sendKeys("leena.gajelli@gmail.com");
			Thread.sleep(3000);
//			6. Click on continue button 
			Accounts.continuebtninAccounts.click();
			Thread.sleep(1000);
//			Browser should display  registration page with following fields 
			Accounts.AccountsDetailsPage();
			Thread.sleep(1000);
			Accounts.registrationPageVerification();

//			name, 
//			mobile number 
//			create password and 
//			continue button 
			
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
