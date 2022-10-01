package cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import preConditions.PreCondition;

public class TestCase8 {
    PreCondition conditions;

    @Test
    void testCase8() throws InterruptedException {
        conditions = new PreCondition();

        try {
            conditions.navigation();
            Thread.sleep(1000);

            Select buySelector = new Select(
                    conditions.getDriver().findElement(By.xpath(
                            conditions.getProperties().getProperty("buySelector")
                    ))
            );
            buySelector.selectByVisibleText("Арендовать");

            WebElement apartmentSelector = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("apartmentSelector")
            ));
            apartmentSelector.click();

            WebElement house = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("house")
            ));
            house.click();

            WebElement city = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("city")
            ));
            city.click();

            WebElement almaty = conditions.getDriver().findElement(By.xpath("//*[@data-label='Алматы']"));
            almaty.click();

            WebElement choice = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("choice")
            ));
            conditions.getWait().until(ExpectedConditions.elementToBeClickable(choice));
            choice.click();

            WebElement from = conditions.getDriver().findElement(By.xpath("//*[@placeholder='От']"));
            from.sendKeys("2000000000");

            WebElement search = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("search")
            ));
            search.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
            conditions.getDriver().quit();
        }

    }

}
