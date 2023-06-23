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

public class Pradesh {

	JavascriptExecutor js;
	WebDriverWait wait, wait2;
	NgWebDriver ngDriver;
	WebDriver driver;
	// pradesh filter data
	String pradesh;
	String organisationUnit;
	String organisationSubUnit;

	@And("^user click on add entry button for pradesh$")
	public void user_click_on_add_entry_button_for_pradesh() throws InterruptedException {

		driver = DriverFactory.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		js = (JavascriptExecutor) driver;
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		List<WebElement> addEntryElement = driver.findElements(By.xpath("//button/span[contains(text(),'Add Entry')]"));
		wait.until(ExpectedConditions.visibilityOf(addEntryElement.get(0)));
		js.executeScript("arguments[0].click();", addEntryElement.get(0));
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

	}

	@And("^user select pradesh data filter$")
	public void user_select_pradesh_data_filter(DataTable pradesh_filter_data) throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		Map<String, String> map = pradesh_filter_data.asMap(String.class, String.class);
		pradesh = map.get("pradesh");
		organisationUnit = map.get("Organisation Unit");
		organisationSubUnit = map.get("Organisation Sub Unit");
		js = (JavascriptExecutor) driver;

		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page has loaded");
		}
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				System.out.println("Page has not loaded yet ");
			}
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}

		// Select State
		WebElement selectstateNameEle = driver.findElement(By.xpath("//div[contains(text(),'Select State')]"));
		selectstateNameEle.click();

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// select Organisation Unit
		WebElement stateNameEle = driver.findElement(By.xpath("//div[contains(text(),'" + pradesh + "')]"));
		js.executeScript("arguments[0].click();", stateNameEle);

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
		// Select Organisation Sub Unit
		WebElement selectOrganisationSubUnitEle = driver
				.findElement(By.xpath("//div[contains(text(),'" + organisationSubUnit + "')]"));
		js.executeScript("arguments[0].click();", selectOrganisationSubUnitEle);
		// --------------------------------------------------------------------------------------
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

	}

	@And("^user click on search button and verify pradesh filter text$")
	public void user_click_on_search_button_and_verify_pradesh_filter_text() throws InterruptedException {

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

		String allSelection = pradesh + " >> " + organisationUnit + " >> " + organisationSubUnit;
		System.out.println("allSelection :" + allSelection);
		Assert.assertEquals(copiedHeadingText, allSelection);

	}
	
	

}
