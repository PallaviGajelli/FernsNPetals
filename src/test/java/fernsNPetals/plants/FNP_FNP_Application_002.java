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
		
		HomePage.homepageverification();


	}
}
