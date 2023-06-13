package Com.qa.testing;

import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.netty.channel.unix.Errors;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


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
            Main.scroll(ScrollDriection.Down,0.4);
            Thread.sleep(3000);
            Main.scroll(ScrollDriection.UP,0.4);


        }
        public enum ScrollDriection{
            UP,Down,Left,Right
        }

        public static void scroll(ScrollDriection dir,double scrollRatio){
            Duration SCROLL_DUR = Duration.ofMillis(1000);
            if (scrollRatio < 0|| scrollRatio > 1){
                throw new Error("Scroll distance must be betwooen 0 and 1");
            }

            Dimension size = Main.driver.manage().window().getSize();
            System.out.println(size);


            Point midpoint = new Point((int)(size.width*0.5),(int)(size.height*0.5));
            int bottom = midpoint.y + (int)(midpoint.y*scrollRatio);
            int top = midpoint.y - (int)(midpoint.y*scrollRatio);
            int left = midpoint.x + (int)(midpoint.x*scrollRatio);
            int right = midpoint.x - (int)(midpoint.x*scrollRatio);


            if (dir== ScrollDriection.UP){
                swpie(new Point(midpoint.x, top),new Point(midpoint.x,bottom),SCROLL_DUR);

            } else if (dir== ScrollDriection.Down) {
                swpie(new Point(midpoint.x, bottom),new Point(midpoint.x,top),SCROLL_DUR);
            } else if (dir== ScrollDriection.Left) {
                swpie(new Point(left,midpoint.x),new Point(right,midpoint.x),SCROLL_DUR);
            }
            else {
                swpie(new Point(right,midpoint.x),new Point(left,midpoint.x),SCROLL_DUR);
            }


//            Point start = new Point(midpoint.x, bottom);
//            Point end = new Point(midpoint.x, top);

//            swpie(start,end,SCROLL_DUR);
        }

         protected static void swpie(Point start, Point end, Duration duration){

             PointerInput input = new PointerInput(PointerInput.Kind.TOUCH,"finge1");
             Sequence swipe = new Sequence(input,0);
             swipe.addAction(input.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(),start.x,start.y));
             swipe.addAction(input.createPointerDown( PointerInput.MouseButton.LEFT.asArg()));
             swipe.addAction(input.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(),end.x,end.y));
             swipe.addAction(input.createPointerUp( PointerInput.MouseButton.LEFT.asArg()));

             ((AppiumDriver) Main.driver).perform((ImmutableList.of(swipe)));

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