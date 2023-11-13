package example;

import static org.testng.Assert.*;
import org.testng.annotations.*;

public class SpaceOrderTestTemplate {

   //
   // You must delete test T3 and place your own test data here
   //
   @DataProvider(name="acceptOrderData")
   public Object[][] getAcceptOrderData() {
      return new Object[][] {
         //                 TID, special, space,  e_rv, e_accept
         {  "SpaceOrderTest T3",    true,     7,  true,     true},
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
