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

public class TalukaPanchayatKaryakarta {

	JavascriptExecutor js;
	WebDriverWait wait, wait2;
	NgWebDriver ngDriver;
	WebDriver driver;
	// talukapanchayat karyakarta data filter
	String state;
	String administrativeDistrcit;
	String block;
	String organisationUnit;
	String organisationSubUnit;

	@And("^user click on add entry button for talukapanchayat karyakarta$")
	public void user_click_on_add_entry_button_for_talukapanchayat_karyakarta() throws InterruptedException {

		driver = DriverFactory.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		js = (JavascriptExecutor) driver;
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		List<WebElement> addEntryElement = driver.findElements(By.xpath("//button/span[contains(text(),'Add Entry')]"));
		wait.until(ExpectedConditions.visibilityOf(addEntryElement.get(8)));
		js.executeScript("arguments[0].click();", addEntryElement.get(8));
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

	}

	@And("^user select talukapanchayat karyakarta data filter$")
	public void user_select_talukapanchayat_karyakarta_data_filter(DataTable talukapanchayat_karyakarta_data_filter)
			throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		Map<String, String> map = talukapanchayat_karyakarta_data_filter.asMap(String.class, String.class);
		state = map.get("state");
		administrativeDistrcit = map.get("administrativeDistrcit");
		block = map.get("block");
		organisationUnit = map.get("Organisation Unit");
		organisationSubUnit = map.get("Organisation Sub Unit");
		js = (JavascriptExecutor) driver;

		List<WebElement> app_Taluka_panchayat_karyakarta_filter = driver
				.findElements(By.xpath("//div[@class= 'ng-input']"));
		// Select State

		WebElement selectStateEle = app_Taluka_panchayat_karyakarta_filter.get(0);

		selectStateEle.click();

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

		// Select Administrative District

		WebElement selectAdministrativeDistrict = app_Taluka_panchayat_karyakarta_filter.get(1);

		selectAdministrativeDistrict.click();
		WebElement selectAdministrativeDistrictEle = driver
				.findElement(By.xpath("//div[contains(text(),'" + administrativeDistrcit + "')]"));

		js.executeScript("arguments[0].click();", selectAdministrativeDistrictEle);

		// Select Block.
		WebElement selectBlock = app_Taluka_panchayat_karyakarta_filter.get(2);
		selectBlock.click();

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

		WebElement selectBlockEle = driver.findElement(By.xpath("//div[contains(text(),'" + block + "')]"));
		js.executeScript("arguments[0].click();", selectBlockEle);

		// Select Organisation Unit.
		WebElement selectOrganisationUnit = app_Taluka_panchayat_karyakarta_filter.get(3);
		selectOrganisationUnit.click();

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

		WebElement selectOrganisationUnitEle = driver
				.findElement(By.xpath("//div[contains(text(),'" + organisationUnit + "')]"));

		js.executeScript("arguments[0].click();", selectOrganisationUnitEle);

		// Select Organisation Sub Unit.
		WebElement selectOrganisationSubUnit = app_Taluka_panchayat_karyakarta_filter.get(4);
		selectOrganisationSubUnit.click();

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

		WebElement selectOrganisationSubUnitEle = driver
				.findElement(By.xpath("//div[contains(text(),'" + organisationSubUnit + "')]"));

		js.executeScript("arguments[0].click();", selectOrganisationSubUnitEle);

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

	}

	@And("^user click on search button and verify talukapanchayat Karyakarta filter text$")
	public void user_click_on_search_button_and_verify_talukapanchayat_karyakarta_filter_text() {

	}

}
