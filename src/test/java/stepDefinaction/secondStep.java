package stepDefinaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class secondStep extends baseclass {

	@Before
	public void loginToDriver() throws IOException {
		
		logger=Logger.getLogger("PrototypeForBDDToJavaSelenium");
		PropertyConfigurator.configure("log4j.properties");
		
		config=new Properties();
		FileInputStream configfile=new FileInputStream("config.properties");
		config.load(configfile);
		logger.info("Lonch Browser");
		driver=comman.driversetup(config.getProperty("browser"));
		
		}
	
	@Given("user should be hit the page {string}")
	public void user_should_be_hit_the_page(String urls) {
		logger.info("Lonch Url");
	    comman.url(urls);
	}

	@When("Text {string} on name of textbox is {string}")
	public void text_on_name_of_textbox_is(String value, String name) 
	{
		logger.info("value of Snedkey is : "+value);
		ArrayList<String> values=comman.readfile(name);
		comman.sendkeys(values.get(0),values.get(1), value);
	}

	@Then("click on {string}")
	public void click_on(String name) {
		ArrayList<String> values=comman.readfile(name);
	    comman.buttonClick(values.get(0),values.get(1));
	    logger.info("Click the button");
	}
	
	@Then("user should on Dashboard and title is {string}")
	public void user_should_on_and_title_is(String value) {
	    comman.pagetitle(value);
	    logger.info("PageTitle Verifyed");
	}
	
	
	
	
	@After
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed()){
	        String screenshotName = scenario.getName().replaceAll("","_");
	        TakesScreenshot sc=((TakesScreenshot)driver);
	        Date d = new Date();
	        String FileName = d.toString().replace(":", "_").replace(" ", "_")+screenshotName;
			File DestFile=new File("./Screeenshot\\"+FileName+".jpg");
			File SrcFile=sc.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.close();
	}

}
