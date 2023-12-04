import static org.testng.Assert.*;
import org.testng.annotations.*;

public class main_bugged_testing {
    @DataProvider(name = "MainTestData")
    public Object[][] getOrderData() {
        return new Object[][]{
                //TID, orderType, quantity, sizeChoice, finishChoice, timeChoice, enteredCode, expectedCost
                {"T1.1", },
        };
    }

    @Test(dataProvider = "MainTestData")
    public void testMain(String tid, int orderType, int quantity, int sizeChoice, int finishChoice, int timeChoice, String enteredCode, double expectedCost) {
        assertEquals(Main_bugged.calculateOrderCost(orderType, quantity, sizeChoice, finishChoice, timeChoice, enteredCode), expectedCost);
    }
}
