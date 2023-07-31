package resources;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WardPageObject {

	public WebDriver driver;

//	public WardPageObject(WebDriver driver){
//		driver = this.driver;
//	}
	By SangathanDataEntryEle = By.cssSelector("data-entry-card-titles");
	By nameEle = By.xpath("//input[@placeholder='Name']");

	public WardPageObject(WebDriver driver) {
		driver = this.driver;
	}

	public List<WebElement> getSangathanDataEntryEle() {
		return driver.findElements(SangathanDataEntryEle);
	}

	public WebElement getNameEle() {
		return driver.findElement(nameEle);
	}

}
