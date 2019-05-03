package fernsNPetals.plants;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.BonsaiPlants;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;
//Verify the user able to write the message on card
public class Fnp_Plants_036 extends TestBase{
	@Test
	public void Fnp_Plants_036() throws Exception {
		try {
//			1.Launch the FNP Application  in the browser
			initialization();
			HomePage HomePage = new HomePage();
			HomePage = PageFactory.initElements(driver, HomePage.getClass());
			GiftPage GiftPage = new GiftPage();
			GiftPage = PageFactory.initElements(driver, GiftPage.getClass());
			BonsaiPlants BonsaiPlants = new BonsaiPlants();
			BonsaiPlants = PageFactory.initElements(driver, BonsaiPlants.getClass());
			CheckoutPage CheckoutPage = new CheckoutPage();
			CheckoutPage = PageFactory.initElements(driver, CheckoutPage.getClass());
//			2.Click on the Plants  link
			HomePage.mouseHover("plantsmenu");
//			3.Click on Bonsai Plants link 
			BonsaiPlants.click("BonsaiPlants");
//			4.Click on Bonsai Beauty
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", BonsaiPlants.Marvellous_Bonsai_Plant);
//			5.Enter Area/pincode in the texbox
			GiftPage.navigateToCart(driver);
			GiftPage.sendkeys("searchaddressbox", "kondapur");
//			6.Select suggestions under the textbox
			GiftPage.clickfirstAddressintheList(driver);
//			7.Click on Change Date Link
			GiftPage.click("SelectDeliveryDate");
//			8.Select Delivery date
			GiftPage.selectDayAfterTomorrow(driver);
			Thread.sleep(2000);
//			9.Click on Buy Now button 
			GiftPage.click("buynowbutton");
//			10.Click on Continue With Addon
			GiftPage.click("addoncheckbox");
			GiftPage.click("addonbutton");
//		11.In checkout login page,Click on email id 

//		12.Enter Valid mail id and click on continue button i.e Existing user
			CheckoutPage.sendkeys("loginEmailID", prop.getProperty("mailID"));
			CheckoutPage.click("continuebutton");
//		13.Enter Password and click on continue button
		    CheckoutPage.sendkeys("pwd", prop.getProperty("pwd"));
		    CheckoutPage.click("continuebutton");

//			14.Select Prefix as-Ms
            CheckoutPage.selectPrefixAsMs(driver);
		    
//			15.Enter Name in the text field
//			16.Enter Recipients address
//			17.Enter landmark
//			18.Enter mobile number
//			19.Enter Email id textbox
//			20.Click on Save Address button
		    CheckoutPage.filladdressToDelivery(driver, "chaya sree", "Ammerpet", "9876543210","Saradhi studio behind,near value mart","test@gmail.Com");
//			21.Click on Free Message card
		    js.executeScript("arguments[0].click();", CheckoutPage.FreeMessagecard);
		  
//			22.Select occasion as Birthday
		    CheckoutPage.SelectOccasion.click();
		    CheckoutPage.Occasionbirthday.click();
		    
//			23.Click on Save Button
		    CheckoutPage.saveBtn.click();
//			*Note:Expected step1 has to be verified
		    CheckoutPage.MessageCannotBeEmpty.isDisplayed();
		    System.out.println("Select Message is displayed");
//			24.write message on card
		    CheckoutPage.SelectMessageonCard.click();
		    CheckoutPage.SelectfirstMessage.click();
		    
//			25.Click on save button
		    CheckoutPage.saveBtn.click();
//			*Note:Expected step2 has to be verified
		    CheckoutPage.msgoncard.isDisplayed();
		    System.out.println("msg is dispayed on the card");
			
			
//			1.Browser should display error message 'Message is required'
//			2.Browser should display message on card is saved
//			5.Name:Ms.chaya sree
//			6.Address:Ammerpet
//			7.Landmark:Saradhi studio behind,near value mart
//			8.Mobile No:9876543210
//			9.Email:test@gmail.Com
			
			
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
