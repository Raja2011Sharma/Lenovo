package Hooks;

import SaralStaging.Utils.ConfigReader;
import SaralStaging.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class SaralStagingHooks {
    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;
    @Before(order = 0)
    public void getProperty(){
        configReader=new ConfigReader();
        prop=configReader.InitProp();
    }
    @Before(order = 1)
    public void launchBrowser(){
        String browserName = prop.getProperty("browser");
        driverFactory=new DriverFactory();
        driver=driverFactory.intilization(browserName);
    }
    @After(order = 0)
    public void quitBrowser(){
        driver.quit();
    }
    @After(order = 1)
    public void tearDown(Scenario scenario){
        String screenshotname = scenario.getName().replaceAll("","_");
        byte[] sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    scenario.attach(sourcepath,"image/png",screenshotname);
    }

}

