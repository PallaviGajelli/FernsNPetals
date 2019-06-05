package fernsNPetals.plants;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.BonsaiPlants;
import fernsNPetals.pages.HomePage;

//Verify user able to select the product from the header tool bar
public class Fnp_Plants_003 extends TestBase {
	
	@Test
	public void Fnp_Plants_003() throws InterruptedException {
//	1.Launch the FNP Application  in the browser
		initialization();
		HomePage HomePage= new HomePage();
		HomePage= PageFactory.initElements(driver, HomePage.getClass());
		BonsaiPlants BonsaiPlants= new BonsaiPlants();
		BonsaiPlants= PageFactory.initElements(driver, BonsaiPlants.getClass());
		
//	2.mouse hover the Plants  link
		HomePage.mouseHover("plantsmenu");
		Thread.sleep(1000);
//	3.Click on Bonsai Plants link
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", BonsaiPlants.BonsaiPlants);
		//BonsaiPlants.BonsaiPlants.click();	
		
//	4.Click on any product 
		
		js.executeScript("arguments[0].click();", BonsaiPlants.Marvellous_Bonsai_Plant);
		//BonsaiPlants.click("Marvellous_Bonsai_Plant");
//	Ex: Bonsai Beauty
//	
//	Browser should navigate to Gift Booking window
		Set<String>IDs= driver.getWindowHandles();
		java.util.Iterator<String> iter=IDs.iterator();
		String homewindow = iter.next(); 
		String cartwindow = iter.next();
		
	driver.switchTo().window(cartwindow);
	String url =driver.getCurrentUrl();
	boolean a=url.contains("https://www.fnp.com/gift/marvellous-bonsai-plant");
	if (a==true) {
		System.out.println("you are at gift  page");
	}else {
		System.out.println("you are at other than gift  page");
	}
	
	driver.quit();
	
	
	

}
}