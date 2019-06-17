package fernsNPetals.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import fernsNPetals.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//*[@id=\"fnpsearch\"]")
	public WebElement searchbox;
	@FindBy(xpath = "//*[@id=\"searchbtn\"]/i")
	public WebElement searchbutton;
	@FindBy(xpath = "//*[@id=\"searchProductListing\"]/li[1]/a/figure/img")
	public WebElement item;

	@FindBy(xpath = "//*[@id=\"#cakesmenu\"]")
	public WebElement cakesmenu;

	@FindBy(xpath = "//*[@id=\"#mothersdaymenu\"]")
	public WebElement mothersdaymenu;
	@FindBy(xpath = "//*[@id=\"#birthdaymenu\"]")
	public WebElement birthdaymenu;
	@FindBy(xpath = "//*[@id=\"#personalizedmenu\"]")
	public WebElement personalizedmenu;
	@FindBy(xpath = "//*[@id=\"#flowersmenu\"]")
	public WebElement flowersmenu;
	@FindBy(xpath = "//*[@id=\"#plantsmenu\"]")
	public WebElement plantsmenu;
	@FindBy(xpath = "//*[@id=\"#combosmenu\"]")
	public WebElement combosmenu;
	@FindBy(xpath = "//*[@id=\"#othergiftsmenu\"]")
	public WebElement othergiftsmenu;
	@FindBy(xpath = "//*[@id=\"#anniversarymenu\"]")
	public WebElement anniversarymenu;
	@FindBy(xpath = "//*[@id=\"#occasionsmenu\"]")
	public WebElement occassionsmenu;
	@FindBy(xpath = "//*[@id=\"#globalmenu\"]")
	public WebElement globalmenu;

	@FindBy(xpath = "//*[@id=\"cartbtn\"]/span[1]/i")
	public WebElement cartbtn;
	@FindBy(xpath = "//*[@id=\"accountbtn\"]")
	public WebElement accountbtn;
	@FindBy(xpath = "//span[@id='user-info']")
	public WebElement usernameintheaccount;

	@FindBy(xpath = "//*[@id=\"currency-sym\"]")
	public WebElement currency_sym;
	@FindBy(xpath = "//a[text()='EUR - Euro']")
	public WebElement Euro;
	@FindBy(xpath = "//*[@id=\"call-info\"]")
	public WebElement call_info;
	@FindBy(xpath = "//*[@id=\"enquire\"]")
	public WebElement more;

	@FindBy(xpath = "//*[@id=\"fnplogo\"]/a/img")
	public WebElement fnplogo;

	public void searchproduct(String items) throws InterruptedException {
		// Thread.sleep(3000);
		searchbox.sendKeys(items);
		Thread.sleep(1000);
		searchbutton.click();
		Thread.sleep(3000);
		item.click();
		Thread.sleep(3000);
	}

	public void mouseHover(WebElement webelement) {
		Actions action = new Actions(driver);
		action.moveToElement(webelement).build().perform();
	}

	public void mouseHover(String Menu) {
		Actions action = new Actions(driver);
		switch (Menu) {
		case "accountbtn":
			action.moveToElement(accountbtn).build().perform();
			break;
		case "cakesmenu":
			action.moveToElement(cakesmenu).build().perform();
			break;
		case "plantsmenu":
			action.moveToElement(plantsmenu).build().perform();
			break;
		case "anniversarymenu":
			action.moveToElement(anniversarymenu).build().perform();
			break;
		case "occassionsmenu":
			action.moveToElement(occassionsmenu).build().perform();
			break;
		case "currency_sym":
			action.moveToElement(currency_sym).build().perform();
			break;
		case "personalizedmenu":
			action.moveToElement(personalizedmenu).build().perform();
			break;
		case "globalmenu":
			action.moveToElement(globalmenu).build().perform();
			break;
		}
	}

	public void validation(WebElement webelement) {
		Assert.assertEquals((webelement.isDisplayed()), true);
		System.out.println(webelement + "is displayed");
	}

	public void validation(String menuName) {
		switch (menuName) {

		case "cartbtn":
			Assert.assertEquals((cartbtn.isDisplayed()), true);
			System.out.println("cartbtn is displayed");
			break;
		case "accountbtn":
			Assert.assertEquals((accountbtn.isDisplayed()), true);
			System.out.println("cartbtn is displayed");
			break;
		case "currency_sym":
			Assert.assertEquals((currency_sym.isDisplayed()), true);
			System.out.println("currency_sym is displayed");
			break;
		case "call_info":
			Assert.assertEquals((call_info.isDisplayed()), true);
			System.out.println("call_info is displayed");
			break;
		case "more":
			Assert.assertEquals((more.isDisplayed()), true);
			System.out.println("more is displayed");
			break;
		case "fnplogo":
			Assert.assertEquals((fnplogo.isDisplayed()), true);
			System.out.println("fnplogo is displayed");
			break;
		case "searchbox":
			Assert.assertEquals((searchbox.isDisplayed()), true);
			System.out.println("searchbox is displayed");
			break;
		case "flowersmenu":
			Assert.assertEquals((flowersmenu.isDisplayed()), true);
			System.out.println("flowersmenu is displayed");
			break;
		case "cakesmenu":
			Assert.assertEquals((cakesmenu.isDisplayed()), true);
			System.out.println("cakesmenu is displayed");
			break;
		case "personalizedmenu":
			Assert.assertEquals((personalizedmenu.isDisplayed()), true);
			System.out.println("personalizedmenu is displayed");
			break;
		case "plantsmenu":
			Assert.assertEquals((plantsmenu.isDisplayed()), true);
			System.out.println("plantsmenu is displayed");
			break;
		case "birthdaymenu":
			Assert.assertEquals((birthdaymenu.isDisplayed()), true);
			System.out.println("birthdaymenu is displayed");
			break;
		case "othergiftsmenu":
			Assert.assertEquals((othergiftsmenu.isDisplayed()), true);
			System.out.println("othergiftsmenu is displayed");
			break;
		case "anniversarymenu":
			Assert.assertEquals((anniversarymenu.isDisplayed()), true);
			System.out.println("anniversarymenu is displayed");
			break;
		case "occassionsmenu":
			Assert.assertEquals((occassionsmenu.isDisplayed()), true);
			System.out.println("occassionsmenu is displayed");
			break;
		case "globalmenu":
			Assert.assertEquals((globalmenu.isDisplayed()), true);
			System.out.println("globalmenu is displayed");
			break;

		}

	}

	public void homepageverification() {

		Assert.assertEquals((cartbtn.isDisplayed()), true);
		System.out.println("cartbtn is displayed");

		Assert.assertEquals((accountbtn.isDisplayed()), true);
		System.out.println("cartbtn is displayed");
//		* Top of the page shows following fields:   
		Assert.assertEquals((currency_sym.isDisplayed()), true);
		System.out.println("currency_sym is displayed");

		Assert.assertEquals((currency_sym.getText().contentEquals("GBP")), true);
		System.out.println("currency_sym is displayed in GBP");

		Assert.assertEquals((call_info.isDisplayed()), true);
		System.out.println("call_info is displayed");

		Assert.assertEquals((more.isDisplayed()), true);
		System.out.println("more is displayed");
//		* Left side of the page shows the following fields:
		Assert.assertEquals((fnplogo.isDisplayed()), true);
		System.out.println("fnplogo is displayed");

		Assert.assertEquals((searchbox.isDisplayed()), true);
		System.out.println("searchbox is displayed");
//		* Header toolbar shows with following fields:
		Assert.assertEquals((flowersmenu.isDisplayed()), true);
		System.out.println("flowersmenu is displayed");

		Assert.assertEquals((cakesmenu.isDisplayed()), true);
		System.out.println("cakesmenu is displayed");

		Assert.assertEquals((personalizedmenu.isDisplayed()), true);
		System.out.println("personalizedmenu is displayed");

		Assert.assertEquals((plantsmenu.isDisplayed()), true);
		System.out.println("plantsmenu is displayed");

		Assert.assertEquals((birthdaymenu.isDisplayed()), true);
		System.out.println("birthdaymenu is displayed");

		Assert.assertEquals((othergiftsmenu.isDisplayed()), true);
		System.out.println("othergiftsmenu is displayed");

		Assert.assertEquals((anniversarymenu.isDisplayed()), true);
		System.out.println("anniversarymenu is displayed");

		Assert.assertEquals((occassionsmenu.isDisplayed()), true);
		System.out.println("occassionsmenu is displayed");

		Assert.assertEquals((globalmenu.isDisplayed()), true);
		System.out.println("globalmenu is displayed");

	}

}