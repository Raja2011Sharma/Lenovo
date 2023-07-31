package resources;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class SangathanDataEntry extends Base {

	public SangathanDataEntry(WebDriver driver) {
		driver = this.driver;

	}

	public void dataEntryCard() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		NgWebDriver ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		WebElement SangathanDataEntryEle = driver.findElements(By.className("data-entry-card-titles")).get(0);

		wait.until(ExpectedConditions.elementToBeClickable(SangathanDataEntryEle)).click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
	}

}
