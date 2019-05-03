package fernsNPetals.pages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import fernsNPetals.base.TestBase;

public class CheckoutPage extends TestBase {
	
	@FindBy(xpath = "//*[@id=\"checkout-container\"]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div")
	WebElement deleteProductatcheckout;
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div")
    WebElement deleteProductalert;//Are you sure you want to delete this item ?YesNo
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div/div[2]/span[1]")
    WebElement deleteProductalertYesBtn;
    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div/div[2]/span[2]")
    WebElement deleteProductalertNoBtn;
    @FindBy(xpath = "//div[@class='empty-msg']")
    WebElement cartisEmptyMsg;//shopping_cartYour cart is empty. But it doesn't have to be
    @FindBy(xpath = "//span[text()='START SHOPPING NOW']")
    WebElement StartShoppingNowBtn;
    
	
	@FindBy(xpath = "//*[@id=\"checkout-container\"]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/span/span[1]/span")
	WebElement MarvellousBonsaiPlantPrice;//15.11
	@FindBy(xpath = "//*[@id=\"checkout-container\"]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/span/span[2]")
	WebElement MarvellousBonsaiPlantqty;//x1
	@FindBy(xpath = "//*[@id=\"checkout-container\"]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[2]")
	public WebElement DeliveryDate;//Fri, 3rd May, 2019
	@FindBy(xpath = "//*[@id=\"checkout-container\"]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[3]/div[1]/div[2]")
	public WebElement deliverytime;//09:00 - 21:00 Hrs
	@FindBy(xpath = "//*[@id=\"checkout-container\"]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div/div[3]/div[2]/div")
	public WebElement changebtn;
	@FindBy(xpath = "//*[@id=\"checkout-container\"]/div[3]/div/div/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div[1]")
	public WebElement addon;
	@FindBy(xpath = "//*[@id=\"saved-address--1\"]/ul[1]/li/span/span")
	public static WebElement addnewaddress;
	@FindBy(xpath = "//h5[text()='Free Message card']")
	public WebElement FreeMessagecard;
	@FindBy(xpath = "//span[@class='sender-info-title']")
	public WebElement SendersDetailsheading;
	@FindBy(xpath = "//*[@id=\"senderName\"]")
	public WebElement senderName;
	@FindBy(xpath = "//*[@id=\"senderEmailId\"]")
	public WebElement senderEmailId;
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
	@FindBy(xpath = "//span[text()='Select Message on Card']")
	public WebElement SelectMessageonCard;
	@FindBy(xpath = "//*[@id=\"messagecard-dialog\"]/div[2]/div/div[1]/div/div[2]/div[2]/div/div/div/div/ul/li[1]")
	public WebElement SelectfirstMessage;
	@FindBy(xpath = "//div[text()='Select Message']")
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
	WebElement pwd;
	@FindBy(xpath = "//*[@id=\"submit-check\"]/span[1]/span[1]")
	WebElement continuebutton;
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
	WebElement SelectedDate;
	String dd;
	
	public void selectPrefixAsMs(WebDriver driver) throws InterruptedException {
		Prefix.click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",CheckoutPage.PrefixMs);
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
		case "editsavedAddBtn":
			editsavedAddBtn.click();
			Thread.sleep(1000);
			break;
		case "Prefix":
			Prefix.click();
			Thread.sleep(1000);
			break;
		case "PrefixMs":
			JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].click();", PrefixMs);
			//PrefixMs.click();
			Thread.sleep(1000);
			break;
		case "addnewaddress":
			addnewaddress.click();
			Thread.sleep(1000);
			break;
		case "StartShoppingNowBtn":
			StartShoppingNowBtn.click();
			Thread.sleep(1000);
			break;
		case "deleteProductalertYesBtn":
			deleteProductalertYesBtn.click();
			Thread.sleep(1000);
			break;
		case "deleteProductalertNoBtn":
			deleteProductalertNoBtn.click();
			Thread.sleep(1000);
			break;
		case "deleteProductatcheckout":
			deleteProductatcheckout.click();
			Thread.sleep(1000);
			break;
		case "changebtn":
			changebtn.click();
			Thread.sleep(1000);
			break;
		case "continuebutton":
			continuebutton.click();
			Thread.sleep(1000);
			break;
		case "submitaddressbutton":
			submitaddressbutton.click();
			Thread.sleep(2000);
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
		

		case "loginEmailID":
			boolean a = loginEmailID.isDisplayed();
			Assert.assertEquals(a, true);
			System.out.println("loginEmailID is displayed");
			break;
		case "continuebutton":
			boolean a1 = continuebutton.isDisplayed();
			Assert.assertEquals(a1, true);
			System.out.println("continuebutton is displayed");
			break;
		case "facebooklogin":
			boolean a2 = facebooklogin.isDisplayed();
			Assert.assertEquals(a2, true);
			System.out.println("facebook login is displayed");
			break;
		case "googlelogin":
			boolean a3 = googlelogin.isDisplayed();
			Assert.assertEquals(a3, true);
			System.out.println("google login is displayed");
			break;
		case "orderenDeliveryDetails":
			boolean a4 = orderenDeliveryDetails.isDisplayed();
			Assert.assertEquals(a4, true);
			System.out.println("Header 'Marvellous Bonsai Plant' is displayed");
			break;
		case "paymentOptions":
			boolean a5 = paymentOptions.isDisplayed();
			Assert.assertEquals(a5, true);
			System.out.println("Header 'Marvellous Bonsai Plant' is displayed");
			break;
		case "orderenDeliveryDetailsPage":
			boolean a6 = orderenDeliveryDetailsPage.isDisplayed();
			Assert.assertEquals(a6, true);
			System.out.println("ordere n Delivery Details Page is displayed");
			break;
		case "errorLogin"://this is for wrong password
			boolean a7 = errorLogin.isDisplayed();
			String a8=errorLogin.getText();
			Assert.assertEquals(a7, true);
			System.out.println("Enter correct email or password. is displayed is :"+a8);
			break;
		case "MarvellousBonsaiPlantPriceandQty":
			boolean a9 = MarvellousBonsaiPlantPrice.isDisplayed();
			Assert.assertEquals(a9, true);
			System.out.println("Marvellous Bonsai Plant Price is displayed in ordere n Delivery Details Page");
			
			boolean a20 = MarvellousBonsaiPlantqty.isDisplayed();
			Assert.assertEquals(a20, true);
			System.out.println("Marvellous Bonsai Plant qty is displayed in ordere n Delivery Details Page");
			break;
		case "Deliverydateandtime":
			boolean a10 = DeliveryDate.isDisplayed();
			Assert.assertEquals(a10, true);
			System.out.println("Delivery Date is displayed in ordere n Delivery Details Page");
			
			boolean a19 = deliverytime.isDisplayed();
			Assert.assertEquals(a19, true);
			System.out.println("delivery time is displayed in ordere n Delivery Details Page");
			break;
		case "changebtn":
			boolean a11 = changebtn.isDisplayed();
			Assert.assertEquals(a11, true);
			System.out.println("changebtn is displayed in ordere n Delivery Details Page");
			break;
		case "addon":
			boolean a12 = addon.isDisplayed();
			Assert.assertEquals(a12, true);
			System.out.println("addon is displayed in ordere n Delivery Details Page");
			break;
		case "addnewaddress":
			boolean a13 = addnewaddress.isDisplayed();
			Assert.assertEquals(a13, true);
			System.out.println("add new address is displayed in ordere n Delivery Details Page");
			break;
		case "FreeMessagecard":
			boolean a14 = FreeMessagecard.isDisplayed();
			Assert.assertEquals(a14, true);
			System.out.println("FreeMessagecard is displayed in ordere n Delivery Details Page");
			break;
		case "sendersdetails":
			boolean a15 = SendersDetailsheading.isDisplayed();
			Assert.assertEquals(a15, true);
			System.out.println("Senders Details heading is displayed in ordere n Delivery Details Page");
			
			boolean a16 = senderName.isDisplayed();
			Assert.assertEquals(a16, true);
			System.out.println("senderName is displayed in ordere n Delivery Details Page");
			
			boolean a17 = senderEmailId.isDisplayed();
			Assert.assertEquals(a17, true);
			System.out.println("senderEmailId is displayed in ordere n Delivery Details Page");
			
			boolean a18 = senderPhone.isDisplayed();
			Assert.assertEquals(a18, true);
			System.out.println("senderPhone is displayed in ordere n Delivery Details Page");
			break;
		case "selectDeliveryDate":
			boolean a21 = selectDeliveryDate.isDisplayed();
			Assert.assertEquals(a21, true);
			System.out.println("select Delivery Date is displayed on clicking changebtn");
			break;
		case "DeliveryDate":
			boolean a22 = DeliveryDate.isDisplayed();
			Assert.assertEquals(a22, true);
			System.out.println("Delivery Date is displayed in ordere n Delivery Details Page");
			String a23= DeliveryDate.getText();
			try {
				//String[] formats = {"EEE, d'st' MMM, yyyy","EEE, d'nd' MMM, yyyy","EEE, d'rd' MMM, yyyy","EEE, d'th' MMM, yyyy"};
				DateFormat format = new SimpleDateFormat("EEE, d'th' MMM, yyyy", Locale.ENGLISH);
				Date date = format.parse(a23);
				System.out.println(date); // Sat Jan 02 00:00:00 GMT 2010
				
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "deleteProductalert":
			boolean a24 = deleteProductalert.isDisplayed();
			String a25=deleteProductalert.getText();
			Assert.assertEquals(a24, true);
			Assert.assertEquals(a25,"Are you sure you want to delete this item ?\nYESNO");
			System.out.println("select Delivery Date is displayed on clicking changebtn :"+a25);
			break; 
		case "StartShoppingNowBtn":
			boolean a26 = StartShoppingNowBtn.isDisplayed();
			Assert.assertEquals(a26, true);
			System.out.println("Start Shopping Now Btn is displayed in ordere n Delivery Details Page");
		case "cartisEmptyMsg":
			boolean a27 = cartisEmptyMsg.isDisplayed();
			Assert.assertEquals(a27, true);
			System.out.println("cart is Empty Msg is displayed in ordere n Delivery Details Page");
		case "EmptyAddressAlertMsg":
		    boolean a29= nameisrequire.isDisplayed();
			String a32 = nameisrequire.getText();
			Assert.assertEquals(a29, true);
			Assert.assertEquals(a32, "* Name is required");
			System.out.println("name is require is displayed :"+a32);
			
			boolean a28 = addisrequire.isDisplayed();
			String a31 = addisrequire.getText();
			Assert.assertEquals(a28, true);
			Assert.assertEquals(a31, "* Recipient's address is required");
			System.out.println("add is require is displayed :"+a31);
		
			boolean a30 = mobileisreqire.isDisplayed();
			Assert.assertEquals(a30, true);
			String a33 = mobileisreqire.getText();
			Assert.assertEquals(a33, "* Recipient’s mobile number is required.");
	    	System.out.println("mobile is reqire is displayed :"+a33);
			break;
            
		    case "invalidrMobile":
	        boolean a34= invalidrMobile.isDisplayed();
			String a35 = invalidrMobile.getText();
			Assert.assertEquals(a34, true);
			Assert.assertEquals(a35, "* Recipient’s mobile number is invalid.");
			System.out.println("invalid rmobile is displayed :"+a35);
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
			boolean a42 = savedAddselected.isDisplayed();
			Assert.assertEquals(a42, true);
			System.out.println("saved Add selected is displayed in ordere n Delivery Details Page");
			break;
		    case "editsavedAddpage":
			boolean a43 = editsavedAddpage.isDisplayed();
			Assert.assertEquals(a43, true);
			System.out.println("edit saved Add page is displayed in ordere n Delivery Details Page");
			break;
		    case "checklogin":
				boolean a44 = checklogin.isDisplayed();
				Assert.assertEquals(a44, true);
				System.out.println("wrong email id alert is displayed");
				break;
			
		
		}
	}
		
	
	
	
	
}
