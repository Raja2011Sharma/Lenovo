package SaralStaging.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class elementutil {

    public static void sendOTPDigits(WebDriver driver, String otp, String otp_input) {
        for (int i = 0; i < otp.length(); i++) {
            String dynamicXpath = "(" + otp_input + ")[" + (i + 1) + "]";
            WebElement otpElement = driver.findElement(By.xpath(dynamicXpath));
            char digit = otp.charAt(i);
            otpElement.sendKeys(Character.toString(digit));
        }
    }
}
