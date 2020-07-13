package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/java/features", 
		plugin = "json:target/jsonReports/cucumber-report.json",
		glue = "stepDefinitions"
		)
public class TestRunner extends AbstractTestNGCucumberTests {
	 
}
