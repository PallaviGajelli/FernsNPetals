package fernsNPetals.Login_Page;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.HomePage;
//Verify the functionality of remember me check box in log in /sign up page 
public class FNP_Login_TC_017 extends TestBase{
	@Test
	public void FNP_Login_TC_017() throws Exception {
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
			Accounts.emailboxinaccounts.sendKeys("testmeapp1@gmail.com");
			Thread.sleep(2000);
			Accounts.continuebtninAccounts.click();
			Thread.sleep(1000);
//			6.Click on Remember me check box
			Accounts.remembercheckacc.click();
//			user should be able to click on the check box
			System.out.println("user is able to click on the check box");
			
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
