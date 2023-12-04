import static org.testng.Assert.*;
import org.testng.annotations.*;

public class main_bugged_testing {
    @DataProvider(name = "MainTestData")
    public Object[][] getOrderData() {
        return new Object[][]{
                //TID, orderType, quantity, sizeChoice, finishChoice, timeChoice, enteredCode, expectedCost
                {"T1.1",    1,  25,                 1, 1, 1, "N56M2",   3.50},
                //{"T1.2",    1,  60,                 2, 2, 2, "!N56M2",  21.90},
                //{"T1.3",    2,  85,                 3, 2, 2, "!N56M2",  72.63},
                //{"T1.4*",   1,  -100,               3, 2, 2, "!N56M2",  0},
                //{"T1.5*",   1,  500,                3, 2, 2, "!N56M2",  0},
                {"T2.1",    1,  1,                  1, 1, 1, "!N56M2",  0.14},
                //{"T2.2",    2,  50,                 2, 2, 2, "N56M2",   24.50},
                {"T2.3",    1,  51,                 3, 1, 1, "!N56M2",  34.64},
                {"T2.4",    1,  75,                 1, 1, 1, "!N56M2",  10.00},
                {"T2.5",    1,  76,                 1, 1, 1, "!N56M2",  10.10},
                //{"T2.6",    1,  100,                1, 1, 1, "N56M2",   10.50},
                //{"T2.7*",    1,  101,                1, 1, 1, "!N56M2",  0},
                //{"T2.8*",    1,  Integer.MAX_VALUE,  1, 1, 1, "!N56M2",  0},
                //{"T2.9*",    1,  Integer.MIN_VALUE,  1, 1, 1, "!N56M2",  0},
                {"T2.10*",   1,  0,                  1, 1, 1, "!N56M2",  0},
        };
    }

    @Test(dataProvider = "MainTestData")
    public void testMain(String tid, int orderType, int quantity, int sizeChoice, int finishChoice, int timeChoice, String enteredCode, double expectedCost) {
        assertEquals(Math.round((Main_bugged.calculateOrderCost(orderType, quantity, sizeChoice, finishChoice, timeChoice, enteredCode) * 100)) / 100.0, expectedCost);
        System.out.println(tid + " passed");
    }
}
