package cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import preConditions.PreCondition;

public class TestCase17 {
    PreCondition conditions;

    @Test
    void testCase17() throws InterruptedException {
        conditions = new PreCondition();

        try {
            conditions.navigation();
            Thread.sleep(1000);

            conditions.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(
                    conditions.getProperties().getProperty("loginBtn")
            ))).click();
            conditions.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(
                    conditions.getProperties().getProperty("supportBtn")
            ))).click();
            WebElement supportEmail = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("supportEmail")
            ));
            supportEmail.sendKeys("textXperts@test.com");
            WebElement suppportMessage = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("suppportMessage")
            ));
            suppportMessage.sendKeys("Hello, we have some issues...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
            conditions.getDriver().quit();
        }
    }
}
