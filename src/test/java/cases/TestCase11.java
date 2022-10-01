package cases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import preConditions.PreCondition;

public class TestCase11 {
    PreCondition conditions;

    @Test
    void testCase11() throws InterruptedException {
        conditions = new PreCondition();

        try {
            conditions.navigation();
            Thread.sleep(1000);

            conditions.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(
                    conditions.getProperties().getProperty("hotItem")
            ))).click();
            conditions.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(
                    conditions.getProperties().getProperty("hideTooltip")
            ))).click();
            conditions.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(
                    conditions.getProperties().getProperty("likeBtn")
            ))).click();
            conditions.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(
                    conditions.getProperties().getProperty("favouritesBtn")
            ))).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(5000);
            conditions.getDriver().quit();
        }
    }

}
