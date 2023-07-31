package SaralStaging.StepDefination;

import SaralStaging.Pages.LoginPage;
import SaralStaging.factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.yaml.snakeyaml.events.Event;

import java.util.Properties;

public class LoginSteps {
private WebDriver driver;
private Properties prop;
    private static String title;
    private LoginPage loginPage = new LoginPage(DriverFactory.driver);
    @Given("user is on login page")
    public void user_is_on_login_page() {
        new ChromeDriver();
//driver.get("https://zila-staging.ccdms.in/");
        driver =DriverFactory.getDriver();
                driver.get(prop.getProperty("url"));
//                "https://zila-staging.ccdms.in/"

    }

    @When("user gets title of the page")
    public void user_gets_title_of_the_page() {
        title= loginPage.getLoginPageTitle();
        System.out.println("Logintitle page is :"+title);
        throw new io.cucumber.java.PendingException();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedtitlename) {
        Assert.assertTrue(title.contains(expectedtitlename));
        throw new io.cucumber.java.PendingException();
    }

    @When("user enters phone number{string}")
    public void user_enters_phone_number(String PhoneNumber) {
    loginPage.phone_number(PhoneNumber);
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on otp")
    public void user_clicks_on_otp() {
loginPage.SendOTP();
        throw new io.cucumber.java.PendingException();
    }

    @When("user enters otp {string}")
    public void user_enters_otp(String sendOtp) {
    loginPage.OtpInput(sendOtp);
        throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on login")
    public void user_clicks_on_login() {
       loginPage.login();
        throw new io.cucumber.java.PendingException();
    }





    @When("user enters Email id {string}")
    public void user_enters_email_id(String Emailid) {
        loginPage.Email_id(Emailid);
        throw new io.cucumber.java.PendingException();
    }

    @When("user enters Password {string}")
    public void user_enters_password(String PassWord) {
        loginPage.Password(PassWord);
        throw new io.cucumber.java.PendingException();
    }

    @Then("user gets the title of the Homepage")
    public void user_gets_the_title_of_the_homepage() {
        title= loginPage.getLoginPageTitle();
        System.out.println("Logintitle page is :"+title);
        throw new io.cucumber.java.PendingException();
    }


}
