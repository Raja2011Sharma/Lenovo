package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KaryakartaDynamicForm {

	JavascriptExecutor js;
	WebDriver driver;

	public KaryakartaDynamicForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Name
	@FindBy(xpath = "//input[@placeholder='Name']")
	private WebElement nameEle;
	// Father's and Husband Name
	@FindBy(xpath = "//input[contains(@placeholder, 'Father')]")
	private WebElement relationNameEle;
	// Designation
	@FindBy(xpath = "//div[contains(text(),'Select Designation')]")
	private WebElement designationEle;
//		//Designation Value
//		@FindBy(xpath="//div//span[contains(text(),'" + designation + "')]")
//		private WebElement selectDesignation;

	public void enterKaryakartaName(String nameText) {
		nameEle.sendKeys(nameText);
	}

	public void enterKaryakartaRelationName(String relationNameText) {
		relationNameEle.sendKeys(relationNameText);
	}

	public void clickOnDesignation() {
		designationEle.click();

	}

	public void selectDesignation(String designationValue) {
		WebElement selectDesignationNameEle = driver
				.findElement(By.xpath("//div//span[contains(text(),'" + designationValue + "')]"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", selectDesignationNameEle);
		selectDesignationNameEle.click();

	}

}
