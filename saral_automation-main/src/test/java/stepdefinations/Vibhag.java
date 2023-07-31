package stepdefinations;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.NgWebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

public class Vibhag {

	JavascriptExecutor js;
	WebDriverWait wait, wait2;
	NgWebDriver ngDriver;
	WebDriver driver;
	// vibhag filter data
	String state;
	String vibhag;
	String organisationUnit;
	String organisationSubUnit;

	@And("^user click on add entry button for vibhag$")
	public void user_click_on_add_entry_button_for_vibhag() throws InterruptedException {
		driver = DriverFactory.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		js = (JavascriptExecutor) driver;
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		List<WebElement> addEntryElement = driver.findElements(By.xpath("//button/span[contains(text(),'Add Entry')]"));
		wait.until(ExpectedConditions.visibilityOf(addEntryElement.get(1)));
		js.executeScript("arguments[0].click();", addEntryElement.get(1));
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

	}

	@And("^user select vibhag karyakarta data filter$")
	public void user_select_ward_karyakarta_data_filter(DataTable vibhag_filter_data) throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		Map<String, String> map = vibhag_filter_data.asMap(String.class, String.class);
		state = map.get("zila");
		vibhag = map.get("vibhag");
		organisationUnit = map.get("Organisation Unit");
		organisationSubUnit = map.get("Organisation Sub Unit");
		js = (JavascriptExecutor) driver;

		// click on Select state
		WebElement selectStateEle = driver.findElement(By.xpath("//div[contains(text(),'Select State')]"));
		selectStateEle.click();

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// select state
		// WebElement StateEle = driver.findElement(By.xpath("//div[contains(text(),'" +
		// State + "')]"));
		WebElement StateEle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + state + "')]")));

		js.executeScript("arguments[0].click();", StateEle);

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

		// click on Select Vibhag
		WebElement SelectVibhagEle = driver.findElement(By.xpath("//div[contains(text(),'Select Vibhag')]"));
		SelectVibhagEle.click();
		// select Vibhag
		WebElement VibhagNameEle = driver.findElement(By.xpath("//div[contains(text(),'" + vibhag + "')]"));
		js.executeScript("arguments[0].click();", VibhagNameEle);

		// click on Select Organisation Unit
		WebElement SelectOrgUnitEle = driver
				.findElement(By.xpath("//div[contains(text(),'Select Organisation Unit')]"));
		SelectOrgUnitEle.click();

		// select Organisation Unit
		WebElement organisationUnitNameEle = driver
				.findElement(By.xpath("//div[contains(text(),'" + organisationUnit + "')]"));
		js.executeScript("arguments[0].click();", organisationUnitNameEle);

		// click on Select Organisation Sub Unit
		WebElement SelectOrgSubUnitEle = driver
				.findElement(By.xpath("//div[contains(text(),'Select Organisation Sub Unit')]"));
		SelectOrgSubUnitEle.click();

		// select Organisation Sub Unit
		WebElement organisationSubUnitNameEle = driver
				.findElement(By.xpath("//div[contains(text(),'" + organisationSubUnit + "')]"));
		js.executeScript("arguments[0].click();", organisationSubUnitNameEle);

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

	}

	@And("^user click on search button and verify vibhag filter text$")
	public void user_click_on_search_button_and_verify_vibhag_filter_text() throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		js = (JavascriptExecutor) driver;
		// Search Button
		WebElement searchButtonEle = driver
				.findElement(By.xpath("//button[@color='primary']/child::span[contains(text(),'Search')]"));
		js.executeScript("arguments[0].click();", searchButtonEle);
		// wait.until(ExpectedConditions.elementToBeClickable(searchButtonEle)).click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

		// visible selection
		WebElement headingEle = driver.findElement(By.tagName("h6"));

		String copiedHeadingText = wait.until(ExpectedConditions.visibilityOf(headingEle)).getText();
		System.out.println("copiedHeadingText :" + copiedHeadingText);

	}

}
