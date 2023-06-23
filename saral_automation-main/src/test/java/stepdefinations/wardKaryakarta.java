package stepdefinations;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.paulhammant.ngwebdriver.NgWebDriver;

import factory.DriverFactory;
import factory.FormControlKaryakarta;
import factory.Login;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.KaryakartaDynamicForm;
import resources.Base;
import utils.KaryakaryaDataEntryFormControl;

public class WardKaryakarta {
	// public WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait, wait2;
	NgWebDriver ngDriver;
	WebDriver driver;
	// Ward Karyakarta Data Filter Data
	public String state;
	public String ULBType;
	public String administrativeDistrict;
	public String localBody;
	public String Ward;
	public String organisationUnit;
	public String organisationSubUnit;
	// Karyakarta Details
	public String name;
	public String fatherName;
	public String designation;
	public String hasSmartPhone;
	public String phoneNumber;
	public String primaryMemberId;
	public String age;
	public String gender;
	public String whatsApp;
	public String updatedStdCode;
	public String updatedLandlineNumber;
	public String updatedCategory;
	public String updatedCaste;
	public String updatedEmail;
	public String updatedDob;
	public String updatedFullAddress;
	public String updatedVillage;
	public String updatedTaluka;
	public String updatedDistrict;
	public String updatedPinCode;
	public String updatedEducation;
	public String updatedProfession;
	public String updatedBike;
	public String updatedCar;
	public String updatedVidhanSabhaWhereHeSheVotes;
	public String updatedBoothWhereHeSheVotes;
	public String updatedVoterId;
	public String updatedAadharNumber;
	public String updatedPannaNumber;
	public String updatedRationCardNumber;
	public String updatedFacebookProfile;
	public String updatedTwitterProfile;
	public String updatedLinkedinProfile;
	public String updatedInstagramProfile;
	public String updatedImage;
	public String updatedSalutation;
	public String updatedSubCaste;
	public String updatedQualification;
	public String updatedReligion;
	public String updatedActiveMemberId;
	public String updatedPartyZila;
	public String updatedPartyMandal;
	public String updatedBloodGroup;
	// Karyakarta_Edit_Details
	public String updatedName;
	public String updatedFatherName;
	public String updatedDesignation;
	public String updatedHasSmartPhone;
	public String updatedPhoneNumber;
	public String updatedPrimaryMemberId;
	public String updatedAge;
	public String updatedGender;
	public String updatedWhatsApp;
	public String stdCode;
	public String landlineNumber;
	public String category;
	public String caste;
	public String email;
	public String dob;
	public String fullAddress;
	public String village;
	public String taluka;
	public String district;
	public String pinCode;
	public String education;
	public String profession;
	public String bike;
	public String car;
	public String vidhanSabhaWhereHeSheVotes;
	public String boothWhereHeSheVotes;
	public String voterId;
	public String aadharNumber;
	public String pannaNumber;
	public String rationCardNumber;
	public String facebookProfile;
	public String twitterProfile;
	public String linkedinProfile;
	public String instagramProfile;
	public String image;
	public String salutation;
	public String subCaste;
	public String qualification;
	public String religion;
	public String activeMemberId;
	public String partyZila;
	public String partyMandal;
	public String bloodGroup;
	public String copiedEnteredName;
	public String copiedEnteredFather_Husband_Name;
	public String copiedSelectedDesignation;
	public String copiedHasSmartPhone;
	public String copiedPhoneNo;
	public String copiedPrimaryMember;
	public String copiedAge;
	public String copiedDob;
	public String copiedWhatsAppNumber;
	public String copiedStdCode;
	public String copiedLandLineNo;
	public String copiedFullAddress;
	public String copiedVillage;
	public String copiedTaluka_Tehsil;
	public String copiedSelectedDistrict;
	public String CopiedpinCode;
	public String copiedSelectedEducation;
	public String copiedSelectedProfession;
	public String copiedHasBike;
	public String copiedHasCar;
	public String copied_vidhanSabha_where_he_sheVotes;
	public String copiedBothWhereHeSheVotes;
	public String copiedVoterId;
	public String copiedAadhaarNumber;
	public String copiedPannaNumber;
	public String copiedRationCard;
	public String copiedFacebookValue;
	public String copiedTwitterProfile;
	public String copiedInstagramProfile;
	public String copiedLinkedInProfile;
	public String copiedSalutation;
	public String copiedBloodGroup;
	public String copiedSubCaste;
	public String copiedQualification;
	public String copiedReligion;
	public String copiedActiveMemberId;
	public String copiedSelectedPartyZilaId;
	public String copiedSelectedPartyMandalId;
	public String copiedSelectedCategory;
	public String copiedSelectedCaste;
	public String copiedEmail;
	public Base contextSteps;

	public static Logger log = LogManager.getLogger(WardKaryakarta.class.getName());

	@Given("^user logged in into the saral application$")
	public void user_logged_in_into_the_saral_application(DataTable login_table_ward)
			throws InterruptedException, IOException {

		// get driver
		driver = DriverFactory.getDriver();
		// driver.get("https://zila-staging.ccdms.in/");
		System.out.println("URL for ward");
		Map<String, String> map = login_table_ward.asMap(String.class, String.class);

		// -----contructor for setting login values-----------

		KaryakaryaDataEntryFormControl login_values = new KaryakaryaDataEntryFormControl(map.get("Email"),
				map.get("Password"), map.get("Otp"));

		Login.login_in_saral_application(login_values.getKaryakartaEmail(), login_values.getKaryakartaPassword(),
				login_values.getKaryakartaOtp());
		log.debug("user successfully came on the dashboard page");
	}

	@Then("^user click on sangathan data management card on dashboard$")
	public void user_click_on_sangathan_data_management_card_on_dashboard() throws InterruptedException {

		// Sangathan Data Entry
		driver = DriverFactory.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		WebElement SangathanDataEntryEle = driver.findElements(By.className("data-entry-card-titles")).get(0);
		wait.until(ExpectedConditions.elementToBeClickable(SangathanDataEntryEle)).click();
		log.debug("user click on sangathan data management card");
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

	}

	@And("^user click on add entry button for ward karyakarta$")
	public void user_click_on_add_entry_button_for_ward_karyakarta() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		js = (JavascriptExecutor) driver;
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		List<WebElement> addEntryElement = driver.findElements(By.xpath("//button/span[contains(text(),'Add Entry')]"));
		wait.until(ExpectedConditions.visibilityOf(addEntryElement.get(10)));
		js.executeScript("arguments[0].click();", addEntryElement.get(10));
		log.debug("user click on add entry button for ward karyakarta");
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

	}

	@And("^user select ward karyakarta data filter$")
	public void user_select_ward_karyakarta_data_filter(DataTable ward_karyakarta_filter_data)
			throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		Map<String, String> map = ward_karyakarta_filter_data.asMap(String.class, String.class);
		state = map.get("state");
		ULBType = map.get("ULB Type");
		administrativeDistrict = map.get("Administrative District");
		localBody = map.get("Local Body");
		Ward = map.get("Ward");
		organisationUnit = map.get("Organisation Unit");
		organisationSubUnit = map.get("Organisation Sub Unit");
		js = (JavascriptExecutor) driver;

		List<WebElement> ward_karyakarta_filter = driver.findElements(By.xpath("//div[@class='ng-value-container']"));
		// state
		ward_karyakarta_filter.get(0).click();

		WebElement selectState = driver.findElement(By.xpath("//div[contains(text(),'" + state + "')]"));
		wait.until(ExpectedConditions.visibilityOf(selectState)).click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// ULB Type
		// js.executeScript("arguments[0].click();", ward_karyakarta_filter.get(1));
		ward_karyakarta_filter.get(1).click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		WebElement selectLocalBodyType = driver.findElement(By.xpath("//div[contains(text(),'" + ULBType + "')]"));
		wait.until(ExpectedConditions.visibilityOf(selectLocalBodyType)).click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		// Administrative District
		// js.executeScript("arguments[0].click();", ward_karyakarta_filter.get(2));
		ward_karyakarta_filter.get(2).click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		WebElement selectAdministrativeDistrict = driver
				.findElement(By.xpath("//div[contains(text(),'" + administrativeDistrict + "')]"));
		wait.until(ExpectedConditions.visibilityOf(selectAdministrativeDistrict)).click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// Local Body
		// js.executeScript("arguments[0].click();", ward_karyakarta_filter.get(3));
		ward_karyakarta_filter.get(3).click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		WebElement selectLocalBody = driver.findElement(By.xpath("//div[contains(text(),'" + localBody + "')]"));
		wait.until(ExpectedConditions.visibilityOf(selectLocalBody)).click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// ward
		// js.executeScript("arguments[0].click();", ward_karyakarta_filter.get(4));
		ward_karyakarta_filter.get(4).click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		WebElement selectWard = driver.findElement(By.xpath("//div[contains(text(),'" + Ward + "')]"));
		System.out.println("WardDrop: " + selectWard);
		js.executeScript("arguments[0].click();", selectWard);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// Organisation Unin
		// js.executeScript("arguments[0].click();", ward_karyakarta_filter.get(5));
		ward_karyakarta_filter.get(5).click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		WebElement selectOrganisationUnit = driver
				.findElement(By.xpath("(//div[contains(text(),'" + organisationUnit + "')])[2]"));
		wait.until(ExpectedConditions.visibilityOf(selectOrganisationUnit)).click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// Organisation Sub Unit
		// js.executeScript("arguments[0].click();", ward_karyakarta_filter.get(6));
		ward_karyakarta_filter.get(6).click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		WebElement selectOrganisationSubUnit = driver
				.findElement(By.xpath("(//div[contains(text(),'" + organisationSubUnit + "')])[2]"));
		js.executeScript("arguments[0].click();", selectOrganisationSubUnit);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

	}

	@And("^user click on search button and verify ward karyakarta filter text$")
	public void user_click_on_search_button_and_verify_ward_karyakarta_filter_text() throws InterruptedException {
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

		String ward_karyakarta_filter_text = driver.findElement(By.xpath("//h6[@class='locations-list']")).getText();
		System.out.println(">>>>>>>ward_karyakarta_filter_text: " + ward_karyakarta_filter_text);
		String ward_karyakarta_filter_text_format = state + "   >   " + ULBType + "   >   " + administrativeDistrict
				+ "   >  " + localBody + "   >   " + Ward.replaceAll("\\s", "");

		System.out.println("-------ward_karyakarta_filter_text_format: " + ward_karyakarta_filter_text_format);
		Assert.assertEquals(ward_karyakarta_filter_text, ward_karyakarta_filter_text_format);

	}

	@And("^user clicks on enter more details$")
	public void user_clicks_on_enter_more_details() throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		js = (JavascriptExecutor) driver;
		WebElement extraDetailsEle = driver.findElement(By.className("mat-expansion-panel-header-description"));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(extraDetailsEle));
		js.executeScript("arguments[0].click();", extraDetailsEle);
		Thread.sleep(1000);

	}

	@Then("^user input primary details in the data entry form$")
	public void user_input_primary_details_in_the_data_entry_form(DataTable Karyakarta_primary_details)
			throws InterruptedException {
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		Map<String, String> map = Karyakarta_primary_details.asMap(String.class, String.class);
		name = map.get("Name");
		fatherName = map.get("Father Name");
		designation = map.get("Designation");
		hasSmartPhone = map.get("Has Smartphone");
		phoneNumber = map.get("Phone Number");
		primaryMemberId = map.get("Primary Member ID");
		age = map.get("Age");

		// FormControlKaryakarta FormControlKaryakarta = new FormControlKaryakarta();
		// Name
		FormControlKaryakarta.enterKaryakartaName(name);

		// Father and Husband Name
		FormControlKaryakarta.enterKaryakartaRelationName(fatherName);

		// Designation
		FormControlKaryakarta.clickOnkaryakartaDesignation();

		// Select Designation
		FormControlKaryakarta.selectKaryakartaDesignation(designation);

		// hasSmartPhone
		FormControlKaryakarta.clickOnKaryakartaHasSmartPhone();

		// select hasSmartPhone
		FormControlKaryakarta.selectKaryakartaDesignation(hasSmartPhone);

		// Primary Member
		FormControlKaryakarta.enterKaryakartaPrimaryMemberId(primaryMemberId);
		// Age
		FormControlKaryakarta.enterKaryakartaAge(age);

		// Validation for phone no.
		apply_validation_in_phone_number();
		// phone number
		FormControlKaryakarta.enterKaryakartaPhoneNumber(phoneNumber);

	}

	@Then("^user input below details in data entry form with input fields validation$")
	public void enter_karyakarta_details_in_the_form(DataTable karyakarta_details) throws InterruptedException {
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		Map<String, String> map = karyakarta_details.asMap(String.class, String.class);
		name = map.get("Name");
		fatherName = map.get("Father Name");
		designation = map.get("Designation");
		hasSmartPhone = map.get("Has Smartphone");
		phoneNumber = map.get("Phone Number");
		primaryMemberId = map.get("Primary Member ID");
		age = map.get("Age");
		gender = map.get("Gender");
		whatsApp = map.get("WhatsApp Number");
		stdCode = map.get("STD Code");
		landlineNumber = map.get("Landline Number");
		category = map.get("Category");
		caste = map.get("Caste");
		email = map.get("Email");
		dob = map.get("Dob");
		fullAddress = map.get("Full Address");
		village = map.get("Village");
		taluka = map.get("Taluka");
		district = map.get("District");
		pinCode = map.get("Pin Code");
		education = map.get("Education");
		profession = map.get("Profession");
		bike = map.get("Bike");
		car = map.get("Car");
		vidhanSabhaWhereHeSheVotes = map.get("Vidhan Sabha where he/she votes");
		boothWhereHeSheVotes = map.get("Booth where he/she votes");
		voterId = map.get("Voter Id");
		aadharNumber = map.get("Aadhaar Number");
		pannaNumber = map.get("Panna Number");
		rationCardNumber = map.get("Ration Card Number");
		facebookProfile = map.get("Facebook Profile");
		twitterProfile = map.get("Twitter Profile");
		instagramProfile = map.get("Intagram Profile");
		linkedinProfile = map.get("Linkedin Profile");
		image = map.get("Image");
		salutation = map.get("Salutation");
		subCaste = map.get("Sub Caste");
		qualification = map.get("Qualification");
		religion = map.get("Religion");
		activeMemberId = map.get("Active Member Id");
		partyZila = map.get("Party Zila");
		partyMandal = map.get("Party Mandal");
		bloodGroup = map.get("Blood Group");

		// FormControlKaryakarta FormControlKaryakarta = new FormControlKaryakarta();
		// Name
		FormControlKaryakarta.enterKaryakartaName(name);

		// Father and Husband Name
		FormControlKaryakarta.enterKaryakartaRelationName(fatherName);

		// Designation
		FormControlKaryakarta.clickOnkaryakartaDesignation();

		// Select Designation
		FormControlKaryakarta.selectKaryakartaDesignation(designation);

		// hasSmartPhone
		FormControlKaryakarta.clickOnKaryakartaHasSmartPhone();

		// select hasSmartPhone
		FormControlKaryakarta.selectKaryakartaDesignation(hasSmartPhone);

		// Primary Member
		FormControlKaryakarta.enterKaryakartaPrimaryMemberId(primaryMemberId);
		// Age
		FormControlKaryakarta.enterKaryakartaAge(age);
		int ageInt = Integer.parseInt(age);
		// Dob
		String calculatedDOB = dob_calculation_based_on_age_input(ageInt);
		WebElement dobEle = driver.findElement(By.xpath("//input[@data-placeholder='Dob']"));
		String copiedDobAfterEnteredAge = dobEle.getAttribute("value");
		Assert.assertEquals(calculatedDOB, copiedDobAfterEnteredAge);
		dobEle.clear();
		apply_validation_in_dob();
		String day_and_month_updated_dob = set_day_and_month_in_dob(ageInt);
		System.out.println("day_and_month_updated_dob= " + day_and_month_updated_dob);
		// AgeEle.clear();
		// AgeEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		// AgeEle.sendKeys(age);
		dobEle.sendKeys(day_and_month_updated_dob);
		String copiedDob = dobEle.getAttribute("value");
		Assert.assertEquals(day_and_month_updated_dob, copiedDob);

		// select gender
		String selectGender;
		if (gender.equals("Male") || gender.equals("Female")) {
			selectGender = gender.toLowerCase();
		} else {
			// make Other to others
			selectGender = gender.toLowerCase() + "s";
		}
		WebElement genderEle = driver.findElement(By.xpath("//input[@value='" + selectGender + "']"));
		WebElement genderLevelTxt = driver.findElement(By.xpath("//label[contains(text(),'Gender')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", genderLevelTxt);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", genderEle);
		// Blood Group
		WebElement BloodGroupEle = driver.findElement(By.xpath("//input[@data-placeholder='Blood Group']"));
		BloodGroupEle.sendKeys(bloodGroup);

		// Validation for phone no.
		apply_validation_in_phone_number();
		// phone number
		FormControlKaryakarta.enterKaryakartaPhoneNumber(phoneNumber);
		// STD Code
		WebElement stdCodeEle = driver.findElement(By.xpath("//input[@placeholder='STD Code']"));
		stdCodeEle.sendKeys(stdCode);
		// WhatsApp
		WebElement whatsAppEle = driver.findElement(By.xpath("//input[@placeholder='WhatsApp Number']"));
		// Validation for WhatsApp No.
		apply_validation_in_whatsapp_number();
		whatsAppEle.sendKeys(whatsApp);
		// Landline Number
		WebElement stdLandlineEle = driver.findElement(By.xpath("//input[@placeholder='Landline Number']"));
		stdLandlineEle.sendKeys(landlineNumber);
		// Category
		List<WebElement> selectCategoryEle = driver.findElements(By.xpath("//div[contains(text(),'Select Category')]"));

		// Caste
		List<WebElement> CasteEle = driver.findElements(By.xpath("//div[contains(text(),'Caste')]"));
		// Validation in category and caste
		apply_validation_in_category_and_caste();

		// click on select Category
		selectCategoryEle.get(0).click();
		// categoryValue = addDatadriven.get(12);
		WebElement categoryValueEle = driver.findElement(By.xpath("//div//span[contains(text(),'" + category + "')]"));
		js.executeScript("arguments[0].click();", categoryValueEle);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		// Thread.sleep(2000);

		List<WebElement> casteOverlayEle = driver.findElements(By.xpath("//div[@class='overlay ng-star-inserted']"));
		while (casteOverlayEle.size() > 0) {
			System.out.println("caste Overlay 1 ........");
			casteOverlayEle = driver.findElements(By.xpath("//div[@class='overlay ng-star-inserted']"));
			Thread.sleep(1000);
		}
		System.out.println("--------------- overlay gone----------------");
		Thread.sleep(2000);

		// click on Caste
		WebElement CasteEleAfterwait = wait.until(ExpectedConditions.elementToBeClickable(CasteEle.get(0)));
		CasteEleAfterwait.click();

		// casteValue = addDatadriven.get(13);
		WebElement CasteValueEle = driver.findElement(By.xpath("//div//span[contains(text(),'" + caste + "')]"));
		js.executeScript("arguments[0].click();", CasteValueEle);

		// Email
		WebElement emailEle = driver.findElement(By.xpath("//input[@placeholder='Email']"));
		// validation in email
		apply_validation_in_email();
		emailEle.sendKeys(email);

		// Full Address
		WebElement fullAddressEle = driver.findElement(By.xpath("//input[@placeholder='Full Address']"));
		fullAddressEle.sendKeys(fullAddress);

		// Village
		WebElement villageEle = driver.findElement(By.xpath("//input[@placeholder='Village/Ward']"));
		villageEle.sendKeys(village);

		// Taluka/Tehsil
		WebElement Taluka_Tehsil_Ele = driver.findElement(By.xpath("//input[contains(@placeholder, 'Taluka')]"));
		Taluka_Tehsil_Ele.sendKeys(taluka);

		// District
		WebElement selectDistrictEle = driver.findElement(By.xpath("//div[contains(text(),'Select District')]"));
		selectDistrictEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// Select District
		WebElement DistrictNameEle = driver.findElement(By.xpath("//div//span[contains(text(),'" + district + "')]"));
		js.executeScript("arguments[0].click();", DistrictNameEle);
		// Pincode
		WebElement pincodeEle = driver.findElement(By.xpath("//input[@placeholder='Pin Code']"));
		pincodeEle.sendKeys(pinCode);

		// Education
		WebElement selectEducationEle = driver.findElement(By.xpath("//div[contains(text(),'Select Education')]"));
		selectEducationEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// Select Education
		WebElement EducationValueEle = driver
				.findElement(By.xpath("//div//span[contains(text(),'" + education + "')]"));
		js.executeScript("arguments[0].click();", EducationValueEle);
		// click on Select Profession
		WebElement selectProfessionEle = driver.findElement(By.xpath("//div[contains(text(),'Select Profession')]"));
		selectProfessionEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// Select Profession
		WebElement ProfessionValueEle = driver
				.findElement(By.xpath("//div//span[contains(text(),'" + profession + "')]"));
		js.executeScript("arguments[0].click();", ProfessionValueEle);

		// click on Bike
		WebElement BikeEle = driver.findElement(By.xpath("//div[contains(text(),'Bike')]"));
		BikeEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(1000);
		WebElement bikeValueEle = null;
		// Select yes or no for bike
		if (bike.equals("Yes")) {
			bikeValueEle = driver.findElements(By.className("ng-option-label")).get(0);
		} else {
			bikeValueEle = driver.findElements(By.className("ng-option-label")).get(1);
		}
		js.executeScript("arguments[0].click();", bikeValueEle);

		// click on Car
		WebElement CarEle = driver.findElement(By.xpath("//div[contains(text(),'Car')]"));
		CarEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(1000);
		// Select yes or no for car
		WebElement carValueEle = null;
		if (car.equals("Yes")) {
			carValueEle = driver.findElements(By.className("ng-option-label")).get(0);
		} else {
			carValueEle = driver.findElements(By.className("ng-option-label")).get(1);
		}
		js.executeScript("arguments[0].click();", carValueEle);

		// click on Vidhan Sabha where He/She Votes
		WebElement VidhanSabhawhereHe_SheVotesEle = driver
				.findElement(By.xpath("//div[contains(text(),'Vidhan Sabha where He/She Votes')]"));
		VidhanSabhawhereHe_SheVotesEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// Select Vidhan Sabha
		WebElement VidhanSabhawhereHe_SheVotesValueEle = driver
				.findElement(By.xpath("//div//span[contains(text(),'" + vidhanSabhaWhereHeSheVotes + "')]"));
		js.executeScript("arguments[0].click();", VidhanSabhawhereHe_SheVotesValueEle);

		// Booth where He/She Votes
		WebElement BoothwhereHe_SheVotesValueEle = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'Booth where He/She Votes')]"));
		BoothwhereHe_SheVotesValueEle.clear();
		BoothwhereHe_SheVotesValueEle.sendKeys(boothWhereHeSheVotes);

		// Voter Id
		WebElement voterIdValueEle = driver.findElement(By.xpath("//input[contains(@placeholder, 'ex. UTC026351')]"));
		voterIdValueEle.sendKeys(voterId);

		// Aadhaar Number
		WebElement AadhaarNumberEle = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'ex. 765478961243')]"));
		// Validation AadhaarNumber.
		apply_validation_in_aadhar_number();
		AadhaarNumberEle.sendKeys(aadharNumber);

		// Panna Number
		WebElement PannaNumberEle = driver.findElement(By.xpath("//input[contains(@placeholder, 'Panna Number')]"));
		// Panna Number Validation
		apply_validation_in_panna_number();
		PannaNumberEle.sendKeys(pannaNumber);

		// Ration Card Number
		WebElement RationCardNumberEle = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'Ration Card Number')]"));
		RationCardNumberEle.sendKeys(rationCardNumber);

		// FacebookProfile
		WebElement FacebookProfileEle = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'www.fb.com/username')]"));
		FacebookProfileEle.sendKeys(facebookProfile);

		// TwitterProfile
		WebElement TwitterProfileEle = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'www.twitter.com/username')]"));
		TwitterProfileEle.sendKeys(twitterProfile);

		// InstagramProfile
		WebElement InstagramProfileEle = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'www.instagram.com/username')]"));
		InstagramProfileEle.sendKeys(instagramProfile);

		// LinkedInProfile
		WebElement LinkedInProfileEle = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'www.linkedin.com/username')]"));
		LinkedInProfileEle.sendKeys(linkedinProfile);

		// Photo
		WebElement photoEle = driver.findElement(By.xpath("//input[@type='file']"));
		image = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\image1.jpg";
		photoEle.sendKeys(image);

		// click on Salutation
		WebElement SalutationEle = driver.findElements(By.className("mat-select-placeholder")).get(1);
		SalutationEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// Select SalutationEle
		WebElement salutationValueEle = driver
				.findElement(By.xpath("//mat-option//span[contains(text(),'" + salutation + "')]"));
		js.executeScript("arguments[0].click();", salutationValueEle);

		// Sub Caste
		WebElement SubCasteEle = driver.findElement(By.xpath("//input[contains(@placeholder, 'Sub caste')]"));
		SubCasteEle.sendKeys(subCaste);

		// Qualification
		WebElement QualificationEle = driver.findElement(By.xpath("//input[contains(@placeholder, 'Qualification')]"));
		QualificationEle.sendKeys(qualification);

		// Religion
		WebElement ReligionEle = driver.findElements(By.className("mat-select-placeholder")).get(1);
		ReligionEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// Select Religion
		WebElement ReligionEleValueEle = driver
				.findElement(By.xpath("//mat-option//span[contains(text(),'" + religion + "')]"));
		js.executeScript("arguments[0].click();", ReligionEleValueEle);

		// Active Member Id
		WebElement ActiveMemberIdValueEle = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'Active Member Id')]"));
		ActiveMemberIdValueEle.sendKeys(activeMemberId);

		// Party Zila and Party Mandal
		apply_validation_in_party_zila_and_mandal();

		// click Select Party Zila Id
		WebElement SelectPartyZilaIdEle = driver.findElement(By.xpath("//div[contains(text(),'Select Party Zila')]"));
		WebElement SelectPartyMandalEle = driver.findElement(By.xpath("//div[contains(text(),'Select Party Mandal')]"));
		SelectPartyZilaIdEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// Select Party Zila Id
		WebElement PartyZilaIdValueEle = driver
				.findElement(By.xpath("//div//span[contains(text(),'" + partyZila + "')]"));
		wait.until(ExpectedConditions.visibilityOf(PartyZilaIdValueEle));
		js.executeScript("arguments[0].click();", PartyZilaIdValueEle);

		// click Select Party Mandal

		List<WebElement> partyMandalOverlayEle = driver
				.findElements(By.xpath("//div[@class='overlay ng-star-inserted']"));
		while (partyMandalOverlayEle.size() > 0) {
			System.out.println("partyMandal Overlay 1 ........");
			partyMandalOverlayEle = driver.findElements(By.xpath("//div[@class='overlay ng-star-inserted']"));
			Thread.sleep(1000);
		}

		System.out.println("--- overlay gone of party Mandal-------");

		SelectPartyMandalEle = driver.findElement(By.xpath("//div[contains(text(),'Select Party Mandal')]"));
		wait.until(ExpectedConditions.elementToBeClickable(SelectPartyMandalEle)).click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// Select Party Mandal
		WebElement enterPartyMandalEle = driver.findElement(with(By.tagName("input")).below(SelectPartyMandalEle));
		enterPartyMandalEle.sendKeys(partyMandal);
		enterPartyMandalEle.sendKeys(Keys.ENTER);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

	}

	@And("^user click on add button$")
	public void user_click_on_add_button() throws InterruptedException {

		// click on Add button
		WebElement addButtonEle = driver.findElement(By.xpath("//button//span[contains(text(),'Add')]"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", addButtonEle);
		Thread.sleep(5000);

	}

	public void user_verify_added_entry_in_karyakarta_dynamic_table() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		js = (JavascriptExecutor) driver;
		Thread.sleep(3000);

		// table column list
		List<WebElement> columnHeaderNames = driver.findElements(By.xpath("//table//thead/tr/th"));
		// table first row list
		List<WebElement> firstRowValueList = driver.findElements(By.xpath("//table//tbody/tr[1]/td"));
		for (int c = 1; c < columnHeaderNames.size(); c++) {
			String columnHeaderNamesText = columnHeaderNames.get(c).getText();
			System.out.println("columnHeaderNamesText: " + columnHeaderNamesText);
			if (columnHeaderNamesText.contains("Name")) {
				String nameTableValue = firstRowValueList.get(c).getText();
				System.out.println("nameTableValue: " + nameTableValue);
				Assert.assertEquals(nameTableValue, name);
			}
			if (columnHeaderNamesText.contains("Father's/Husband's Name")) {
				String relationTableValue = firstRowValueList.get(c).getText();
				System.out.println("nameTableValue: " + relationTableValue);
				Assert.assertEquals(relationTableValue, fatherName);
			}
			if (columnHeaderNamesText.contains("Designation")) {
				String designationTableValue = firstRowValueList.get(c).getText();
				System.out.println("nameTableValue: " + designationTableValue);
				Assert.assertEquals(designationTableValue, designation);
			}
		}

	}

	@And("^user click on edit button for recently added entry$")
	public void user_click_on_edit_button_for_recently_added_entry() throws InterruptedException {
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(5000);
		get_Karyakarta_Data_To_Edit(phoneNumber);
	}

	@And("^user verify primary details in the data entry form$")
	public void user_verify_primary_details_in_the_data_entry_form() throws InterruptedException {
		js = (JavascriptExecutor) driver;
		// Name
		copiedEnteredName = driver.findElement(By.xpath("//input[@placeholder='Name']")).getAttribute("value");
		Assert.assertEquals(copiedEnteredName.toUpperCase(), name.toUpperCase());

		// Father's/Husband's Name
		copiedEnteredFather_Husband_Name = driver.findElement(By.xpath("//input[contains(@placeholder, 'Father')]"))
				.getAttribute("value");
		Assert.assertEquals(fatherName.toUpperCase(), copiedEnteredFather_Husband_Name.toUpperCase());

		// Designation
		WebElement SelectDesignationEle = driver.findElement(By.xpath("//div[contains(text(),'Select Designation')]"));
		copiedSelectedDesignation = driver.findElement(with(By.className("ng-value-label")).below(SelectDesignationEle))
				.getText();
		Assert.assertEquals(copiedSelectedDesignation, designation);

		// Has SmartPhone
		WebElement hasSmartPhoneEle = driver.findElement(By.xpath("//div[contains(text(),'Has Smartphone')]"));
		copiedHasSmartPhone = driver.findElement(with(By.className("ng-value-label")).below(hasSmartPhoneEle))
				.getText();
		Assert.assertEquals(copiedHasSmartPhone, hasSmartPhone);

		// Phone Number
		copiedPhoneNo = driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).getAttribute("value");
		Assert.assertEquals(copiedPhoneNo, phoneNumber);

		// Primary Member
		copiedPrimaryMember = driver.findElement(By.xpath("//input[@placeholder='Primary Member Id']"))
				.getAttribute("value");
		Assert.assertEquals(copiedPrimaryMember, primaryMemberId);

		// Age
		copiedAge = driver.findElement(By.xpath("//input[@placeholder='Age']")).getAttribute("value");
		Assert.assertEquals(copiedAge, age);

		// click on cancel button
		WebElement cancelButtonEle = driver.findElement(By.xpath("//span[contains(.,'Cancel')]"));
		js.executeScript("arguments[0].click();", cancelButtonEle);

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
	}

	@And("^user verify all the added data$")
	public void user_verify_all_the_added_data() throws InterruptedException {
		js = (JavascriptExecutor) driver;
		// get all the added data.
		user_clicks_on_enter_more_details();

		// Name
		copiedEnteredName = driver.findElement(By.xpath("//input[@placeholder='Name']")).getAttribute("value");
		Assert.assertEquals(copiedEnteredName.toUpperCase(), name.toUpperCase());

		// Father's/Husband's Name
		copiedEnteredFather_Husband_Name = driver.findElement(By.xpath("//input[contains(@placeholder, 'Father')]"))
				.getAttribute("value");
		Assert.assertEquals(fatherName.toUpperCase(), copiedEnteredFather_Husband_Name.toUpperCase());

		// Designation
		WebElement SelectDesignationEle = driver.findElement(By.xpath("//div[contains(text(),'Select Designation')]"));
		copiedSelectedDesignation = driver.findElement(with(By.className("ng-value-label")).below(SelectDesignationEle))
				.getText();
		Assert.assertEquals(copiedSelectedDesignation, designation);

		// Has SmartPhone
		WebElement hasSmartPhoneEle = driver.findElement(By.xpath("//div[contains(text(),'Has Smartphone')]"));
		copiedHasSmartPhone = driver.findElement(with(By.className("ng-value-label")).below(hasSmartPhoneEle))
				.getText();
		Assert.assertEquals(copiedHasSmartPhone, hasSmartPhone);

		// Phone Number
		copiedPhoneNo = driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).getAttribute("value");
		Assert.assertEquals(copiedPhoneNo, phoneNumber);

		// Primary Member
		copiedPrimaryMember = driver.findElement(By.xpath("//input[@placeholder='Primary Member Id']"))
				.getAttribute("value");
		Assert.assertEquals(copiedPrimaryMember, primaryMemberId);

		// Age
		copiedAge = driver.findElement(By.xpath("//input[@placeholder='Age']")).getAttribute("value");
		Assert.assertEquals(copiedAge, age);
		int ageInt = Integer.parseInt(age);
		// Dob
		WebElement dobEle = driver.findElement(By.xpath("//input[@data-placeholder='Dob']"));
		String day_and_month_updated_dob = set_day_and_month_in_dob(ageInt);
		System.out.println("day_and_month_updated_dob= " + day_and_month_updated_dob);
		copiedDob = dobEle.getAttribute("value");
		Assert.assertEquals(day_and_month_updated_dob, copiedDob);

		// Blood Group
		WebElement BloodGroupEle = driver.findElement(By.xpath("//input[@data-placeholder='Blood Group']"));
		copiedBloodGroup = BloodGroupEle.getAttribute("value");
		Assert.assertEquals(copiedBloodGroup, bloodGroup);

		// Gender
		String genderFormating = gender.toLowerCase();
		if (genderFormating.equals("other")) {
			genderFormating = genderFormating + "s";
		}
		System.out.println("genderFormating :" + genderFormating);

		String classOfselectedGender = driver
				.findElement(By.xpath("//mat-radio-button[@value='" + genderFormating + "']")).getAttribute("class");
		System.out.println("classOfselectedGender :" + classOfselectedGender);
		Assert.assertEquals(classOfselectedGender.contains("mat-radio-checked"), true,
				"seems like gender is not selected");

		// WhatsApp
		copiedWhatsAppNumber = driver.findElement(By.xpath("//input[@placeholder='WhatsApp Number']"))
				.getAttribute("value");
		Assert.assertEquals(copiedWhatsAppNumber, whatsApp);

		// STD Code
		copiedStdCode = driver.findElement(By.xpath("//input[@placeholder='STD Code']")).getAttribute("value");
		Assert.assertEquals(copiedStdCode, stdCode);

		// Landline Number
		copiedLandLineNo = driver.findElement(By.xpath("//input[@placeholder='Landline Number']"))
				.getAttribute("value");
		Assert.assertEquals(copiedLandLineNo, landlineNumber);

		// Select Category
		WebElement SelectCategoryEle = driver.findElement(By.xpath("//div[contains(text(),'Select Category')]"));
		copiedSelectedCategory = driver.findElement(with(By.className("ng-value-label")).below(SelectCategoryEle))
				.getText();
		Assert.assertEquals(copiedSelectedCategory, category);

		// Caste
		WebElement SelectCasteEle = driver.findElement(By.xpath("//div[contains(text(),'Caste')]"));
		copiedSelectedCaste = driver.findElement(with(By.className("ng-value-label")).below(SelectCasteEle)).getText();
		Assert.assertEquals(copiedSelectedCaste, caste);

		// Email
		copiedEmail = driver.findElement(By.xpath("//input[@placeholder='Email']")).getAttribute("value");
		Assert.assertEquals(copiedEmail, email);

		// Full Address
		copiedFullAddress = driver.findElement(By.xpath("//input[@placeholder='Full Address']")).getAttribute("value");
		Assert.assertEquals(copiedFullAddress, fullAddress);

		// Village
		copiedVillage = driver.findElement(By.xpath("//input[@placeholder='Village/Ward']")).getAttribute("value");
		Assert.assertEquals(copiedVillage, village);

		// Taluka/Tehsil
		copiedTaluka_Tehsil = driver.findElement(By.xpath("//input[contains(@placeholder, 'Taluka')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedTaluka_Tehsil, taluka);

		// select district
		WebElement SelectDistrictEle = driver.findElement(By.xpath("//div[contains(text(),'Select District')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", SelectDistrictEle);
		copiedSelectedDistrict = driver.findElement(with(By.className("ng-value-label")).below(SelectDistrictEle))
				.getText();
		Assert.assertEquals(copiedSelectedDistrict, district);

		// Pin Code
		CopiedpinCode = driver.findElement(By.xpath("//input[@placeholder='Pin Code']")).getAttribute("value");
		Assert.assertEquals(CopiedpinCode, pinCode);

		// Select Education
		WebElement SelectEducationEle = driver.findElement(By.xpath("//div[contains(text(),'Select Education')]"));
		copiedSelectedEducation = driver.findElement(with(By.className("ng-value-label")).below(SelectEducationEle))
				.getText();
		Assert.assertEquals(copiedSelectedEducation, education);

		// Select Profession
		WebElement SelectProfessionEle = driver.findElement(By.xpath("//div[contains(text(),'Select Profession')]"));
		copiedSelectedProfession = driver.findElement(with(By.className("ng-value-label")).below(SelectProfessionEle))
				.getText();
		Assert.assertEquals(copiedSelectedProfession, profession);

		// hasBike
		WebElement HasBikeEle = driver.findElement(By.xpath("//div[contains(text(),'Bike')]"));
		copiedHasBike = driver.findElement(with(By.className("ng-value-label")).below(HasBikeEle)).getText();
		Assert.assertEquals(copiedHasBike, bike);

		// hasCar
		WebElement HasCarEle = driver.findElement(By.xpath("//div[contains(text(),'Car')]"));
		copiedHasCar = driver.findElement(with(By.className("ng-value-label")).below(HasCarEle)).getText();
		Assert.assertEquals(copiedHasCar, car);

		// vidhanSabha where he/she votes
		WebElement vidhanSabha_where_he_sheVotesEle = driver
				.findElement(By.xpath("//div[contains(text(),'Vidhan Sabha where He/She Votes')]"));
		copied_vidhanSabha_where_he_sheVotes = driver
				.findElement(with(By.className("ng-value-label")).below(vidhanSabha_where_he_sheVotesEle)).getText();

		// separating number and "-" from copied_vidhanSabha_where_he_sheVotes
		// String[] vidhansabhaNameArr =
		// copied_vidhanSabha_where_he_sheVotes.split("-");
		Assert.assertEquals(copied_vidhanSabha_where_he_sheVotes, vidhanSabhaWhereHeSheVotes);

		// Booth where He/She Votes
		copiedBothWhereHeSheVotes = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'Booth where He/She Votes')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedBothWhereHeSheVotes, boothWhereHeSheVotes);

		// Voter Id
		copiedVoterId = driver.findElement(By.xpath("//input[contains(@placeholder, 'ex. UTC026351')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedVoterId, voterId);

		// Aadhaar Number
		copiedAadhaarNumber = driver.findElement(By.xpath("//input[contains(@placeholder, 'ex. 765478961243')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedAadhaarNumber, aadharNumber);

		// Panna Number
		copiedPannaNumber = driver.findElement(By.xpath("//input[contains(@placeholder, 'Panna Number')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedPannaNumber, pannaNumber);

		// Ration Card
		copiedRationCard = driver.findElement(By.xpath("//input[contains(@placeholder, 'Ration Card Number')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedRationCard, rationCardNumber);

		// Facebook
		copiedFacebookValue = driver.findElement(By.xpath("//input[contains(@placeholder, 'www.fb.com/username')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedFacebookValue, facebookProfile);

		// TwitterProfile
		copiedTwitterProfile = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'www.twitter.com/username')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedTwitterProfile, twitterProfile);

		// InstagramProfile
		copiedInstagramProfile = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'www.instagram.com/username')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedInstagramProfile, instagramProfile);

		// LinkedInProfile
		copiedLinkedInProfile = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'www.linkedin.com/username')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedLinkedInProfile, linkedinProfile);

		// Salutation
		copiedSalutation = driver.findElements(By.className("mat-select-value-text")).get(0).getText();
		Assert.assertEquals(copiedSalutation, salutation);

		// Sub Caste
		copiedSubCaste = driver.findElement(By.xpath("//input[contains(@placeholder, 'Sub caste')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedSubCaste, subCaste);

		// Qualification
		copiedQualification = driver.findElement(By.xpath("//input[contains(@placeholder, 'Qualification')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedQualification, qualification);

		// Religion
		copiedReligion = driver.findElements(By.className("mat-select-value-text")).get(1).getText();
		Assert.assertEquals(copiedReligion, religion);

		// Active Member Id
		copiedActiveMemberId = driver.findElement(By.xpath("//input[contains(@placeholder, 'Active Member Id')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedActiveMemberId, activeMemberId);

		// Select Party Zila Id
		WebElement SelectPartyZilaIdEle = driver.findElement(By.xpath("//div[contains(text(),'Select Party Zila')]"));
		copiedSelectedPartyZilaId = driver.findElement(with(By.className("ng-value-label")).below(SelectPartyZilaIdEle))
				.getText();
		Assert.assertEquals(copiedSelectedPartyZilaId, partyZila);

		// Select Party Mandal
		WebElement SelectPartyMandalEle = driver.findElement(By.xpath("//div[contains(text(),'Select Party Mandal')]"));
		copiedSelectedPartyMandalId = driver
				.findElement(with(By.className("ng-value-label")).below(SelectPartyMandalEle)).getText();
		Assert.assertEquals(copiedSelectedPartyMandalId, partyMandal);

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

		// click on cancel button
		WebElement cancelButtonEle = driver.findElement(By.xpath("//span[contains(.,'Cancel')]"));
		js.executeScript("arguments[0].click();", cancelButtonEle);

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
	}

	@When("^user enter data with duplicate phone which is already exist on given data level, unit, and subunit$")
	public void user_enter_data_with_duplicate_phone_which_is_already_exist_on_given_data_level_unit_and_subunit()
			throws InterruptedException {
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		js = (JavascriptExecutor) driver;
		// primary fields
		// Name
		FormControlKaryakarta.enterKaryakartaName(name);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

		// Father and Husband Name
		FormControlKaryakarta.enterKaryakartaRelationName(fatherName);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

		// Designation
		FormControlKaryakarta.clickOnkaryakartaDesignation();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

		// Select Designation
		FormControlKaryakarta.selectKaryakartaDesignation(designation);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

		// phone number
		FormControlKaryakarta.enterKaryakartaPhoneNumber(phoneNumber);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

		user_click_on_add_button();

		// if person with duplicate phone number exists on same unit and sub unit and on
		// same location.
		WebElement dialogForDuplicatePerson = driver.findElement(By.xpath("//mat-dialog-container"));
		wait.until(ExpectedConditions.visibilityOf(dialogForDuplicatePerson));
		WebElement textInDialogEle = driver
				.findElement(By.xpath("//mat-dialog-container//div[@class='mat-dialog-title']"));
		String textInDialog = textInDialogEle.getText();
		Assert.assertEquals(
				"We can not create an entry with given details because a person can not hold two designations at the same organizational level & unit.",
				textInDialog);

		WebElement cancelDialogButtonEle = driver.findElement(By.xpath("//span[contains(.,'Cancel')]"));
		js.executeScript("arguments[0].click();", cancelDialogButtonEle);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

	}

	@And("^user enter data with duplicate phone number which is already exist on different data level , unit and subunit$")
	public void user_enter_data_with_duplicate_phone_number_which_is_already_exist_on_different_data_level_unit_and_subunit(
			DataTable duplicate_Phone) throws InterruptedException {
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		js = (JavascriptExecutor) driver;

		// get phone number from which karyakarta already exists on diffrent location
		Map<String, String> map = duplicate_Phone.asMap(String.class, String.class);
		String duplicatePhoneNumber = map.get("Duplicate Phone Number");

		// primary fields
		// Name
		FormControlKaryakarta.enterKaryakartaName(name);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

		// Father and Husband Name
		FormControlKaryakarta.enterKaryakartaRelationName(fatherName);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

		// Designation
		FormControlKaryakarta.clickOnkaryakartaDesignation();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

		// Select Designation
		FormControlKaryakarta.selectKaryakartaDesignation(designation);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

		// phone number
		FormControlKaryakarta.enterKaryakartaPhoneNumber(duplicatePhoneNumber);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

		user_click_on_add_button();
		// if user exists on different data level unit and sub unit
		WebElement dialogForDuplicatePerson = driver.findElement(By.xpath("//mat-dialog-container"));
		wait.until(ExpectedConditions.visibilityOf(dialogForDuplicatePerson));
		WebElement textInDialogEle = driver
				.findElement(By.xpath("//mat-dialog-container//div[@class='mat-dialog-title']"));
		String textInDialog = textInDialogEle.getText();
		System.out.println("textInDialog:" + textInDialog);
		// Assert.assertEquals(false, textInDialog);
		// cancel dialog
		WebElement cancelDialogButtonEle = driver.findElement(By.xpath("//span[contains(.,'Cancel')]"));
		js.executeScript("arguments[0].click();", cancelDialogButtonEle);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

	}

	@Then("^user edit primary details in the data entry form$")
	public void user_edit_primary_details_in_the_data_entry_form(DataTable Karyakarta_Primary_Edit_Details)
			throws InterruptedException {

		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		Map<String, String> map = Karyakarta_Primary_Edit_Details.asMap(String.class, String.class);
		updatedName = map.get("Name");
		updatedFatherName = map.get("Father Name");
		updatedDesignation = map.get("Designation");
		updatedHasSmartPhone = map.get("Has Smartphone");
		updatedPhoneNumber = map.get("Phone Number");
		updatedPrimaryMemberId = map.get("Primary Member ID");
		updatedAge = map.get("Age");

		// Karyakarta_Edit_Details fill into the dynamic form
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

		WebElement actionEle = driver.findElements(By.xpath("//mat-icon[contains(.,'more_vert')]")).get(0);
		WebElement actioneleAfterClickable = wait.until(ExpectedConditions.elementToBeClickable(actionEle));
		js.executeScript("arguments[0].scrollIntoView(true);", actioneleAfterClickable);
		Thread.sleep(1000);
		// click on action from 1st row
		js.executeScript("arguments[0].click();", actionEle);
		Thread.sleep(1000);
		// click on Edit option
		driver.findElement(By.xpath("//span[contains(.,'Edit')]")).click();

		Thread.sleep(1000);
		// ------If you want to enter extra details please use this section.------
		WebElement extraDetailsEle = driver.findElement(By.className("mat-expansion-panel-header-description"));
		js.executeScript("arguments[0].scrollIntoView(true);", extraDetailsEle);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", extraDetailsEle);

		// Name
		WebElement nameEle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Name']")));
		nameEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);

		nameEle.sendKeys(updatedName);

		// Father's/Husband's Name
		WebElement fatherEle = driver.findElement(By.xpath("//input[contains(@placeholder, 'Father')]"));
		fatherEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		fatherEle.sendKeys(updatedFatherName);

		// select Designation
		driver.findElement(By.xpath("//div[contains(text(),'Select Designation')]")).click();
		WebElement selectDesignationNameEle = driver.findElement(
				By.xpath("//div[contains(@class,'ng-option')]//span[contains(text(),'" + updatedDesignation + "')]"));
		js.executeScript("arguments[0].click();", selectDesignationNameEle);

		// Has SmartPhone
		driver.findElement(By.xpath("//*[contains(text(),'Has Smartphone')]")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//div[contains(@class,'ng-option')]//span[contains(text(),'" + updatedHasSmartPhone + "')]"))
				.click();

		// Phone Number
		WebElement PhoneNumberEle = driver.findElement(By.xpath("//input[@placeholder='Phone Number']"));
		PhoneNumberEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		PhoneNumberEle.sendKeys(updatedPhoneNumber);

		// Primary Member
		WebElement PrimaryMemberIdEle = driver.findElement(By.xpath("//input[@placeholder='Primary Member Id']"));
		PrimaryMemberIdEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		PrimaryMemberIdEle.sendKeys(updatedPrimaryMemberId);

		// Age
		WebElement AgeEle = driver.findElement(By.xpath("//input[@placeholder='Age']"));
		AgeEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		AgeEle.sendKeys(updatedAge);

	}

	@Then("^user edit all the added data with new data$")
	public void user_edit_all_the_added_data_with_new_data(DataTable Karyakarta_Edit_Details)
			throws InterruptedException {
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		Map<String, String> map = Karyakarta_Edit_Details.asMap(String.class, String.class);
		updatedName = map.get("Name");
		updatedFatherName = map.get("Father Name");
		updatedDesignation = map.get("Designation");
		updatedHasSmartPhone = map.get("Has Smartphone");
		updatedPhoneNumber = map.get("Phone Number");
		updatedPrimaryMemberId = map.get("Primary Member ID");
		updatedAge = map.get("Age");
		updatedGender = map.get("Gender");
		updatedWhatsApp = map.get("WhatsApp Number");
		updatedStdCode = map.get("STD Code");
		updatedLandlineNumber = map.get("Landline Number");
		updatedCategory = map.get("Category");
		updatedCaste = map.get("Caste");
		updatedEmail = map.get("Email");
		updatedDob = map.get("Dob");
		updatedFullAddress = map.get("Full Address");
		updatedVillage = map.get("Village");
		updatedTaluka = map.get("Taluka");
		updatedDistrict = map.get("District");
		updatedPinCode = map.get("Pin Code");
		updatedEducation = map.get("Education");
		updatedProfession = map.get("Profession");
		updatedBike = map.get("Bike");
		updatedCar = map.get("Car");
		updatedVidhanSabhaWhereHeSheVotes = map.get("Vidhan Sabha where he/she votes");
		updatedBoothWhereHeSheVotes = map.get("Booth where he/she votes");
		updatedVoterId = map.get("Voter Id");
		updatedAadharNumber = map.get("Aadhaar Number");
		updatedPannaNumber = map.get("Panna Number");
		updatedRationCardNumber = map.get("Ration Card Number");
		updatedFacebookProfile = map.get("Facebook Profile");
		updatedTwitterProfile = map.get("Twitter Profile");
		updatedInstagramProfile = map.get("Intagram Profile");
		updatedLinkedinProfile = map.get("Linkedin Profile");
		updatedImage = map.get("Image");
		updatedSalutation = map.get("Salutation");
		updatedSubCaste = map.get("Sub Caste");
		updatedQualification = map.get("Qualification");
		updatedReligion = map.get("Religion");
		updatedActiveMemberId = map.get("Active Member Id");
		updatedPartyZila = map.get("Party Zila");
		updatedPartyMandal = map.get("Party Mandal");
		updatedBloodGroup = map.get("Blood Group");

		System.out.println("Name:>>>> " + name);

		// Karyakarta_Edit_Details fill into the dynamic form
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

		WebElement actionEle = driver.findElements(By.xpath("//mat-icon[contains(.,'more_vert')]")).get(0);
		WebElement actioneleAfterClickable = wait.until(ExpectedConditions.elementToBeClickable(actionEle));
		js.executeScript("arguments[0].scrollIntoView(true);", actioneleAfterClickable);
		Thread.sleep(1000);
		// click on action from 1st row
		js.executeScript("arguments[0].click();", actionEle);
		Thread.sleep(1000);
		// click on Edit option
		driver.findElement(By.xpath("//span[contains(.,'Edit')]")).click();

		Thread.sleep(1000);
		// ------If you want to enter extra details please use this section.------
		WebElement extraDetailsEle = driver.findElement(By.className("mat-expansion-panel-header-description"));
		js.executeScript("arguments[0].scrollIntoView(true);", extraDetailsEle);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", extraDetailsEle);

		// Name
		WebElement nameEle = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Name']")));
		nameEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);

		nameEle.sendKeys(updatedName);

		// Father's/Husband's Name
		WebElement fatherEle = driver.findElement(By.xpath("//input[contains(@placeholder, 'Father')]"));
		fatherEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		fatherEle.sendKeys(updatedFatherName);

		// select Designation
		driver.findElement(By.xpath("//div[contains(text(),'Select Designation')]")).click();
		WebElement selectDesignationNameEle = driver.findElement(
				By.xpath("//div[contains(@class,'ng-option')]//span[contains(text(),'" + updatedDesignation + "')]"));
		js.executeScript("arguments[0].click();", selectDesignationNameEle);

		// Has SmartPhone
		driver.findElement(By.xpath("//*[contains(text(),'Has Smartphone')]")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//div[contains(@class,'ng-option')]//span[contains(text(),'" + updatedHasSmartPhone + "')]"))
				.click();

		// Phone Number
		WebElement PhoneNumberEle = driver.findElement(By.xpath("//input[@placeholder='Phone Number']"));
		PhoneNumberEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		PhoneNumberEle.sendKeys(updatedPhoneNumber);

		// Primary Member
		WebElement PrimaryMemberIdEle = driver.findElement(By.xpath("//input[@placeholder='Primary Member Id']"));
		PrimaryMemberIdEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		PrimaryMemberIdEle.sendKeys(updatedPrimaryMemberId);

		// Age
		WebElement AgeEle = driver.findElement(By.xpath("//input[@placeholder='Age']"));
		AgeEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		AgeEle.sendKeys(updatedAge);
		int ageInt = Integer.parseInt(updatedAge);
		// Dob
		String calculatedDOB = dob_calculation_based_on_age_input(ageInt);
		WebElement dobEle = driver.findElement(By.xpath("//input[@data-placeholder='Dob']"));
		String copiedDobAfterEnteredAge = dobEle.getAttribute("value");
		Assert.assertEquals(calculatedDOB, copiedDobAfterEnteredAge);
		dobEle.clear();
		apply_validation_in_dob();
		String day_and_month_updated_dob = set_day_and_month_in_dob(ageInt);
		System.out.println("day_and_month_updated_dob= " + day_and_month_updated_dob);
		// AgeEle.clear();
		// AgeEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		// AgeEle.sendKeys(age);
		dobEle.sendKeys(day_and_month_updated_dob);
		String copiedDob = dobEle.getAttribute("value");
		Assert.assertEquals(day_and_month_updated_dob, copiedDob);
		// Blood Group
		WebElement bloodGroupEle = driver.findElement(By.xpath("//input[@data-placeholder='Blood Group']"));
		bloodGroupEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		bloodGroupEle.sendKeys(updatedBloodGroup);
		// select gender
		String selectGender;
		if (updatedGender.equals("Male") || updatedGender.equals("Female")) {
			selectGender = updatedGender.toLowerCase();
		} else {
			// make Other to others
			selectGender = updatedGender.toLowerCase() + "s";
		}
		WebElement genderEle = driver.findElement(By.xpath("//input[@value='" + selectGender + "']"));
		js.executeScript("arguments[0].scrollIntoView(true);", genderEle);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", genderEle);

		// WhatsApp Number
		WebElement whatsAppEle = driver.findElement(By.xpath("//input[@placeholder='WhatsApp Number']"));
		whatsAppEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		whatsAppEle.sendKeys(updatedWhatsApp);

		// STD Code
		WebElement stdCodeEle = driver.findElement(By.xpath("//input[@placeholder='STD Code']"));
		stdCodeEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		stdCodeEle.sendKeys(updatedStdCode);

		// Landline Number
		WebElement stdLandlineEle = driver.findElement(By.xpath("//input[@placeholder='Landline Number']"));
		stdLandlineEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		stdLandlineEle.sendKeys(updatedLandlineNumber);
		// Clear Category

		List<WebElement> selectCategoryEle = driver.findElements(By.xpath("//div[contains(text(),'Select Category')]"));
		WebElement clearCategory = driver
				.findElement(with(By.xpath("//span[@title='Clear all']")).toRightOf(selectCategoryEle.get(0)));

		// Caste
		List<WebElement> CasteEle = driver.findElements(By.xpath("//div[contains(text(),'Caste')]"));
		// WebElement clearCaste =
		// driver.findElement(with(By.xpath("//span[@title='Clear
		// all']")).toRightOf(CasteEle.get(0)));
		// click on select Category
		selectCategoryEle.get(0).click();
		clearCategory.click();
		apply_validation_in_category_and_caste();

		selectCategoryEle.get(0).click();

		// categoryValue = addDatadriven.get(12);
		WebElement categoryValueEle = driver
				.findElement(By.xpath("//div//span[contains(text(),'" + updatedCategory + "')]"));
		js.executeScript("arguments[0].click();", categoryValueEle);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		// Thread.sleep(2000);

		List<WebElement> casteOverlayEle = driver.findElements(By.xpath("//div[@class='overlay ng-star-inserted']"));
		while (casteOverlayEle.size() > 0) {
			System.out.println("caste Overlay 1 ........");
			casteOverlayEle = driver.findElements(By.xpath("//div[@class='overlay ng-star-inserted']"));
			Thread.sleep(1000);
		}
		System.out.println("--------------- overlay gone----------------");
		Thread.sleep(2000);

		// click on Caste
		WebElement CasteEleAfterwait = wait.until(ExpectedConditions.elementToBeClickable(CasteEle.get(0)));
		CasteEleAfterwait.click();
		WebElement CasteValueEle = driver.findElement(By.xpath("//div//span[contains(text(),'" + updatedCaste + "')]"));
		js.executeScript("arguments[0].click();", CasteValueEle);

		// Email
		WebElement emailEle = driver.findElement(By.xpath("//input[@placeholder='Email']"));
		emailEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		emailEle.sendKeys(updatedEmail);

		// enter full Address
		WebElement fullAddressEle = driver.findElement(By.xpath("//input[@placeholder='Full Address']"));
		fullAddressEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		fullAddressEle.sendKeys(updatedFullAddress);

		// Village
		WebElement villageEle = driver.findElement(By.xpath("//input[@placeholder='Village/Ward']"));
		villageEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		villageEle.sendKeys(updatedVillage);

		// Taluka/Tehsil
		WebElement Taluka_Tehsil_Ele = driver.findElement(By.xpath("//input[contains(@placeholder, 'Taluka')]"));
		Taluka_Tehsil_Ele.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		Taluka_Tehsil_Ele.sendKeys(updatedTaluka);

		// click on Select District
		WebElement selectDistrictEle = driver.findElement(By.xpath("//div[contains(text(),'Select District')]"));
		selectDistrictEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		WebElement DistrictNameEle = driver.findElement(
				By.xpath("//div[contains(@class,'ng-option')]//span[contains(text(),'" + updatedDistrict + "')]"));
		js.executeScript("arguments[0].click();", DistrictNameEle);

		// pinCode
		WebElement pincodeEle = driver.findElement(By.xpath("//input[@placeholder='Pin Code']"));
		pincodeEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		pincodeEle.sendKeys(updatedPinCode);

		// click on Select Education
		WebElement selectEducationEle = driver.findElement(By.xpath("//div[contains(text(),'Select Education')]"));
		selectEducationEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// Select Education
		WebElement EducationValueEle = driver.findElement(
				By.xpath("//div[contains(@class,'ng-option')]//span[contains(text(),'" + updatedEducation + "')]"));
		js.executeScript("arguments[0].click();", EducationValueEle);

		// click on Select Profession
		WebElement selectProfessionEle = driver.findElement(By.xpath("//div[contains(text(),'Select Profession')]"));
		selectProfessionEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// Select Education
		WebElement ProfessionValueEle = driver.findElement(
				By.xpath("//div[contains(@class,'ng-option')]//span[contains(text(),'" + updatedProfession + "')]"));
		js.executeScript("arguments[0].click();", ProfessionValueEle);

		// click on Bike
		WebElement BikeEle = driver.findElement(By.xpath("//div[contains(text(),'Bike')]"));
		BikeEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(1000);
		WebElement bikeValueEle = driver.findElement(
				By.xpath("//div[contains(@class,'ng-option')]//span[contains(text(),'" + updatedBike + "')]"));
		js.executeScript("arguments[0].click();", bikeValueEle);

		// click on Car
		WebElement CarEle = driver.findElement(By.xpath("//div[contains(text(),'Car')]"));
		CarEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(1000);
		// Select yes or no for bike
		WebElement carValueEle = driver.findElement(
				By.xpath("//div[contains(@class,'ng-option')]//span[contains(text(),'" + updatedCar + "')]"));
		js.executeScript("arguments[0].click();", carValueEle);

		// click on Vidhan Sabha where He/She Votes
		WebElement VidhanSabhawhereHe_SheVotesEle = driver
				.findElement(By.xpath("//div[contains(text(),'Vidhan Sabha where He/She Votes')]"));
		VidhanSabhawhereHe_SheVotesEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// Select Education
		WebElement VidhanSabhawhereHe_SheVotesValueEle = driver
				.findElement(By.xpath("//div[contains(@class,'ng-option')]//span[contains(text(),'"
						+ updatedVidhanSabhaWhereHeSheVotes + "')]"));
		js.executeScript("arguments[0].click();", VidhanSabhawhereHe_SheVotesValueEle);

		// Booth where He/She Votes
		WebElement BoothwhereHe_SheVotesValueEle = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'Booth where He/She Votes')]"));
		BoothwhereHe_SheVotesValueEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		BoothwhereHe_SheVotesValueEle.sendKeys(updatedBoothWhereHeSheVotes);

		// Voter Id
		WebElement votesIdValueEle = driver.findElement(By.xpath("//input[contains(@placeholder, 'ex. UTC026351')]"));
		votesIdValueEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		votesIdValueEle.sendKeys(updatedVoterId);

		// Aadhaar Number
		WebElement AadhaarNumberEle = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'ex. 765478961243')]"));
		AadhaarNumberEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		AadhaarNumberEle.sendKeys(updatedAadharNumber);

		// Panna Number
		WebElement PannaNumberEle = driver.findElement(By.xpath("//input[contains(@placeholder, 'Panna Number')]"));
		PannaNumberEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		PannaNumberEle.sendKeys(updatedPannaNumber);

		// Ration Card Number
		WebElement RationCardNumberEle = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'Ration Card Number')]"));
		RationCardNumberEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		RationCardNumberEle.sendKeys(updatedRationCardNumber);

		// FacebookProfile
		WebElement FacebookProfileEle = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'www.fb.com/username')]"));
		FacebookProfileEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		FacebookProfileEle.sendKeys(updatedFacebookProfile);

		// TwitterProfile
		WebElement TwitterProfileEle = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'www.twitter.com/username')]"));
		TwitterProfileEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		TwitterProfileEle.sendKeys(updatedTwitterProfile);

		// InstagramProfile
		WebElement InstagramProfileEle = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'www.instagram.com/username')]"));
		InstagramProfileEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		InstagramProfileEle.sendKeys(updatedInstagramProfile);

		// LinkedInProfile
		WebElement LinkedInProfileEle = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'www.linkedin.com/username')]"));
		LinkedInProfileEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		LinkedInProfileEle.sendKeys(updatedLinkedinProfile);

		Thread.sleep(2000);
		// click on Salutation
		WebElement SalutationEle = driver.findElements(By.className("mat-select-value-text")).get(0);
		SalutationEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(1000);
		// Select SalutationEle
		WebElement salutationValueEle = driver.findElement(
				By.xpath("//mat-option[contains(@role,'option')]//span[contains(text(),'" + updatedSalutation + "')]"));
		js.executeScript("arguments[0].click();", salutationValueEle);

		// Sub Caste
		WebElement SubCasteEle = driver.findElement(By.xpath("//input[contains(@placeholder, 'Sub caste')]"));
		SubCasteEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		SubCasteEle.sendKeys(updatedSubCaste);

		// Qualification
		WebElement QualificationEle = driver.findElement(By.xpath("//input[contains(@placeholder, 'Qualification')]"));
		QualificationEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		QualificationEle.sendKeys(updatedQualification);

		// Religion
		WebElement ReligionEle = driver.findElements(By.className("mat-select-value-text")).get(1);
		ReligionEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(1000);
		// Select Religion
		WebElement ReligionEleValueEle = driver.findElement(
				By.xpath("//mat-option[contains(@role,'option')]//span[contains(text(),'" + updatedReligion + "')]"));
		js.executeScript("arguments[0].click();", ReligionEleValueEle);

		// Active Member Id
		WebElement ActiveMemberIdValueEle = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'Active Member Id')]"));
		ActiveMemberIdValueEle.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
		ActiveMemberIdValueEle.sendKeys(updatedActiveMemberId);

		// Clear Party Zila
		WebElement SelectPartyZilaIdEle = driver.findElement(By.xpath("//div[contains(text(),'Select Party Zila')]"));
		WebElement clearPartyZila = driver
				.findElement(with(By.xpath("//span[@title='Clear all']")).toRightOf(SelectPartyZilaIdEle));
		clearPartyZila.click();
		// Party Zila and Party Mandal
		apply_validation_in_party_zila_and_mandal();

		// click Select Party Zila Id
		WebElement SelectPartyMandalEle = driver.findElement(By.xpath("//div[contains(text(),'Select Party Mandal')]"));
		SelectPartyZilaIdEle.click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// Select Party Zila Id
		WebElement PartyZilaIdValueEle = driver
				.findElement(By.xpath("//div//span[contains(text(),'" + updatedPartyZila + "')]"));
		js.executeScript("arguments[0].click();", PartyZilaIdValueEle);

		// click Select Party Mandal

		List<WebElement> partyMandalOverlayEle = driver
				.findElements(By.xpath("//div[@class='overlay ng-star-inserted']"));
		while (partyMandalOverlayEle.size() > 0) {
			System.out.println("partyMandal Overlay 1 ........");
			partyMandalOverlayEle = driver.findElements(By.xpath("//div[@class='overlay ng-star-inserted']"));
			Thread.sleep(1000);
		}

		System.out.println("--- overlay gone of party Mandal-------");

		SelectPartyMandalEle = driver.findElement(By.xpath("//div[contains(text(),'Select Party Mandal')]"));
		wait.until(ExpectedConditions.elementToBeClickable(SelectPartyMandalEle)).click();
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		// Select Party Mandal
		WebElement enterPartyMandalEle = driver.findElement(with(By.tagName("input")).below(SelectPartyMandalEle));
		enterPartyMandalEle.sendKeys(updatedPartyMandal);
		enterPartyMandalEle.sendKeys(Keys.ENTER);
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();

	}

	@And("^user click on update button$")
	public void user_click_on_update_button() throws InterruptedException {
		Thread.sleep(2000);
		WebElement updateButton = driver.findElement(By.xpath("//span[contains(.,'Update')]"));
		updateButton.click();

	}

	@And("^user verify all the updated data$")
	public void user_verify_all_the_updated_data() throws InterruptedException {

		// click on edit button
		user_click_on_edit_button_for_recently_added_entry();

		// user verify all the added data
		js = (JavascriptExecutor) driver;
		// get all the added data.
		user_clicks_on_enter_more_details();

		// Name
		copiedEnteredName = driver.findElement(By.xpath("//input[@placeholder='Name']")).getAttribute("value");
		Assert.assertEquals(copiedEnteredName.toUpperCase(), updatedName.toUpperCase());

		// Father's/Husband's Name
		copiedEnteredFather_Husband_Name = driver.findElement(By.xpath("//input[contains(@placeholder, 'Father')]"))
				.getAttribute("value");
		Assert.assertEquals(updatedFatherName.toUpperCase(), copiedEnteredFather_Husband_Name.toUpperCase());

		// Designation
		WebElement SelectDesignationEle = driver.findElement(By.xpath("//div[contains(text(),'Select Designation')]"));
		copiedSelectedDesignation = driver.findElement(with(By.className("ng-value-label")).below(SelectDesignationEle))
				.getText();
		Assert.assertEquals(copiedSelectedDesignation, updatedDesignation);

		// Has SmartPhone
		WebElement hasSmartPhoneEle = driver.findElement(By.xpath("//div[contains(text(),'Has Smartphone')]"));
		copiedHasSmartPhone = driver.findElement(with(By.className("ng-value-label")).below(hasSmartPhoneEle))
				.getText();
		Assert.assertEquals(copiedHasSmartPhone, updatedHasSmartPhone);

		// Phone Number
		copiedPhoneNo = driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).getAttribute("value");
		Assert.assertEquals(copiedPhoneNo, updatedPhoneNumber);

		// Primary Member
		copiedPrimaryMember = driver.findElement(By.xpath("//input[@placeholder='Primary Member Id']"))
				.getAttribute("value");
		Assert.assertEquals(copiedPrimaryMember, updatedPrimaryMemberId);

		// Age
		copiedAge = driver.findElement(By.xpath("//input[@placeholder='Age']")).getAttribute("value");
		Assert.assertEquals(copiedAge, updatedAge);
		int ageInt = Integer.parseInt(updatedAge);
		// Dob
		WebElement dobEle = driver.findElement(By.xpath("//input[@data-placeholder='Dob']"));
		String day_and_month_updated_dob = set_day_and_month_in_dob(ageInt);
		System.out.println("day_and_month_updated_dob= " + day_and_month_updated_dob);
		copiedDob = dobEle.getAttribute("value");
		Assert.assertEquals(day_and_month_updated_dob, copiedDob);

		// Blood Group
		WebElement BloodGroupEle = driver.findElement(By.xpath("//input[@data-placeholder='Blood Group']"));
		copiedBloodGroup = BloodGroupEle.getAttribute("value");
		Assert.assertEquals(copiedBloodGroup, updatedBloodGroup);

		// Gender
		String genderFormating = updatedGender.toLowerCase();
		if (genderFormating.equals("other")) {
			genderFormating = genderFormating + "s";
		}
		System.out.println("genderFormating :" + genderFormating);

		String classOfselectedGender = driver
				.findElement(By.xpath("//mat-radio-button[@value='" + genderFormating + "']")).getAttribute("class");
		System.out.println("classOfselectedGender :" + classOfselectedGender);
		Assert.assertEquals(classOfselectedGender.contains("mat-radio-checked"), true,
				"seems like gender is not selected");

		// WhatsApp
		copiedWhatsAppNumber = driver.findElement(By.xpath("//input[@placeholder='WhatsApp Number']"))
				.getAttribute("value");
		Assert.assertEquals(copiedWhatsAppNumber, updatedWhatsApp);

		// STD Code
		copiedStdCode = driver.findElement(By.xpath("//input[@placeholder='STD Code']")).getAttribute("value");
		Assert.assertEquals(copiedStdCode, updatedStdCode);

		// Landline Number
		copiedLandLineNo = driver.findElement(By.xpath("//input[@placeholder='Landline Number']"))
				.getAttribute("value");
		Assert.assertEquals(copiedLandLineNo, updatedLandlineNumber);

		// Select Category
		WebElement SelectCategoryEle = driver.findElement(By.xpath("//div[contains(text(),'Select Category')]"));
		copiedSelectedCategory = driver.findElement(with(By.className("ng-value-label")).below(SelectCategoryEle))
				.getText();
		Assert.assertEquals(copiedSelectedCategory, updatedCategory);

		// Caste
		WebElement SelectCasteEle = driver.findElement(By.xpath("//div[contains(text(),'Caste')]"));
		copiedSelectedCaste = driver.findElement(with(By.className("ng-value-label")).below(SelectCasteEle)).getText();
		Assert.assertEquals(copiedSelectedCaste, updatedCaste);

		// Email
		copiedEmail = driver.findElement(By.xpath("//input[@placeholder='Email']")).getAttribute("value");
		Assert.assertEquals(copiedEmail, updatedEmail);

		// Full Address
		copiedFullAddress = driver.findElement(By.xpath("//input[@placeholder='Full Address']")).getAttribute("value");
		Assert.assertEquals(copiedFullAddress, updatedFullAddress);

		// Village
		copiedVillage = driver.findElement(By.xpath("//input[@placeholder='Village/Ward']")).getAttribute("value");
		Assert.assertEquals(copiedVillage, updatedVillage);

		// Taluka/Tehsil
		copiedTaluka_Tehsil = driver.findElement(By.xpath("//input[contains(@placeholder, 'Taluka')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedTaluka_Tehsil, updatedTaluka);

		// select district
		WebElement SelectDistrictEle = driver.findElement(By.xpath("//div[contains(text(),'Select District')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", SelectDistrictEle);
		copiedSelectedDistrict = driver.findElement(with(By.className("ng-value-label")).below(SelectDistrictEle))
				.getText();
		Assert.assertEquals(copiedSelectedDistrict, updatedDistrict);

		// Pin Code
		CopiedpinCode = driver.findElement(By.xpath("//input[@placeholder='Pin Code']")).getAttribute("value");
		Assert.assertEquals(CopiedpinCode, updatedPinCode);

		// Select Education
		WebElement SelectEducationEle = driver.findElement(By.xpath("//div[contains(text(),'Select Education')]"));
		copiedSelectedEducation = driver.findElement(with(By.className("ng-value-label")).below(SelectEducationEle))
				.getText();
		Assert.assertEquals(copiedSelectedEducation, updatedEducation);

		// Select Profession
		WebElement SelectProfessionEle = driver.findElement(By.xpath("//div[contains(text(),'Select Profession')]"));
		copiedSelectedProfession = driver.findElement(with(By.className("ng-value-label")).below(SelectProfessionEle))
				.getText();
		Assert.assertEquals(copiedSelectedProfession, updatedProfession);

		// hasBike
		WebElement HasBikeEle = driver.findElement(By.xpath("//div[contains(text(),'Bike')]"));
		copiedHasBike = driver.findElement(with(By.className("ng-value-label")).below(HasBikeEle)).getText();
		Assert.assertEquals(copiedHasBike, updatedBike);

		// hasCar
		WebElement HasCarEle = driver.findElement(By.xpath("//div[contains(text(),'Car')]"));
		copiedHasCar = driver.findElement(with(By.className("ng-value-label")).below(HasCarEle)).getText();
		Assert.assertEquals(copiedHasCar, updatedCar);

		// vidhanSabha where he/she votes
		WebElement vidhanSabha_where_he_sheVotesEle = driver
				.findElement(By.xpath("//div[contains(text(),'Vidhan Sabha where He/She Votes')]"));
		copied_vidhanSabha_where_he_sheVotes = driver
				.findElement(with(By.className("ng-value-label")).below(vidhanSabha_where_he_sheVotesEle)).getText();

		// separating number and "-" from copied_vidhanSabha_where_he_sheVotes
		// String[] vidhansabhaNameArr =
		// copied_vidhanSabha_where_he_sheVotes.split("-");
		Assert.assertEquals(copied_vidhanSabha_where_he_sheVotes, updatedVidhanSabhaWhereHeSheVotes);

		// Booth where He/She Votes
		copiedBothWhereHeSheVotes = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'Booth where He/She Votes')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedBothWhereHeSheVotes, updatedBoothWhereHeSheVotes);

		// Voter Id
		copiedVoterId = driver.findElement(By.xpath("//input[contains(@placeholder, 'ex. UTC026351')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedVoterId, updatedVoterId);

		// Aadhaar Number
		copiedAadhaarNumber = driver.findElement(By.xpath("//input[contains(@placeholder, 'ex. 765478961243')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedAadhaarNumber, updatedAadharNumber);

		// Panna Number
		copiedPannaNumber = driver.findElement(By.xpath("//input[contains(@placeholder, 'Panna Number')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedPannaNumber, updatedPannaNumber);

		// Ration Card
		copiedRationCard = driver.findElement(By.xpath("//input[contains(@placeholder, 'Ration Card Number')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedRationCard, updatedRationCardNumber);

		// Facebook
		copiedFacebookValue = driver.findElement(By.xpath("//input[contains(@placeholder, 'www.fb.com/username')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedFacebookValue, updatedFacebookProfile);

		// TwitterProfile
		copiedTwitterProfile = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'www.twitter.com/username')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedTwitterProfile, updatedTwitterProfile);

		// InstagramProfile
		copiedInstagramProfile = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'www.instagram.com/username')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedInstagramProfile, updatedInstagramProfile);

		// LinkedInProfile
		copiedLinkedInProfile = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'www.linkedin.com/username')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedLinkedInProfile, updatedLinkedinProfile);

		// Salutation
		copiedSalutation = driver.findElements(By.className("mat-select-value-text")).get(0).getText();
		Assert.assertEquals(copiedSalutation, updatedSalutation);

		// Sub Caste
		copiedSubCaste = driver.findElement(By.xpath("//input[contains(@placeholder, 'Sub caste')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedSubCaste, updatedSubCaste);

		// Qualification
		copiedQualification = driver.findElement(By.xpath("//input[contains(@placeholder, 'Qualification')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedQualification, updatedQualification);

		// Religion
		copiedReligion = driver.findElements(By.className("mat-select-value-text")).get(1).getText();
		Assert.assertEquals(copiedReligion, updatedReligion);

		// Active Member Id
		copiedActiveMemberId = driver.findElement(By.xpath("//input[contains(@placeholder, 'Active Member Id')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedActiveMemberId, updatedActiveMemberId);

		// Select Party Zila Id
		WebElement SelectPartyZilaIdEle = driver.findElement(By.xpath("//div[contains(text(),'Select Party Zila')]"));
		copiedSelectedPartyZilaId = driver.findElement(with(By.className("ng-value-label")).below(SelectPartyZilaIdEle))
				.getText();
		Assert.assertEquals(copiedSelectedPartyZilaId, updatedPartyZila);

		// Select Party Mandal
		WebElement SelectPartyMandalEle = driver.findElement(By.xpath("//div[contains(text(),'Select Party Mandal')]"));
		copiedSelectedPartyMandalId = driver
				.findElement(with(By.className("ng-value-label")).below(SelectPartyMandalEle)).getText();
		Assert.assertEquals(copiedSelectedPartyMandalId, updatedPartyMandal);

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

		// click on cancel button
		WebElement cancelButtonEle = driver.findElement(By.xpath("//span[contains(.,'Cancel')]"));
		js.executeScript("arguments[0].click();", cancelButtonEle);

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

	}

	@And("^user scroll to view data table and search for data which need to edit and get all the data$")
	public void user_scroll_to_view_data_table_and_search_for_data_which_need_to_edit_and_get_all_the_data(
			DataTable Karyakarta_Edit_Details) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		js = (JavascriptExecutor) driver;
		Map<String, String> map = Karyakarta_Edit_Details.asMap(String.class, String.class);
		// Get Data
		updatedName = map.get("Name");
		updatedFatherName = map.get("Father Name");
		updatedDesignation = map.get("Designation");
		updatedHasSmartPhone = map.get("Has Smartphone");
		updatedPhoneNumber = map.get("Phone Number");
		updatedPrimaryMemberId = map.get("Primary Member ID");
		updatedAge = map.get("Age");
		updatedGender = map.get("Gender");
		updatedWhatsApp = map.get("WhatsApp Number");
		updatedStdCode = map.get("STD Code");
		updatedLandlineNumber = map.get("Landline Number");
		updatedCategory = map.get("Category");
		updatedCaste = map.get("Caste");
		updatedEmail = map.get("Email");
		updatedDob = map.get("Dob");
		updatedFullAddress = map.get("Full Address");
		updatedVillage = map.get("Village");
		updatedTaluka = map.get("Taluka");
		updatedDistrict = map.get("District");
		updatedPinCode = map.get("Pin Code");
		updatedEducation = map.get("Education");
		updatedProfession = map.get("Profession");
		updatedBike = map.get("Bike");
		updatedCar = map.get("Car");
		updatedVidhanSabhaWhereHeSheVotes = map.get("Vidhan Sabha where he/she votes");
		updatedBoothWhereHeSheVotes = map.get("Booth where he/she votes");
		updatedVoterId = map.get("Voter Id");
		updatedAadharNumber = map.get("Aadhaar Number");
		updatedPannaNumber = map.get("Panna Number");
		updatedRationCardNumber = map.get("Ration Card Number");
		updatedFacebookProfile = map.get("Facebook Profile");
		updatedTwitterProfile = map.get("Twitter Profile");
		updatedInstagramProfile = map.get("Intagram Profile");
		updatedLinkedinProfile = map.get("Linkedin Profile");
		updatedImage = map.get("Image");
		updatedSalutation = map.get("Salutation");
		updatedSubCaste = map.get("Sub Caste");
		updatedQualification = map.get("Qualification");
		updatedReligion = map.get("Religion");
		updatedActiveMemberId = map.get("Active Member Id");
		updatedPartyZila = map.get("Party Zila");
		updatedPartyMandal = map.get("Party Mandal");
		updatedBloodGroup = map.get("Blood Group");
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//table")));
		System.out.println("updatedPhoneNumber????: " + updatedPhoneNumber);
		List<WebElement> colms = driver.findElements(By.xpath("//table/thead/tr/th"));
		int lastColNum = colms.size();
		for (int col = 0; col < lastColNum; col++) {
			String colmValue = colms.get(col).getText();
			System.out.println("colmsValue: " + colmValue);
			if (colmValue.contains("Phone Number")) {
				List<WebElement> phoneNumberRows = driver
						.findElements(By.xpath("//table/tbody/tr/td[" + (col + 1) + "]"));
				int phoneNumberRowSize = phoneNumberRows.size();
				System.out.println("phoneNumberRowSize: " + phoneNumberRowSize);
				for (int phoneNumberRow = 0; phoneNumberRow < phoneNumberRowSize; phoneNumberRow++) {
					System.out.println("phoneNumberRow:" + phoneNumberRow);
					String phoneNumberValue = phoneNumberRows.get(phoneNumberRow).getText();
					if (phoneNumberValue.contains(updatedPhoneNumber)) {
						System.out.println("phoneNumberValue>>: " + phoneNumberValue);
						WebElement actionButtonEle = driver
								.findElement(By.xpath("//table/tbody/tr[" + (phoneNumberRow + 1) + "]/td["
										+ (lastColNum) + "]//mat-icon[contains(.,'more_vert')]"));
						js.executeScript("arguments[0].click();", actionButtonEle);

						List<WebElement> actionAllEle = driver.findElements(By.xpath("//button//img"));
						wait.until(ExpectedConditions.visibilityOfAllElements(actionAllEle));
						WebElement editButtonEle = driver.findElement(By.xpath("//button//span[text()='Edit']"));
						js.executeScript("arguments[0].click();", editButtonEle);
						ngDriver = new NgWebDriver((JavascriptExecutor) driver);
						Thread.sleep(2000);
						user_clicks_on_enter_more_details();
						// get all the data from the update mode
						// Name
						copiedEnteredName = driver.findElement(By.xpath("//input[@placeholder='Name']"))
								.getAttribute("value");
						Assert.assertEquals(copiedEnteredName.toUpperCase(), updatedName.toUpperCase());

						// Father's/Husband's Name
						copiedEnteredFather_Husband_Name = driver
								.findElement(By.xpath("//input[contains(@placeholder, 'Father')]"))
								.getAttribute("value");
						Assert.assertEquals(updatedFatherName.toUpperCase(),
								copiedEnteredFather_Husband_Name.toUpperCase());

						// Designation
						WebElement SelectDesignationEle = driver
								.findElement(By.xpath("//div[contains(text(),'Select Designation')]"));
						copiedSelectedDesignation = driver
								.findElement(with(By.className("ng-value-label")).below(SelectDesignationEle))
								.getText();
						Assert.assertEquals(copiedSelectedDesignation, updatedDesignation);

						// Has SmartPhone
						WebElement hasSmartPhoneEle = driver
								.findElement(By.xpath("//div[contains(text(),'Has Smartphone')]"));
						copiedHasSmartPhone = driver
								.findElement(with(By.className("ng-value-label")).below(hasSmartPhoneEle)).getText();
						Assert.assertEquals(copiedHasSmartPhone, updatedHasSmartPhone);

						// Phone Number
						copiedPhoneNo = driver.findElement(By.xpath("//input[@placeholder='Phone Number']"))
								.getAttribute("value");
						Assert.assertEquals(copiedPhoneNo, updatedPhoneNumber);

						// Primary Member
						copiedPrimaryMember = driver.findElement(By.xpath("//input[@placeholder='Primary Member Id']"))
								.getAttribute("value");
						Assert.assertEquals(copiedPrimaryMember, updatedPrimaryMemberId);

						// Age
						copiedAge = driver.findElement(By.xpath("//input[@placeholder='Age']")).getAttribute("value");
						Assert.assertEquals(copiedAge, updatedAge);
						int ageInt = Integer.parseInt(updatedAge);
						// Dob
						WebElement dobEle = driver.findElement(By.xpath("//input[@data-placeholder='Dob']"));
						String day_and_month_updated_dob = set_day_and_month_in_dob(ageInt);
						System.out.println("day_and_month_updated_dob= " + day_and_month_updated_dob);
						copiedDob = dobEle.getAttribute("value");
						Assert.assertEquals(day_and_month_updated_dob, copiedDob);

						// Blood Group
						WebElement BloodGroupEle = driver
								.findElement(By.xpath("//input[@data-placeholder='Blood Group']"));
						copiedBloodGroup = BloodGroupEle.getAttribute("value");
						Assert.assertEquals(copiedBloodGroup, updatedBloodGroup);

						// Gender
						String genderFormating = updatedGender.toLowerCase();
						if (genderFormating.equals("other")) {
							genderFormating = genderFormating + "s";
						}
						System.out.println("genderFormating :" + genderFormating);

						String classOfselectedGender = driver
								.findElement(By.xpath("//mat-radio-button[@value='" + genderFormating + "']"))
								.getAttribute("class");
						System.out.println("classOfselectedGender :" + classOfselectedGender);
						Assert.assertEquals(classOfselectedGender.contains("mat-radio-checked"), true,
								"seems like gender is not selected");

						// WhatsApp
						copiedWhatsAppNumber = driver.findElement(By.xpath("//input[@placeholder='WhatsApp Number']"))
								.getAttribute("value");
						Assert.assertEquals(copiedWhatsAppNumber, updatedWhatsApp);

						// STD Code
						copiedStdCode = driver.findElement(By.xpath("//input[@placeholder='STD Code']"))
								.getAttribute("value");
						Assert.assertEquals(copiedStdCode, updatedStdCode);

						// Landline Number
						copiedLandLineNo = driver.findElement(By.xpath("//input[@placeholder='Landline Number']"))
								.getAttribute("value");
						Assert.assertEquals(copiedLandLineNo, updatedLandlineNumber);

						// Select Category
						WebElement SelectCategoryEle = driver
								.findElement(By.xpath("//div[contains(text(),'Select Category')]"));
						copiedSelectedCategory = driver
								.findElement(with(By.className("ng-value-label")).below(SelectCategoryEle)).getText();
						Assert.assertEquals(copiedSelectedCategory, updatedCategory);

						// Caste
						WebElement SelectCasteEle = driver.findElement(By.xpath("//div[contains(text(),'Caste')]"));
						copiedSelectedCaste = driver
								.findElement(with(By.className("ng-value-label")).below(SelectCasteEle)).getText();
						Assert.assertEquals(copiedSelectedCaste, updatedCaste);

						// Email
						copiedEmail = driver.findElement(By.xpath("//input[@placeholder='Email']"))
								.getAttribute("value");
						Assert.assertEquals(copiedEmail, updatedEmail);

						// Full Address
						copiedFullAddress = driver.findElement(By.xpath("//input[@placeholder='Full Address']"))
								.getAttribute("value");
						Assert.assertEquals(copiedFullAddress, updatedFullAddress);

						// Village
						copiedVillage = driver.findElement(By.xpath("//input[@placeholder='Village/Ward']"))
								.getAttribute("value");
						Assert.assertEquals(copiedVillage, updatedVillage);

						// Taluka/Tehsil
						copiedTaluka_Tehsil = driver.findElement(By.xpath("//input[contains(@placeholder, 'Taluka')]"))
								.getAttribute("value");
						Assert.assertEquals(copiedTaluka_Tehsil, updatedTaluka);

						// select district
						WebElement SelectDistrictEle = driver
								.findElement(By.xpath("//div[contains(text(),'Select District')]"));
						js.executeScript("arguments[0].scrollIntoView(true);", SelectDistrictEle);
						copiedSelectedDistrict = driver
								.findElement(with(By.className("ng-value-label")).below(SelectDistrictEle)).getText();
						Assert.assertEquals(copiedSelectedDistrict, updatedDistrict);

						// Pin Code
						CopiedpinCode = driver.findElement(By.xpath("//input[@placeholder='Pin Code']"))
								.getAttribute("value");
						Assert.assertEquals(CopiedpinCode, updatedPinCode);

						// Select Education
						WebElement SelectEducationEle = driver
								.findElement(By.xpath("//div[contains(text(),'Select Education')]"));
						copiedSelectedEducation = driver
								.findElement(with(By.className("ng-value-label")).below(SelectEducationEle)).getText();
						Assert.assertEquals(copiedSelectedEducation, updatedEducation);

						// Select Profession
						WebElement SelectProfessionEle = driver
								.findElement(By.xpath("//div[contains(text(),'Select Profession')]"));
						copiedSelectedProfession = driver
								.findElement(with(By.className("ng-value-label")).below(SelectProfessionEle)).getText();
						Assert.assertEquals(copiedSelectedProfession, updatedProfession);

						// hasBike
						WebElement HasBikeEle = driver.findElement(By.xpath("//div[contains(text(),'Bike')]"));
						copiedHasBike = driver.findElement(with(By.className("ng-value-label")).below(HasBikeEle))
								.getText();
						Assert.assertEquals(copiedHasBike, updatedBike);

						// hasCar
						WebElement HasCarEle = driver.findElement(By.xpath("//div[contains(text(),'Car')]"));
						copiedHasCar = driver.findElement(with(By.className("ng-value-label")).below(HasCarEle))
								.getText();
						Assert.assertEquals(copiedHasCar, updatedCar);

						// vidhanSabha where he/she votes
						WebElement vidhanSabha_where_he_sheVotesEle = driver
								.findElement(By.xpath("//div[contains(text(),'Vidhan Sabha where He/She Votes')]"));
						copied_vidhanSabha_where_he_sheVotes = driver
								.findElement(
										with(By.className("ng-value-label")).below(vidhanSabha_where_he_sheVotesEle))
								.getText();

						// separating number and "-" from copied_vidhanSabha_where_he_sheVotes
						String[] vidhansabhaNameArr = copied_vidhanSabha_where_he_sheVotes.split("-");
						Assert.assertEquals(vidhansabhaNameArr[1].trim(), updatedVidhanSabhaWhereHeSheVotes);

						// Booth where He/She Votes
						copiedBothWhereHeSheVotes = driver
								.findElement(By.xpath("//input[contains(@placeholder, 'Booth where He/She Votes')]"))
								.getAttribute("value");
						Assert.assertEquals(copiedBothWhereHeSheVotes, updatedBoothWhereHeSheVotes);

						// Voter Id
						copiedVoterId = driver.findElement(By.xpath("//input[contains(@placeholder, 'ex. UTC026351')]"))
								.getAttribute("value");
						Assert.assertEquals(copiedVoterId, updatedVoterId);

						// Aadhaar Number
						copiedAadhaarNumber = driver
								.findElement(By.xpath("//input[contains(@placeholder, 'ex. 765478961243')]"))
								.getAttribute("value");
						Assert.assertEquals(copiedAadhaarNumber, updatedAadharNumber);

						// Panna Number
						copiedPannaNumber = driver
								.findElement(By.xpath("//input[contains(@placeholder, 'Panna Number')]"))
								.getAttribute("value");
						Assert.assertEquals(copiedPannaNumber, updatedPannaNumber);

						// Ration Card
						copiedRationCard = driver
								.findElement(By.xpath("//input[contains(@placeholder, 'Ration Card Number')]"))
								.getAttribute("value");
						Assert.assertEquals(copiedRationCard, updatedRationCardNumber);

						// Facebook
						copiedFacebookValue = driver
								.findElement(By.xpath("//input[contains(@placeholder, 'www.fb.com/username')]"))
								.getAttribute("value");
						Assert.assertEquals(copiedFacebookValue, updatedFacebookProfile);

						// TwitterProfile
						copiedTwitterProfile = driver
								.findElement(By.xpath("//input[contains(@placeholder, 'www.twitter.com/username')]"))
								.getAttribute("value");
						Assert.assertEquals(copiedTwitterProfile, updatedTwitterProfile);

						// InstagramProfile
						copiedInstagramProfile = driver
								.findElement(By.xpath("//input[contains(@placeholder, 'www.instagram.com/username')]"))
								.getAttribute("value");
						Assert.assertEquals(copiedInstagramProfile, updatedInstagramProfile);

						// LinkedInProfile
						copiedLinkedInProfile = driver
								.findElement(By.xpath("//input[contains(@placeholder, 'www.linkedin.com/username')]"))
								.getAttribute("value");
						Assert.assertEquals(copiedLinkedInProfile, updatedLinkedinProfile);

						// Salutation
						copiedSalutation = driver.findElements(By.className("mat-select-value-text")).get(0).getText();
						Assert.assertEquals(copiedSalutation, updatedSalutation);

						// Sub Caste
						copiedSubCaste = driver.findElement(By.xpath("//input[contains(@placeholder, 'Sub caste')]"))
								.getAttribute("value");
						Assert.assertEquals(copiedSubCaste, updatedSubCaste);

						// Qualification
						copiedQualification = driver
								.findElement(By.xpath("//input[contains(@placeholder, 'Qualification')]"))
								.getAttribute("value");
						Assert.assertEquals(copiedQualification, updatedQualification);

						// Religion
						copiedReligion = driver.findElements(By.className("mat-select-value-text")).get(1).getText();
						Assert.assertEquals(copiedReligion, updatedReligion);

						// Active Member Id
						copiedActiveMemberId = driver
								.findElement(By.xpath("//input[contains(@placeholder, 'Active Member Id')]"))
								.getAttribute("value");
						Assert.assertEquals(copiedActiveMemberId, updatedActiveMemberId);

						// Select Party Zila Id
						WebElement SelectPartyZilaIdEle = driver
								.findElement(By.xpath("//div[contains(text(),'Select Party Zila Id')]"));
						copiedSelectedPartyZilaId = driver
								.findElement(with(By.className("ng-value-label")).below(SelectPartyZilaIdEle))
								.getText();
						Assert.assertEquals(copiedSelectedPartyZilaId, updatedPartyZila);

						// Select Party Mandal
						WebElement SelectPartyMandalEle = driver
								.findElement(By.xpath("//div[contains(text(),'Select Party Mandal')]"));
						copiedSelectedPartyMandalId = driver
								.findElement(with(By.className("ng-value-label")).below(SelectPartyMandalEle))
								.getText();
						Assert.assertEquals(copiedSelectedPartyMandalId, updatedPartyMandal);

						ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
						Thread.sleep(2000);

						// click on cancel button
						WebElement cancelButtonEle = driver.findElement(By.xpath("//span[contains(.,'Cancel')]"));
						js.executeScript("arguments[0].click();", cancelButtonEle);

//							

					}
				}

			}
		}
	}

	@And("^user search for data which need to qc$")
	public void user_scroll_to_view_data_table_and_search_for_data_which_need_to_qc() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//table")));
		// columns in table
		List<WebElement> colms = driver.findElements(By.xpath("//table/thead/tr/th"));
		int lastColNum = colms.size();
		for (int col = 0; col < lastColNum; col++) {
			String colmValue = colms.get(col).getText();
			System.out.println("colmsValue: " + colmValue);
			if (colmValue.contains("Phone Number")) {
				List<WebElement> phoneNumberRows = driver
						.findElements(By.xpath("//table/tbody/tr/td[" + (col + 1) + "]"));
				int phoneNumberRowSize = phoneNumberRows.size();
				System.out.println("phoneNumberRowSize: " + phoneNumberRowSize);
				for (int phoneNumberRow = 0; phoneNumberRow < phoneNumberRowSize; phoneNumberRow++) {
					System.out.println("phoneNumberRow:" + phoneNumberRow);
					String phoneNumberValue = phoneNumberRows.get(phoneNumberRow).getText();
					if (phoneNumberValue.contains(updatedPhoneNumber)) {
						System.out.println("phoneNumberValue>>: " + phoneNumberValue);
						WebElement actionButtonEle = driver
								.findElement(By.xpath("//table/tbody/tr[" + (phoneNumberRow + 1) + "]/td["
										+ (lastColNum) + "]//mat-icon[contains(.,'more_vert')]"));
						js.executeScript("arguments[0].click();", actionButtonEle);

						List<WebElement> actionAllEle = driver.findElements(By.xpath("//button//img"));
						wait.until(ExpectedConditions.visibilityOfAllElements(actionAllEle));
						WebElement qcStatusButtonEle = driver
								.findElement(By.xpath("//button//span[text()='QC status']"));
						js.executeScript("arguments[0].click();", qcStatusButtonEle);
						WebElement qcPopup = driver.findElement(By.xpath("//app-qc//div"));
						wait.until(ExpectedConditions.visibilityOf(qcPopup));

					}
				}

			}
		}

	}

	@And("^user qc all the data in qc pop up$")
	public void user_qc_all_the_data_in_qc_pop_up() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		js = (JavascriptExecutor) driver;
		WebElement qcImageEle = driver.findElement(By.xpath("//app-qc//img"));
		js.executeScript("arguments[0].scrollIntoView(true);", qcImageEle);
		List<WebElement> personalDetailQc = driver
				.findElements(By.xpath("//app-qc//div[@class='personal-detail']/div/span"));
		// name qc value verification
		String nameQcValue = personalDetailQc.get(1).getText();
		System.out.println("nameQcValue: " + nameQcValue);
		Assert.assertEquals(nameQcValue, copiedEnteredName);
		// relation name qc value verfication
		String relationQcValue = personalDetailQc.get(3).getText();
		System.out.println("relationQcValue: " + relationQcValue);
		Assert.assertEquals(relationQcValue, copiedEnteredFather_Husband_Name);
		// age qc value verification
		String ageQcValue = personalDetailQc.get(5).getText();
		System.out.println("ageQcValue: " + ageQcValue);
		Assert.assertEquals(ageQcValue, copiedAge);
		// designation qc value verification
		String designationQcValue = personalDetailQc.get(7).getText();
		System.out.println("designationQcValue: " + designationQcValue);
		Assert.assertEquals(designationQcValue, copiedSelectedDesignation);
		// has smartphone qc value verification
		String smartphoneQcValue = personalDetailQc.get(9).getText();
		System.out.println("smartphoneQcValue: " + smartphoneQcValue);
		Assert.assertEquals(smartphoneQcValue, copiedHasSmartPhone);
		// blood group qc value verification
		String bloodgroupQcValue = personalDetailQc.get(11).getText();
		System.out.println("bloodgroupQcValue: " + bloodgroupQcValue);
		Assert.assertEquals(bloodgroupQcValue, copiedBloodGroup);
		// mobile number qc value verification
		String mobilenumberQcValue = personalDetailQc.get(13).getText();
		System.out.println("mobilenumberQcValue: " + mobilenumberQcValue);
		Assert.assertEquals(mobilenumberQcValue, copiedPhoneNo);
		// primary member qc value verification
		String primarymemberQcValue = personalDetailQc.get(15).getText();
		System.out.println("primarymemberQcValue: " + primarymemberQcValue);
		Assert.assertEquals(primarymemberQcValue, copiedPrimaryMember);

		List<WebElement> personalSocialDetailsQcValue = driver
				.findElements(By.xpath("//div[@class='qc-person-social-detial']/div/div/span[2]"));
		// panna number qc value
		String pannanumberQcValue = personalSocialDetailsQcValue.get(0).getText();
		Assert.assertEquals(pannanumberQcValue, copiedPannaNumber);

		// ration card qc value
		String rationcardQcValue = personalSocialDetailsQcValue.get(1).getText();
		Assert.assertEquals(rationcardQcValue, copiedRationCard);

		// facebook profile qc value
		String facebookQcValue = personalSocialDetailsQcValue.get(2).getText();
		Assert.assertEquals(facebookQcValue, copiedFacebookValue);

		// twitter profile qc value
		String twitterQcValue = personalSocialDetailsQcValue.get(3).getText();
		Assert.assertEquals(twitterQcValue, copiedTwitterProfile);

		// instagram profile qc value
		String instagramQcValue = personalSocialDetailsQcValue.get(4).getText();
		Assert.assertEquals(instagramQcValue, copiedInstagramProfile);

		// Linkedin profile qc value
		String linkedinQcValue = personalSocialDetailsQcValue.get(5).getText();
		Assert.assertEquals(linkedinQcValue, copiedLinkedInProfile);

		// Qc person details
		List<WebElement> personDetailsQcvalue = driver
				.findElements(By.xpath("//div[@class='qc-person-details']/div/div/span[2]"));
		// gender qc value
		String genderQcValue = personDetailsQcvalue.get(0).getText();
		Assert.assertEquals(genderQcValue, "male");
		// whatsApp number qc value
		String whatsAppQcValue = personDetailsQcvalue.get(1).getText();
		Assert.assertEquals(whatsAppQcValue, copiedWhatsAppNumber);
		// Landline number qc value
		String landlineQcValue = personDetailsQcvalue.get(2).getText();
		String landline_stdValue = copiedStdCode + "-" + copiedLandLineNo;
		Assert.assertEquals(landlineQcValue, landline_stdValue);
		// Category qc value
		String categoryQcValue = personDetailsQcvalue.get(3).getText();
		Assert.assertEquals(categoryQcValue, copiedSelectedCategory);

		// Caste qc value
		String casteQcValue = personDetailsQcvalue.get(4).getText();
		Assert.assertEquals(casteQcValue, copiedSelectedCaste);

		// Email qc value
		String emailQcValue = personDetailsQcvalue.get(5).getText();
		Assert.assertEquals(emailQcValue, copiedEmail);

		// Dob qc value
		String dobQcValue = personDetailsQcvalue.get(6).getText();
		Assert.assertEquals(dobQcValue, copiedDob);

		// Address qc value
		String addressQcvalue = personDetailsQcvalue.get(7).getText();
		Assert.assertEquals(addressQcvalue, copiedFullAddress);

		// Village qc value
		String villageQcValue = personDetailsQcvalue.get(8).getText();
		Assert.assertEquals(villageQcValue, copiedVillage);

		// Taluka Tehsil Qc Value
		String talukaQcValue = personDetailsQcvalue.get(9).getText();
		Assert.assertEquals(talukaQcValue, copiedTaluka_Tehsil);

		// Distrcit qc value
		String districtQcValue = personDetailsQcvalue.get(10).getText();
		Assert.assertEquals(districtQcValue, copiedSelectedDistrict);

		// Pincode qc value
		String pincodeQcValue = personDetailsQcvalue.get(11).getText();
		Assert.assertEquals(pincodeQcValue, CopiedpinCode);

		// Education qc value
		String educationQcValue = personDetailsQcvalue.get(12).getText();
		Assert.assertEquals(educationQcValue, copiedSelectedEducation);

		// Profession qc value
		String professionQcValue = personDetailsQcvalue.get(13).getText();
		Assert.assertEquals(professionQcValue, copiedSelectedProfession);

		// Bike qc value
		String bikeQcValue = personDetailsQcvalue.get(14).getText();
		Assert.assertEquals(bikeQcValue, copiedHasBike);

		// Car qc value
		String carQcValue = personDetailsQcvalue.get(15).getText();
		Assert.assertEquals(carQcValue, copiedHasCar);

		// Vidhan Sabha qc value
		String vidhansabhaQcValue = personDetailsQcvalue.get(16).getText();
		Assert.assertEquals(vidhansabhaQcValue, copied_vidhanSabha_where_he_sheVotes);

		// Booth qc value
		String boothQcValue = personDetailsQcvalue.get(17).getText();
		Assert.assertEquals(boothQcValue, copiedBothWhereHeSheVotes);

		// Voter Id qc value
		String voteridQcValue = personDetailsQcvalue.get(18).getText();
		Assert.assertEquals(voteridQcValue, copiedVoterId);

		// Aadhar qc value
		String aadharQcValue = personDetailsQcvalue.get(19).getText();
		Assert.assertEquals(aadharQcValue, copiedAadhaarNumber);

		// Salutation qc value
		String salutationQcValue = personDetailsQcvalue.get(20).getText();
		Assert.assertEquals(salutationQcValue, copiedSalutation);

		// Sub Caste qc value
		String subcasteQcValue = personDetailsQcvalue.get(21).getText();
		Assert.assertEquals(subcasteQcValue, copiedSubCaste);

		// Religion qc value
		String religionQcValue = personDetailsQcvalue.get(22).getText();
		Assert.assertEquals(religionQcValue, copiedReligion);

		// Active Member Id qc value
		String activeMemberIdQcValue = personDetailsQcvalue.get(23).getText();
		Assert.assertEquals(activeMemberIdQcValue, copiedActiveMemberId);

		// Party Zila qc value
		String partyZilaQcValue = personDetailsQcvalue.get(24).getText();
		Assert.assertEquals(partyZilaQcValue, copiedSelectedPartyZilaId);

		// Party Mandal qc value
		String partyMandalQcValue = personDetailsQcvalue.get(25).getText();
		Assert.assertEquals(partyMandalQcValue, copiedSelectedPartyMandalId);

	}

	@And("^user click on qc done button and verify qc status$")
	public void user_click_on_qc_done_button_and_verify_qc_status() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		js = (JavascriptExecutor) driver;
		WebElement qcDoneButtonEle = driver.findElement(By.xpath("//div/button[contains(.,'Done & QCed')]"));
		js.executeScript("arguments[0].click();", qcDoneButtonEle);
		Thread.sleep(3000);

		// verification of qc status
		// columns size
		List<WebElement> colms = driver.findElements(By.xpath("//table/thead/tr/th"));
		int lastColNum = colms.size();
		for (int col = 0; col < lastColNum; col++) {
			String columValue = colms.get(col).getText();
			if (columValue.contains("Phone Number")) {
				List<WebElement> phoneNumberRows = driver
						.findElements(By.xpath("//table/tbody/tr/td[" + (col + 1) + "]"));
				int phoneNumberRowSize = phoneNumberRows.size();
				System.out.println("phoneNumberRowSize: " + phoneNumberRowSize);
				for (int phoneNumberRow = 0; phoneNumberRow < phoneNumberRowSize; phoneNumberRow++) {
					System.out.println("phoneNumberRow:" + phoneNumberRow);
					String phoneNumberValue = phoneNumberRows.get(phoneNumberRow).getText();
					if (phoneNumberValue.contains(updatedPhoneNumber)) {
						System.out.println("phoneNumberValue>>: " + phoneNumberValue);
						String qcedStatusText = driver
								.findElement(By.xpath(
										"//table/tbody/tr[" + (phoneNumberRow + 1) + "]/td[" + (lastColNum - 1) + "]"))
								.getText();

						Assert.assertEquals(qcedStatusText, "QCED");

					}
				}
			}
		}

	}

	@And("^user verify data in qc edit flow$")
	public void user_verify_data_in_qc_edit_flow() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(110));
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		js = (JavascriptExecutor) driver;
		user_scroll_to_view_data_table_and_search_for_data_which_need_to_qc();
		WebElement qcEditButton = driver.findElement(By.xpath("//button[contains(.,'QC Edit')]"));
		js.executeScript("arguments[0].click();", qcEditButton);
		// wait until edit qc form is visible
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@data-placeholder='Name']"))));

		// click on enter more details to extend form
		user_clicks_on_enter_more_details();
		Thread.sleep(2000);
		// get all the data from the update mode
		// Name
		copiedEnteredName = driver.findElement(By.xpath("//input[@placeholder='Name']")).getAttribute("value");
		Assert.assertEquals(copiedEnteredName.toUpperCase(), updatedName.toUpperCase());

		// Father's/Husband's Name
		copiedEnteredFather_Husband_Name = driver.findElement(By.xpath("//input[contains(@placeholder, 'Father')]"))
				.getAttribute("value");
		Assert.assertEquals(updatedFatherName.toUpperCase(), copiedEnteredFather_Husband_Name.toUpperCase());

		// Designation
		WebElement SelectDesignationEle = driver.findElement(By.xpath("//div[contains(text(),'Select Designation')]"));
		copiedSelectedDesignation = driver.findElement(with(By.className("ng-value-label")).below(SelectDesignationEle))
				.getText();
		Assert.assertEquals(copiedSelectedDesignation, updatedDesignation);

		// Has SmartPhone
		WebElement hasSmartPhoneEle = driver.findElement(By.xpath("//div[contains(text(),'Has Smartphone')]"));
		copiedHasSmartPhone = driver.findElement(with(By.className("ng-value-label")).below(hasSmartPhoneEle))
				.getText();
		Assert.assertEquals(copiedHasSmartPhone, updatedHasSmartPhone);

		// Phone Number
		copiedPhoneNo = driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).getAttribute("value");
		Assert.assertEquals(copiedPhoneNo, updatedPhoneNumber);

		// Primary Member
		copiedPrimaryMember = driver.findElement(By.xpath("//input[@placeholder='Primary Member Id']"))
				.getAttribute("value");
		Assert.assertEquals(copiedPrimaryMember, updatedPrimaryMemberId);

		// Age
		copiedAge = driver.findElement(By.xpath("//input[@placeholder='Age']")).getAttribute("value");
		Assert.assertEquals(copiedAge, updatedAge);
		int ageInt = Integer.parseInt(updatedAge);
		// Dob
		WebElement dobEle = driver.findElement(By.xpath("//input[@data-placeholder='Dob']"));
		String day_and_month_updated_dob = set_day_and_month_in_dob(ageInt);
		System.out.println("day_and_month_updated_dob= " + day_and_month_updated_dob);
		copiedDob = dobEle.getAttribute("value");
		Assert.assertEquals(day_and_month_updated_dob, copiedDob);

		// Blood Group
		WebElement BloodGroupEle = driver.findElement(By.xpath("//input[@data-placeholder='Blood Group']"));
		copiedBloodGroup = BloodGroupEle.getAttribute("value");
		Assert.assertEquals(copiedBloodGroup, updatedBloodGroup);
		// Gender
		String genderFormating = updatedGender.toLowerCase();
		if (genderFormating.equals("other")) {
			genderFormating = genderFormating + "s";
		}
		System.out.println("genderFormating :" + genderFormating);

		String classOfselectedGender = driver
				.findElement(By.xpath("//mat-radio-button[@value='" + genderFormating + "']")).getAttribute("class");
		System.out.println("classOfselectedGender :" + classOfselectedGender);
		Assert.assertEquals(classOfselectedGender.contains("mat-radio-checked"), true,
				"seems like gender is not selected");

		// WhatsApp
		copiedWhatsAppNumber = driver.findElement(By.xpath("//input[@placeholder='WhatsApp Number']"))
				.getAttribute("value");
		Assert.assertEquals(copiedWhatsAppNumber, updatedWhatsApp);

		// STD Code
		copiedStdCode = driver.findElement(By.xpath("//input[@placeholder='STD Code']")).getAttribute("value");
		Assert.assertEquals(copiedStdCode, updatedStdCode);

		// Landline Number
		copiedLandLineNo = driver.findElement(By.xpath("//input[@placeholder='Landline Number']"))
				.getAttribute("value");
		Assert.assertEquals(copiedLandLineNo, updatedLandlineNumber);

		// Select Category
		WebElement SelectCategoryEle = driver.findElement(By.xpath("//div[contains(text(),'Select Category')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", SelectCategoryEle);
		copiedSelectedCategory = driver
				.findElement(
						with(By.xpath("//span[@class='ng-value-label ng-star-inserted']")).below(SelectCategoryEle))
				.getText();
		Assert.assertEquals(copiedSelectedCategory, updatedCategory);

		// Caste
		WebElement SelectCasteEle = driver.findElement(By.xpath("//div[contains(text(),'Caste')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", SelectCasteEle);
		copiedSelectedCaste = driver
				.findElement(with(By.xpath("//span[@class='ng-value-label ng-star-inserted']")).below(SelectCasteEle))
				.getText();
		Assert.assertEquals(copiedSelectedCaste, updatedCaste);

		// Email
		copiedEmail = driver.findElement(By.xpath("//input[@placeholder='Email']")).getAttribute("value");
		Assert.assertEquals(copiedEmail, updatedEmail);

		// Full Address
		copiedFullAddress = driver.findElement(By.xpath("//input[@placeholder='Full Address']")).getAttribute("value");
		Assert.assertEquals(copiedFullAddress, updatedFullAddress);

		// Village
		copiedVillage = driver.findElement(By.xpath("//input[@placeholder='Village/Ward']")).getAttribute("value");
		Assert.assertEquals(copiedVillage, updatedVillage);

		// Taluka/Tehsil
		copiedTaluka_Tehsil = driver.findElement(By.xpath("//input[contains(@placeholder, 'Taluka')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedTaluka_Tehsil, updatedTaluka);

		// select district
		WebElement SelectDistrictEle = driver.findElement(By.xpath("//div[contains(text(),'Select District')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", SelectDistrictEle);
		copiedSelectedDistrict = driver
				.findElement(
						with(By.xpath("//span[@class='ng-value-label ng-star-inserted']")).below(SelectDistrictEle))
				.getText();
		Assert.assertEquals(copiedSelectedDistrict, updatedDistrict);

		// Pin Code
		CopiedpinCode = driver.findElement(By.xpath("//input[@placeholder='Pin Code']")).getAttribute("value");
		Assert.assertEquals(CopiedpinCode, updatedPinCode);

		// Select Education
		WebElement SelectEducationEle = driver.findElement(By.xpath("//div[contains(text(),'Select Education')]"));
		copiedSelectedEducation = driver
				.findElement(
						with(By.xpath("//span[@class='ng-value-label ng-star-inserted']")).below(SelectEducationEle))
				.getText();
		Assert.assertEquals(copiedSelectedEducation, updatedEducation);

		// Select Profession
		WebElement SelectProfessionEle = driver.findElement(By.xpath("//div[contains(text(),'Select Profession')]"));
		copiedSelectedProfession = driver
				.findElement(
						with(By.xpath("//span[@class='ng-value-label ng-star-inserted']")).below(SelectProfessionEle))
				.getText();
		Assert.assertEquals(copiedSelectedProfession, updatedProfession);

		// hasBike
		WebElement HasBikeEle = driver.findElement(By.xpath("//div[contains(text(),'Bike')]"));
		copiedHasBike = driver
				.findElement(with(By.xpath("//span[@class='ng-value-label ng-star-inserted']")).below(HasBikeEle))
				.getText();
		Assert.assertEquals(copiedHasBike, updatedBike);

		// hasCar
		WebElement HasCarEle = driver.findElement(By.xpath("//div[contains(text(),'Car')]"));
		copiedHasCar = driver
				.findElement(with(By.xpath("//span[@class='ng-value-label ng-star-inserted']")).below(HasCarEle))
				.getText();
		Assert.assertEquals(copiedHasCar, updatedCar);

		// vidhanSabha where he/she votes
		WebElement vidhanSabha_where_he_sheVotesEle = driver
				.findElement(By.xpath("//div[contains(text(),'Vidhan Sabha where He/She Votes')]"));
		copied_vidhanSabha_where_he_sheVotes = driver
				.findElement(with(By.xpath("//span[@class='ng-value-label ng-star-inserted']"))
						.below(vidhanSabha_where_he_sheVotesEle))
				.getText();

		// separating number and "-" from copied_vidhanSabha_where_he_sheVotes
		String[] vidhansabhaNameArr = copied_vidhanSabha_where_he_sheVotes.split("-");
		Assert.assertEquals(vidhansabhaNameArr[1].trim(), updatedVidhanSabhaWhereHeSheVotes);

		// Booth where He/She Votes
		copiedBothWhereHeSheVotes = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'Booth where He/She Votes')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedBothWhereHeSheVotes, updatedBoothWhereHeSheVotes);

		// Voter Id
		copiedVoterId = driver.findElement(By.xpath("//input[contains(@placeholder, 'ex. UTC026351')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedVoterId, updatedVoterId);

		// Aadhaar Number
		copiedAadhaarNumber = driver.findElement(By.xpath("//input[contains(@placeholder, 'ex. 765478961243')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedAadhaarNumber, updatedAadharNumber);

		// Panna Number
		copiedPannaNumber = driver.findElement(By.xpath("//input[contains(@placeholder, 'Panna Number')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedPannaNumber, updatedPannaNumber);

		// Ration Card
		copiedRationCard = driver.findElement(By.xpath("//input[contains(@placeholder, 'Ration Card Number')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedRationCard, updatedRationCardNumber);

		// Facebook
		copiedFacebookValue = driver.findElement(By.xpath("//input[contains(@placeholder, 'www.fb.com/username')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedFacebookValue, updatedFacebookProfile);

		// TwitterProfile
		copiedTwitterProfile = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'www.twitter.com/username')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedTwitterProfile, updatedTwitterProfile);

		// InstagramProfile
		copiedInstagramProfile = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'www.instagram.com/username')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedInstagramProfile, updatedInstagramProfile);

		// LinkedInProfile
		copiedLinkedInProfile = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'www.linkedin.com/username')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedLinkedInProfile, updatedLinkedinProfile);

		// Salutation
		copiedSalutation = driver.findElements(By.xpath("//mat-select")).get(1).getText();
		Assert.assertEquals(copiedSalutation, updatedSalutation);

		// Sub Caste
		copiedSubCaste = driver.findElement(By.xpath("//input[contains(@placeholder, 'Sub caste')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedSubCaste, updatedSubCaste);

		// Qualification
		copiedQualification = driver.findElement(By.xpath("//input[contains(@placeholder, 'Qualification')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedQualification, updatedQualification);

		// Religion
		copiedReligion = driver.findElements(By.xpath("//mat-select")).get(2).getText();
		Assert.assertEquals(copiedReligion, updatedReligion);

		// Active Member Id
		copiedActiveMemberId = driver.findElement(By.xpath("//input[contains(@placeholder, 'Active Member Id')]"))
				.getAttribute("value");
		Assert.assertEquals(copiedActiveMemberId, updatedActiveMemberId);

		// Select Party Zila Id
		WebElement SelectPartyZilaIdEle = driver
				.findElement(By.xpath("//div[contains(text(),'Select Party Zila Id')]"));
		copiedSelectedPartyZilaId = driver
				.findElement(
						with(By.xpath("//span[@class='ng-value-label ng-star-inserted']")).below(SelectPartyZilaIdEle))
				.getText();
		Assert.assertEquals(copiedSelectedPartyZilaId, updatedPartyZila);

		// Select Party Mandal
		WebElement SelectPartyMandalEle = driver.findElement(By.xpath("//div[contains(text(),'Select Party Mandal')]"));
		copiedSelectedPartyMandalId = driver
				.findElement(
						with(By.xpath("//span[@class='ng-value-label ng-star-inserted']")).below(SelectPartyMandalEle))
				.getText();
		Assert.assertEquals(copiedSelectedPartyMandalId, updatedPartyMandal);

		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);

		// click on update and mark qc button
		WebElement updateQCButtonEle = driver.findElement(By.xpath("//span[contains(.,'Update & Mark Qced')]"));
		js.executeScript("arguments[0].click();", updateQCButtonEle);

	}

	@And("^user edit all the data in qc edit flow$")
	public void user_edit_all_the_data_in_qc_edit_flow() {

	}

	// @And("^apply validation in phone number$")
	public void apply_validation_in_phone_number() throws InterruptedException {
		wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));

		WebElement PhoneNumberEle = driver.findElement(By.xpath("//input[@placeholder='Phone Number']"));
		WebElement PrimaryMemberIdEle = driver.findElement(By.xpath("//input[@placeholder='Primary Member Id']"));

		// enter less than 10 digit as Phone Number
		PhoneNumberEle.sendKeys("234");
		PrimaryMemberIdEle.click();
		Thread.sleep(2000);

		WebElement errorTextElement = driver.findElement(with(By.className("mat-error")).below(PhoneNumberEle));
		wait2.until(ExpectedConditions.textToBePresentInElement(errorTextElement, errorTextElement.getText()));
		System.out.println("errorTextElement text1:" + errorTextElement.getText());
		// enter wrong Phone Number
		PhoneNumberEle.clear();
		PhoneNumberEle.sendKeys("2222433434");
		PrimaryMemberIdEle.click();

		errorTextElement = driver.findElement(with(By.className("mat-error")).below(PhoneNumberEle));
		wait2.until(ExpectedConditions.textToBePresentInElement(errorTextElement, "Please enter a valid input"));
		System.out.println("errorTextElement text2:" + errorTextElement.getText());
		// PhoneNumberEle.sendKeys(phoneNumberValue);
		// correct Phone Number
		PhoneNumberEle.clear();

	}

	// @And("^apply validation in whatsApp number$")
	public void apply_validation_in_whatsapp_number() throws InterruptedException {

		wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement whatsAppEle = driver.findElement(By.xpath("//input[@placeholder='WhatsApp Number']"));
		WebElement stdCodeEle = driver.findElement(By.xpath("//input[@placeholder='STD Code']"));
		// Enter wrong whatsApp Number
		whatsAppEle.sendKeys("1234567890");
		js.executeScript("arguments[0].click();", stdCodeEle);
		Thread.sleep(2000);
		WebElement errorTextElement = driver.findElement(with(By.className("mat-error")).below(whatsAppEle));
		errorTextElement = driver.findElement(with(By.className("mat-error")).below(whatsAppEle));
		wait2.until(ExpectedConditions.textToBePresentInElement(errorTextElement, "Please enter a valid input"));
		whatsAppEle.clear();

	}

	// @And("^apply validation in category and caste$")
	public void apply_validation_in_category_and_caste() throws InterruptedException {
		// Select Category
		List<WebElement> selectCategoryEle = driver.findElements(By.xpath("//div[contains(text(),'Select Category')]"));
		System.out.println("selectCategoryEle size :" + selectCategoryEle.size());

		// Caste
		List<WebElement> CasteEle = driver.findElements(By.xpath("//div[contains(text(),'Caste')]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(CasteEle.get(0)).perform();
		Thread.sleep(4000);
		// Caste Tooltip
		WebElement casteToolltip = driver.findElement(By.xpath("//*[@class='mat-tooltip mat-tooltip-show']"));
		String copiedCasteTooltip = casteToolltip.getText();
		Assert.assertEquals(copiedCasteTooltip, "Please select a category first to enter or select a caste");
		System.out.println("copied text for caste tooltip :" + casteToolltip.getText());
		Thread.sleep(2000);
		actions.moveToElement(selectCategoryEle.get(0)).perform();

	}

	// @And("^apply validation in email$")
	public void apply_validation_in_email() throws InterruptedException {
		// Full Address
		WebElement fullAddressEle = driver.findElement(By.xpath("//input[@placeholder='Full Address']"));
		// Email
		WebElement emailEle = driver.findElement(By.xpath("//input[@placeholder='Email']"));
		// enter wrong email
		emailEle.sendKeys("dsdsd");
		fullAddressEle.click();
		Thread.sleep(2000);
		WebElement errorTextElement = driver.findElement(with(By.className("mat-error")));
		errorTextElement = driver.findElement(with(By.className("mat-error")).below(emailEle));
		wait2.until(ExpectedConditions.textToBePresentInElement(errorTextElement, "Please enter a valid input"));
		Thread.sleep(2000);
		emailEle.clear();
	}

	// @And("^apply validation in aadhar number$")
	public void apply_validation_in_aadhar_number() throws InterruptedException {
		// Voter Id
		WebElement voterIdValueEle = driver.findElement(By.xpath("//input[contains(@placeholder, 'ex. UTC026351')]"));
		// Aadhaar Number
		WebElement AadhaarNumberEle = driver
				.findElement(By.xpath("//input[contains(@placeholder, 'ex. 765478961243')]"));
		// Enter AadhaarNumber less than 12 digit
		AadhaarNumberEle.sendKeys("4343");
		voterIdValueEle.click();
		Thread.sleep(2000);
		WebElement errorTextElement = driver.findElement(with(By.className("mat-error")));
		errorTextElement = driver.findElement(with(By.className("mat-error")).below(AadhaarNumberEle));
		wait2.until(
				ExpectedConditions.textToBePresentInElement(errorTextElement, "Enter valid 12 digit aadhar number"));
		AadhaarNumberEle.clear();

	}

	// @And("^apply validation in panna number$")
	public void apply_validation_in_panna_number() throws InterruptedException {
		wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));
		// Voter Id
		WebElement voterIdValueEle = driver.findElement(By.xpath("//input[contains(@placeholder, 'ex. UTC026351')]"));
		// Panna Number
		WebElement PannaNumberEle = driver.findElement(By.xpath("//input[contains(@placeholder, 'Panna Number')]"));
		// Enter PannaNumber less than 3
		PannaNumberEle.sendKeys("1");
		voterIdValueEle.click();
		Thread.sleep(2000);
		WebElement errorTextElement = driver.findElement(with(By.className("mat-error")));
		errorTextElement = driver.findElement(with(By.className("mat-error")).below(PannaNumberEle));
		wait2.until(ExpectedConditions.textToBePresentInElement(errorTextElement, "Please enter a valid input"));
		PannaNumberEle.clear();

	}

	public void apply_validation_in_party_zila_and_mandal() throws InterruptedException {
		// click Select Party Mandal
		WebElement SelectPartyMandalEle = driver.findElement(By.xpath("//div[contains(text(),'Select Party Mandal')]"));
		SelectPartyMandalEle.click();
		WebElement popUpEle = driver.findElement(By.className("mat-simple-snack-bar-content"));
		String popUpTextPatyMandal = wait.until(ExpectedConditions.visibilityOf(popUpEle)).getText();
		System.out.println("popUpTextPatyMandal :" + popUpTextPatyMandal);
		Assert.assertEquals(popUpTextPatyMandal, "Please select party zila");
		ngDriver.withRootSelector("\"app-root\"").waitForAngularRequestsToFinish();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.invisibilityOf(popUpEle));

	}

	public void apply_validation_in_dob() throws InterruptedException {
		wait2 = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement dobEle = driver.findElement(By.xpath("//input[@data-placeholder='Dob']"));
		WebElement PannaNumberEle = driver.findElement(By.xpath("//input[contains(@placeholder, 'Panna Number')]"));
		String dobValue = "01/12/2022";
		dobEle.sendKeys(dobValue);
		PannaNumberEle.click();
		Thread.sleep(2000);
		WebElement errorTextElement = driver.findElement(with(By.xpath("//mat-error")).below(dobEle));
		wait2.until(ExpectedConditions.textToBePresentInElement(errorTextElement, "Minimum age should be 18 years"));
		dobEle.clear();

	}

	public String dob_calculation_based_on_age_input(int age) {

		Calendar calendar = Calendar.getInstance(); // get calender or instance of current date and time
		calendar.add(Calendar.YEAR, -age); // decrease calender year by given age
		calendar.set(Calendar.DATE, 1); // set calender date by 1
		calendar.set(Calendar.MONTH, 0); // set calender month by 1 means january
		// below code for getting date in proper format
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDOB = dateFormat.format(calendar.getTime());
		System.out.println(formattedDOB);
		return formattedDOB;

	}

	public String set_day_and_month_in_dob(int age) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -age);
		calendar.set(Calendar.DATE, 29);
		calendar.set(Calendar.MONTH, 4);
		// below code for getting date in proper format
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String setDOB = dateFormat.format(calendar.getTime());
		System.out.println(setDOB);
		return setDOB;

	}

	public void get_Karyakarta_Data_To_Edit(String phoneNumber) throws InterruptedException {

		List<WebElement> colms = driver.findElements(By.xpath("//table/thead/tr/th"));
		int lastColNum = colms.size();
		for (int col = 0; col < lastColNum; col++) {
			String colmValue = colms.get(col).getText();
			System.out.println("colmsValue: " + colmValue);
			if (colmValue.contains("Phone Number")) {
				List<WebElement> phoneNumberRows = driver
						.findElements(By.xpath("//table/tbody/tr/td[" + (col + 1) + "]"));
				int phoneNumberRowSize = phoneNumberRows.size();
				System.out.println("phoneNumberRowSize: " + phoneNumberRowSize);
				for (int phoneNumberRow = 0; phoneNumberRow < phoneNumberRowSize; phoneNumberRow++) {
					System.out.println("phoneNumberRow:" + phoneNumberRow);
					String phoneNumberValue = phoneNumberRows.get(phoneNumberRow).getText();
					if (phoneNumberValue.contains(phoneNumber)) {
						System.out.println("phoneNumberValue>>: " + phoneNumberValue);
						WebElement actionButtonEle = driver
								.findElement(By.xpath("//table/tbody/tr[" + (phoneNumberRow + 1) + "]/td["
										+ (lastColNum) + "]//mat-icon[contains(.,'more_vert')]"));
						js.executeScript("arguments[0].click();", actionButtonEle);

						List<WebElement> actionAllEle = driver.findElements(By.xpath("//button//img"));
						wait.until(ExpectedConditions.visibilityOfAllElements(actionAllEle));
						WebElement editButtonEle = driver.findElement(By.xpath("//button//span[text()='Edit']"));
						js.executeScript("arguments[0].click();", editButtonEle);
						ngDriver = new NgWebDriver((JavascriptExecutor) driver);
						Thread.sleep(2000);

					}
				}
			}
		}
	}
}
