package fernsNPetals.pages;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import fernsNPetals.base.TestBase;

public class GiftPage extends TestBase{
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"destlookup\"]")
	public
	WebElement searchaddressbox;  
    @FindBy(xpath="//span[text()='Solapu']")
    WebElement firstdynamicaddress;
    
   
   
    
    @FindBy(xpath="//*[@id=\"addToCart\"]") 
    WebElement addtocartbutton;
    @FindBy(xpath="//*[@id=\"buynow\"]")    
    WebElement buynowbutton;
    @FindBy(xpath="//*[@id=\"FNP_ADDON_ROOT_INDIA\"]/ul/li[5]/label/div/span")
    WebElement addoncheckbox;
    @FindBy(xpath="//*[@id='addon']/form/div[3]/button")          
    WebElement addonbutton;
    
    @FindBy(id="selecte_date")WebElement selectDate;
    @FindBy(xpath="//*[@id=\"deliverydatepicker\"]/div/div/a[2]")WebElement nextmonth;
    @FindBy(xpath="//*[@id=\"deliverydatepicker\"]/div/div/a[1]/span")WebElement previousmonth;
 
    
    
    @FindBy(xpath="//*[@id=\"check-login\"]/div/div/div/div/span")  //validation
    WebElement checklogin;
    @FindBy(xpath="//*[@id=\"sidebar\"]")                         
    WebElement deliveryDetails;
    
    @FindBy(xpath="//*[@id=\"loginformEmailId\"]")
	public                
    WebElement loginEmailID;
    @FindBy(xpath="//*[@id=\"loginPassword\"]")                  
    WebElement pwd;
    @FindBy(xpath="//*[@id=\"submit-check\"]/span[1]/span[1]")    
    WebElement continuebutton;
   
  
    @FindBy(xpath="//*[@id=\"saved-address--1\"]/h5")
	public                       
    WebElement Add_Delivery_Address;
    @FindBy(xpath="//*[@id=\"rNameId-1\"]")
	public                       
    WebElement rname;
    @FindBy(xpath="//*[@id=\"rMobileId-1\"]")                     
    WebElement rmobileno;
    @FindBy(xpath="//*[@id=\"rAddressId-1\"]")                    
    WebElement raddress;
   
    // @FindBy(xpath="//*[@id=\"remailId-1\"]")  
    //WebElement rEmailid;//optional
   
    @FindBy(xpath="//*[@id=\"datetimelink\"]")                    
    WebElement deliverydate;
    @FindBy(xpath="//*[@id=\"save-address-btn-1\"]/span[1]/span[1]")
    WebElement submitaddressbutton;
    @FindBy (css="input.contains('hello')")
    WebElement Iagreetickbox;
   // @FindBy(xpath="//*[@id=\"checkout-container\"]/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div/label/span[1]/span[1]/input")
    //WebElement Iagreetickbox;
    @FindBy(xpath="//*[@id=\"proceed-to-checkout\"]/span[1]/span[1]")
    WebElement submitorderbutton;
    
    @FindBy(xpath="//*[@id=\"dateAlert\"]")
    WebElement deliverydatealert;
    @FindBy(xpath="//*[@id=\"pincodeAlert\"]") // Select Delivery Area to continue 
    WebElement pincodealert;
    @FindBy(xpath="//*[@id=\"addressform-1\"]/div[1]/div[2]/span") //* Name is required
    WebElement nameisrequire;
    @FindBy(xpath="//*[@id=\"addressform-1\"]/div[3]/span")  //* Recipient's address is required     
    WebElement addisrequire;
    @FindBy(xpath="//*[@id=\"addressform-1\"]/div[8]/div/span") // * Recipient’s mobile number is required. 
    WebElement mobileisreqire;
    
    //@FindBy(className="delete-address")
    @FindBy(xpath="//*[@id=\"saved-address--1\"]/ul[2]/li/div[2]/div/p[2]")
    WebElement deleteaddress;
    @FindBy(xpath="/html/body/div[5]/div[2]/div/div/div[2]/span[1]")
    WebElement yesdelete;
    
    public void clickfirstAddressintheList(WebDriver driver) throws InterruptedException {
    	List<WebElement> list= driver.findElements(By.xpath("//div[@class='pac-item']"));
    	list.get(0).click();
    	Thread.sleep(4000);
    }
    
    
    public void click(String buttonName) throws InterruptedException {
    	switch (buttonName) {
    	case "nextmonth":nextmonth.click();
              break;
    	case "previousmonth":previousmonth.click();
              break;
    	case "selectDate":selectDate.click();
    	Thread.sleep(2000);
	          break;
    	case "deleteaddress":deleteaddress.click();
    	Thread.sleep(2000);
	          break;
    	case "yesdelete":yesdelete.click();
    	Thread.sleep(3000);
	          break;
    	case "firstdynamicaddress":firstdynamicaddress.click();
    	Thread.sleep(3000);
	          break;
		case "addtocartbutton":addtocartbutton.click();
		Thread.sleep(3000);
		      break;			
		case "buynowbutton":buynowbutton.click();
		Thread.sleep(3000);
		      break;
		case "addoncheckbox":addoncheckbox.click();
		Thread.sleep(3000);
	          break;
		case "addonbutton":addonbutton.click();
    	Thread.sleep(3000);
	          break;
        case "continuebutton":continuebutton.click();  
        Thread.sleep(3000);
		      break;
        case "submitaddressbutton":submitaddressbutton.click();
        Thread.sleep(3000);
		      break;
        case "Iagreetickbox":Iagreetickbox.click();
        Thread.sleep(3000);
		      break;
        case "submitorderbutton":submitorderbutton.click();
        Thread.sleep(3000);
			  break;
		default : System.out.print("Button not found");
		Thread.sleep(3000);
			  break;
		}    
    }
    
    public void sendkeys(String textbox,String keysToSend) throws InterruptedException {
    	switch (textbox) {
    	
		case "searchaddressbox":searchaddressbox.sendKeys(keysToSend);
		Thread.sleep(3000);
		      break;			
		case "loginEmailID":loginEmailID.sendKeys(keysToSend);
		Thread.sleep(2000);
		      break;
		case "pwd":pwd.sendKeys(keysToSend);
		Thread.sleep(1000);
	          break;
        case "rname":rname.sendKeys(keysToSend); 
        Thread.sleep(1000);
		      break;
        case "rmobileno":rmobileno.sendKeys(keysToSend);
        Thread.sleep(1000);
		      break;
        case "raddress":raddress.sendKeys(keysToSend);
        Thread.sleep(1000);
		      break;
        
		default : System.out.print("texbox not found to enter keysToSend");
		Thread.sleep(1000);
			  break;
		}    
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
			 
    	
	
    	
    }}
    
    public void filladdressToDelivery(String name,String address,String mobileno ) throws InterruptedException {
    	
		
    rname.sendKeys(name);
    raddress.sendKeys(address);
   	rmobileno.sendKeys(mobileno);
   	Thread.sleep(1000);
   	submitaddressbutton.click();
   	
   	
   }
    
    public void filladdToDelivery(WebDriver driver,String address,String mobileno,String name ) {
		
		  //WebDriver driver;
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
   public void scrooldownTo(WebDriver driver,String element) {
   	     JavascriptExecutor js = (JavascriptExecutor) driver;
   	     switch (element) {
   	     case"Iagreetickbox":
   	    	//JavascriptExecutor js = (JavascriptExecutor) driver;
   	    	 js.executeScript("arguments[0].scrollIntoView();", Iagreetickbox);
   	    	 break;
   	     case"addtocartbutton":
   	    	//JavascriptExecutor js1 = (JavascriptExecutor) driver;
   	    	 js.executeScript("arguments[0].scrollIntoView();", addtocartbutton);
   	   	     break;
   	   	 case"buynowbutton":
   	   	     //JavascriptExecutor js2 = (JavascriptExecutor) driver;
   	   		 js.executeScript("arguments[0].scrollIntoView();", buynowbutton);
  	    	 break;
   	     case"rname":
   	    	//JavascriptExecutor js3 = (JavascriptExecutor) driver;
   	    	 js.executeScript("arguments[0].scrollIntoView();", rname);
   	         break;
   	     case"submitaddressbutton":
 	    	//JavascriptExecutor js3 = (JavascriptExecutor) driver;
 	    	 js.executeScript("arguments[0].scrollIntoView();", submitaddressbutton);
 	         break;  
   	  case"raddress":
	    	//JavascriptExecutor js3 = (JavascriptExecutor) driver;
	    	 js.executeScript("arguments[0].scrollIntoView();", raddress);
	    	 break;
 	        
   	  default : System.out.print(" not able to scroll down to element"+element);
		break;
   	     }
   	 
   }
   
  
   
}

