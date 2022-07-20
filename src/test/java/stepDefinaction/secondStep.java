package stepDefinaction;

import java.util.ArrayList;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class secondStep extends baseclass {

	@Before
	public void loginToDriver() {
		driver=comman.driversetup("chrome");
		}
	
	@Given("user should be hit the page {string}")
	public void user_should_be_hit_the_page(String string) {
	    comman.url(string);
	}

	@When("Text {string} on name of textbox is {string}")
	public void text_on_name_of_textbox_is(String string, String string2) 
	{
		ArrayList<String> values=comman.readfile(string2);
		comman.sendkeys(values.get(0),values.get(1), string);
	}

	@Then("click on {string}")
	public void click_on(String string) {
		ArrayList<String> values=comman.readfile(string);
	    comman.buttonClick(values.get(0),values.get(1));
	}
	@After
	public void tearDown()
	{
		driver.close();
	}

}
