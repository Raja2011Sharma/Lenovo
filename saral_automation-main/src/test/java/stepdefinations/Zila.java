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
import org.testng.Assert;

import com.paulhammant.ngwebdriver.NgWebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

public class Zila {
	JavascriptExecutor js;
	WebDriverWait wait, wait2;
	NgWebDriver ngDriver;
	WebDriver driver;
	// zila filter Data
	String zila;
	String organisationUnit;
	String organisationSubUnit;

	@And("^user click on add entry button for zila$")
	public void user_click_on_add_entry_button_for_zila() throws InterruptedException {

		driver = DriverFactory.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		js = (JavascriptExecutor) driver;
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		List<WebElement> addEntryElement = driver.findElements(By.xpath("//button/span[contains(text(),'Add Entry')]"));
		wait.until(ExpectedConditions.visibilityOf(addEntryElement.get(3)));
		js.executeScript("arguments[0].click();", addEntryElement.get(3));
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

	}

	@And("^user select zila data filter$")
	public void user_select_zila_data_filter(DataTable zila_filter_data) throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		Map<String, String> map = zila_filter_data.asMap(String.class, String.class);
		zila = map.get("zila");
		organisationUnit = map.get("Organisation Unit");
		organisationSubUnit = map.get("Organisation Sub Unit");
		js = (JavascriptExecutor) driver;

		// click on Select Zila
		WebElement selectZilaNameEle = driver.findElement(By.xpath("//div[contains(text(),'Select Zila Name')]"));
		selectZilaNameEle.click();

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// select zila name
		WebElement zilaNameEle = driver.findElement(By.xpath("//div[contains(text(),'" + zila + "')]"));
		js.executeScript("arguments[0].click();", zilaNameEle);

		// click on Select Organisation Unit
		WebElement selectOrganisationunitEle = driver
				.findElement(By.xpath("//div[contains(text(),'Select Organisation Unit')]"));
		selectOrganisationunitEle.click();

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// Select Organisation Unit value
		WebElement selectOrganisationUnitEle = driver
				.findElement(By.xpath("//div[contains(text(),'" + organisationUnit + "')]"));
		js.executeScript("arguments[0].click();", selectOrganisationUnitEle);

		// click on Select Organisation Sub Unit
		driver.findElement(By.xpath("//div[contains(text(),'Select Organisation Sub Unit')]")).click();

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// Select Organisation Sub Unit value
		WebElement selectOrganisationSubUnitEle = driver
				.findElement(By.xpath("//div[contains(text(),'" + organisationSubUnit + "')]"));
		js.executeScript("arguments[0].click();", selectOrganisationSubUnitEle);

	}

	@And("^user click on search button and verify zila filter text$")
	public void user_click_on_search_button_and_verify_zila_filter_text() throws InterruptedException {

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

		// varify zila filter text
		WebElement headingEle = driver.findElement(By.tagName("h6"));
		String copiedHeadingText = wait.until(ExpectedConditions.visibilityOf(headingEle)).getText();
		System.out.println("copiedHeadingText :" + copiedHeadingText);

		String allSelection = zila + " >> " + organisationUnit + " >> " + organisationSubUnit;
		System.out.println("allSelection :" + allSelection);
		Assert.assertEquals(copiedHeadingText, allSelection);

	}

}
