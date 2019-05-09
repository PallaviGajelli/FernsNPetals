package fernsNPetals.MyAccount;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
//Verify the functionality of the Gift Coupons link in Account page
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.HomePage;

public class FNP_MyAccount_TC_011 extends TestBase{
	@Test
	public void FNP_MyAccount_TC_011() throws Exception {
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
//			7.click on the Gift coupons
//			8.click on used
			Accounts.used.click();
//			Browser should display the following field:Used Gift Coupons Codes
			Assert.assertEquals((Accounts.usedGiftCoupanCodes.isDisplayed()), true);
			System.out.println("Used Gift Coupons Codes is displayed");
		
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
