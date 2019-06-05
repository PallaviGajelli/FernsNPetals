package fernsNPetals.other;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


//@Listeners(fernsNPetals.extentReportListener.ExtentReporterNG.class)
public class loggerTest {
	
	WebDriver driver;
	static ExtentTest logger;//log in to report
    static ExtentReports report;//set sys info
	Logger log = Logger.getLogger(loggerTest.class);
	
	
	@BeforeMethod
	public void setup(){
		log.info("****************************** Starting test cases execution  *****************************************");

		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Selenium\\chromedriver_win32\\chromedriver.exe");	
		driver = new ChromeDriver(); 
		log.info("launching chrome broswer");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.fnp.com/");
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
	}
	
	
	@Test(priority=1)
	public void freeCrmTitleTest(){
		log.info("****************************** starting test case *****************************************");
		log.info("******************************FnP Test *****************************************");
		String title = driver.getTitle();
		System.out.println(title);
		log.info("FnP page title is--->"+title);
		Assert.assertEquals(title,"Flower Delivery Online | India's No.1 Florist - Ferns N Petals");
		
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** Fnp TitleTest *****************************************");

	}
	
	@Test(priority=2)
	public void freemCRMLogoTest(){
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** FnP LogoTest *****************************************");

		boolean b = driver.findElement(By.xpath("//*[@id=\"fnplogo\"]/a/img")).isDisplayed();
		Assert.assertTrue(b);
		
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** FnP LogoTest *****************************************");

	}
	
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
		log.info("****************************** Browser is closed *****************************************");

		
	}
	
	
	

}
