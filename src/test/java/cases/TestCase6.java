package cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import preConditions.PreCondition;

public class TestCase6 {
    PreCondition conditions;

    @Test
    void testCase6() throws InterruptedException {
        conditions = new PreCondition();

        try {
            conditions.navigation();
            Thread.sleep(1000);

            WebElement selling = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("selling")
            ));
            selling.click();

            WebElement renting = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("renting")
            ));
            renting.click();

            WebElement company = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("company")
            ));
            company.click();

            WebElement newBuildings = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("newBuildings")
            ));
            newBuildings.click();

            WebElement hint = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("hint")
            ));
            hint.click();

            WebElement news = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("news")
            ));
            news.click();

            WebElement guide = conditions.getDriver().findElement(By.xpath(
                    conditions.getProperties().getProperty("guide")
            ));
            guide.click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
            conditions.getDriver().quit();
        }

    }

}
