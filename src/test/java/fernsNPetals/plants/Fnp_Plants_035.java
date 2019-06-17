package fernsNPetals.plants;

import java.awt.Desktop.Action;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.BonsaiPlants;
import fernsNPetals.pages.CheckoutPage;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;
//Verify User able to Edit the Address in the Delivery details page
public class Fnp_Plants_035 extends TestBase{
	@Test
	public void Fnp_Plants_035() throws Exception {
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
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", BonsaiPlants.BonsaiPlants);
//			4.Click on Bonsai Beauty
			js.executeScript("arguments[0].click();", BonsaiPlants.Marvellous_Bonsai_Plant);
//			5.Enter Area/pincode in the texbox
			GiftPage.navigateToCart(driver);
			Thread.sleep(2000);
			GiftPage.sendkeys("searchaddressbox", "kondapur");
//			6.Select suggestions under the textbox
			GiftPage.clickfirstAddressintheList(driver);
			Thread.sleep(1000);
//			7.Click on Change Date Link
			if (GiftPage.datetimeshipping.isDisplayed()) {
				GiftPage.datetimeshipping.click();	
			}else {
				GiftPage.SelectDeliveryDate.click();
			}
//			8.Select Delivery date
			GiftPage.selectDayAfterTomorrow(driver);
			Thread.sleep(3000);
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
//		    CheckoutPage.click("Prefix");
//		    Select dropdown=new Select(CheckoutPage.Prefix);
//		    dropdown.selectByVisibleText("Ms.");
		    
//			15.Enter Name in the text field
//			16.Enter Recipients address
//			17.Enter landmark
//			18.Enter mobile number
//			19.Enter Email id textbox
//			20.Click on Save Address button
		    CheckoutPage.filladdressToDelivery(driver, "chaya sree", "Ammerpet", "9876543210","Saradhi studio behind,near value mart","test@gmail.Com");
//			21.Click on Edit button
		    CheckoutPage.click("editsavedAddBtn");
//			*Note:Expected step1 has to be verified
		    CheckoutPage.verify("editsavedAddpage");
//			22.Change name
		    Thread.sleep(1000);
		    JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].scrollIntoView();",CheckoutPage.rname);
		    //CheckoutPage.rname.clear();
			CheckoutPage.rname.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			Thread.sleep(1000);
		    CheckoutPage.sendkeys("rname", "sri lasya");
//			23.Change number
		    CheckoutPage.rmobileno.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		    Thread.sleep(1000);
		    CheckoutPage.sendkeys("rmobileno", "7894562310");
//			24.Click on Save Button
		    CheckoutPage.click("submitaddressbutton");
//			*Note:Expected step2 has to be verified
		    String chanedDetails=CheckoutPage.savedaddDetails.getText();
     		Assert.assertEquals(chanedDetails, "Sri Lasya7894562310");
     		System.out.println("Changed name and mobile no is displayed");
//			1.Browser should displays the select delivery
//			address window
//			2.Browser should displays the updated address i.e
//			sri lasya
//			7894562310
//			
//			5.Name:Ms.chaya sree
//			6.Address:Ammerpet
//			7.Landmark:Saradhi studio behind,near value mart
//			8.Mobile No:9876543210
//			9.Email:test@gmail.Com
//			10.Name: sri lasya
//			11.Mobile No:7894562310
			
			
			
			
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
