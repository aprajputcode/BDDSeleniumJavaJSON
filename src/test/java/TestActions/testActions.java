package TestActions;


import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import junit.framework.Assert;
import stepDefinaction.baseclass;

public class testActions extends baseclass {

	public void url(String path) {
		driver.navigate().to(path);
		
	}
	public void buttonClick(String path,String type) {
		if(type.equalsIgnoreCase("xpath"))
		{
		driver.findElement(By.xpath(path)).click();
		}
		else if (type.equalsIgnoreCase("css"))
		{
		driver.findElement(By.cssSelector(path)).click();			
		}
	}
	
	
	public void verify(String path,String type) {
		WebElement display=(WebElement) driver.findElements(By.xpath(path));
		Assert.assertTrue(display.isDisplayed());
		
	}
	@After
	public void closeDriver() {
		
		driver.quit();
		
	}
}
