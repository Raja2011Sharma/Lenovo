package SaralStagingTestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/Resouces/SaralStaging.feature/LoginPage.feature"},
        glue= {"StepDefination","Hooks"},
        plugin = {"pretty"}
)
public class TestRunner {

}
