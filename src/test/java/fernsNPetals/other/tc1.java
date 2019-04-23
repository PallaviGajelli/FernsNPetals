package fernsNPetals.other;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.testng.annotations.Test;

import fernsNPetals.pages.GiftPage;

public class tc1 {
	@Test
	  public void test1() {
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--disable-notifications");
		  String baseUrl = "https://www.fnp.com/gift/truffle-cake?pos=1";
		  System.setProperty("webdriver.chrome.driver",
		  "C:\\Users\\sanjaygajelli\\Downloads\\chromedriver_win32\\chromedriver.exe");
		  WebDriver chrome = new ChromeDriver(options); 
		  chrome .get(baseUrl);
		  WebElement searchbox= chrome.findElement(By.xpath("//*[@id=\"destlookup\"]"));
		  searchbox.sendKeys("Pune");
		  try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  List<WebElement> a = chrome.findElements(By.xpath("//div[@class='pac-item']"));
		  a.get(0).click();
		  
		  //searchbox.sendKeys(Keys.ENTER);
		  try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  WebElement selectDate=chrome.findElement(By.id("selecte_date"));
		  selectDate.click();
		  Date date= new Date();//date
		  SimpleDateFormat dateF= new SimpleDateFormat("dd-MM-yyyy");//format
		  String todaysDate=dateF.format(date);//todaysdate in this format
		  System.out.println("Todays date is : "+todaysDate);
		  
		  Calendar cal=Calendar.getInstance();//callender
		  cal.add(Calendar.DATE, 2);
		  String after2days= dateF.format(cal.getTime());//day after tomorrow 
		  System.out.println("Day after tomorrow is :"+after2days);
		  
		  String a1[]=after2days.split("-");
		  String dd = a1[0];
		  

		  WebElement dayAfterTom= chrome.findElement(By.xpath("//a[text()='"+dd+"']"));
			
		  dayAfterTom.click();
		  chrome.close();
		  
		  
		  
	
	  }

}