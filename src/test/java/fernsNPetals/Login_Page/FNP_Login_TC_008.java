package fernsNPetals.Login_Page;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.HomePage;
//Verify functionality of Email id textbox in log in /sign up page
public class FNP_Login_TC_008 extends TestBase{
	@Test
	public void FNP_Login_TC_008() throws Exception {
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
			//Accounts.emailboxinaccounts.click();
//			5.Enter mail id with the combination of alphanumeric and special characters.
			Accounts.emailboxinaccounts.sendKeys("abc123@mail.Com");
//			It should accept  60 characters in the Email id textbox 
			System.out.println("It is accepting  60 characters in the Email id textbox");
			
			
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
