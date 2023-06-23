package TestPages;

import Jarvis.qa.sso.constant.ApplicationConstant;
import Jarvis.qa.sso.factory.PlaywrightFactory;
import Jarvis.qa.sso.pages.LoginPage;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testbase.TestBase;

public class LoginTest extends TestBase {

    @Test
    public void logintest() throws InterruptedException {
       loginpage.doLogin("sarada.assam.admin@gmail.com","Sarada@123","010203");
    }
    @Test
    public void LoginTitleTest(){
        String actualTitle = loginpage.getLoginPageTitle();

    Assert.assertEquals(actualTitle, ApplicationConstant.Login_page_Title);
}
}
