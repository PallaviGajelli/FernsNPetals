package fernsNPetals.stepDefinations;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;



public class stepdeinationsMyAccountPage{
	WebDriver driver;
	
	@Given("^user is already on My account Page$")
	public void user_is_already_on_My_account_Page()  {
		
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--disable-notifications");
		 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sanjaygajelli\\Downloads\\chromedriver_win32\\chromedriver.exe");	
		driver = new ChromeDriver(options); 
		driver.get("https://www.fnp.com/account/my-account");
	    
	}
	@Then("^user enters usermailID \"([^\"]*)\"$")
	public void user_enters_usermailID(String MailID) throws InterruptedException  {
		 driver.findElement(By.xpath("//*[@id=\"email-input\"]")).sendKeys(MailID);
		
		Thread.sleep(1000);
		
	}

	@Then("^user enters password \"([^\"]*)\"$")
	public void user_enters_password(String pwd) throws InterruptedException  {
		 driver.findElement(By.xpath("//*[@id=\"password-input\"]")).sendKeys(pwd);
		 Thread.sleep(1000);
	    
	}

	

	@Then("^user clicks on continue button$")
	public void user_clicks_on_continue_button() throws InterruptedException  {
		 driver.findElement(By.xpath("//*[@id=\"continue\"]/span[1]")).click();;
		 Thread.sleep(1000);
	}   

	@Then("^my account details are shown$")
	public void my_account_details_are_shown()  {
	WebElement myaccountheader=	driver.findElement(By.xpath("//*[@id=\"myaccountlink\"]/h4"));
	String header=myaccountheader.getText();
	Assert.assertEquals(header, "My Account"); 
	}

	@Then("^Close the browser$")
	public void close_the_browser()  {
		driver.close();
	    
	}


}


