package factory;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.NgWebDriver;

import resources.Base;

public class Login extends Base {
	static WebDriver driver;
	static JavascriptExecutor js;
	static WebDriverWait wait, wait2;
	static NgWebDriver ngDriver;

	public static void main(String[] args) throws InterruptedException {

		// DriverFactory.initializeBrowser("chrome");
		// driver = DriverFactory.getDriver();

	}

	public static void login_in_saral_application(String login_email, String login_password, String login_otp)
			throws InterruptedException, IOException {
		driver = DriverFactory.getDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		DriverFactory.getDriver().get("https://zila-staging.ccdms.in/");
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		js = (JavascriptExecutor) driver;
		WebElement loginEmail = driver.findElement(By.name("email"));
		loginEmail.sendKeys(login_email);
		Thread.sleep(2000);
		WebElement loginPassword = driver.findElement(By.name("password"));

		wait.until(ExpectedConditions.visibilityOf(loginPassword));
		loginPassword.sendKeys(login_password);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//button/span[contains(.,'Send OTP')]")))).click();
		Thread.sleep(2000);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		List<WebElement> optInputElement = driver.findElements(By.className("otp-input"));
		String otp = login_otp;
		wait.until(ExpectedConditions.visibilityOf(optInputElement.get(0))).sendKeys(String.valueOf(otp.charAt(0)));
		wait.until(ExpectedConditions.visibilityOf(optInputElement.get(1))).sendKeys(String.valueOf(otp.charAt(1)));
		wait.until(ExpectedConditions.visibilityOf(optInputElement.get(2))).sendKeys(String.valueOf(otp.charAt(2)));
		wait.until(ExpectedConditions.visibilityOf(optInputElement.get(3))).sendKeys(String.valueOf(otp.charAt(3)));
		wait.until(ExpectedConditions.visibilityOf(optInputElement.get(4))).sendKeys(String.valueOf(otp.charAt(4)));
		wait.until(ExpectedConditions.visibilityOf(optInputElement.get(5))).sendKeys(String.valueOf(otp.charAt(5)));

		WebElement submitButtom = driver.findElement(By.tagName("button"));
		wait.until(ExpectedConditions.elementToBeClickable(submitButtom)).click();

	}
}
