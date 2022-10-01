package cases;

import org.testng.annotations.Test;
import preConditions.PreCondition;

public class TestCase1 {
    PreCondition conditions;

    @Test
    private void testCase1() throws InterruptedException {
        conditions = new PreCondition();
        try {
            conditions.login();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
            conditions.getDriver().quit();
        }
    }

}
