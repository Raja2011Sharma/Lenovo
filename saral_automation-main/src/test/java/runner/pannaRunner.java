package runner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/panna", glue = { "stepdefinations" , "hooks" }, publish = true, plugin = { "pretty",
		"html:target/CucumberReports/CucumberReport.html", "timeline:test-output-thread/", "html:target/CucumberReports/CucumberPannaReport.html" })
public class pannaRunner extends AbstractTestNGCucumberTests {

//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios() {
//		return super.scenarios();
//	}

}