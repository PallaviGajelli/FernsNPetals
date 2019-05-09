package fernsNPetals.MyAccount;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
//Verify user able to Edit the profile in Account page
import fernsNPetals.pages.Accounts;
import fernsNPetals.pages.HomePage;

public class FNP_MyAccount_TC_005 extends TestBase{
	@Test
	public void FNP_MyAccount_TC_005() throws Exception {
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
//			6.click on Edit profile link
//			7.change name
//			8.select gender
//			9.Enter address in the textbox
//			10.Enter city
//			11.Enter pincode
//			12.click on Save button
			Accounts.EditMyAccount("chaya", "F", "ammerpet", "hyderbad", "500019");
//			Browser should display the updated profile i.e
//			chaya		
//			Mobile No.:  9876543210
//			Email ID	:  fnptest88@mail.com
//			Gender	  :  Female
//			Address	:  ammerpet
//			City	      :  hyderbad
//			Country	 :  IND
//			Pincode	:  500019
			
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
