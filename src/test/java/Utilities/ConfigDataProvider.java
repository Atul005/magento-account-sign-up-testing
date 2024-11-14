package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

    Properties properties;

    public ConfigDataProvider(){
        String fileName = System.getProperty("user.dir") + "/Configurations/Config.properties";

        try {
            File file = new File(fileName);
            FileInputStream fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getBrowser(){
        return properties.getProperty("BROWSER");
    }

    public String getURL(){
        return properties.getProperty("URL");
    }

}
