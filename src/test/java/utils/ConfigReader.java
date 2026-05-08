package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    static Properties prop;
    static {
        try {
            prop = new Properties();
            InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");
            prop.load(input);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(
            String key) {

        return prop.getProperty(key);
    }
}