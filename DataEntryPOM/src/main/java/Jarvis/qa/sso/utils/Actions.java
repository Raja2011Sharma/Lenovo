package Jarvis.qa.sso.utils;

import com.microsoft.playwright.Page;

public class Actions {
private Actions(){
}
    public static void sendOTPDigits(Page page, String otp, String Otp) {
        for (int i = 0; i < otp.length(); i++) {
            String dynamicXpath = "(" + Otp + ")[" + (i + 1) + "]";
            page.fill(dynamicXpath, String.valueOf(otp.charAt(i)));
        }
    }
}
