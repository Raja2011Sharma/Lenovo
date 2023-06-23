package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver initializeBrowser(String browserName) {

		// This method is used to initialize the threadlocal driver on the basis of
		// given browser

		if (browserName.equals("chrome")) {
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();

			tlDriver.set(new ChromeDriver(co));

		} else if (browserName.equals("firefox")) {

			tlDriver.set(new FirefoxDriver());

		} else if (browserName.equals("safari")) {
			driver = new SafariDriver();

		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}

	// This is used to get the driver with ThreadLocal

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
