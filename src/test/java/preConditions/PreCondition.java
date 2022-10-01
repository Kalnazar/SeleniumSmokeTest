package preConditions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverSettings;

import java.time.Duration;

public class PreCondition extends WebDriverSettings {
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));

    public void navigation() {
        getDriver().get(getProperties().getProperty("url"));
    }

    public void login() throws InterruptedException {

        try {
            navigation();
            Thread.sleep(1000);

            WebElement login = getDriver().findElement(By.xpath(
                    getProperties().getProperty("loginBtn")
            ));
            login.click();

            WebElement phoneNumber = getDriver().findElement(By.xpath(
                    getProperties().getProperty("userLogin")
            ));
            phoneNumber.sendKeys(getProperties().getProperty("phoneNumber"), Keys.ENTER);

            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            WebElement password = getDriver().findElement(By.xpath(
                    getProperties().getProperty("userPassword")
            ));
            password.click();
            password.sendKeys(getProperties().getProperty("password"), Keys.ENTER);

            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = getDriver().switchTo().alert();
            alert.dismiss();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
