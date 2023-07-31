package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "",
                glue = {},
                plugin = {"pretty","html:target/cucumber-reports","jason:target/cucumber.jason "},
                monochrome = true,
                publish = true





)
public class TestRunner extends AbstractTestNGCucumberTests  {
    @Override
    @DataProvider(parallel = true
    )
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
