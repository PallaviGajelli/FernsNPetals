package fernsNPetals.MyAccount;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.HomePage;
//Verify user able to view the updated name in the Account page
public class FNP_MyAccount_TC_006 extends TestBase{
	@Test
	public void FNP_MyAccount_TC_006() throws Exception {
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
//			3..Enter mail id in the textbox
			Accounts.emailboxinaccounts.sendKeys("testmeapp1@gmail.com");
			Thread.sleep(2000);
            Accounts.continuebtninAccounts.click();
			Thread.sleep(1000);
//			4.Enter password in the textbox
			Accounts.passboxinAccounts.sendKeys("test@2018");
			Thread.sleep(1000);
//			5.click on continue button
			Accounts.continuebtninAccounts.click();
			Thread.sleep(2000);
//			6.Mouse over  Account icon
			HomePage.mouseHover("accountbtn");
			Assert.assertEquals((HomePage.usernameintheaccount.getText()), "Hi chaya");
			System.out.println("Browser is displaying the updated name under the Account icon");
//			Browser should displays the updated name under the Account icon 
			
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
