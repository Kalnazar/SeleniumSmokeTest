package cases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import preConditions.PreCondition;

public class TestCase16 {
    PreCondition conditions;

    @Test
    void testCase16() throws InterruptedException {
        conditions = new PreCondition();

        try {
            conditions.login();
            Thread.sleep(1000);

            conditions.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    conditions.getProperties().getProperty("profileBtn")
            )));
            WebElement profileBtn = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("profileBtn")
            ));
            profileBtn.click();

            Thread.sleep(1000);
            conditions.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    conditions.getProperties().getProperty("settingsBtn")
            )));
            WebElement settingsBtn = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("settingsBtn")
            ));
            settingsBtn.click();

            conditions.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(
                    conditions.getProperties().getProperty("changePasswordNav")
            ))).click();
            conditions.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(
                    conditions.getProperties().getProperty("changePasswordBtn")
            ))).click();

            WebElement currentPasswordField = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("currentPasswordField")
            ));
            currentPasswordField.sendKeys(conditions.getProperties().getProperty("password"), Keys.ENTER);

            WebElement newPasswordField = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("newPasswordField")
            ));
            newPasswordField.sendKeys(conditions.getProperties().getProperty("password"));
            WebElement confirmPasswordField = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("confirmPasswordField")
            ));
            confirmPasswordField.sendKeys(conditions.getProperties().getProperty("password"), Keys.ENTER);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
            conditions.getDriver().quit();
        }
    }
}
