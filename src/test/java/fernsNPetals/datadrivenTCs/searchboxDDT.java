package fernsNPetals.datadrivenTCs;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fernsNPetals.base.TestBase;
import fernsNPetals.pages.GiftPage;
import fernsNPetals.pages.HomePage;
import fernsNPetals.util.TestUtil;

public class searchboxDDT extends TestBase {
	
	HomePage HomePage;
	GiftPage GiftPage;
	TestUtil TestUtil;
	
	public searchboxDDT() {
		super();
	}
	
	@BeforeTest
	public void setUp() throws InterruptedException 
	{
		
	initialization();
	HomePage = new HomePage();
	GiftPage = new GiftPage();
	TestUtil = new TestUtil(); 
    HomePage=PageFactory.initElements(driver, HomePage.getClass());
    GiftPage=PageFactory.initElements(driver, GiftPage.getClass());
	}   
    
	@Test (dataProvider="testdata")
	public void searchbox(String product) 
	{
  
    	HomePage.searchbox.sendKeys(product);
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(product);
		HomePage.searchbox.clear();
	
	}
	
	@DataProvider
	public Object[][] testdata(){
	  TestUtil=PageFactory.initElements(driver, TestUtil.getClass());
	  
	  Object data[][] = fernsNPetals.util.TestUtil.getTestData("searchbox");
		return data;
	}

}
