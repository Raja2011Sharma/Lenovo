package Com.qa.testing;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DataEntry {

    private static AppiumDriver driver;
    public AppiumDriverLocalService service;
    @BeforeMethod
    public void setUp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability("appPackage", "com.saral.application");
        caps.setCapability("appActivity", "com.saral.application.ui.modules.splash.SplashActivity");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");




        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, caps);
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.saral.application:id/et_mobile")).sendKeys("5111909070");
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.Button")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.saral.application:id/otp_view")).sendKeys("010203");
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.Button")).click();
        Thread.sleep(5000);
        Main.scroll(Main.ScrollDriection.Down,0.4);
        Thread.sleep(3000);
        Main.scroll(Main.ScrollDriection.UP,0.4);
//Appium Code
     // driver.findElement(By.xpath("")).click();
//        driver.findElement(By.xpath("")).sendKeys();
        // driver.findElement(By.id("")).click();
//        driver.findElement(By.xpath("")).sendKeys();


        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/\n" +
                " android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/\n" +
                " android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.\n" +
                " CardView[1]/android.widget.ImageView")).click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android\n" +
                ".widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.\n" +
                "ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")).click();
        driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Saral image description\"])[4]")).click();
        driver.findElement(By.xpath("\n" +
                "MobileElement el4 = (MobileElement) driver.findElementByXPath(\"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/\n" +
                "android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.\n" +
                "RecyclerView/android.view.ViewGroup[1]/android.widget.TextView")).click();
        driver.findElement(By.id("com.saral.application:id/fab_add")).click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/\n" +
                "android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/\n" +
                "androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.EditText")).sendKeys("Raja");
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/\n" +
                "android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/\n" +
                "androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.EditText")).sendKeys("Sajaja");
        driver.findElement(By.id("com.saral.application:id/tv_value")).click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout\n" +
                "/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/\n" +
                "androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.TextView")).click();

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/\n" +
                "android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/\n" +
                "androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.EditText")).sendKeys("5494898441");
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout\n" +
                "/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/\n" +
                "androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[7]/android.widget.EditText")).sendKeys("4323232345");
        (new TouchAction( driver))
                .press(PointOption.point(596, 643}))
            .moveTo(PointOption.point(557, 159}))
        .release()
        .perform();

        (new TouchAction(driver))
        .press(PointOption.point(446, 1976}))
        .moveTo(PointOption.point(566, 617}))
        .release()
        .perform();


        }
    @Test
    public void sampleTest() {
        System.out.println("hellod");
//		driver.findElement(
//				"C:\Program Files\Appium Server GUI\resources\app\node_modules\appium\build\lib\main.js"
    }


//	  @AfterMethod
//	  public void tearDown() {
//	    driver.quit();
//	  }

}
