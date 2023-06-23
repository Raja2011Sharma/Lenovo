package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class WaitUtils {

	JavascriptExecutor js;
	WebDriver driver;

	public void waitForPageLoad() {
		
		

		js = (JavascriptExecutor) driver;
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page has loaded");
		}
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				System.out.println("Page has not loaded yet ");
			}
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}

		}
	}
}
