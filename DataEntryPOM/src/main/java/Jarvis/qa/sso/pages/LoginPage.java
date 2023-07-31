package Jarvis.qa.sso.pages;

import java.util.PrimitiveIterator;

import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {

    private Page page;
    //1. String Locator
    private String Emailbox = "input[placeholder='Email Address/Phone No.']";
    private String Loginbox = "input[placeholder='Password']";
    private String OtpButton = "//button//span[@class='mat-button-focus-overlay']";
    private String Otp ="//input[@type='password']";
//    private String Login="//button//span[@class='mat-button-focus-overlay']";
    private String Login="//button[@class='mat-focus-indicator btn orange-btn login-form-field login mat-button mat-button-base']";
    private String password_icon= "//mat-icon[@aria-hidden='true']";

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
    public void doLogin(String UserName) throws InterruptedException {


        page.fill(Emailbox,UserName);
        page.keyboard().press("Enter");
//        page.fill(Loginbox,PassWord);
        page.click(OtpButton);
//        page.fill(Otp,otp);
       Thread.sleep(5000);
//       page.click(Login);
    }
    public void enterOTP(String otp) throws InterruptedException {
        Thread.sleep(5000);
        for (int i = 0; i < otp.length(); i++) {
            String dynamicXpath = "" + Otp + "[" + (i + 1) + "]";
            page.fill(dynamicXpath, String.valueOf(otp.charAt(i)));
        }
       page.click(password_icon);
      Thread.sleep(3000);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log In")).click();
///        page.hover(Login);
//        page.waitForClickable(Login);
//        page.click(Login);
//        page.evaluate("console.log");
//        page.keyboard().press("Enter");
        Thread.sleep(50000);
    }
}
