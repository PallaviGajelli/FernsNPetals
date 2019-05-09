package fernsNPetals.pages;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import fernsNPetals.base.TestBase;

public class GiftPage extends TestBase {
	
	
	WebDriver driver;
	@FindBy(xpath = "//span[text()='Next Day Delivery ']")
	public WebElement NextDayDelivery;
	
	
	@FindBy(xpath = "//*[@id=\"personal-image\"]/div/div")//also chngephoto btn
	public WebElement selectPhoto;
	@FindBy(xpath = "//*[@id=\"img-size\"]")
	public WebElement ImgSizeErrorMsg;
	
	
	@FindBy(xpath = "//*[@id=\"destlookup\"]")
	public WebElement searchaddressbox;
	@FindBy(xpath = "/html/body/div[4]")
	public WebElement addressSuggestions;
	@FindBy(xpath = "//span[text()='Solapu']")
	public WebElement firstdynamicaddress;
	@FindBy(xpath = "//span[text()='Hyderabad, Telangana, India']")
	public WebElement hybd500084;
	@FindBy(xpath = "//span[text()='Andhra Pradesh, India']")
	public WebElement hybd533249;

	@FindBy(xpath = "//*[@id=\"addToCart\"]")
	public static WebElement addtocartbutton;
	@FindBy(xpath = "//*[@id=\"buynow\"]")
	public WebElement buynowbutton;
    @FindBy(xpath = "//*[@id=\"FNP_ADDON_ROOT_INDIA\"]/ul/li[5]/label/div/span")
	public WebElement addoncheckbox;
    @FindBy(xpath = "//*[@id=\"FNP_ADDON_ROOT_INDIA\"]/ul/li[5]/figcaption/span[2]")
	public WebElement addonpriceonaddonPage;
    
	@FindBy(xpath = "//*[@id='addon']/form/div[3]/button")
	public WebElement addonbutton;
	@FindBy(xpath = "//*[@id=\"addon\"]/form/div[3]/button/span")
	public WebElement withoutaddonbutton;

	@FindBy(xpath="//*[@id=\"selecte_date\"]")
	public WebElement selectDate;
	@FindBy(xpath = "//*[@id=\"deliverydatepicker\"]/div/div/a[2]")
	WebElement nextmonth;
	@FindBy(xpath = "//*[@id=\"deliverydatepicker\"]/div/div/a[1]/span")
	WebElement previousmonth;

	@FindBy(xpath = "//i[@class='material-icons type-icon info-color']") // validation
	public WebElement checklogin;
	@FindBy(xpath = "//*[@id=\"sidebar\"]")
	WebElement deliveryDetails;

	@FindBy(xpath = "//*[@id=\"loginformEmailId\"]")
	public WebElement loginEmailID;
	@FindBy(xpath = "//*[@id=\"loginPassword\"]")
	WebElement pwd;
	@FindBy(xpath = "//*[@id=\"submit-check\"]/span[1]/span[1]")
	WebElement continuebutton;

	@FindBy(xpath = "//*[@id=\"saved-address--1\"]/h5")
	public WebElement Add_Delivery_Address;
	@FindBy(xpath = "//*[@id=\"rNameId-1\"]")
	public WebElement rname;
	@FindBy(xpath = "//*[@id=\"rMobileId-1\"]")
	WebElement rmobileno;
	@FindBy(xpath = "//*[@id=\"rAddressId-1\"]")
	WebElement raddress;

	// @FindBy(xpath="//*[@id=\"remailId-1\"]")
	// WebElement rEmailid;//optional

	@FindBy(xpath = "//*[@id=\"datetimelink\"]")
	WebElement deliverydate;
	@FindBy(xpath = "//*[@id=\"save-address-btn-1\"]/span[1]/span[1]")
	WebElement submitaddressbutton;
	@FindBy(css = "input.contains('hello')")
	WebElement Iagreetickbox;
	// @FindBy(xpath="//*[@id=\"checkout-container\"]/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div/label/span[1]/span[1]/input")
	// WebElement Iagreetickbox;
	@FindBy(xpath = "//*[@id=\"proceed-to-checkout\"]/span[1]/span[1]")
	WebElement submitorderbutton;

	@FindBy(xpath = "//*[@id=\"dateAlert\"]")
	WebElement deliverydatealert;
	@FindBy(xpath = "//*[@id=\"pincodeAlert\"]") // Select Delivery Area to continue
	WebElement pincodealert;
	@FindBy(xpath = "//*[@id=\"addressform-1\"]/div[1]/div[2]/span") // * Name is required
	WebElement nameisrequire;
	@FindBy(xpath = "//*[@id=\"addressform-1\"]/div[3]/span") // * Recipient's address is required
	WebElement addisrequire;
	@FindBy(xpath = "//*[@id=\"addressform-1\"]/div[8]/div/span") // * Recipient’s mobile number is required.
	WebElement mobileisreqire;

	// @FindBy(className="delete-address")
	@FindBy(xpath = "//*[@id=\"saved-address--1\"]/ul[2]/li/div[2]/div/p[2]")
	WebElement deleteaddress;
	@FindBy(xpath = "/html/body/div[5]/div[2]/div/div/div[2]/span[1]")
	WebElement yesdelete;

	@FindBy(xpath = "//*[@id=\"today\"]/ul/li[2]/div[1]")
	public static WebElement FreeDelivery;//under today
	@FindBy(xpath = "//*[@id=\"today\"]/ul/li[1]/div[1]")
	public static WebElement StdDeliveryunderToday;
	
	@FindBy(xpath = "//*[@id=\"selecte_date-tb\"]/ul/li[2]/div[1]")
	public static WebElement StdDeliveryunderCalender;
	@FindBy(xpath = "//*[@id=\"selecte_date-tb\"]/ul/li[2]/div[2]/ul/li[2]")
	public static WebElement TSlot12to15undercalender;
	
	
	@FindBy(xpath = "//div[@class='item-heading product-name']")//side heading
	public WebElement itemheadingproductname;
	@FindBy(xpath = "//span[@class='curr-symbol']")
	public WebElement currsymbol;
	@FindBy(xpath = "//*[@id=\"breadcrumbs\"]/div/span[2]")
	public WebElement TopHeadingProductName;
	
	@FindBy(xpath = "//*[@id=\"breadcrumbs\"]/div/span[3]")//not applicable for all
	public WebElement TopHeaderOnthePic;
	@FindBy(xpath = "/html/body/main/div[2]/div/div[1]/div/div/div[2]/div/div[1]")//side heading
	public WebElement sideheadernextToPic;
	@FindBy(xpath = "//*[@id=\"breadcrumbs\"]/div/span[3]")
	public WebElement H_Marvellous_Bonsai_Plant;
	@FindBy(xpath = "/html/body/main/div[2]/div/div[1]/div/div/div[2]/div/div[2]/span[2]")
	public WebElement Reviews;
	@FindBy(xpath = "//*[@id=\"productfrm\"]/div[1]")
	public WebElement Cost;
	@FindBy(xpath = "/html/body/main/div[2]/div/div[1]/div/div/div[2]/div/div[1]")
	public WebElement H2_Marvellous_Bonsai_Plan;

	@FindBy(xpath = "//*[@id=\"productfrm\"]/div[3]/a")
	public WebElement View_Product_Details;

	@FindBy(xpath = "//*[@id=\"cartItem_0\"]/ul[1]/li/div[2]/span")
	public WebElement Marvellous_Bonsai_Plant_AddedToCart;
	// @FindBy(xpath = "//span[text()='2 Bournville with gift wraping']")
	// WebElement addonAddedToCart;
	@FindBy(xpath = "//span[text()='2 Bournville with gift wraping']")
	WebElement addonAddedToCart;

	@FindBy(xpath = "//*[@id=\"datetimeshipping\"]")
	public WebElement datetimeshipping;
	@FindBy(xpath = "//*[@id=\"datetimelink\"]")
	public WebElement SelectDeliveryDate;
	@FindBy(xpath = "//a[@class='ui-state-default ui-state-active']")
	public WebElement allreadySelectedDate;
	
	@FindBy(xpath = "//*[@id=\"cartItem_0\"]/ul[1]/li/div[2]/span")
	public WebElement product_AddedToCart;
	@FindBy(xpath = "//*[@id=\"delete-item_0\"]/i")// delet icon
	public WebElement delete_item_0;
	@FindBy(xpath = "//*[@id=\"delete-item_1\"]/i")
	WebElement delete_item_1;
	@FindBy(xpath = "//*[@id=\"cart-button\"]/button") // button[@class='cart-proceed']
	public WebElement proceedToCheckoutinTheCartbtn;
	@FindBy(xpath = "//*[@id=\"cartItem_0\"]/div[2]/span")
	WebElement SendTo;
	@FindBy(xpath = "//span[@class='location-name']")
	WebElement SendTowithoutaddon;
	@FindBy(xpath = "//span[@class=\"addon-quantity\"]")//this is addon qty
	WebElement Quantity;
	@FindBy(xpath = "//span[@class=\"addon-quantity\"]")
	WebElement addonQuantity;
//	@FindBy(xpath = "")
//	WebElement productQuantity;
	@FindBy(xpath = "//*[@id=\"viewcart\"]/div[2]/div[3]/div[1]/span[2]") // GBP 19.75
	public WebElement Amount;
	@FindBy(xpath = "//*[@id=\"viewcart\"]/div[2]/div[3]/div[1]/span[2]/span") // GBP 
	public WebElement cartTotalCurrency;
	                  
	                  
	@FindBy(xpath = "//*[@id=\"cartItem_0\"]/ul/li/div[2]/div/span[2]") // GBP 15.11
	public WebElement subtotalProductwithoutaddon;
	@FindBy(xpath = "//*[@id=\"cartItem_0\"]/ul[1]/li/div[2]/div/span[2]") // GBP 15.11
	public WebElement subtotalProduct;
	@FindBy(xpath = "//*[@id=\"cartItem_0\"]/ul[2]/li/div[2]/div/span[2]") // GBP 4.64
	public WebElement subtotaladdon;
	@FindBy(xpath = "//span[@class='cart-timeslot']")
	WebElement shippingChargesincart;
	@FindBy(xpath = "//*[@id=\"cartbtn\"]/span[1]/i")
	public WebElement cartbtn;
	@FindBy(xpath = "//*[@id=\"cartItem_0\"]/div[3]/div/img")
	public WebElement selectedPhotointhecart;
	
// /html/body/div[1]/div
	@FindBy(xpath = "//div[@class='delete-dialog']")
	public WebElement deletedialog;
	@FindBy(xpath = "//button[@class='del-button opened']")
	public WebElement deleteYesBtn;
	@FindBy(xpath = "//p[text()='Your cart is empty']")
	public WebElement urCartisEmpty;
	String dd;

//	  public void scrollDownToElement(WebElement Element) { 
//		  JavascriptExecutor js =(JavascriptExecutor) driver;
//	  js.executeScript("arguments[0].scrollIntoView();", Element); }

	public void navigateToCart(WebDriver driver) {
		Set<String> IDs = driver.getWindowHandles();
		java.util.Iterator<String> iter = IDs.iterator();
		String homewindow = iter.next();
		String cartwindow = iter.next();

		driver.switchTo().window(cartwindow);
	}

	public void selectDayAfterTomorrow(WebDriver driver) {
		Date date = new Date();
		SimpleDateFormat dateF = new SimpleDateFormat("dd/MMMM/yyyy");
		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.DATE, 4);
		String d = dateF.format(cal.getTime());

		String Ad[] = d.split("/");
		String dd = Ad[0];

		WebElement after2days;
		if (dd.startsWith("0")) {
			dd = dd.substring(1, 2);
			after2days = driver.findElement(By.xpath("//a[text()='" + dd + "']"));
		} else {
			after2days = driver.findElement(By.xpath("//a[text()='" + dd + "']"));
		}
		after2days.click();
	}

	public void clickfirstAddressintheList(WebDriver driver) throws InterruptedException {
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='pac-item']"));
		Thread.sleep(1000);
		list.get(0).click();
		Thread.sleep(1000);
	}
	

	public void IsAddressintheListDisplayed(WebDriver driver) throws InterruptedException {
	List<WebElement> list = driver.findElements(By.xpath("//div[@class='pac-item']"));
	boolean l= list.isEmpty();
	Assert.assertEquals(l, true);
	Thread.sleep(2000);
	}
	


	
	

	public void click(String buttonName) throws InterruptedException {
		switch (buttonName) {
		case "hybd533249":
			hybd533249.click();
			break;
		case "hybd500084":
			hybd500084.click();
			break;
		case "deleteYesBtn":
			deleteYesBtn.click();
			break;
		case "delete_item_0":
			delete_item_0.click();
			break;
		case "cartbtn":
			cartbtn.click();
			break;
		case "datetimeshipping":
			datetimeshipping.click();
			break;
		case "SelectDeliveryDate":
			SelectDeliveryDate.click();
			break;
		case "nextmonth":
			nextmonth.click();
			break;
		case "previousmonth":
			previousmonth.click();
			break;
		case "selectDate":
			selectDate.click();
			Thread.sleep(2000);
			break;
		case "deleteaddress":
			deleteaddress.click();
			Thread.sleep(2000);
			break;
		case "yesdelete":
			yesdelete.click();
			Thread.sleep(3000);
			break;
		case "firstdynamicaddress":
			firstdynamicaddress.click();
			Thread.sleep(3000);
			break;
		case "addtocartbutton":
			addtocartbutton.click();
			Thread.sleep(3000);
			break;
		case "buynowbutton":
			buynowbutton.click();
			Thread.sleep(3000);
			break;
		case "addoncheckbox":
			addoncheckbox.click();
			Thread.sleep(1000);
			break;
		case "addonbutton":
			addonbutton.click();
			Thread.sleep(2000);
			break;
		case "withoutaddonbutton":
			withoutaddonbutton.click();
			break;
		case "continuebutton":
			continuebutton.click();
			Thread.sleep(3000);
			break;
		case "submitaddressbutton":
			submitaddressbutton.click();
			Thread.sleep(3000);
			break;
		case "Iagreetickbox":
			Iagreetickbox.click();
			Thread.sleep(3000);
			break;
		case "submitorderbutton":
			submitorderbutton.click();
			Thread.sleep(3000);
			break;
			
			
		default:
			System.out.print("Button not found");
			Thread.sleep(3000);
			break;
		}
	}

	public void sendkeys(String textbox, String keysToSend) throws InterruptedException {
		switch (textbox) {

		case "searchaddressbox":
			searchaddressbox.sendKeys(keysToSend);
			Thread.sleep(2000);
			break;
		case "loginEmailID":
			loginEmailID.sendKeys(keysToSend);
			Thread.sleep(2000);
			break;
		case "pwd":
			pwd.sendKeys(keysToSend);
			Thread.sleep(1000);
			break;
		case "rname":
			rname.sendKeys(keysToSend);
			Thread.sleep(1000);
			break;
		case "rmobileno":
			rmobileno.sendKeys(keysToSend);
			Thread.sleep(1000);
			break;
		case "raddress":
			raddress.sendKeys(keysToSend);
			Thread.sleep(1000);
			break;

		default:
			System.out.print("texbox not found to enter keysToSend");
			Thread.sleep(1000);
			break;
		}
	}

	public void alertValidation(String alerttype) throws InterruptedException {
		switch (alerttype) {

		case "pincodealert":
			if (pincodealert.isDisplayed()) {
				String alert = pincodealert.getText();
				// Assert.assertEquals(alert, "Select Delivery Area to continue");
				if (alert.contentEquals("Select Delivery Area to continue")) {
					System.out.println("right alert=" + alert);
				} else {
					System.out.println(alert + "is wrong alert");
				}
			}

			Thread.sleep(1000);
			break;

		case "nameisrequire":
			if (nameisrequire.isDisplayed()) {
				String alert = nameisrequire.getText();
				System.out.println(alert);
				// Assert.assertEquals(alert, "* Name is required");
				if (alert.contentEquals("* Name is required")) {
					System.out.println("right alert=" + alert);
				} else {
					System.out.println(alert + " is wrong alert");
				}
			}

			Thread.sleep(1000);
			break;
		case "addisrequire":
			if (addisrequire.isDisplayed()) {
				String alert = addisrequire.getText();
				System.out.println(alert);
				// Assert.assertEquals(alert, "* Recipient's address is required");
				if (alert.contentEquals("* Recipient's address is required")) {
					System.out.println("right alert=" + alert);
				} else {
					System.out.println(alert + " is wrong alert");
				}
			}

			Thread.sleep(1000);
			break;
		case "mobileisreqire":
			if (mobileisreqire.isDisplayed()) {
				String alert = mobileisreqire.getText();
				System.out.println(alert);
				// Assert.assertEquals(alert, "* Recipient’s mobile number is required.");
				if (alert.contentEquals("* Recipient’s mobile number is required.")) {
					System.out.println("right alert=" + alert);
				} else {
					System.out.println(alert + " is wrong alert");
				}
			}

			Thread.sleep(1000);
			break;

		case "checklogin":
			if (checklogin.isEnabled()) {
				System.out.println("This is invalid Email ID");
			} else {
				System.out.println("This is valid Email ID");
			}
			loginEmailID.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
			Thread.sleep(1000);
			break;

		case "deliveryDetails":
			Boolean DeliDetai = deliveryDetails.isDisplayed();
			if (DeliDetai == true) {
				System.out.println("Delivery Details are Displyaed");

			} else {
				System.out.println("Delivery Details are NOT Displyaed");

			}
			break;

		default:
			System.out.print(" message is not displayed");
			break;

		}
	}

	public void filladdressToDelivery(String name, String address, String mobileno) throws InterruptedException {

		rname.sendKeys(name);
		raddress.sendKeys(address);
		rmobileno.sendKeys(mobileno);
		Thread.sleep(1000);
		submitaddressbutton.click();

	}

	public void filladdToDelivery(WebDriver driver, String address, String mobileno, String name) {

		// WebDriver driver;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView();", rname);

		rname.sendKeys(name);
		rmobileno.sendKeys(mobileno);
		raddress.sendKeys(address);
		submitaddressbutton.click();

	}

	public void placeorder() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Iagreetickbox);
		Iagreetickbox.click();
		submitorderbutton.click();

	}

	public void addonproducts() throws InterruptedException {
		addoncheckbox.click();
		addonbutton.click();
		Thread.sleep(3000);
	}

	public void checkPGUrl() {
		  String PGurl= driver.getCurrentUrl();
			
			if (PGurl=="https://www.fnp.com/control/checkout-page-rj/#/checkout-page?f=d") {
			System.out.println("you are at PGurl "+PGurl);}
			else {
				System.out.println("you are at other than PGurl ");
			}
	}
   
  //this is login page
	 public void VerifyCheckoutPage(WebDriver driver) {
	                                                 
		boolean url=driver.getCurrentUrl().contains("https://www.fnp.com/control/checkout-page-rj/#/checkout-page");
	    Assert.assertEquals(url, true);
		if(url==true)
	    {
	    	System.out.println("you are at Login/sign up page");
	    }else {
	    	System.out.println("you are not at Login/sign up page");
	    }
	  
  }
	                                                        
	 public void verifyGiftPageUrl(WebDriver driver,String Product) {
		 Assert.assertEquals((driver.getCurrentUrl().contains("https://www.fnp.com/usa/gift/"+Product+"?")), true);
		 System.out.println("Browser is navigateing to Gift Booking window :"+driver.getCurrentUrl());
	 }
	 
	
    

	public void scrooldownTo(WebDriver driver, String element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		switch (element) {
		case "Iagreetickbox":
			// JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", Iagreetickbox);
			break;
		case "addtocartbutton":
			// JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", addtocartbutton);
			break;
		case "buynowbutton":
			// JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", buynowbutton);
			break;
		case "rname":
			// JavascriptExecutor js3 = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", rname);
			break;
		case "submitaddressbutton":
			// JavascriptExecutor js3 = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", submitaddressbutton);
			break;
		case "raddress":
			// JavascriptExecutor js3 = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", raddress);
			break;

		default:
			System.out.print(" not able to scroll down to element" + element);
			break;
		}

	}
	

	public void vrify(String Element) throws InterruptedException {
		switch (Element) {
		
		case "ImgSizeErrorMsg":
		    Assert.assertEquals((ImgSizeErrorMsg.isDisplayed()), true);
		    Assert.assertEquals((ImgSizeErrorMsg.getText()), "File size between 100KB - 10MB. Only JPG or PNG.");
		    System.out.println("Browser is displaying error message 'File size between100KB-10MB.only JPG or PNG");
		    break;
        case "H_Marvellous_Bonsai_Plant":
			boolean a = H_Marvellous_Bonsai_Plant.isDisplayed();
			Assert.assertEquals(a, true);
			System.out.println("Header 'Marvellous Bonsai Plant' is displayed");
			break;
		case "H2_Marvellous_Bonsai_Plan":
			boolean a1 = H2_Marvellous_Bonsai_Plan.isDisplayed();
			Assert.assertEquals(a1, true);
			System.out.println("Side Header 'Marvellous Bonsai Plant' is displayed");
			break;
		case "Cost":
			boolean a2 = Cost.isDisplayed();
			Assert.assertEquals(a2, true);
			System.out.println("cost of 'Marvellous Bonsai Plant' is displayed");
			break;
		case "Reviews":
			boolean a3 = Reviews.isDisplayed();
			Assert.assertEquals(a3, true);
			System.out.println("Reviews for 'Marvellous Bonsai Plant' is displayed");
			break;
		case "addtocartbutton":
			boolean a4 = addtocartbutton.isDisplayed();
			Assert.assertEquals(a4, true);
			System.out.println("add to cart button is displayed");
			break;
		case "buynowbutton":
			boolean a5 = buynowbutton.isDisplayed();
			Assert.assertEquals(a5, true);
			System.out.println("buynowbutton is displayed");
			break;
		case "searchaddressbox":
			boolean a6 = searchaddressbox.isDisplayed();
			Assert.assertEquals(a6, true);
			System.out.println("searchaddressbox is displayed");
			break;
		case "View_Product_Details":
			boolean a7 = View_Product_Details.isDisplayed();
			Assert.assertEquals(a7, true);
			System.out.println("View Product Details is displayed");
			break;
		case "pincodealert":
			boolean a8 = pincodealert.isDisplayed();
			Assert.assertEquals(a8, true);
			String a9 = pincodealert.getText();
			System.out.println("pincodealert is displayed is :" + a9);
			break;
		case "Marvellous_Bonsai_Plant_AddedToCart":
			boolean a10 = Marvellous_Bonsai_Plant_AddedToCart.isDisplayed();
			Assert.assertEquals(a10, true);
			String a11 = Marvellous_Bonsai_Plant_AddedToCart.getText();
			System.out.println("Product Added To Cart is :" + a11);
			break;
		case "product_AddedToCart":
			Assert.assertEquals((product_AddedToCart.isDisplayed()), true);
			System.out.println("Product Added To Cart is :" +(product_AddedToCart.getText()));
			break;
		case "addonAddedToCart":
			boolean a12 = addonAddedToCart.isDisplayed();
			Assert.assertEquals(a12, true);
			String a13 = addonAddedToCart.getText();
			System.out.println("addon Added To Cart is :" + a13);
			break;
		case "delete_item_0":
			boolean a14 = delete_item_0.isDisplayed();
			Assert.assertEquals(a14, true);
			System.out.println("delete item icon is displayed in the cart");
			break;
		case "delete_item_1":
			boolean a15 = delete_item_1.isDisplayed();
			Assert.assertEquals(a15, true);
			System.out.println("delete addon item icon is displayed in the cart");
			break;
		case "proceedToCheckoutinTheCartbtn":
			boolean a16 = proceedToCheckoutinTheCartbtn.isDisplayed();
			Assert.assertEquals(a16, true);
			System.out.println("proceed To Checkout in The Cartbtn is displayed in the cart");
			break;
		case "SendTo":
			boolean a17 = SendTo.isDisplayed();
			Assert.assertEquals(a17, true);
			System.out.println("Send To Address is displayed in the cart");
			break;
		case "Quantity":
			boolean a18 = Quantity.isDisplayed();
			Assert.assertEquals(a18, true);
			System.out.println("Quantity is displayed in the cart");
			break;
		case "Amount":
			boolean a19 = Amount.isDisplayed();
			Assert.assertEquals(a19, true);
			System.out.println("Amount is displayed in the cart");
			break;
		case "subtotalProduct":
			boolean a20 = subtotalProduct.isDisplayed();
			Assert.assertEquals(a20, true);
			System.out.println("sub total of Product is displayed in the cart");
			break;
		case "subtotaladdon":
			boolean a21 = subtotaladdon.isDisplayed();
			Assert.assertEquals(a21, true);
			System.out.println("sub total of th addon is displayed in the cart");
			break;
		case "shippingChargesincart":
			boolean a22 = shippingChargesincart.isDisplayed();
			Assert.assertEquals(a22, true);
			System.out.println("shipping Charges in cart is displayed");
			break;

		case "deletedialog":
			Assert.assertEquals((deletedialog.isDisplayed()), true);
			System.out.println("delete dialog box is displayed");
			Assert.assertEquals((deletedialog.getText().contentEquals("Delete this Item?\nNOYES")), true);
			System.out.println("msg displayed on the alert msg:"+(deletedialog.getText()));
			break;
		case "urCartisEmpty":
			boolean a25 = urCartisEmpty.isDisplayed();
			Assert.assertEquals(a25, true);
			System.out.println("your cart is empty is displayed");
			boolean a26 = urCartisEmpty.getText().contentEquals("Your cart is empty");
			try {
				Assert.assertEquals(a26, true);
			} catch (Exception e) {
				System.out.println("Exception occured is :" + e);
			}
			break;
		
		default:
			System.out.println(Element + "Element is missing");

		}
	}
       
		public void giftwindowVerification(String ProductName) {
		
			
			//Assert.assertEquals(TopHeaderOnthePic.isDisplayed(), true);
			Assert.assertEquals((TopHeaderOnthePic.getText()),""+ProductName);
			System.out.println("Top Header On the Pic is displayed:"+TopHeaderOnthePic.getText());
			
			
		
			//Assert.assertEquals(sideheadernextToPic.isDisplayed(), true);
			Assert.assertEquals((sideheadernextToPic.getText()), ProductName);
			System.out.println("side header next To Pic is displayed:"+sideheadernextToPic.getText());
			
		
			Assert.assertEquals(Cost.isDisplayed(), true);
			System.out.println("cost of 'Marvellous Bonsai Plant' is displayed");
	
			Assert.assertEquals(Reviews.isDisplayed(), true);
			System.out.println("Reviews for 'Marvellous Bonsai Plant' is displayed");
		
			Assert.assertEquals(addtocartbutton.isDisplayed(), true);
			System.out.println("add to cart button is displayed");
		
			Assert.assertEquals(buynowbutton.isDisplayed(), true);
			System.out.println("buynowbutton is displayed");
		
			Assert.assertEquals(searchaddressbox.isDisplayed(), true);
			System.out.println("searchaddressbox is displayed");
		
	}
		
		public void cartverification(String Product) {
		////////product name
			Assert.assertEquals(product_AddedToCart.getText().contains(Product), true);
			System.out.println("product name is displayed in the cart");
			
			Assert.assertEquals(delete_item_0.isDisplayed(), true);
			System.out.println("delete item icon is displayed in the cart");
			////////////continue shopping btn
//			Assert.assertEquals(.isDisplayed(), true);
//			System.out.println("continue shopping btn is displayed in the cart");
		
			Assert.assertEquals(proceedToCheckoutinTheCartbtn.isDisplayed(), true);
			System.out.println("proceed To Checkout in The Cartbtn is displayed in the cart");
	
			Assert.assertEquals(SendTowithoutaddon.isDisplayed(), true);
			System.out.println("Send To Address is displayed in the cart");
		
//			Assert.assertEquals(productQuantity.isDisplayed(), true);
//			System.out.println(" Product Quantity is displayed in the cart");
	
			Assert.assertEquals(Amount.isDisplayed(), true);
			System.out.println("Amount is displayed in the cart");
		
			Assert.assertEquals(subtotalProductwithoutaddon.isDisplayed(), true);
			System.out.println("sub total of Product is displayed in the cart");
		
//			Assert.assertEquals(subtotaladdon.isDisplayed(), true);
//			System.out.println("sub total of th addon is displayed in the cart");
			
			Assert.assertEquals(shippingChargesincart.isDisplayed(), true);
			System.out.println("shipping Charges in cart is displayed");
	
		}
		



}
