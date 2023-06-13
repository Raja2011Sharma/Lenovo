package TestPages;

import Jarvis.qa.sso.factory.PlaywrightFactory;
import Jarvis.qa.sso.pages.LoginPage;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    PlaywrightFactory pf;
    Page page;
    LoginPage loginpage;

    @BeforeTest
    public void setup(){
        pf = new PlaywrightFactory();
        page = pf.initBrowser("chrome");
        loginpage = new LoginPage(page);

    }
    @Test
    public void logintest() throws InterruptedException {
       loginpage.doLogin("nationaladminssouser@gmail.com","Test@123","010203");
    }
    @AfterTest
    public void teardown(){
        page.context().browser().close();
    }
}
