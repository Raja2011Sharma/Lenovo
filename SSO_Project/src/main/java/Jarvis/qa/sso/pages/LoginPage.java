package Jarvis.qa.sso.pages;

import java.util.PrimitiveIterator;
import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;
    //1. String Locator
    private String Emailbox = "input[placeholder='Email Address']";
    private String Loginbox = "input[placeholder='Password']";
    private String OtpButton = "//button//span[@class='mat-button-focus-overlay']";

    private String Otp ="#c_r5wfahjv0xfli60ml9a";

    private String Login=" //button[@class='mat-focus-indicator login-button login-form-field mt-1 mat-button mat-button-base ng-star-inserted']";

    //Page constructor
    public LoginPage(Page page){
        this.page=page;
    }

    //Page Actons
    public String getLoginPageTitle(){
        return page.title();
    }
    public String getLoginPageUrl(){
        return page.url();
    }
    public void doLogin(String UserName,String PassWord,String otp) throws InterruptedException {
        page.fill(Emailbox,UserName);
        page.fill(Loginbox,PassWord);
        page.click(OtpButton);
//        page.fill(Otp,otp);
        Thread.sleep(5000);
        page.click(Login);
    }
}
