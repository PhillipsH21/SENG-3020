/*
 * InsuranceTest - ep
 */
package eost;

import static org.testng.Assert.*;
import org.testng.annotations.*;
import eost.Insurance.Status;
import static eost.Insurance.Status.*;

public class InsuranceTest {

   // This is dummy data - delete it, add you own test data, and DELETE this comment!

   // EP test data
   private static Object[][] testData1 = new Object[][] {
      //  test,               age,        ncb, lowRisk, expected output
      { "Tx.y",                55,  Status.NO,    true,             500 },
    };

    // Method to return the EP test data
    @DataProvider(name="dataset1")
    public Object[][] getTestData() {
       return testData1;
    }

    // Method to execute the EP tests
    @Test(dataProvider="dataset1")
    public void test_premium( String id, int age, Status ncb, boolean lowRisk, int expected)
    {
       assertEquals( Insurance.premium( age, ncb, lowRisk ), expected );
    }

}
