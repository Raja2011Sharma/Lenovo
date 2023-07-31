package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class FormControlKaryakarta {

	static WebDriver driver;
	static JavascriptExecutor js;
	static WebDriverWait wait, wait2;
	static NgWebDriver ngDriver;
	static ElementUtils elementUtils;

	public static void main(String[] args) throws InterruptedException {
//
//		DriverFactory driverFactory = new DriverFactory();
//		driverFactory.initializeBrowser("chrome");

	}

	public FormControlKaryakarta(WebDriver driver) {

		elementUtils = new ElementUtils(driver);
	}

	public static void enterKaryakartaName(String name) {

		driver = DriverFactory.getDriver();

		// Name WebElement....
		WebElement nameEle = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		nameEle.clear();
		nameEle.sendKeys(name);
		// elementUtils.typeTextIntoElement(nameEle, name, 01);
	}

	public static void enterKaryakartaRelationName(String relationName) {

		// Relation Name WebElement....
		WebElement relationNameEle = driver.findElement(By.xpath("//input[contains(@placeholder, 'Father')]"));
		relationNameEle.clear();
		relationNameEle.sendKeys(relationName);
		// elementUtils.typeTextIntoElement(relationNameEle, relationName, 10);

	}

	public static void clickOnkaryakartaDesignation() {

		// designation WebElement....
		WebElement designationEle = driver.findElement(By.xpath("//div[contains(text(),'Select Designation')]"));
		js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", designationEle);
		designationEle.click();
		//elementUtils.clickOnElement(designationEle, 10);

	}

	public static void selectKaryakartaDesignation(String designation) {

		// designation value WebElement....
		WebElement selectDesignationNameEle = driver
				.findElement(By.xpath("//div//span[contains(text(),'" + designation + "')]"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", selectDesignationNameEle);
		//selectDesignationNameEle.click();

	}

	public static void clickOnKaryakartaHasSmartPhone() {

		// has smart phone WebElement....
		WebElement hasSmartPhone = driver.findElement(By.xpath("//*[contains(text(),'Has Smartphone')]"));
		js = (JavascriptExecutor) driver;
		hasSmartPhone.click();
	
	}

	public static void selectKaryakartaHasSmartPhone(String hasSmartPhone) {

		// has smart phone value WebElement....
		WebElement HasSmartPhoneValueEle = driver
				.findElement(By.xpath("//div//span[contains(text(),'" + hasSmartPhone + "')]"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", HasSmartPhoneValueEle);

	}

	public static void enterKaryakartaPrimaryMemberId(String primaryMemberId) {
		//primary member id webElement...
		WebElement PrimaryMemberIdEle = driver.findElement(By.xpath("//input[@placeholder='Primary Member Id']"));
		PrimaryMemberIdEle.sendKeys(primaryMemberId);
		
	}
	public static void enterKaryakartaAge(String age) {

		// age WebElement....
		WebElement AgeEle = driver.findElement(By.xpath("//input[@placeholder='Age']"));
		AgeEle.sendKeys(age);
	}

	public static void enterKaryakartaDob(String dob) {

		// dob WebElement....
		WebElement dobEle = driver.findElement(By.xpath("//input[@data-placeholder='Dob']"));
		dobEle.sendKeys(dob);

	}

	public static String getKaryakartaCopiedDob() {

		// get karyakarta dob......
		WebElement dobEle = driver.findElement(By.xpath("//input[@data-placeholder='Dob']"));
		String copiedDobAfterEnteredAge = dobEle.getAttribute("value");
		return copiedDobAfterEnteredAge;

	}

	public static void enterKaryakartaBloodGroup(String bloodGroup) {

		// blood group WebElement....
		WebElement BloodGroupEle = driver.findElement(By.xpath("//input[@data-placeholder='Blood Group']"));
		BloodGroupEle.sendKeys(bloodGroup);

	}

	public static void enterKaryakartaPhoneNumber(String phoneNumber) {

		// phone number WebElement....
		// Phone Number
		WebElement PhoneNumberEle = driver.findElement(By.xpath("//input[@placeholder='Phone Number']"));
		PhoneNumberEle.clear();
		PhoneNumberEle.sendKeys(phoneNumber);

	}

}
