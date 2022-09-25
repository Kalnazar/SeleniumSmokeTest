package preConditions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.WebDriverSettings;

import java.time.Duration;

import static utils.WebDriverSettings.properties;

public class Login {

    @BeforeTest
    public void login() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Programming\\Drivers\\chromedriver_win32\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        try {
            driver.get(properties.getProperty("url"));
            Thread.sleep(2000);

            WebElement login = driver.findElement(By.xpath(properties.getProperty("loginBtn")));
            login.click();

            WebElement input = driver.findElement(By.xpath(properties.getProperty("userLogin")));
            input.sendKeys(properties.getProperty("phoneNumber"), Keys.ENTER);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            WebElement password = driver.findElement(By.xpath(properties.getProperty("userPassword")));
            password.click();
            password.sendKeys(properties.getProperty("password"), Keys.ENTER);

            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
            driver.quit();
        }
    }

}
