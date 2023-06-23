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

public class LoksabhaKaryakarta {
	JavascriptExecutor js;
	WebDriverWait wait, wait2;
	NgWebDriver ngDriver;
	public WebDriver driver;
	String loksabha;
	String organisationUnit;
	String organisationSubUnit;
	int loksabhaNumber;

	@And("^user click on add entry button for loksabha karyakarta$")
	public void user_click_on_add_entry_button_for_ward_karyakarta() throws InterruptedException {
		driver = DriverFactory.getDriver();
		// driver = getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		List<WebElement> addEntryElement = driver.findElements(By.xpath("//button/span[contains(text(),'Add Entry')]"));
		wait.until(ExpectedConditions.visibilityOf(addEntryElement.get(2))).click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

	}

	@And("^user select loksabha karyakarta data filter$")
	public void user_select_loksabha_karyakarta_data_filter(DataTable loksabha_karyakarta_filter_data)
			throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		Map<String, String> map = loksabha_karyakarta_filter_data.asMap(String.class, String.class);
		loksabha = map.get("Loksabha");
		organisationUnit = map.get("Organisation Unit");
		organisationSubUnit = map.get("Organisation Sub Unit");
		js = (JavascriptExecutor) driver;
		List<WebElement> loksabha_karyakarta_filter = driver
				.findElements(By.xpath("//div[@class='ng-value-container']"));
		// loksabha
		WebElement loksabhaEle = grampanchayatKaryakarta.waitForElementWithFluentWait(driver,
				loksabha_karyakarta_filter.get(0));
		loksabhaEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		loksabhaNumber = get_loksabha_number();
		System.out.println("loksabhaNumber: " + loksabhaNumber);
		// select loksabha value
		WebElement selectLoksabha = grampanchayatKaryakarta.waitForElementWithFluentWait(driver,
				driver.findElement(By.xpath("//span[contains(text(),'" + loksabha + "')]")));
		selectLoksabha.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		// Organisation Unit

		WebElement organisationUnitEle = grampanchayatKaryakarta.waitForElementWithFluentWait(driver,
				loksabha_karyakarta_filter.get(1));
		organisationUnitEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

		// select organisation unit value

		WebElement selectOrganisationUnit = grampanchayatKaryakarta.waitForElementWithFluentWait(driver,
				driver.findElement(By.xpath("//div[contains(text(),'" + organisationUnit + "')]")));
		selectOrganisationUnit.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		// Organisation Sub Unit
		WebElement organisationSubUnitEle = grampanchayatKaryakarta.waitForElementWithFluentWait(driver,
				loksabha_karyakarta_filter.get(2));
		organisationSubUnitEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

		// Select Organisation Sub Unit Value

		WebElement selectOrganisationSubUnit = grampanchayatKaryakarta.waitForElementWithFluentWait(driver,
				driver.findElement(By.xpath("//div[contains(text(),'" + organisationSubUnit + "')][@role='option']")));
		selectOrganisationSubUnit.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

	}

	@And("^user click on search button and verify loksabha karyakarta filter text$")
	public void user_click_on_search_button_and_verify_loksabha_karyakarta_filter_text() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		js = (JavascriptExecutor) driver;

		// Search Button Ele
		WebElement searchButtonEle = driver.findElement(By.xpath("//mat-icon[contains(.,'search')]"));
		js.executeScript("arguments[0].click();", searchButtonEle);

		// Verifying Loksabha data filters	
		 
	    WebElement loksabhaKaryakartaFilter = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div/h6"))));
	    String loksabhaKaryakartaFilterText = loksabhaKaryakartaFilter.getText();
		System.out.println("loksabhaKaryakartaFilterText: " + loksabhaKaryakartaFilterText);
		String loksabha_karyakarta_filter_text_format = loksabhaNumber + " " + loksabha + " >> " + organisationUnit
				+ " >> " + organisationSubUnit;

		System.out.println("-------loksabha_karyakarta_filter_text_format: " + loksabha_karyakarta_filter_text_format);
		Assert.assertEquals(loksabhaKaryakartaFilterText, loksabha_karyakarta_filter_text_format);

	}

	// Get loksabha number;
	public int get_loksabha_number() {
		List<WebElement> allLoksabha = driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));
		for (int i = 0; i < allLoksabha.size(); i++) {
			String loksabhaDropdownValue = allLoksabha.get(i).getText();
			System.out.println(loksabhaDropdownValue);
			if (loksabhaDropdownValue.contains(loksabha)) {
				loksabhaNumber = (i + 1);

				return loksabhaNumber;
			}
		}
		return loksabhaNumber;
	}

}
