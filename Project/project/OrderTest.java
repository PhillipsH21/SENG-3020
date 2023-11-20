package project;

import static org.testng.Assert.*;
import org.testng.annotations.*;

import project.Print.Finish;
import project.Print.ProcessingTime;
import project.Print.Size;

public class OrderTest {
    @DataProvider(name="OrderData")
    public Object[][] getOrderData() {
        return new Object[][] {
            //TID, print_quantity, size, finish, process_time, promotion_code, separate, return value
            {"T1.1", 25, Size.FOUR_BY_SIX, Finish.GLOSSY, ProcessingTime.NEXT_DAY, false, false, 3.50},
        };
    }

    @Test(dataProvider="OrderData")
    public void testOrderProcessing(String tid, int quantity, Size size, Finish finish, ProcessingTime processingTime, boolean promotionCode, boolean separate, double expected_value) {
        Order o = new Order();
        o.addPrints(quantity, size, finish, processingTime, promotionCode, separate);
        assertEquals(o.processOrder(), expected_value);
   }
}
