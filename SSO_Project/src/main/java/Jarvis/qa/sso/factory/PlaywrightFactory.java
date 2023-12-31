package Jarvis.qa.sso.factory;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
public class PlaywrightFactory {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;


    public Page initBrowser(String browserName){
        System.out.println("browser name is "+ browserName);
        playwright=Playwright.create();
        switch (browserName.toLowerCase()){
            case "chromium":
                browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser= playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari":
                browser= playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser= playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            default:
                System.out.println("Please pass the right browser name....");
                break;

        }
        browserContext = browser.newContext();
        page =browserContext.newPage();
        page.navigate("https://staging-sso.ccdms.in/");
        return page;
    }


}
