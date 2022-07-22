package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/java/FeaturePackage/first.feature"
		,glue={"stepDefinaction"}
		,dryRun=false
		//,tags= "@sanity"
		,plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:target/cucumber-html-report/report.html",
				"json:target/cucumber-report/cucumber.json",
				"junit:target/cucumber-report/cucumber.xml"}
		,monochrome=true
		)
public class testRunner {

}

