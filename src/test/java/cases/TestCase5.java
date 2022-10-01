package cases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import preConditions.PreCondition;

import java.time.Duration;

public class TestCase5 {
    PreCondition conditions;

    @Test
    void testCase5() throws InterruptedException {
        conditions = new PreCondition();

        try {
            conditions.navigation();
            Thread.sleep(1000);

            WebElement loginBtn = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("loginBtn")
            ));
            loginBtn.click();

            WebElement phoneNumber = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("userLogin")
            ));
            phoneNumber.sendKeys(conditions.getProperties().getProperty("phoneNumber"), Keys.ENTER);

            conditions.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    conditions.getProperties().getProperty("forgotPassword")
            )));
            WebElement forgotPassword = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("forgotPassword")
            ));
            forgotPassword.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
            conditions.getDriver().quit();
        }

    }

}
