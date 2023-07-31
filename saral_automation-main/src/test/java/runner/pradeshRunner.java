package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/pradesh", glue = { "stepdefinations",
		"hooks" }, publish = true, plugin = {"pretty", "html:target/CucumberReports/CucumberPradeshRepor.html" } ,
		
		tags="@Add/Edit_Data"
		)

public class pradeshRunner extends AbstractTestNGCucumberTests {

//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios() {
//		return super.scenarios();
//	}

}
