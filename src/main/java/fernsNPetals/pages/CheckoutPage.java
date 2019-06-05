package fernsNPetals.pages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import fernsNPetals.base.TestBase;

public class CheckoutPage extends TestBase {
	
	@FindBy(xpath = "//*[@id=\"checkout-container\"]/div[1]/div/div/div[1]/div[1]/div[2]")
    public WebElement registrationPage;
	@FindBy(xpath = "//*[@id=\"reg_name\"]")
    public WebElement regname;
	@FindBy(xpath = "//*[@id=\"reg_mobile\"]")
    public WebElement regmobile;
	@FindBy(xpath = "//*[@id=\"regPassword\"]")
    public WebElement regPassword;
	@FindBy(xpath = "//*[@id=\"register_form\"]/div[2]/span")//Name is required
    public WebElement Nameisrequired;
	@FindBy(xpath = "//*[@id=\"register_form\"]/div[4]/span")//Mobile number is required
    public WebElement Mobilenumberisrequired;
	@FindBy(xpath = "//*[@id=\"register_form\"]/div[6]/div[2]/p")//At least 6 characters
    public WebElement Atleast6characters;
	@FindBy(xpath = "//*[@id=\"register_form\"]/div[6]/span")//Create password is required
    public WebElement Createpasswordisrequired;
	@FindBy(xpath = "//*[@id=\"checkout-container\"]/div[1]/div/div/div[1]/div[1]/div[2]/h4")
    public WebElement RegisterPageheading;//Register
	@FindBy(xpath = "//*[@id=\"register_form\"]/div[1]")//Welcome, we are glad you are here!
    public WebElement Welcome;
	@FindBy(xpath = "//*[@id=\"register_form\"]/div[5]/div/div/div/span")//edit mail id
    public WebElement modeedit;
	@FindBy(xpath = "//*[@id=\"check-login2\"]/div[1]/div/div/div/span")//edit mail id on login page
    public WebElement editEmailID;
	
	@FindBy(xpath = "//*[@id=\"register_form\"]/div[7]/label/span[2]/span")//Remember me
    public WebElement Remembermecheckbox;
	
	
	
	@FindBy(xpath = "//*[@id=\"card-form--cc\"]/span[1]/span[1]/span/span")
    public WebElement PayBtnonPaymentOptions;
	@FindBy(xpath = "//*[@id=\"checkout-container\"]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div/div[1]/img")
    public WebElement yourPhotoOnProduct;
	
	@FindBy(xpath = "//*[@id=\"checkout-container\"]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div")
	public WebElement deleteProductatcheckout;
    @FindBy(xpath = "//div[text()='Are you sure you want to delete this item ?']")
    public WebElement deleteProductalert;//Are you sure you want to delete this item ?YesNo
    @FindBy(xpath = "//span[@class='delete-confirm-yes']")
    public WebElement deleteProductalertYesBtn;
    @FindBy(xpath = "//span[@class='delete-confirm-no']")
    public WebElement deleteProductalertNoBtn;
    @FindBy(xpath = "//div[@class='empty-msg']")
    public WebElement cartisEmptyMsg;//shopping_cartYour cart is empty. But it doesn't have to be
    @FindBy(xpath = "//span[text()='START SHOPPING NOW']")
    public WebElement StartShoppingNowBtn;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/div[2]/div[1]/span")
	public static WebElement TotalProductPriceonPriceDetails ;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/div[2]/div[2]/span")
	public static WebElement shippingPriceonPriceDetails;
    @FindBy(xpath = "//*[@id=\"sidebar\"]/div[2]/div[3]/span")
	public static WebElement TotalPriceonPriceDetails;
    
    @FindBy(xpath = "//*[@id=\"checkout-container\"]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/span/span[1]/span")
	public WebElement productPriceonOrdernDeliveryDetailPage;
    @FindBy(xpath = "//*[@id=\"checkout-container\"]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/span/span[2]")
	WebElement ProductqtyonDeliveryDetailPage;//x1
                      
    @FindBy(xpath = "//*[@id=\"checkout-container\"]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/span/span/span")
	public WebElement addonPriceonOrdernDeliveryDetailPage;
    @FindBy(xpath = "//*[@id=\"checkout-container\"]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div/div/div[2]/div[2]/span/span/span")
	public WebElement addonPricewithimgonOrdernDeliveryDetailPage;
    
	@FindBy(xpath = "//*[@id=\"checkout-container\"]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/span/span[1]/span")
	WebElement MarvellousBonsaiPlantPrice;//15.11
	@FindBy(xpath = "//*[@id=\"checkout-container\"]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/span/span[2]")
	WebElement MarvellousBonsaiPlantqty;//x1
	@FindBy(xpath = "//div[@class='delivery-date ']")
	public WebElement DeliveryDate;//Fri, 3rd May, 2019
	@FindBy(xpath = "//*[@id=\"checkout-container\"]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[3]/div[1]/div[2]")
	public WebElement deliverytime ;//09:00 - 21:00 Hrs
	@FindBy(xpath = "//*[@id=\"checkout-container\"]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[3]/div[2]/div")
	public WebElement changebtn;
	@FindBy(xpath = "//*[@id=\"checkout-container\"]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div[1]")
	public WebElement addon;
	@FindBy(xpath = "//*[@id=\"checkout-container\"]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div/div/div[2]/div[1]")
	public WebElement addonwithimg;
	@FindBy(xpath = "//h5[text()='Add Delivery Address']")
	public static WebElement addnewaddress;//header
	@FindBy(xpath = "//h5[text()='Free Message card']")
	public WebElement FreeMessagecard;
	@FindBy(xpath = "//span[@class='sender-info-title']")
	public WebElement SendersDetailsheading;
	@FindBy(xpath = "//*[@id=\"senderName\"]")
	public WebElement  senderName;
	@FindBy(xpath = "//*[@id=\"senderEmailId\"]")
	public WebElement  senderEmailId;
	@FindBy(xpath = "//*[@id=\"senderPhone\"]")
	public WebElement senderPhone;
	
	
	@FindBy(xpath = "//span[text()='Select Occasion']")
	public WebElement SelectOccasion;
	@FindBy(xpath = "//li[@value='birthday']")
	public WebElement Occasionbirthday;
	@FindBy(xpath = "//span[text()='Save']")
	public WebElement saveBtn;
	@FindBy(xpath = "//span[text()='Message Cannot Be Empty']")
	public WebElement MessageCannotBeEmpty;
	@FindBy(xpath = "//span[text()='Select Message on Card']")//this is btn
	public WebElement SelectMessageonCard;
	@FindBy(xpath = "//*[@id=\"messagecard-dialog\"]/div[2]/div/div[1]/div/div[2]/div[2]/div/div/div/div/ul/li[1]")
	public WebElement SelectfirstMessage;
	@FindBy(xpath = "//div[text()='Select Message']")//this is alert msg
	public WebElement SelectMessage;
	@FindBy(xpath = "//textarea[@id='msg_card_message']")
	public WebElement msgoncard;
	
	
	
	@FindBy(xpath = "//span[text()='Select Delivery Date']")
	public WebElement selectDeliveryDate;
	

	@FindBy(xpath = "//h4[text()='Order & Delivery Details']")
	public WebElement orderenDeliveryDetails;
	@FindBy(xpath = "//div[@class='giftItem']")
	public WebElement orderenDeliveryDetailsPage;
	
	@FindBy(xpath = "//div[@class='facebook-login']")
	WebElement facebooklogin;
	@FindBy(xpath = "//div[@class='google-login']")
	WebElement googlelogin;
	
	

	@FindBy(xpath = "//*[@id=\"loginformEmailId\"]")
	public WebElement loginEmailID;
	@FindBy(xpath = "//*[@id=\"loginPassword\"]")
	public  WebElement pwd;
	@FindBy(xpath = "//*[@id=\"submit-check\"]/span[1]/span[1]")
	public WebElement continuebutton;
	@FindBy(xpath = "//span[@class='errorLogin']")//Enter correct email or password.
	WebElement errorLogin;
	
	@FindBy(xpath = "//*[@id=\"saved-address--1\"]/h5")
	public WebElement Add_Delivery_Address;
	@FindBy(xpath = "//*[@id=\"rNameId-1\"]")
	public WebElement rname;
    @FindBy(xpath = "//*[@id=\"addressform-1\"]/div[1]/div[1]/button/span[1]")//div[@id='menu-list-collapse'] menu-list-collapse--id
	public static WebElement Prefix;
   @FindBy(xpath = "//li[text()='Ms.']")
	public static WebElement PrefixMs;
    
	@FindBy(xpath = "//*[@id=\"rMobileId-1\"]")
	public
	WebElement rmobileno;
	@FindBy(xpath = "//*[@id=\"rAddressId-1\"]")
	public
	WebElement raddress;
	@FindBy(xpath = "//*[@id=\"rAddress2Id-1\"]")
	WebElement landmark;
	@FindBy(xpath = "//input[@id='remailId-1']")
	public
	WebElement rEmailIdOptional;
	@FindBy(xpath = "//*[@id=\"save-address-btn-1\"]/span[1]/span[1]")
	WebElement submitaddressbutton;

	@FindBy(xpath = "//*[@id=\"saved-address--1\"]/ul[2]/li")
	public WebElement savedAdd;//li[@class='saved-address selected']
	@FindBy(xpath = "//li[@class='saved-address selected']")
	public WebElement savedAddselected;
	@FindBy(xpath = "//p[@title='Edit this Address']")
	public WebElement editsavedAddBtn;
	@FindBy(xpath = "//div[@class='add-address-main']")
	public WebElement editsavedAddpage;
	@FindBy(xpath = "//span[@class='recepient-name capitalize']")
	public WebElement recepientnameinSavedAdd;
	@FindBy(xpath = "//span[@class='recepient-name capitalize']")
	public WebElement recepientmobileinSavedAdd;
	@FindBy(xpath = "//div[@class='saved-address--details']")
	public WebElement savedaddDetails;
	
	
	

	@FindBy(xpath = "//*[@id=\"addressform-1\"]/div[1]/div[2]/span") // * Name is required
	WebElement nameisrequire;
	@FindBy(xpath = "//*[@id=\"addressform-1\"]/div[3]/span") // * Recipient's address is required
	WebElement addisrequire;
	@FindBy(xpath = "//*[@id=\"addressform-1\"]/div[8]/div/span") // * Recipient’s mobile number is required.
	WebElement mobileisreqire;
	@FindBy(xpath = "//*[@id=\"addressform-1\"]/div[8]/div/span") // * Recipient’s mobile number is invalid.
	WebElement invalidrMobile;
	
	@FindBy(xpath = "//input[@value='hello']")
	WebElement Iagreetickbox;
	@FindBy(xpath = "//span[text()='Proceed To Checkout']")
	public WebElement proceedtocheckout;
	@FindBy(xpath = "//span[text()='Your consent is required']")
	public WebElement Yourconsentisrequired;
	

	@FindBy(xpath = "//h4[text()='PAYMENT OPTIONS']")
	public WebElement paymentOptions;
	@FindBy(xpath = "//div[@class='payment-options']")
	public WebElement paymentOptionspage;
	@FindBy(xpath = "//*[@id=\"check-login\"]/div/div/div/div/span") // validation//i[@class='material-icons type-icon info-color']
	public WebElement checklogin;

	@FindBy(xpath = "//*[@id=\"pincodeAlert\"]") // Select Delivery Area to continue
	WebElement pincodealert;
	@FindBy(xpath = "//*[@id=\"sidebar\"]")
	WebElement deliveryDetails;
	@FindBy(xpath = "//div[@class='DayPicker-Day DayPicker-Day--selected']")
	public WebElement SelectedDate;
	
	//div[ @class='DayPicker-Day DayPicker-Day--selected']
	String dd;
	
	 public void validation(WebElement webelement) {
		   Assert.assertEquals((webelement.isDisplayed()), true);
			System.out.println(webelement+ "is displayed");
	   }
	
	public void selectPrefixAsMs(WebDriver driver) throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",CheckoutPage.Prefix);
		//Prefix.click();
		Thread.sleep(1000);
		
		js.executeScript("arguments[0].click();",CheckoutPage.PrefixMs);
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
	
	
	public void selectTomorrow(WebDriver driver) {
		Date date = new Date();
		SimpleDateFormat dateF = new SimpleDateFormat("dd/MMMM/yyyy");
		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.DATE, 4);
		String d = dateF.format(cal.getTime());

		String Ad[] = d.split("/");
	    dd = Ad[0];

		WebElement after2days;
		if (dd.startsWith("0")) {
			dd = dd.substring(1, 2);
			after2days = driver.findElement(By.xpath("//div[text()='"+dd+"']"));
		} else {
			after2days = driver.findElement(By.xpath("//div[text()='"+dd+"']"));
		}
		after2days.click();
	}
	

	public void sendkeys(String textbox, String keysToSend) throws InterruptedException {
		switch (textbox) {

		case "loginEmailID":
			loginEmailID.sendKeys(keysToSend);
			Thread.sleep(1000);
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
		case "landmark":
			landmark.sendKeys(keysToSend);
			Thread.sleep(1000);
			break;
		case "rEmailIdOptional":
			rEmailIdOptional.sendKeys(keysToSend);
			Thread.sleep(1000);
			break;

		default:
			System.out.print("texbox not found to enter keysToSend");
			Thread.sleep(1000);
			break;
		}
	}

	public void loginFnP() throws InterruptedException {

		loginEmailID.sendKeys("testmeapp1@gmail.com");
		Thread.sleep(1000);
		continuebutton.click();
		Thread.sleep(1000);
		pwd.sendKeys("test@2018");
		Thread.sleep(1000);
		continuebutton.click();
		Thread.sleep(1000);
	}

	public void click(String buttonName) throws InterruptedException {
		switch (buttonName) {  
		case "editsavedAddBtn":editsavedAddBtn.click();Thread.sleep(1000);
			break;
		case "Prefix":Prefix.click();Thread.sleep(1000);
			break;
		case "PrefixMs":JavascriptExecutor js = (JavascriptExecutor)driver;
			           js.executeScript("arguments[0].click();", PrefixMs);
			           //PrefixMs.click();
			          Thread.sleep(1000);
			          break;
		case "addnewaddress":addnewaddress.click();Thread.sleep(1000);
			break;
		case "StartShoppingNowBtn":StartShoppingNowBtn.click();Thread.sleep(1000);
			break;
		case "deleteProductalertYesBtn":deleteProductalertYesBtn.click();Thread.sleep(1000);
			break;
		case "deleteProductalertNoBtn":deleteProductalertNoBtn.click();Thread.sleep(1000);
			break;
		case "deleteProductatcheckout":deleteProductatcheckout.click();Thread.sleep(1000);
			break;
		case "changebtn":changebtn.click();Thread.sleep(1000);
			break;
		case "continuebutton":continuebutton.click();Thread.sleep(1000);
			break;
		case "submitaddressbutton":submitaddressbutton.click();Thread.sleep(2000);
			break;

		}
	}

	public void filladdressToDelivery(WebDriver driver, String name, String address, String mobileno)
			throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", rname);

		rname.sendKeys(name);
		raddress.sendKeys(address);
		rmobileno.sendKeys(mobileno);
		Thread.sleep(1000);
		submitaddressbutton.click();
		Thread.sleep(1000);

	}
	public void filladdressToDelivery(WebDriver driver, String name, String address, String mobileno,String slandmark,String emailid)
			throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", rname);

		rname.sendKeys(name);
		raddress.sendKeys(address);
		rmobileno.sendKeys(mobileno);
		Thread.sleep(1000);
		landmark.sendKeys(slandmark);
		rEmailIdOptional.sendKeys(emailid);
		submitaddressbutton.click();
		Thread.sleep(1000);

	}

	public void placeorder(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Iagreetickbox);
		js.executeScript("arguments[0].click();", proceedtocheckout);
		//proceedtocheckout.click();
	}

	public void alertValidation(String alerttype) throws InterruptedException {
    	switch (alerttype) {
		
    	case "pincodealert":
			if(pincodealert.isDisplayed()) { 
				  String alert=pincodealert.getText();
				  //Assert.assertEquals(alert, "Select Delivery Area to continue");
				  if (alert.contentEquals("Select Delivery Area to continue"))
				  {
			         System.out.println("right alert="+alert);
			      } 
				  else {
			        System.out.println(alert+"is wrong alert");
			           }}
			
				  Thread.sleep(1000);
				  break;			
		
		case "nameisrequire":
			if(nameisrequire.isDisplayed()) { 
				  String alert=nameisrequire.getText();
				  System.out.println(alert);
				 // Assert.assertEquals(alert, "* Name is required");
				  if (alert.contentEquals("* Name is required"))
				   {
			         System.out.println("right alert="+alert);
			       } 
				  else {
			        System.out.println(alert+" is wrong alert");
			           }}
				  
				  Thread.sleep(1000);
		          break;
		case "addisrequire": 
		if(addisrequire.isDisplayed()) { 
			  String alert=addisrequire.getText();
			  System.out.println(alert);
			 // Assert.assertEquals(alert, "* Recipient's address is required");
			  if (alert.contentEquals("* Recipient's address is required"))
			  {
		         System.out.println("right alert="+alert);
		       } 
			  else {
		        System.out.println(alert+" is wrong alert");
		         }}
			
			  Thread.sleep(1000);
	          break;
		case "mobileisreqire":
		if(mobileisreqire.isDisplayed()) { 
			  String alert= mobileisreqire.getText();
			  System.out.println(alert);
			 // Assert.assertEquals(alert, "* Recipient’s mobile number is required.");
			  if (alert.contentEquals("* Recipient’s mobile number is required."))
			  {
		         System.out.println("right alert="+alert);
		       } 
			  else {
		        System.out.println(alert+" is wrong alert");
		         }}
			 
			  Thread.sleep(1000);
	          break;
		
		case "checklogin":     
	          if (checklogin.isEnabled()) {
	      		System.out.println("This is invalid Email ID");}
	      	else {
	      		System.out.println("This is valid Email ID");
	      	     }	
	      	loginEmailID.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));	 
	  			  Thread.sleep(1000);
	  			break;
	  			  
		case"deliveryDetails":
			Boolean DeliDetai = deliveryDetails.isDisplayed();
			   if(DeliDetai==true) {
			    	  System.out.println("Delivery Details are Displyaed");
			    	  
			      }else {
			    	  System.out.println("Delivery Details are NOT Displyaed");

			     }
			   break;
			
			  default : System.out.print(" message is not displayed"); 
			  break;
	
    }
	}
	
	
    	
	public void verify(String Element) {
		
		switch (Element) {
		case "registrationPage":
			Assert.assertEquals((registrationPage.isDisplayed()), true);
			System.out.println("registrationPage is displayed");
			break;
        case "loginEmailID":
			Assert.assertEquals(loginEmailID.isDisplayed(), true);
			System.out.println("loginEmailID is displayed");
			break;
		case "continuebutton":
			Assert.assertEquals(continuebutton.isDisplayed(), true);
			System.out.println("continuebutton is displayed");
			break;
		case "facebooklogin":
			Assert.assertEquals(facebooklogin.isDisplayed(), true);
			System.out.println("facebook login is displayed");
			break;
		case "googlelogin":
			Assert.assertEquals(googlelogin.isDisplayed(), true);
			System.out.println("google login is displayed");
			break;
		case "orderenDeliveryDetails":
			Assert.assertEquals(orderenDeliveryDetails.isDisplayed(), true);
			System.out.println("Header 'Marvellous Bonsai Plant' is displayed");
			break;
		case "paymentOptions":
			Assert.assertEquals(paymentOptions.isDisplayed(), true);
			System.out.println("paymentOptions is displayed");
			break;
		case "orderenDeliveryDetailsPage":
		    Assert.assertEquals(orderenDeliveryDetailsPage.isDisplayed(), true);
			System.out.println("ordere n Delivery Details Page is displayed");
			break;
		case "errorLogin"://this is for wrong password
            Assert.assertEquals(errorLogin.isDisplayed(), true);
			System.out.println("Enter correct email or password. is displayed is :"+errorLogin.getText());
			break;
		case "MarvellousBonsaiPlantPriceandQty":
			Assert.assertEquals(MarvellousBonsaiPlantPrice.isDisplayed(), true);
			System.out.println("Marvellous Bonsai Plant Price is displayed in ordere n Delivery Details Page");
			break;
		case "Deliverydateandtime":
	        Assert.assertEquals(DeliveryDate.isDisplayed(), true);
			System.out.println("Delivery Date is displayed in ordere n Delivery Details Page");
		    Assert.assertEquals(deliverytime.isDisplayed(), true);
			System.out.println("delivery time is displayed in ordere n Delivery Details Page");
			break;
		case "changebtn":
			Assert.assertEquals(changebtn.isDisplayed(), true);
			System.out.println("changebtn is displayed in ordere n Delivery Details Page");
			break;
		case "addon":
			Assert.assertEquals(addon.isDisplayed(), true);
			System.out.println("addon is displayed in ordere n Delivery Details Page");
			break;
		case "addnewaddress":
			Assert.assertEquals(addnewaddress.isDisplayed(), true);
			System.out.println("add new address is displayed in ordere n Delivery Details Page");
			break;
		case "FreeMessagecard":
			Assert.assertEquals(FreeMessagecard.isDisplayed(), true);
			System.out.println("FreeMessagecard is displayed in ordere n Delivery Details Page");
			break;
		case "sendersdetails":
			Assert.assertEquals(SendersDetailsheading.isDisplayed(), true);
			System.out.println("Senders Details heading is displayed in ordere n Delivery Details Page");
	    	Assert.assertEquals(senderName.isDisplayed(), true);
			System.out.println("senderName is displayed in ordere n Delivery Details Page");
	        Assert.assertEquals(senderEmailId.isDisplayed(), true);
			System.out.println("senderEmailId is displayed in ordere n Delivery Details Page");
		    Assert.assertEquals(senderPhone.isDisplayed(), true);
			System.out.println("senderPhone is displayed in ordere n Delivery Details Page");
			break;
		case "selectDeliveryDate":
			Assert.assertEquals(selectDeliveryDate.isDisplayed(), true);
			System.out.println("select Delivery Date is displayed on clicking changebtn");
			break;
		case "DeliveryDate":
			Assert.assertEquals(DeliveryDate.isDisplayed(), true);
			System.out.println("Delivery Date is displayed in ordere n Delivery Details Page");
			
			try {
				//String[] formats = {"EEE, d'st' MMM, yyyy","EEE, d'nd' MMM, yyyy","EEE, d'rd' MMM, yyyy","EEE, d'th' MMM, yyyy"};
				DateFormat format = new SimpleDateFormat("EEE, d'th' MMM, yyyy", Locale.ENGLISH);
				Date date = format.parse(DeliveryDate.getText());
				System.out.println(date); // Sat Jan 02 00:00:00 GMT 2010
				
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "deleteProductalert":
	        Assert.assertEquals(deleteProductalert.isDisplayed(), true);
			Assert.assertEquals(deleteProductalert.getText().contains("Are you sure you want to delete this item ?"),true);
			System.out.println("select Delivery Date is displayed on clicking changebtn :"+deleteProductalert.getText());
			break; 
		case "StartShoppingNowBtn":
			Assert.assertEquals(StartShoppingNowBtn.isDisplayed(), true);
			System.out.println("Start Shopping Now Btn is displayed in ordere n Delivery Details Page");
			break;
		case "cartisEmptyMsg":
			Assert.assertEquals(cartisEmptyMsg.isDisplayed(), true);
			System.out.println("cart is Empty Msg is displayed in ordere n Delivery Details Page");
			break;
		case "EmptyAddressAlertMsg":
		 
			Assert.assertEquals(nameisrequire.isDisplayed(), true);
			Assert.assertEquals(nameisrequire.getText(), "* Name is required");
			System.out.println("name is require is displayed :"+nameisrequire.getText());
		
			Assert.assertEquals(addisrequire.isDisplayed(), true);
			Assert.assertEquals(addisrequire.getText(), "* Recipient's address is required");
			System.out.println("add is require is displayed :"+addisrequire.getText());
	    	Assert.assertEquals(mobileisreqire.isDisplayed(), true);
			
			Assert.assertEquals(mobileisreqire.getText(), "* Recipient’s mobile number is required.");
	    	System.out.println("mobile is reqire is displayed :"+mobileisreqire.getText());
			break;
            
		    case "invalidrMobile":
	        Assert.assertEquals(invalidrMobile.isDisplayed(), true);
			Assert.assertEquals(invalidrMobile.getText(), "* Recipient’s mobile number is invalid.");
			System.out.println("invalid rmobile is displayed :"+invalidrMobile.getText());
			break;
		   
//		    case "InvalidAddressAlertMsg":
//		    boolean a36= nameisrequire.isDisplayed();
//			String a37 = nameisrequire.getText();
//			Assert.assertEquals(a36, true);
//			Assert.assertEquals(a37, "* Name is required");
//			System.out.println("name is require is displayed :"+a37);
//			
//			boolean a38 = addisrequire.isDisplayed();
//			String a39 = addisrequire.getText();
//			Assert.assertEquals(a38, true);
//			Assert.assertEquals(a39, "* Recipient's address is required");
//			System.out.println("add is require is displayed :"+a39);
//		
//			boolean a40 = mobileisreqire.isDisplayed();
//			Assert.assertEquals(a40, true);
//			String a41 = mobileisreqire.getText();
//			Assert.assertEquals(a41, "* Recipient’s mobile number is required.");
//	    	System.out.println("mobile is reqire is displayed :"+a41);
//			break;
		    case "savedAddselected":
			Assert.assertEquals(savedAddselected.isDisplayed(), true);
			System.out.println("saved Add selected is displayed in ordere n Delivery Details Page");
			break;
		    case "editsavedAddpage":
		    Assert.assertEquals(editsavedAddpage.isDisplayed(), true);
			System.out.println("edit saved Add page is displayed in ordere n Delivery Details Page");
			break;
		    case "checklogin":
				Assert.assertEquals(checklogin.isDisplayed(), true);
				System.out.println("wrong email id alert is displayed");
				break;
		    case "paymentOptionspage":
				Assert.assertEquals((paymentOptionspage.isDisplayed()), true);
				System.out.println("paymentOptionspage is displayed");
				break;
				
		   
		}
	}
	
	public void checkCurrency(String currency) {
		
	String a45 = productPriceonOrdernDeliveryDetailPage.getAttribute("class");
	Assert.assertEquals(a45.contains(currency), true);
	System.out.println("Product price with "+currency+" price is displayed");
	
	String a46 = addonPriceonOrdernDeliveryDetailPage.getAttribute("class");
	Assert.assertEquals(a46.contains(currency), true);
	System.out.println("addon price with "+currency+" price is displayed");
	
	String a47 = TotalProductPriceonPriceDetails.getAttribute("class");
	Assert.assertEquals(a47.contains(currency), true);
	System.out.println("Total Product Price on Price Details with "+currency+" price is displayed");
	
	String a48 = shippingPriceonPriceDetails.getAttribute("class");
	Assert.assertEquals(a48.contains(currency), true);
	System.out.println("shipping Price on Price Details with "+currency+" price is displayed");
	
	String a49 = TotalPriceonPriceDetails.getAttribute("class");
	Assert.assertEquals(a49.contains(currency), true);
	System.out.println("Total Price on Price Details with "+currency+" price is displayed");
	}	
	
	public void checkoutPageVerification() {
//		Email id textbox
	    Assert.assertEquals((loginEmailID.isDisplayed()), true);
		System.out.println("loginEmailID is displayed");
//		continue button
		Assert.assertEquals((continuebutton.isDisplayed()), true);
		System.out.println("continuebutton is displayed");
//		Facebook link
		Assert.assertEquals((facebooklogin.isDisplayed()), true);
		System.out.println("facebook login is displayed");
//		Google+ link
		Assert.assertEquals((googlelogin.isDisplayed()), true);
		System.out.println("google login is displayed");
//		Order & Delivery Details
		Assert.assertEquals((orderenDeliveryDetails.isDisplayed()), true);
		System.out.println("ordere n Delivery Details  is displayed");
//		Payment options
	    Assert.assertEquals((paymentOptions.isDisplayed()), true);
		System.out.println("paymentOptions is displayed");
	
	}
	
	public void Deliverydetailspageverification(WebDriver driver) {
//		//view details button
//		Assert.assertEquals((.isDisplayed()), true);
//		System.out.println("paymentOptions is displayed");
		
		//Glow Your Memory Personalized Lamp quantity and price
		Assert.assertEquals((productPriceonOrdernDeliveryDetailPage.isDisplayed()), true);
		System.out.println("productPriceonOrdernDeliveryDetailPage is displayed");
		Assert.assertEquals((ProductqtyonDeliveryDetailPage.isDisplayed()), true);
		System.out.println("ProductqtyonDeliveryDetailPage is displayed");
		//Your photo product
		Assert.assertEquals((yourPhotoOnProduct.isDisplayed()), true);
		System.out.println("yourPhotoOnProduct is displayed");
		//add-on with quantity and price
		Assert.assertEquals((addonPricewithimgonOrdernDeliveryDetailPage.isDisplayed()), true);
		System.out.println("addonPricewithimgonOrdernDeliveryDetailPage is displayed");
		
		//To be delivered between Delivery date and time
		Assert.assertEquals((DeliveryDate.isDisplayed()), true);
		System.out.println("DeliveryDate is displayed");
		Assert.assertEquals((deliverytime.isDisplayed()), true);
		System.out.println("deliverytime is displayed");
		
		//Change button
		Assert.assertEquals((changebtn.isDisplayed()), true);
		System.out.println("changebtn is displayed");
		
		//add-on
		Assert.assertEquals((addonwithimg.isDisplayed()), true);
		System.out.println("addonwithimg is displayed");
		
		//Add Delivery address
		Assert.assertEquals((Add_Delivery_Address.isDisplayed()), true);
		System.out.println("Add_Delivery_Address is displayed");
		
		//Free Message card
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", FreeMessagecard);
		Assert.assertEquals((FreeMessagecard.isDisplayed()), true);
		System.out.println("FreeMessagecard is displayed");
		
		//senders details 
		Assert.assertEquals((SendersDetailsheading.isDisplayed()), true);
		System.out.println("SendersDetailsheading is displayed");
		Assert.assertEquals((senderName.isDisplayed()), true);
		System.out.println("senderName is displayed");
		Assert.assertEquals((senderEmailId.isDisplayed()), true);
		System.out.println("senderEmailId is displayed");
		Assert.assertEquals((senderPhone.isDisplayed()), true);
		System.out.println("senderPhone is displayed");
		
		//Proceed To checkout button
//		Assert.assertEquals((Iagreetickbox.isDisplayed()), true);
//		System.out.println("Iagreetickbox is displayed");
		Assert.assertEquals((proceedtocheckout.isDisplayed()), true);
		System.out.println("proceedtocheckout is displayed");
	}
	
	public void Deliverydetailspageverificationwithoutaddon(WebDriver driver) {

		//prouct quantity and price
		Assert.assertEquals((productPriceonOrdernDeliveryDetailPage.isDisplayed()), true);
		System.out.println("productPriceonOrdernDeliveryDetailPage is displayed");
		Assert.assertEquals((ProductqtyonDeliveryDetailPage.isDisplayed()), true);
		System.out.println("ProductqtyonDeliveryDetailPage is displayed");
		//Your photo product
		Assert.assertEquals((yourPhotoOnProduct.isDisplayed()), true);
		System.out.println("yourPhotoOnProduct is displayed");
		
		
		//To be delivered between Delivery date and time
		Assert.assertEquals((DeliveryDate.isDisplayed()), true);
		System.out.println("DeliveryDate is displayed");
		Assert.assertEquals((deliverytime.isDisplayed()), true);
		System.out.println("deliverytime is displayed");
		
		//Change button
		Assert.assertEquals((changebtn.isDisplayed()), true);
		System.out.println("changebtn is displayed");
		
		
		//Add Delivery address
		Assert.assertEquals((Add_Delivery_Address.isDisplayed()), true);
		System.out.println("Add_Delivery_Address is displayed");
		
		//Free Message card
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", FreeMessagecard);
		Assert.assertEquals((FreeMessagecard.isDisplayed()), true);
		System.out.println("FreeMessagecard is displayed");
		
		//senders details 
		Assert.assertEquals((SendersDetailsheading.isDisplayed()), true);
		System.out.println("SendersDetailsheading is displayed");
		Assert.assertEquals((senderName.isDisplayed()), true);
		System.out.println("senderName is displayed");
		Assert.assertEquals((senderEmailId.isDisplayed()), true);
		System.out.println("senderEmailId is displayed");
		Assert.assertEquals((senderPhone.isDisplayed()), true);
		System.out.println("senderPhone is displayed");
		
		//Proceed To checkout button
//		Assert.assertEquals((Iagreetickbox.isDisplayed()), true);
//		System.out.println("Iagreetickbox is displayed");
		Assert.assertEquals((proceedtocheckout.isDisplayed()), true);
		System.out.println("proceedtocheckout is displayed");
	}
	
	public static String RandomString()
	{
		int length = 5;
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		// System.out.println(generatedString);
		return generatedString;
	}
	
	public boolean ReturnWelcomeCondition()
	{
		boolean breturn=false;
		
		try
		{
			Welcome.isDisplayed();
			breturn = true;
		}
		catch(Exception ex)
		{	
			breturn = false;
		}	
		return breturn;
	}	
	         
}
