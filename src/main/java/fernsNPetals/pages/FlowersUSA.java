package fernsNPetals.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import fernsNPetals.base.TestBase;

public class FlowersUSA extends TestBase{
	@FindBy(xpath = "//*[@id=\"globalmenu\"]/div/section[1]/ul/li[1]/a")
	public WebElement flowsersUSAunderGlobal;
	@FindBy(xpath = "//span[text()=' 100 Long Stem Red Roses']")// 100 Long Stem Red Roses
	public WebElement LongStemRedRoses100;
//	@FindBy(xpath = "")
//	public WebElement ;
//	@FindBy(xpath = "")
//	public WebElement ;
//	@FindBy(xpath = "")
//	public WebElement ;
//	@FindBy(xpath = "")
//	public WebElement ;
//	@FindBy(xpath = "")
//	public WebElement ;
//	@FindBy(xpath = "")
//	public WebElement ;
//	@FindBy(xpath = "")
//	public WebElement ;
//	@FindBy(xpath = "")
//	public WebElement ;
//	@FindBy(xpath = "")
//	public WebElement ;
	
}
