package SaralStaging.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    //By Locators:
    private By emailId =By.name("email");
    private By password=By.name("password");
    private By otpButton=By.xpath("//button/span[contains(.,'Send OTP')]");
    private By loginButton=By.tagName("button");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public String getLoginPageTitle(){
        return driver.getTitle();

    }
}
