package testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\afgba\\eclipse-workspace\\selenium\\src\\test\\resources\\Features\\login.feature", glue = "StepDefinitions", monochrome = true, plugin = {
		"pretty", "json:trget/JSONReports/report.json" },

		tags = "@creatnewuser"

)
public class TestRunner {

}
