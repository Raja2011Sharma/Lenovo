package stepdefinations;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;
import com.paulhammant.ngwebdriver.NgWebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

public class grampanchayatKaryakarta {

	// public WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait, wait2;
	NgWebDriver ngDriver;
	WebDriver driver;
	// gram panchayat data filter
	String state;
	String administrativeDistrict;
	String block;
	String grampanchayatName;
	String ward;
	String organisationUnit;
	String organisationSubUnit;

	@And("^user click on add entry button for grampanchayat karyakarta$")
	public void user_click_on_add_entry_button_for_grampanchayat_karyakarta() throws InterruptedException {
		driver = DriverFactory.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		js = (JavascriptExecutor) driver;
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		List<WebElement> addEntryElement = driver.findElements(By.xpath("//button/span[contains(text(),'Add Entry')]"));
		wait.until(ExpectedConditions.visibilityOf(addEntryElement.get(9)));
		js.executeScript("arguments[0].click();", addEntryElement.get(9));
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

	}

	@And("^user select grampanchayat karyakarta data filter$")
	public void user_select_grampanchayat_karyakarta_data_filter(DataTable grampanchayat_karyakarta_filter_data)
			throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		Map<String, String> map = grampanchayat_karyakarta_filter_data.asMap(String.class, String.class);
		state = map.get("State");
		administrativeDistrict = map.get("Administrative District");
		block = map.get("Block");
		grampanchayatName = map.get("Grampanchayat Name");
		organisationUnit = map.get("Organisation Unit");
		organisationSubUnit = map.get("Organisation Sub Unit");
		js = (JavascriptExecutor) driver;

		// App_Gram_Panchayat_Karyakarta_Filters.
		final List<WebElement> app_gram_panchayat_karyakarta_filter = driver
				.findElements(By.xpath("//div[@class='ng-placeholder']"));

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

		// Select Administrative District
		WebElement SelectAdministrativeDistrcit = waitForElementWithFluentWait(driver,
				app_gram_panchayat_karyakarta_filter.get(1));
		SelectAdministrativeDistrcit.click();
		Thread.sleep(2000);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		// Select Administrative District Vale
		WebElement selectAdministrativeDistrictEle = waitForElementWithFluentWait(driver,
				driver.findElement(By.xpath("//div[contains(text(),'" + administrativeDistrict + "')]")));
		js.executeScript("arguments[0].click();", selectAdministrativeDistrictEle);
		Thread.sleep(2000);

		// Select Block.
		WebElement selectBlock = waitForElementWithFluentWait(driver, app_gram_panchayat_karyakarta_filter.get(2));
		selectBlock.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// Select Block Value
		WebElement selectBlockEle = waitForElementWithFluentWait(driver,
				driver.findElement(By.xpath("//div[contains(text(),'" + block + "')]")));
		js.executeScript("arguments[0].click();", selectBlockEle);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// Select Gram Panchayat Name.
		WebElement selectGramPanchayatName = waitForElementWithFluentWait(driver,
				app_gram_panchayat_karyakarta_filter.get(3));
		selectGramPanchayatName.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

		// Select grampanchayt value

		WebElement selectGramPanchayatEle = waitForElementWithFluentWait(driver,
				driver.findElement(By.xpath("//div[contains(text(),'" + grampanchayatName + "')]")));
		selectGramPanchayatEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

		// Select Organisation Unit.
		
		WebElement selectOrganisationUnit = waitForElementWithFluentWait(driver,
				app_gram_panchayat_karyakarta_filter.get(4));
		js.executeScript("arguments[0].click();", selectOrganisationUnit);

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

		// select org value
		WebElement selectOrganisationUnitEle = waitForElementWithFluentWait(driver,
				driver.findElement(By.xpath("//div[contains(text(),'" + organisationUnit + "')]")));
		selectOrganisationUnitEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// Select Organisation Sub Unit.

		WebElement selectOrganisationSubUnit = waitForElementWithFluentWait(driver,
				app_gram_panchayat_karyakarta_filter.get(5));
		selectOrganisationSubUnit.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// select org subunit value

		WebElement selectOrganisationSubUnitEle = waitForElementWithFluentWait(driver,
				driver.findElement(By.xpath("//div[contains(text(),'" + organisationSubUnit + "')]")));
		selectOrganisationSubUnitEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// Search Button Ele
		WebElement searchButton = driver.findElement(By.xpath("//span[text()=' Search ']"));

		wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

	}

	@And("^user click on search button and verify grampanchayat karyakarta filter text$")
	public void user_click_on_search_button_and_verify_grampanchayat_karyakarta_filter_text() {

		// app_gram_panchayat_karyakarta_filter_text verification.
		WebElement app_gram_panchayat_karyakarta_filter_text_ele = driver.findElement(By.xpath("//h6"));
		String app_gram_panchayat_karyakarta_filter_text = app_gram_panchayat_karyakarta_filter_text_ele.getText();
		System.out.println("app_gram_panchayat_karyakarta_filter_text " + app_gram_panchayat_karyakarta_filter_text);
		String app_gram_panchayat_karyakarta_filter_text_format = state + "   >   " + administrativeDistrict + "   >   "
				+ block + "  >   " + grampanchayatName + "   >   " + organisationUnit + "   >   " + organisationSubUnit;
		System.out.println(
				"app_gram_panchayat_karyakarta_filter_text " + app_gram_panchayat_karyakarta_filter_text_format);

		Assert.assertEquals(app_gram_panchayat_karyakarta_filter_text,
				app_gram_panchayat_karyakarta_filter_text_format);

	}

	public static WebElement waitForElementWithFluentWait(WebDriver driver, final WebElement ele) {

		// Declaration of fluent waits
		Wait<WebDriver> MyWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(ElementClickInterceptedException.class);

		WebElement element = MyWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return ele;

			}
		});
		return element;

	}

}
