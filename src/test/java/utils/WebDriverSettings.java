package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class WebDriverSettings extends GoogleDriver {
    private Properties properties = new Properties();

    public WebDriverSettings() {
        BufferedReader reader;

        try {
            String propertyPath = "src/main/resources/data.properties";
            reader = new BufferedReader(new FileReader(propertyPath));
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return properties;
    }
}
