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

public class VidhansabhaKaryakarta {

	JavascriptExecutor js;
	WebDriverWait wait, wait2;
	NgWebDriver ngDriver;
	WebDriver driver;
	// vidhansabha karyakarta data filter
	String vidhansabha;
	String organisationUnit;
	String organisationSubUnit;
	int vidhansabhaNumber;

	@And("^user click on add entry button for vidhansabha karyakarta$")
	public void user_click_on_add_entry_button_for_vidhansabha_karyakarta() throws InterruptedException {

		driver = DriverFactory.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		js = (JavascriptExecutor) driver;
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		List<WebElement> addEntryElement = driver.findElements(By.xpath("//button/span[contains(text(),'Add Entry')]"));
		wait.until(ExpectedConditions.visibilityOf(addEntryElement.get(4)));
		js.executeScript("arguments[0].click();", addEntryElement.get(4));
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

	}

	@And("^user select vidhansabha karyakarta data filter$")
	public void user_select_vidhansabha_karyakarta_data_filter(DataTable vidhansabha_karyakarta_filter_data)
			throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		Map<String, String> map = vidhansabha_karyakarta_filter_data.asMap(String.class, String.class);
		vidhansabha = map.get("vidhansabha");
		organisationUnit = map.get("Organisation Unit");
		organisationSubUnit = map.get("Organisation Sub Unit");
		js = (JavascriptExecutor) driver;

		// click on Select VidhanSabha
		WebElement selectVidhanSabhaEle = driver
				.findElement(By.xpath("//div[contains(text(),'Select Constituency (Vidhan Sabha)')]"));
		selectVidhanSabhaEle.click();
		
		vidhansabhaNumber = get_vidhansabha_number();

		// select VidhanSabha
		WebElement vidhanSabhaNameEle = driver
				.findElement(By.xpath("//div/span[contains(text(),'" + vidhansabha + "')]"));
		js.executeScript("arguments[0].click();", vidhanSabhaNameEle);

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

		// click on Select Organisation Unit
		WebElement SelectOrgUnitEle = driver
				.findElement(By.xpath("//div[contains(text(),'Select Organisation Unit')]"));
		SelectOrgUnitEle.click();

		// select Organisation Unit value
		WebElement organisationUnitNameEle = driver
				.findElement(By.xpath("//div[contains(text(),'" + organisationUnit + "')]"));
		js.executeScript("arguments[0].click();", organisationUnitNameEle);

		// click on Select Organisation Sub Unit
		WebElement SelectOrgSubUnitEle = driver
				.findElement(By.xpath("//div[contains(text(),'Select Organisation Sub Unit')]"));
		SelectOrgSubUnitEle.click();

		// select Organisation Sub Unit value
		WebElement organisationSubUnitNameEle = driver
				.findElement(By.xpath("//div[contains(text(),'" + organisationSubUnit + "')]"));
		js.executeScript("arguments[0].click();", organisationSubUnitNameEle);

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

	}

	@And("^user click on search button and verify vidhansabha karyakarta filter text$")
	public void user_click_on_search_button_and_verify_vidhansabha_karyakarta_filter_text()
			throws InterruptedException {

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

		// varifying vidhansabha karyakarta data filter text
		// visible selection
		WebElement headingEle = driver.findElement(By.tagName("h6"));

		String copiedHeadingText = wait.until(ExpectedConditions.visibilityOf(headingEle)).getText();
		System.out.println("copiedHeadingText :" + copiedHeadingText);
		
		 
	    WebElement vidhansabhaKaryakartaFilter = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div/h6"))));
	    String vidhansabhaKaryakartaFilterText = vidhansabhaKaryakartaFilter.getText();
		System.out.println("loksabhaKaryakartaFilterText: " + vidhansabhaKaryakartaFilterText);
		String vidhansabha_karyakarta_filter_text_format = vidhansabhaNumber + " " + vidhansabha + " >> " + organisationUnit
				+ " >> " + organisationSubUnit;

		System.out.println("-------loksabha_karyakarta_filter_text_format: " + vidhansabha_karyakarta_filter_text_format);
		Assert.assertEquals(vidhansabhaKaryakartaFilterText, vidhansabha_karyakarta_filter_text_format);


	}

	// get vidhansabha number
	public int get_vidhansabha_number() {
		List<WebElement> allVidhansabha = driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));
		for (int i = 0; i < allVidhansabha.size(); i++) {
			String vidhansabhaDropdownValue = allVidhansabha.get(i).getText();
			System.out.println(vidhansabhaDropdownValue);
			if (vidhansabhaDropdownValue.contains(vidhansabha)) {
				vidhansabhaNumber = (i + 1);

				return vidhansabhaNumber;
			}
		}
		return vidhansabhaNumber;
	}

}
