package fernsNPetals.AllFiltersInCategoryPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.FlowersPage;

public class trial extends TestBase{
	
	@Test
	public void trial() {
		initialization();
		FlowersPage FlowersPage = new FlowersPage();
		FlowersPage = PageFactory.initElements(driver, FlowersPage.getClass());
		driver.get("https://www.fnp.com/roses/anniversary?CITY_TAGS=bangalore");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", FlowersPage.ElegancePinkRosesBouquet);
	}
	//img[@title='Elegance - Pink Roses Bouquet']
}
