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

public class Mandal {
	
	JavascriptExecutor js;
	WebDriverWait wait, wait2;
	NgWebDriver ngDriver;
	WebDriver driver;
	//mandal data filter
	String zila;
	String mandal;
	String organisationUnit;
	String organisationSubUnit;

	@And("^user click on add entry button for mandal$")
	public void user_click_on_add_entry_button_for_mandal() throws InterruptedException {
		
		driver = DriverFactory.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		js = (JavascriptExecutor) driver;
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		List<WebElement> addEntryElement = driver.findElements(By.xpath("//button/span[contains(text(),'Add Entry')]"));
		wait.until(ExpectedConditions.visibilityOf(addEntryElement.get(5)));
		js.executeScript("arguments[0].click();", addEntryElement.get(5));
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		
	}

	@And("^user select mandal data filter$")
	public void user_select_mandal_data_filter(DataTable mandal_filter_data) throws InterruptedException {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		Map<String, String> map = mandal_filter_data.asMap(String.class, String.class);
		zila = map.get("zila");
		mandal = map.get("mandal");
		organisationUnit = map.get("Organisation Unit");
		organisationSubUnit = map.get("Organisation Sub Unit");
		js = (JavascriptExecutor) driver;
		
		//click on Select Zila
		WebElement selectZilaEle = driver.findElement(By.xpath("//div[contains(text(),'Select Zila Name')]"));
		selectZilaEle.click();

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// select Zila
		//WebElement ZilaEle = driver.findElement(By.xpath("//div[contains(text(),'" + Zila + "')]"));
		WebElement ZilaEle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + zila + "')]")));
		
		js.executeScript("arguments[0].click();", ZilaEle);

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

		// click on Select Mandal Name
		WebElement SelectMandalEle = driver.findElement(By.xpath("//div[contains(text(),'Select Mandal Name')]"));
		SelectMandalEle.click();
		// select Mandal Name
		WebElement mandalNameEle = driver.findElement(By.xpath("//div[contains(text(),'" + mandal + "')]"));
		js.executeScript("arguments[0].click();", mandalNameEle);

		// click on Select Organisation Unit
		WebElement SelectOrgUnitEle = driver.findElement(By.xpath("//div[contains(text(),'Select Organisation Unit')]"));
		SelectOrgUnitEle.click();
		
		// select Organisation Unit
		WebElement organisationUnitNameEle = driver.findElement(By.xpath("//div[contains(text(),'" + organisationUnit + "')]"));
		js.executeScript("arguments[0].click();", organisationUnitNameEle);
		
		// click on Select Organisation Sub Unit
		WebElement SelectOrgSubUnitEle = driver.findElement(By.xpath("//div[contains(text(),'Select Organisation Sub Unit')]"));
		SelectOrgSubUnitEle.click();
		
		// select Organisation Sub Unit
		WebElement organisationSubUnitNameEle = driver.findElement(By.xpath("//div[contains(text(),'" + organisationSubUnit + "')]"));
		js.executeScript("arguments[0].click();", organisationSubUnitNameEle);
		

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
	
	}

	@And("^user click on search button and verify mandal filter text$")
	public void user_click_on_search_button_and_verify_mandal_filter_text() {
		
		// visible selection
		WebElement headingEle = driver.findElement(By.tagName("h6"));

		String copiedHeadingText = wait.until(ExpectedConditions.visibilityOf(headingEle)).getText();
		System.out.println("copiedHeadingText :" + copiedHeadingText);
		
		
	
	}

}
