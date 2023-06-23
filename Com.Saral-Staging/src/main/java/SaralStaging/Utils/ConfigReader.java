package SaralStaging.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties prop;
    public Properties InitProp(){
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("C:\\Users\\Lenovo\\intellij_workspace\\Com.Saral-Staging\\src\\test\\Resouces\\SaralStagingCOnfig\\Config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        return prop;
    }
}
