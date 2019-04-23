package fernsNPetals.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import fernsNPetals.base.TestBase;

public class MyAccountPage extends TestBase {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"email-input\"]")
	public                
    WebElement accountlogin;
    @FindBy(xpath="//*[@id=\"password-input\"]")                  
    WebElement accountpwd;
    @FindBy(xpath="//*[@id=\"continue\"]/span[1]")    
    WebElement continuebutton;
    @FindBy(xpath="//*[@id=\"myaccountlink\"]/h4")    
    WebElement myaccountheader;
    
    public void loginMyAccount(String MailID,String pwd) throws InterruptedException {
    	accountlogin.sendKeys(MailID);
    	Thread.sleep(1000);
    	continuebutton.click();
    	Thread.sleep(1000);
    	accountpwd.sendKeys(pwd);
    	Thread.sleep(1000);
    	continuebutton.click();
    	assertEquals(myaccountheader, "My Account");
    }
}

