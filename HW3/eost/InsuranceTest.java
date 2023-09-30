package eost;

import static org.testng.Assert.*;
import org.testng.annotations.*;
import eost.Insurance.Status;

public class InsuranceTest {

    //TCI data
    public Object[][] testData01 = new Object[][] {
        {"X3.1", 20, Status.YES, true, 2000},
        {"X3.2", 20, Status.YES, false, 2000},
        {"X3.3", 35, Status.YES, true, 300},
        {"X3.4", 35, Status.YES, false, 300},
        {"X3.5", 60, Status.YES, true, 300},
        {"X3.6", 60, Status.YES, false, 500},
    };

    //Method to return TCI data
    @DataProvider(name = "dataset01")
    public Object[][] getTestData() {
        return testData01;
    }

    //Method that tests TCI data returned by getTestData()
    @Test(dataProvider = "dataset01")
    public void test_premium(String id, int age, Status ncb, boolean lowRisk, int expected) {
        assertEquals(Insurance.premium(age, ncb, lowRisk), expected);
    }
}
