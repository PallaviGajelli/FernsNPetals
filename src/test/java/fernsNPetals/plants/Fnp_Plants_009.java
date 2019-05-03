package fernsNPetals.plants;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.BonsaiPlants;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;

//Verify user able to Edit the pin code in Gift booking window
public class Fnp_Plants_009 extends TestBase{

	private static final StringBuffer Null = null;

	@Test
	public void Fnp_Plants_009() throws InterruptedException {
//	1.Launch the FNP Application  in the browser
		initialization();
		HomePage HomePage = new HomePage();
		HomePage = PageFactory.initElements(driver, HomePage.getClass());
		GiftPage GiftPage = new GiftPage();
		GiftPage = PageFactory.initElements(driver, GiftPage.getClass());
		BonsaiPlants BonsaiPlants = new BonsaiPlants();
		BonsaiPlants = PageFactory.initElements(driver, BonsaiPlants.getClass());
//	2.Click on the Plants  link
		HomePage.mouseHover("plantsmenu");
//	3.Click on Bonsai Plants link 
		BonsaiPlants.click("BonsaiPlants");
//	4.Click on Bonsai Beauty
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", BonsaiPlants.Marvellous_Bonsai_Plant);
//	5.Enter valid pin-code in text box
		GiftPage.navigateToCart(driver);
		GiftPage.sendkeys("searchaddressbox", "500084");
//	*Note:Executed step1 has to be verified
		boolean add=GiftPage.hybd500084.getText().contentEquals("Hyderabad, Telangana, India");
		Assert.assertEquals(add, true);
		GiftPage.click("hybd500084");
		System.out.println("Browser is displaying suggestions under the textbox for valid add");

//	6.Clear the data and enter Invalid pin code
		GiftPage.searchaddressbox.clear();
		GiftPage.sendkeys("searchaddressbox", "dfgdgdeg");	
//	*Note:Executed step2 has to be verified
		GiftPage.IsAddressintheListDisplayed(driver);
		System.out.println("Browser is not displaying suggestions under the textbox for invalid add");
		
//	7.Clear the data and Enter pin 533249
		GiftPage.searchaddressbox.clear();
		GiftPage.sendkeys("searchaddressbox", "533249");	
//	*Note:Executed step3 has to be verified.
		boolean add2=GiftPage.hybd533249.getText().contentEquals("Andhra Pradesh, India");
		Assert.assertEquals(add2, true);
		System.out.println("Browser is displaying suggestions under the textbox for valid add");
		GiftPage.click("hybd533249");
		driver.quit();
//	
//	1.Browser should display suggestions under the pin code textbox
//	500084,Hyderabad,Telngana,India
//	2.Browser should not display any suggestions
//	3.Browser should display suggestions under the textbox
//	533249,AndharPradesh,India

}
}
