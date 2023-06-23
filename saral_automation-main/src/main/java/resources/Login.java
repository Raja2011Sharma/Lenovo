package resources;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login{
//	NgWebDriver ngDriver;
//	JavascriptExecutor js;
//	WebDriverWait wait, wait2, wait3;

//	public Login(WebDriver driver) {
//	driver = this.driver;
//	}

	public static WebDriver  loginInSaral(String username, String password, String OTP) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();

		driver.manage().window().maximize();

		driver.get("https://zila-staging.ccdms.in/");
		
		NgWebDriver ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(110));

		WebElement loginEmail = driver.findElement(By.name("email"));
		loginEmail.sendKeys(username);
		
		WebElement loginPassword = driver.findElement(By.name("password"));

		wait.until(ExpectedConditions.visibilityOf(loginPassword));
		loginPassword.sendKeys(password);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//button/span[contains(text(),'Send OTP')]"))))
				.click();
		Thread.sleep(2000);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		List<WebElement> optInputElement = driver.findElements(By.className("otp-input"));
		String otp = OTP;
		wait.until(ExpectedConditions.visibilityOf(optInputElement.get(0))).sendKeys(String.valueOf(otp.charAt(0)));
		wait.until(ExpectedConditions.visibilityOf(optInputElement.get(1))).sendKeys(String.valueOf(otp.charAt(1)));
		wait.until(ExpectedConditions.visibilityOf(optInputElement.get(2))).sendKeys(String.valueOf(otp.charAt(2)));
		wait.until(ExpectedConditions.visibilityOf(optInputElement.get(3))).sendKeys(String.valueOf(otp.charAt(3)));
		wait.until(ExpectedConditions.visibilityOf(optInputElement.get(4))).sendKeys(String.valueOf(otp.charAt(4)));
		wait.until(ExpectedConditions.visibilityOf(optInputElement.get(5))).sendKeys(String.valueOf(otp.charAt(5)));

		WebElement submitButtom = driver.findElement(By.tagName("button"));
		wait.until(ExpectedConditions.elementToBeClickable(submitButtom)).click();
		
		return driver;
	}
}
