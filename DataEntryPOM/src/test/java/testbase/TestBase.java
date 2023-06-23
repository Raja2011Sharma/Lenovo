package testbase;

import Jarvis.qa.sso.factory.PlaywrightFactory;
import Jarvis.qa.sso.pages.LoginPage;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Properties;

public class TestBase {
    PlaywrightFactory pf;
    protected Properties prop;
    protected Page page;
    protected LoginPage loginpage;

    @BeforeTest
    public void setup() throws IOException {
        pf = new PlaywrightFactory();
       prop= pf.initiliazeProp();
        page = pf.initBrowser(prop);
        loginpage = new LoginPage(page);

    }
    @AfterTest
    public void teardown(){
        page.context().browser().close();
    }
}
