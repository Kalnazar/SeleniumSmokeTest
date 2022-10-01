package cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import preConditions.PreCondition;

public class TestCase9 {
    PreCondition conditions;

    @Test
    void testCase9() throws InterruptedException {
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

            WebElement offerPrice = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("offerPrice")
            ));
            Assert.assertTrue(offerPrice.isDisplayed());

            WebElement offerTitle = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("offerTitle")
            ));
            Assert.assertTrue(offerTitle.isDisplayed());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
            conditions.getDriver().quit();
        }
    }

}
