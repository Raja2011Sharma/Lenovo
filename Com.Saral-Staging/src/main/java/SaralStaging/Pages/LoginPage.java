package SaralStaging.Pages;

import SaralStaging.Utils.elementutil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
String expetedotp="010203";
    //By Locators:
    private By emailId =By.name("email");
    private By password=By.name("password");
    private By sendotp=By.xpath("//button/span[contains(.,'Send OTP')]");
    private By otp_input=By.xpath("//input[@type='password']");
    private By loginButton=By.tagName("button");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public String getLoginPageTitle(){
        return driver.getTitle();

    }
    public void phone_number(String PhoneNumber){
        driver.findElement(emailId).sendKeys(PhoneNumber);

    }
    public void Email_id(String EamiliD){
        driver.findElement(emailId).sendKeys(EamiliD);

    }
    public void Password(String PassWord){
        driver.findElement(password).sendKeys(PassWord);

    }
    public void SendOTP(){
        driver.findElement(sendotp).click();

    }
    public void OtpInput(String     sendOtp){
        elementutil.sendOTPDigits(driver,sendOtp,"otp_input");

    }
    public void login(){
        driver.findElement(loginButton).click();

    }
}
