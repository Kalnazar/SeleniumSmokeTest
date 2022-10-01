package cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import preConditions.PreCondition;

public class TestCase15 {
    PreCondition conditions;

    @Test
    void testCase15() throws InterruptedException {
        conditions = new PreCondition();
        Actions action = new Actions(conditions.getDriver());

        try {
            conditions.navigation();
            Thread.sleep(1000);

            WebElement changeLangBtn = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("changeLang")
            ));
            action.clickAndHold(changeLangBtn).perform();
            Thread.sleep(1000);
            conditions.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(
                    conditions.getProperties().getProperty("changeLangBtn")
            ))).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
            conditions.getDriver().quit();
        }
    }

}
