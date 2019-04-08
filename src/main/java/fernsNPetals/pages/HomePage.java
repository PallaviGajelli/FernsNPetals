package fernsNPetals.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import fernsNPetals.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//*[@id=\"fnpsearch\"]")
	public WebElement searchbox;
	@FindBy(xpath="//*[@id=\"searchbtn\"]/i")WebElement searchbutton;
	@FindBy(xpath="//*[@id=\"searchProductListing\"]/li[1]/a/figure/img")WebElement item;
	
	public void searchproduct(String items) throws InterruptedException {
		//Thread.sleep(3000);
		searchbox.sendKeys(items);
		Thread.sleep(1000);
		searchbutton.click();
		Thread.sleep(3000);
		item.click();
		Thread.sleep(3000);
	}

}
