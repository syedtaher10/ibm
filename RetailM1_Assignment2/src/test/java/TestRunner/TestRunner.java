package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Retail_Simple.feature", glue = { "stepDefinitions" }, tags = {
		"@Assignment02_Syed" })

public class TestRunner {

}
