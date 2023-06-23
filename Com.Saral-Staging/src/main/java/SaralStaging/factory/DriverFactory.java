package SaralStaging.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
public WebDriver driver;
public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

public WebDriver intilization(String browser){
    System.out.println("browser Value is :"+ browser);
    if (browser.equals("chrome")){
        tlDriver.set(new ChromeDriver());
    }
    else if(browser.equals("firefox")){
tlDriver.set(new FirefoxDriver());
    }
    else {
        System.out.println("please pass the correct browser value :"+ browser);
    }
    getDriver().manage().deleteAllCookies();
    getDriver().manage().window().maximize();
    return getDriver();
}
public static synchronized WebDriver  getDriver(){
    return tlDriver.get();
}

}
