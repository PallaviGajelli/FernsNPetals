package fernsNPetals.Login_Page;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
//Verify functionality of  Password textbox in log in /sign up page 
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.HomePage;

public class FNP_Login_TC_009 extends TestBase{
	@Test
	public void FNP_Login_TC_009() throws Exception {
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
//			6.Enter the Valid Password
			Accounts.AccountLoginwithValidID();
//Browser should navigate to the Account details page
			Accounts.AccountsDetailsPage();
			
			
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
