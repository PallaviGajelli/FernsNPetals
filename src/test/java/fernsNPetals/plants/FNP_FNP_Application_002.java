package fernsNPetals.plants;

import org.openqa.selenium.support.PageFactory;
import org.seleniumhq.jetty9.server.HomeBaseWarning;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.HomePage;

public class FNP_FNP_Application_002 extends TestBase {
	
	@Test
	public void validationHopePage() throws InterruptedException {
//	Browser should display the Homepage of the Application with the following fields in
//	the upper Right corner
//	1.Account
//	2.Cart
		initialization();
		HomePage HomePage =new HomePage();
		HomePage=PageFactory.initElements(driver, HomePage.getClass());
		HomePage.validation("cartbtn");
		HomePage.validation("accountbtn");
//	* Top of the page shows following fields:
//	Currency INR
		//Thread.sleep(3000);
		HomePage.validation("currency_sym");
//	Contact number
		HomePage.validation("call_info");
//	More option
		HomePage.validation("more");
//	* Left side of the page shows the following fields:
//	Fernsnpetals logo
		HomePage.validation("fnplogo");
//	search textbox
		HomePage.validation("searchbox");
//	* Header toolbar shows with following fields:
//	FLOWERS
		HomePage.validation("flowersmenu");
//	CAKES
		HomePage.validation("cakesmenu");
//	PERSONALIZED
		HomePage.validation("personalizedmenu");
//	PLANTS
		HomePage.validation("plantsmenu");
//	BIRTHDAY
		HomePage.validation("birthdaymenu");
//	ANNIVERSARY
		HomePage.validation("anniversarymenu");
//	OCCASSIONS
		HomePage.validation("occassionsmenu");
//	OTHER GIFTS
		HomePage.validation("othergiftsmenu");
//	GLOBAL
		HomePage.validation("globalmenu");
		driver.close();

	}
}
