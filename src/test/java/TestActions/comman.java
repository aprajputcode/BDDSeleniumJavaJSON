package TestActions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class comman {
	
	
	//browser setup
	public static WebDriver driver;
	public static WebDriver driversetup(String browser)
	{		
			switch(browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
				
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				break;
				}
			return driver;
	}
	
	
	//Screenshot Method
	public static void screenshot(String methodname) throws IOException {
		TakesScreenshot sc=((TakesScreenshot)driver);
		File DestFile=new File("./Screeenshot\\"+methodname+".png");
		File SrcFile=sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SrcFile, DestFile);
	}
	
	//clickButton
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
	
	
	//url hitting method
	public void url(String path) {
		driver.navigate().to(path);
		
	}
	
	//sendkeys method
	public void sendkeys(String path,String type,String value)
	{
		if(type.equals("xpath"))
		{
			WebElement username=driver.findElement(By.xpath(path));
			username.sendKeys(value);
		}
		else if(type.equals("css"))
		{
			driver.findElement(By.className(path)).sendKeys(value);
		}
	}
	
	//verify page title
	public void pagetitle(String value)
	{
		
			String username=driver.getTitle();
			Assert.assertEquals(value, username);
	}
	
	
	//reading data form json file and passing into the step definaction
	public ArrayList<String> readfile(String name)
	{
		ArrayList<String> values=new ArrayList<String>();
		try {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("./src/test/java/pageObject/xpath.json"));
		JSONObject jsonObject = (JSONObject) obj;
		JSONObject jsonChildObject = (JSONObject)jsonObject.get("login");
		JSONObject username = (JSONObject)jsonChildObject.get(name);
		String path = (String)username.get("path");
		String type = (String)username.get("type");
		values.add(path);
		values.add(type);
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		catch(ParseException e)
		{
			System.out.println(e);
		}
		return values;
	}

}
