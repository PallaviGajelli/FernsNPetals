package fernsNPetals.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import fernsNPetals.base.TestBase;

public class AllCakes extends TestBase {
	@FindBy(xpath = "/html/body/main/div[1]/div[3]/ul/li[1]/a/img")
	WebElement EgglessCake;
//	@FindBy(xpath = "//*[@id=\"searchProductListing\"]/li[2]/a/div[1]") WebElement PinappleCake;
//	
	@FindBy(xpath = "//span[text()=\" Pineapple Cake\"]")
	public WebElement PinappleCake;
	@FindBy(xpath = "//*[@id=\"left-dropdown-3\"]/div/div/div/div[1]/div[2]/input")
	WebElement citysearchbox;
	@FindBy(xpath = "//*[@id=\"topbarcontainer\"]/div/div/section/nav/ul/li[3]/a")
	WebElement DeliveryCity;
	@FindBy(xpath = "/html/body/main/div[1]/div[2]/h1")
	WebElement plpHeading;
	//*[@id="deliverycity"]/li[7]/a
	@FindBy(xpath = "//*[@id=\"deliverycity\"]/li[7]/a")
	WebElement hyderabad;
	
	@FindBy(xpath = "//span[text()='Pineapple Cake Half kg']")
	WebElement PinappleCakecartProduct;
	
	@FindBy(xpath = "//*[@id=\"cakesmenu\"]/div/section[1]/ul/li[1]/a")
	WebElement AllCakes;
	

	public void click(String Element) {
		switch (Element) {
		case "EgglessCake":
			EgglessCake.click();
			break;
		case "PinappleCake":
			PinappleCake.click();
			break;
		case "DeliveryCity":
			DeliveryCity.click();
			break;
		case "hyderabad":
			hyderabad.click();
				break;
		case "AllCakes":
			AllCakes.click();
			break;

		}
	}

	public void sendkeys(String Element, String keystosend) {
		switch (Element) {
		

		}
	}

	public void Assert(String Element, String msg) {
		switch (Element) {
		case "plpHeading":
			String heading = plpHeading.getText();
			Assert.assertEquals(heading, msg);
			break;
		case "PinappleCakecartProduct":
			String cart = PinappleCakecartProduct.getText();
			Assert.assertEquals(cart, msg);
			break;

		}
	}

}
