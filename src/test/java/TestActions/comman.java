package TestActions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

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
	public void url(String path) {
		driver.navigate().to(path);
		
	}
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
