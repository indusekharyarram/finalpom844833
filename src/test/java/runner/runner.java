package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/resources/feature/testcase.feature",
		glue= {"stepdefinition"},
		monochrome = true
		)
public class runner {
}

