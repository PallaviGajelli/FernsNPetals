package fernsNPetals.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import fernsNPetals.base.TestBase;

public class AllPersonalisedGifts extends TestBase{
	@FindBy(xpath = "//*[@id=\"personalizedmenu\"]/div/section[1]/ul/li[1]/a")
	public WebElement allPersonalisedGiftsunderpersonalise;
	@FindBy(xpath = "//*[@id=\"listingcontainer\"]/div/div[3]/section[2]/section[3]/div[2]/a[3]/figure/figcaption")
	public WebElement lamps;
	@FindBy(xpath = "//*[@id=\"listingcontainer\"]/div/div[3]/section[2]/section[1]/div[2]/a[1]/figure/figcaption")
	public WebElement Cushions;
	@FindBy(xpath = "//span[text()=' Shining Memory Personalized Lamp']")
	public WebElement ShiningMemoryPersonalizedLamp;
	@FindBy(xpath = "//span[text()=' Personalised Photograph Cushion']")
	public WebElement PersonalisedPhotographCushion;

}
