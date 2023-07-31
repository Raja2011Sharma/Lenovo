package SaralStaging.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static WebDriver driver;
public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver intilization(String browser) {
        System.out.println("browser Value is :" + browser);
//    System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        if (browser.equals("chrome")) {
//        driver.set(new ChromeDriver(options));
//            driver = new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
//tlDriver.set(new FirefoxDriver());
        } else {
            System.out.println("please pass the correct browser value :" + browser);
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
   return driver;
}
public static synchronized WebDriver  getDriver(){
    return tlDriver.get();
}

}

