package cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import preConditions.PreCondition;

import java.time.Duration;

public class TestCase3 {
    PreCondition conditions;

    @Test
    private void logOut() throws InterruptedException {
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
                    conditions.getProperties().getProperty("signoutBtn")
            )));
            WebElement signoutBtn = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("signoutBtn")
            ));
            signoutBtn.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
            conditions.getDriver().quit();
        }
    }
}
