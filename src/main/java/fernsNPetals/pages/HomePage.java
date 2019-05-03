package fernsNPetals.pages;

import org.apache.bcel.generic.SWITCH;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.google.common.base.CaseFormat;

import fernsNPetals.base.TestBase;
import net.sourceforge.htmlunit.corejs.javascript.ast.SwitchCase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//*[@id=\"fnpsearch\"]")
	public WebElement searchbox;
	@FindBy(xpath = "//*[@id=\"searchbtn\"]/i")
	WebElement searchbutton;
	@FindBy(xpath = "//*[@id=\"searchProductListing\"]/li[1]/a/figure/img")
	WebElement item;

	@FindBy(xpath = "//*[@id=\"#cakesmenu\"]")
	WebElement cakesmenu;
	

	@FindBy(xpath = "//*[@id=\"#mothersdaymenu\"]")
	WebElement mothersdaymenu;
	@FindBy(xpath = "//*[@id=\"#birthdaymenu\"]")
	WebElement birthdaymenu;
	@FindBy(xpath = "//*[@id=\"#personalizedmenu\"]")
	WebElement personalizedmenu;
	@FindBy(xpath = "//*[@id=\"#flowersmenu\"]")
	WebElement flowersmenu;
	@FindBy(xpath = "//*[@id=\"#plantsmenu\"]")
	WebElement plantsmenu;
	@FindBy(xpath = "//*[@id=\"#combosmenu\"]")
	WebElement combosmenu;
	@FindBy(xpath = "//*[@id=\"#othergiftsmenu\"]")
	WebElement othergiftsmenu;
	@FindBy(xpath = "//*[@id=\"#anniversarymenu\"]")
	WebElement anniversarymenu;
	@FindBy(xpath = "//*[@id=\"#occasionsmenu\"]")
	WebElement occassionsmenu;
	@FindBy(xpath = "//*[@id=\"#globalmenu\"]")
	WebElement globalmenu;
	


	@FindBy(xpath = "//*[@id=\"cartbtn\"]/span[1]/i")
	WebElement cartbtn;
	@FindBy(xpath = "//*[@id=\"accountbtn\"]")
	WebElement accountbtn;

	@FindBy(xpath = "//*[@id=\"currency-sym\"]")
	public
	WebElement currency_sym;
	@FindBy(xpath = "//a[text()='EUR - Euro']")
	public WebElement Euro;
	@FindBy(xpath = "//*[@id=\"call-info\"]")
	WebElement call_info;
	@FindBy(xpath = "//*[@id=\"enquire\"]")
	WebElement more;
	
	
	@FindBy(xpath = "//*[@id=\"fnplogo\"]/a/img")
	WebElement fnplogo;
	
	
	

	public void searchproduct(String items) throws InterruptedException {
		// Thread.sleep(3000);
		searchbox.sendKeys(items);
		Thread.sleep(1000);
		searchbutton.click();
		Thread.sleep(3000);
		item.click();
		Thread.sleep(3000);
	}

	public void mouseHover(String Menu) {
		Actions action = new Actions(driver);
		switch (Menu) {
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
	}
	}

//	public void click(String Element) {
//		switch (Element) {
//		case "AllCakes":
//			AllCakes.click();
//			break;
//		
//		}
//	}

	public void validation(String menuName) {
		switch (menuName) {
//		case "cartbtn":
//			boolean a=cartbtn.isDisplayed();
//			Assert.assertEquals(a, true);
//			System.out.println("cartbtn is displayed");
//			break;
		case "cartbtn":
			boolean a = cartbtn.isDisplayed();
			if (a == true) {
				System.out.println("cartbtn is displayed");
			} else {
				System.out.println("cartbtn is Not displayed");
			}
			break;
		case "accountbtn":
			boolean b = accountbtn.isDisplayed();
			if (b == true) {
				System.out.println("accountbtn is displayed");
			} else {
				System.out.println("accountbtn is Not displayed");
			}
			break;
		case "currency_sym":
			String c = currency_sym.getText();
			if (c.equals("GBP")) {
				System.out.println("currency GBP is Displayed");
			} else {
				System.out.println("currency GBP is Not Displayed");
			}
			break;
		case "call_info":
			boolean d = call_info.isDisplayed();
			if (d == true) {
				System.out.println("call_info is Displayed");
			} else {
				System.out.println("call_info is Not Displayed");
			}
			break;
		case "more":
			boolean e = more.isDisplayed();
			if (e == true) {
				System.out.println("more options is Displayed");
			} else {
				System.out.println("more options is Not Displayed");
			}
			break;
		case "fnplogo":
			boolean f = fnplogo.isDisplayed();
			if (f == true) {
				System.out.println("fnplogo is Displayed");
			} else {
				System.out.println("fnplogo is Not Displayed");
			}
			break;
		case "searchbox":
			boolean g = searchbox.isDisplayed();
			if (g == true) {
				System.out.println("searchbox is Displayed");
			} else {
				System.out.println("searchbox is Not Displayed");
			}
			break;
		case "flowersmenu":
			boolean h = flowersmenu.isDisplayed();
			if (h == true) {
				System.out.println("searchbox is Displayed");
			} else {
				System.out.println("searchbox is Not Displayed");
			}
			break;
		case "cakesmenu":
			boolean h1 = cakesmenu.isDisplayed();
			if (h1 == true) {
				System.out.println("cakesmenu is Displayed");
			} else {
				System.out.println("cakesmenu is Not Displayed");
			}
			break;
		case "personalizedmenu":
			boolean h2 = personalizedmenu.isDisplayed();
			if (h2 == true) {
				System.out.println("personalizedmenu is Displayed");
			} else {
				System.out.println("personalizedmenu is Not Displayed");
			}
			break;
		case "plantsmenu":
			boolean h3 = plantsmenu.isDisplayed();
			if (h3 == true) {
				System.out.println("plantsmenu is Displayed");
			} else {
				System.out.println("plantsmenu is Not Displayed");
			}
			break;
		case "birthdaymenu":
			boolean h4 = birthdaymenu.isDisplayed();
			if (h4 == true) {
				System.out.println("birthdaymenu is Displayed");
			} else {
				System.out.println("birthdaymenu is Not Displayed");
			}
			break;
		case "othergiftsmenu":
			boolean h5 = othergiftsmenu.isDisplayed();
			if (h5 == true) {
				System.out.println("othergiftsmenu is Displayed");
			} else {
				System.out.println("othergiftsmenu is Not Displayed");
			}
			break;
		case "anniversarymenu":
			boolean h6 = anniversarymenu.isDisplayed();
			if (h6 == true) {
				System.out.println("anniversarymenu is Displayed");
			} else {
				System.out.println("anniversarymenu is Not Displayed");
			}
			break;
		case "occassionsmenu":
			boolean h7 = occassionsmenu.isDisplayed();
			if (h7 == true) {
				System.out.println("occassionsmenu is Displayed");
			} else {
				System.out.println("occassionsmenu is Not Displayed");
			}
			break;
		case "globalmenu":
			boolean h8 = globalmenu.isDisplayed();
			if (h8 == true) {
				System.out.println("globalmenu is Displayed");
			} else {
				System.out.println("globalmenu is Not Displayed");
			}
			break;
			

		}
	}

}