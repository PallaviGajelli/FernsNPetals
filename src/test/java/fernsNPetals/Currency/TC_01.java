package fernsNPetals.Currency;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.HomePage;
//Verify  user able to select the Currency in scroll bar
public class TC_01 extends TestBase{
	@Test
	public void TC_01() throws IOException {
		try {
			
//			1. Launch the FNP Application  in the browser
			initialization();
			HomePage HomePage= new HomePage();
			HomePage=PageFactory.initElements(driver, HomePage.getClass());
//			2.Mouse over the currency header
			HomePage.mouseHover("currency_sym");
			
//			3.Click on ‘EUR-Euro’
			HomePage.Euro.click();
//			
//			Browser should display the Currency EUR in header
			String s=HomePage.currency_sym.getText();
			Assert.assertEquals(s, "EUR");
			System.out.println("Browser is displaying the Currency EUR in header");
			
			
			
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
