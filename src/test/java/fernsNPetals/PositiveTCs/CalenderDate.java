package fernsNPetals.PositiveTCs;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import fernsNPetals.base.TestBase;
import fernsNPetals.pages.GiftPage;
//import fernsNPetals.pages.HomePage;
//this tc was working but now not.
public class CalenderDate extends TestBase  {
	GiftPage GiftPage;
	
	Logger log = Logger.getLogger(CalenderDate.class);
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization("https://www.fnp.com/gift/truffle-cake?pos=1");
		Thread.sleep(2000);
		}
	
	@Test
	public void selectdate() throws InterruptedException  {
		
		log.info("****************************** starting test case *****************************************");
		log.info("entering application URL"); 
		log.info("****************************** SelectCalenderDate *****************************************");
		
	    GiftPage =new GiftPage();
		GiftPage =PageFactory.initElements(driver, GiftPage.class);
		
		GiftPage.sendkeys("searchaddressbox", "pune");
		GiftPage.clickfirstAddressintheList(driver);
	    GiftPage.click("selectDate");
	  
	    Date date=new Date();
		SimpleDateFormat dateF= new SimpleDateFormat("dd/MMMM/yyyy");
		Calendar cal =Calendar.getInstance();
		
		cal.add(Calendar.DATE, 3);
		String d= dateF.format(cal.getTime());
		  
		String Ad[]=d.split("/");
		String dd=Ad[0];
		
		WebElement after2days= driver.findElement(By.xpath("//a[text()='"+dd+"']"));
		after2days.click();
		
		log.debug("this is debug message");
		log.fatal("hey this is just fatal error message");
		log.warn("Hey this just a warning message");
		log.info("this is just to give info");
	
	
	
		
		
		driver.close();
		
		
		
		

		
	
		
	}
	
	
	
}
