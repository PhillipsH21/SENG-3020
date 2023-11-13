package example;

import static org.testng.Assert.*;
import org.testng.annotations.*;

public class SpaceOrderTest {

   // Test data
   @DataProvider(name="acceptOrderData")
   public Object[][] getAcceptOrderData() {
      return new Object[][] {
         // ID, special, space, e_rv, e_accept
         {"X1", true, 7, true, true},
         {"X2", true, 504, true, true},
         {"X3", true, 5000, true, false},
         {"X4", false, 5000, true, false},
         {"X5", false, 504, true, true},
         {"X6", false, 7, true, false},
      };
   }

   // Code from the book
   @Test(dataProvider="acceptOrderData")
   public void testAcceptOrder(String tid, boolean special,
         int sqm, boolean expectedReturn, boolean expectedAccept) {
      SpaceOrder o = new SpaceOrder(special);
      assertEquals( o.acceptOrder(sqm), expectedReturn );
      assertEquals( o.getAccept(), expectedAccept );
   }

}
