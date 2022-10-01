package cases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import preConditions.PreCondition;

import java.time.Duration;

public class TestCase2 {
    PreCondition conditions;

    @Test
    void testCase2() throws InterruptedException {
        conditions = new PreCondition();

        conditions.navigation();
        try {
            Thread.sleep(1000);
            WebElement login = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("loginBtn")
            ));
            login.click();
            WebElement phoneNumber = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("userLogin")
            ));
            phoneNumber.sendKeys(conditions.getProperties().getProperty("invalid"), Keys.ENTER);

            Thread.sleep(2000);

            phoneNumber.clear();
            phoneNumber.sendKeys(conditions.getProperties().getProperty("phoneNumber"), Keys.ENTER);

            WebElement password = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("userPassword")
            ));
            Thread.sleep(1000);
            password.click();
            password.sendKeys(conditions.getProperties().getProperty("invalid"), Keys.ENTER);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
            conditions.getDriver().quit();
        }
    }
}
