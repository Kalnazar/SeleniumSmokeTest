package cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import preConditions.PreCondition;

public class TestCase14 {
    PreCondition conditions;

    @Test
    void testCase14() throws InterruptedException {
        conditions = new PreCondition();

        try {
            conditions.login();
            Thread.sleep(1000);

            conditions.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(
                    conditions.getProperties().getProperty("applyBtn")
            ))).click();
            conditions.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(
                    conditions.getProperties().getProperty("optionSell")
            ))).click();
            conditions.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(
                    conditions.getProperties().getProperty("optionSellHouse")
            ))).click();
            conditions.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    conditions.getProperties().getProperty("adPrice")
            )));
            WebElement adPrice = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("adPrice")
            ));
            adPrice.sendKeys("1000000000000");
            WebElement adSquare = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("adSquare")
            ));
            adSquare.sendKeys("2000000000000");
            WebElement adLandSquare = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("adLandSquare")
            ));
            adLandSquare.sendKeys("3000000000000");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
            conditions.getDriver().quit();
        }
    }

}
