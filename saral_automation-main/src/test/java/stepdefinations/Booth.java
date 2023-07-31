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

public class Booth {

	JavascriptExecutor js;
	WebDriverWait wait, wait2;
	NgWebDriver ngDriver;
	WebDriver driver;
	//Booth Filter
	String vidhansabha;
	String booth;
	String mandal;
	String shaktikendra;

	@And("^user click on add entry button for booth$")
	public void user_click_on_add_entry_button_for_booth() throws InterruptedException {
        driver = DriverFactory.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		js = (JavascriptExecutor) driver;
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		List<WebElement> addEntryElement = driver.findElements(By.xpath("//button/span[contains(text(),'Add Entry')]"));
		wait.until(ExpectedConditions.visibilityOf(addEntryElement.get(7)));
		js.executeScript("arguments[0].click();", addEntryElement.get(7));
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

	}

	@And("^user select booth data filter$")
	public void user_select_booth_data_filter(DataTable booth_filter_data) throws InterruptedException {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		Map<String, String> map = booth_filter_data.asMap(String.class, String.class);
		vidhansabha = map.get("VidhanSabha");
		booth = map.get("Booth");
		mandal = map.get("Mandal");
		shaktikendra = map.get("ShaktiKendra");
		js = (JavascriptExecutor) driver;

		// Select VidhanSabha
		WebElement selectVidhanSabhaEle = driver.findElement(By.xpath("//div[contains(text(),'Select Vidhan Sabha')]"));
		selectVidhanSabhaEle.click();

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// select Vidhan Sabha
		WebElement vidhanSabhaNameEle = driver
				.findElement(By.xpath("//div/span[contains(text(),'" + vidhansabha + "')]"));
		js.executeScript("arguments[0].click();", vidhanSabhaNameEle);

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

		// click on Select Booth
		WebElement SelectBoothEle = driver.findElement(By.xpath("//div[contains(text(),'Select Booth')]"));
		SelectBoothEle.click();
		// select Booth
		WebElement boothNameEle = driver.findElement(By.xpath("//div/span[contains(text(),'" + booth + "')]"));
		js.executeScript("arguments[0].click();", boothNameEle);

		// click on Select Mandal
		// WebElement SelectMandalEle =
		// driver.findElement(By.xpath("//div[contains(text(),'Select Mandal')]"));
//		driver.findElements(By.className("ng-value-container")).get(4).click();
		// js.executeScript("arguments[0].click();",SelectMandalEle);

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

		// Select Mandal
//		WebElement selectMadalValueEle = driver.findElement(By.xpath("//div/span[contains(text(),'" + mandal + "')]"));
//		js.executeScript("arguments[0].click();", selectMadalValueEle);

		// click on Select Shakti Kendra Name
//		driver.findElement(By.xpath("//div[contains(text(),'Select Shakti Kendra Name')]")).click();
//		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
//		Thread.sleep(2000);
		// Select Shakti Kendra Name
//		WebElement selectShaktiKendraNameEle = driver
//				.findElement(By.xpath("//div/span[contains(text(),'" + shaktikendra + "')]"));
//		js.executeScript("arguments[0].click();", selectShaktiKendraNameEle);
		// --------------------------------------------------------------------------------------
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
//		// visible selection
//		WebElement headingEle = driver.findElement(By.tagName("h6"));
//
//		String copiedHeadingText = wait.until(ExpectedConditions.visibilityOf(headingEle)).getText();
//		System.out.println("copiedHeadingText :" + copiedHeadingText);

		// allSelection = vidhanSabhaName + " >> " + mandal + " >> " + shaktiKendraName;
		// System.out.println("allSelection :" + allSelection);
		// Assert.assertEquals(copiedHeadingText, allSelection);

		// -----------------Add Data--------//

		// ------If you want to enter extra details please use this section.------
	}

	@And("^user click on search button and verify booth filter text$")
	public void user_click_on_search_button_and_verify_booth_filter_text() {
		
		

	}

}
