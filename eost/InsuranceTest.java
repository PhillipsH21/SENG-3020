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
    public static Object[][] getTestData() {
       return testData1;
    }

    // Method to execute the EP tests
    @Test(dataProvider="dataset1")
    public static void test_premium( String id, int age, Status ncb, boolean lowRisk, int expected)
    {
       assertEquals( Insurance.premium( age, ncb, lowRisk ), expected );
    }

    /*
    public static void main(String[] args) {
      System.out.println(getTestData()[0][0]);

      String temp_01 = (String)getTestData()[0][0];
      int temp_02 = (int)getTestData()[0][1];
      Status temp_03 = (Status)getTestData()[0][2];
      boolean temp_04 = (boolean)getTestData()[0][3];
      int temp_05 = (int)getTestData()[0][4];

      test_premium(temp_01, temp_02, temp_03, temp_04, temp_05);
    }
    */
}
