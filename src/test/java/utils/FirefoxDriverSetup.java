package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverSetup {
    private final WebDriver driver;

    public FirefoxDriverSetup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Programming\\Drivers\\geckodriver-v0.31.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
