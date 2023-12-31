package project;

import static org.testng.Assert.*;
import org.testng.annotations.*;

import project.Print.Finish;
import project.Print.ProcessingTime;
import project.Print.Size;

public class OrderProcessingTest {
    @DataProvider(name = "OrderData")
    public Object[][] getOrderData() {
        return new Object[][]{
                //TID,      print_quantity,     size,               finish,         process_time,               promotion_code, separate,   return value
                {"T1.1", 25, Size.FOUR_BY_SIX, Finish.GLOSSY, ProcessingTime.NEXT_DAY, false, false, 3.50},
                {"T1.2", 60, Size.FIVE_BY_SEVEN, Finish.MATTE, ProcessingTime.ONE_HOUR, true, true, 29.0},
                {"T1.3", 85, Size.EIGHT_BY_TEN, Finish.GLOSSY, ProcessingTime.NEXT_DAY, false, false, 53.20},
                {"T1.4", -100, Size.EIGHT_BY_TEN, Finish.GLOSSY, ProcessingTime.NEXT_DAY, false, false, 0},
                {"T1.5", 500, Size.EIGHT_BY_TEN, Finish.GLOSSY, ProcessingTime.NEXT_DAY, false, false, 0},
                {"T2.1", 1, Size.FOUR_BY_SIX, Finish.GLOSSY, ProcessingTime.NEXT_DAY, false, false, 0.14},
                {"T2.2", 50, Size.FIVE_BY_SEVEN, Finish.MATTE, ProcessingTime.ONE_HOUR, true, true, 24.50},
                {"T2.3", 51, Size.EIGHT_BY_TEN, Finish.GLOSSY, ProcessingTime.NEXT_DAY, false, false, 34.64},
                {"T2.4", 75, Size.FOUR_BY_SIX, Finish.GLOSSY, ProcessingTime.NEXT_DAY, false, false, 10.00},
                {"T2.5", 76, Size.FOUR_BY_SIX, Finish.GLOSSY, ProcessingTime.NEXT_DAY, false, false, 10.10},
                {"T2.6", 100, Size.FOUR_BY_SIX, Finish.GLOSSY, ProcessingTime.NEXT_DAY, true, false, 10.50},
                {"T2.7", 101, Size.FOUR_BY_SIX, Finish.GLOSSY, ProcessingTime.NEXT_DAY, false, false, 0},
                {"T2.8", Integer.MAX_VALUE, Size.FOUR_BY_SIX, Finish.GLOSSY, ProcessingTime.NEXT_DAY, false, false, 0},
                {"T2.9", Integer.MIN_VALUE, Size.FOUR_BY_SIX, Finish.GLOSSY, ProcessingTime.NEXT_DAY, false, false, 0},
                {"T2.10", 0, Size.FOUR_BY_SIX, Finish.GLOSSY, ProcessingTime.NEXT_DAY, false, false, 0},
                {"T3.1", 100, Size.FIVE_BY_SEVEN, Finish.GLOSSY, ProcessingTime.NEXT_DAY, false, false, 31.75},
                {"T3.2", 100, Size.FOUR_BY_SIX, Finish.MATTE, ProcessingTime.NEXT_DAY, false, false, 14.50},
                {"T3.3", 100, Size.FIVE_BY_SEVEN, Finish.MATTE, ProcessingTime.NEXT_DAY, false, false, 34.75},
                {"T3.4", 100, Size.EIGHT_BY_TEN, Finish.MATTE, ProcessingTime.NEXT_DAY, false, false, 65.55},
                {"T3.5", 100, Size.FOUR_BY_SIX, Finish.GLOSSY, ProcessingTime.NEXT_DAY, false, true, 19.00},
                {"T3.6", 100, Size.FIVE_BY_SEVEN, Finish.GLOSSY, ProcessingTime.NEXT_DAY, false, true, 37.05},
                {"T3.7", 100, Size.EIGHT_BY_TEN, Finish.GLOSSY, ProcessingTime.NEXT_DAY, false, true, 75.05},
                {"T3.8", 100, Size.FOUR_BY_SIX, Finish.MATTE, ProcessingTime.NEXT_DAY, false, true, 23.00},
                {"T3.9", 100, Size.EIGHT_BY_TEN, Finish.MATTE, ProcessingTime.NEXT_DAY, false, true, 82.65},
                {"T3.10", 100, Size.FOUR_BY_SIX, Finish.GLOSSY, ProcessingTime.ONE_HOUR, false, true, 21.50},
                {"T3.11", 50, Size.FOUR_BY_SIX, Finish.GLOSSY, ProcessingTime.ONE_HOUR, false, false, 8.00},
                {"T3.12", 100, Size.FOUR_BY_SIX, Finish.GLOSSY, ProcessingTime.ONE_HOUR, false, false, 14.00},
        };
    }

    @Test(dataProvider = "OrderData")
    public void testOrderProcessing(String tid, int quantity, Size size, Finish finish, ProcessingTime processingTime, boolean promotionCode, boolean separate, double expected_value) {
        assertEquals(OrderProcessing.processOrder(quantity, size, finish, processingTime, promotionCode, separate), expected_value);
    }
}
