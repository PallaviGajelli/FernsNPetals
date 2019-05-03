package fernsNPetals.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import fernsNPetals.base.TestBase;

public class FlowersPage extends TestBase {
	
	@FindBy(xpath = "//*[@id=\"anniversarymenu\"]/div/section[1]/ul/li[1]/a")
	public WebElement anniversary_flowers;
	@FindBy(xpath = "//*[@id=\"breadcrumbs\"]/div")
	public WebElement breadcrumb_wrapper;
	@FindBy(xpath = "//*[@id=\"sort\"]/option[1]")
	public WebElement recomendedDropDown;
	@FindBy(xpath = "//*[@id=\"sort\"]/option[3]")
	public WebElement PriceLowtoHigh;
	@FindBy(xpath = "//*[@id=\"topbarcontainer\"]/div/div/section/nav/ul/li[1]/a")
	public WebElement GiftTypeFlowers;
	@FindBy(xpath = "//*[@id=\"topbarcontainer\"]/div/div/section/nav/ul/li[2]/a")
	public WebElement OccasionAnniversary;
	@FindBy(xpath = "//*[@id=\"topbarcontainer\"]/div/div/section/nav/ul/li[3]/a")
	public WebElement DeliveryCity;
	@FindBy(xpath = "//*[@id=\"topbarcontainer\"]/div/div/section/ul/li/a")
	public WebElement PriceAnniversary;
	@FindBy(xpath = "//*[@id=\"price-filter\"]/div[2]/div/div/div/label")
	public WebElement Price500Plus;
	@FindBy(xpath = "//*[@id=\"left-dropdown-1\"]/div/div/div/div/ul/li[2]/div/ul/li[2]/a")
	public WebElement Roses;
	@FindBy(xpath = "//*[@id=\"left-dropdown-2\"]/div/div/div/div/ul/li[1]/div/ul/li[2]/a")
	public WebElement AnniversaryUnderOccation;
	@FindBy(xpath = "//*[@id=\"deliverycity\"]/li[3]/a")
	public WebElement Bangalore;
	
	@FindBy(xpath = "//span[text()='Elegance - Pink Roses Bouquet']")//img[@title='Elegance - Pink Roses Bouquet']
	public WebElement ElegancePinkRosesBouquet;
	@FindBy(xpath = " //span[text()=' Vivid - Red Roses Bouquet']")
	public WebElement VividRedRosesBouquet;

	public void mouseHover(String Menu) {
		Actions action = new Actions(driver);
		switch (Menu) {
		case "GiftTypeFlowers":
			action.moveToElement(GiftTypeFlowers).build().perform();
			break;
		case "DeliveryCity":
			action.moveToElement(DeliveryCity).build().perform();
			break;
		case "PriceAnniversary":
			action.moveToElement(PriceAnniversary).build().perform();
			break;

		}

	}
}
