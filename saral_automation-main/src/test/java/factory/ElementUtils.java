package factory;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public static void main(String[] args) throws InterruptedException {

		DriverFactory driverFactory = new DriverFactory();
		driverFactory.initializeBrowser("chrome");
		

	}



	public void clickOnElement(WebElement element, long durationInSeconds) {

		WebElement webElement = waitForElement(element, durationInSeconds);
		webElement.click();
	}

	public void typeTextIntoElement(WebElement element, String textToBeTyped, long durationInSeconds) {
		driver = DriverFactory.getDriver();
		WebElement webElement = waitForElement(element, durationInSeconds);

		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
	}

	public WebElement waitForElement(WebElement element, long durationInSeconds) {

		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			wait.until(ExpectedConditions.elementToBeClickable(element));

		} catch (Throwable e) {

			e.printStackTrace();

		}
		return webElement;

	}

	public WebElement waitForVisiblityOfElement(WebElement element, long durationInSeconds) {
		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return webElement;
	}

	public void javaScriptClick(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForVisiblityOfElement(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("argument[0].click();", webElement);
	}

}
