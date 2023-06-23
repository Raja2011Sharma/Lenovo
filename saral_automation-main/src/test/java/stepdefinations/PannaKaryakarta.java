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
import io.cucumber.java.en.Then;

public class PannaKaryakarta {

	JavascriptExecutor js;
	WebDriverWait wait, wait2;
	NgWebDriver ngDriver;
	WebDriver driver;
	String vidhansabha;
	String booth;
	String panna;
	int boothNumber;
	// int loksabhaNumber;

	@And("^user click on add entry button for panna karyakarta$")
	public void user_click_on_add_entry_button_for_panna_karyakarta() throws InterruptedException {

		driver = DriverFactory.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		List<WebElement> addEntryElement = driver.findElements(By.xpath("//button/span[contains(text(),'Add Entry')]"));
		wait.until(ExpectedConditions.visibilityOf(addEntryElement.get(11))).click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

	}

	@And("^user select panna karyakarta data filter$")
	public void user_select_panna_karyakarta_data_filter(DataTable panna_karyakarta_filter_data)
			throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		Map<String, String> map = panna_karyakarta_filter_data.asMap(String.class, String.class);
		vidhansabha = map.get("Vidhan Sabha");
		booth = map.get("Booth");
		panna = map.get("Panna");
		js = (JavascriptExecutor) driver;
		List<WebElement> panna_karyakarta_filter = driver.findElements(
				By.xpath("//div[@class='row ng-star-inserted']//div//ng-select//div[@class='ng-value-container']"));
		// vidhansabha
		panna_karyakarta_filter.get(2).click();
		WebElement selectVidhansabha = driver.findElement(By.xpath("//span[contains(text(),'" + vidhansabha + "')]"));
		wait.until(ExpectedConditions.visibilityOf(selectVidhansabha)).click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// booth
		panna_karyakarta_filter.get(3).click();
		Thread.sleep(2000);
		//get booth number...
		boothNumber = get_booth_number();
		WebElement selectBooth = driver.findElement(By.xpath("//span[contains(text(),'" + booth + "')]"));
		js.executeScript("arguments[0].click();", selectBooth);
		// wait.until(ExpectedConditions.visibilityOf(selectOrganisationUnit)).click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// panna
		panna_karyakarta_filter.get(4).click();
		Thread.sleep(2000);
		WebElement selectPanna = driver.findElement(By.xpath("//span[contains(text(),'" + panna + "')]"));

		js.executeScript("arguments[0].click();", selectPanna);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

	}
	
	

	

	@And("^user click on search button and verify panna karyakarta filter text$")
	public void user_click_on_search_button_and_verify_panna_karyakarta_filter_text() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		js = (JavascriptExecutor) driver;

		// Search Button Ele
		WebElement searchButtonEle = driver.findElement(By.xpath("//mat-icon[contains(.,'search')]"));
		js.executeScript("arguments[0].click();", searchButtonEle);

		// Verifying panna data filters
		String pannaKaryakartaFilterText = driver.findElement(By.xpath("//div/h6")).getText();
		System.out.println("pannaKaryakartaFilterText: " + pannaKaryakartaFilterText);

		String panna_karyakarta_filter_text_format = "Booth : " + '\n' + boothNumber + " " + booth + "          "+ '\n' + "Panna : " + '\n' + panna;
		System.out.println("panna_karyakarta_filter_text_format: " + panna_karyakarta_filter_text_format);
		
		Assert.assertEquals(pannaKaryakartaFilterText, panna_karyakarta_filter_text_format);
		
		
		
	}
	// get panna number...
	public int get_booth_number() {
		List<WebElement> allBooth = driver.findElements(By.xpath("//div[@class='ng-star-inserted']"));
		for (int i = 0; i < allBooth.size(); i++) {
			String boothDropdownValue = allBooth.get(i).getText();
			System.out.println(boothDropdownValue);
			if (boothDropdownValue.contains(booth)) {
				boothNumber = (i + 1);

				return boothNumber;
			}
		}
		return boothNumber;
	}

}
