package cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import preConditions.PreCondition;

public class TestCase10 {
    PreCondition conditions;

    @Test
    void testCase10() throws InterruptedException {
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

            WebElement ownersItem = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("ownersItem")
            ));
            Assert.assertTrue(ownersItem.isDisplayed());

            conditions.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(
                    conditions.getProperties().getProperty("showPhone")
            ))).click();

            WebElement contactsLoaded = conditions.getWait().until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath(
                            conditions.getProperties().getProperty("contactsLoaded")
                    ))
            );
            Assert.assertTrue(contactsLoaded.isDisplayed());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
            conditions.getDriver().quit();
        }
    }

}
