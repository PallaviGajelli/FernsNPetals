package fernsNPetals.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import fernsNPetals.base.TestBase;

public class BonsaiPlants extends TestBase{
	
	@FindBy(xpath = "//*[@id='plantsmenu']/div/section[1]/ul/li[3]/a")
	WebElement BonsaiPlants;
	@FindBy(xpath = "//img[@title='Marvellous Bonsai Plant']")
	public
	WebElement Marvellous_Bonsai_Plant;
	
	
	
	
	public void click(String Element) {
		switch (Element) {
		case "Marvellous_Bonsai_Plant":Marvellous_Bonsai_Plant.click();
			break;
		case "BonsaiPlants":BonsaiPlants.click();
		   break;
		
	}

}
	
	
}