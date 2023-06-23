package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/zila", glue = { "stepdefinations",
		"hooks" }, publish = true, plugin = { "pretty", "html:target/CucumberReports/CucumberReport.html",
				"timeline:test-output-thread/", "html:target/CucumberReports/CucumberZilaRepor.html" })
public class zilaRunner extends AbstractTestNGCucumberTests {

//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios() {
//		return super.scenarios();
//	}

}
