package Com.qa.testing;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.MobileBy;
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
import java.util.concurrent.TimeUnit;

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.saral.application:id/et_mobile")).sendKeys("5111909070");
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.Button")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("com.saral.application:id/otp_view")).sendKeys("010203");
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.Button")).click();
      Thread.sleep(15000);
//        Main.scroll(Main.ScrollDriection.Down,0.4);
//        Thread.sleep(3000);
//        Main.scroll(Main.ScrollDriection.UP,0.4);
//Appium Code
     // driver.findElement(By.xpath("")).click();
//        driver.findElement(By.xpath("")).sendKeys();
        // driver.findElement(By.id("")).click();
//        driver.findElement(By.xpath("")).sendKeys();


        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/androidx.cardview.widget.CardView[1]/android.widget.ImageView")).click();
        Thread.sleep(3000);  Thread.sleep(3000);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Saral image description\"])[4]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView")).click();
        Thread.sleep(20000);
        driver.findElement(By.id("com.saral.application:id/fab_add")).click();
        Thread.sleep(20000);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.EditText")).sendKeys("Raja");

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.EditText")).sendKeys("Sajaja");

        driver.findElement(By.id("com.saral.application:id/tv_value")).click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout\n" +
                "/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/\n" +
                "androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.TextView")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/\n" +
                "android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/\n" +
                "androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.EditText")).sendKeys("5494898441");
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout\n" +
                "/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/\n" +
                "androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[7]/android.widget.EditText")).sendKeys("4323232345");
//        (new TouchAction( driver))
//                .press(PointOption.point(596, 643}))
//            .moveTo(PointOption.point(557, 159}))
//        .release()
//        .perform();
//
//        (new TouchAction(driver))
//        .press(PointOption.point(446, 1976}))
//        .moveTo(PointOption.point(566, 617}))
//        .release()
//        .perform();

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/"+
        "android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/"+
        "androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[7]/android.widget.EditText")).sendKeys("23");

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/"+
                "android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/"+
                        "androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[8]/android.widget.EditText")).sendKeys("o");
      driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Male\"))"));

        driver.findElement(By.id("com.saral.application:id/rb_male")).click();
//        (new TouchAction(driver))
//        .press(PointOption.point(437, 1899}))
//        .moveTo(PointOption.point(437, 793}))
//        .release()
//        .perform();
//
//        (new TouchAction(driver))
//        .press(PointOption.point(497, 2109}))
//        .moveTo(PointOption.point(549, 780}))
//        .release()
//        .perform();

        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[5]/android.widget.TextView[2]")).click();
        driver.findElement(By.id("com.saral.application:id/iv_down")).click();
        driver.findElement(By.id("com.saral.application:id/btn_preview")).click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/\n" +
                "android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/\n" +
                "androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView[2]")).click();
        // driver.findElement(By.xpath("")).click();
//        driver.findElement(By.xpath("")).sendKeys();
        // driver.findElement(By.id("")).click();
//        driver.findElement(By.xpath("")).sendKeys();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/\n" +
                "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/\n" +
                "androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView")).click();
        driver.findElement(By.id("com.saral.application:id/iv_down")).click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/\n" +
                "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/\n" +
                "androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView")).click();
        driver.findElement(By.id("com.saral.application:id/btn_preview")).click();
//        (new TouchAction(driver))
//                .press(PointOption.point(544, 540}))
//            .moveTo(PointOption.point(566, 326}))
//        .release()
//        .perform();
//
//        (new TouchAction(driver))
//        .press(PointOption.point(480, 2109}))
//        .moveTo(PointOption.point(429, 746}))
//        .release()
//        .perform();
//
//        (new TouchAction(driver))
//        .press(PointOption.point(510, 2053}))
//        .moveTo(PointOption.point(489, 583}))
//        .release()
//        .perform();
        driver.findElement(By.id("com.saral.application:id/btn_submit")).click();
        driver.findElement(By.id("com.saral.application:id/btn_skip")).click();

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
