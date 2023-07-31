package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	public Properties intializeProperties() {
		prop = new Properties();
		File proFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\config.properties");

		try {
			FileInputStream fis = new FileInputStream(proFile);
			prop.load(fis);
			System.out.println("Invoking browser file");
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

		return prop;

	}

}
