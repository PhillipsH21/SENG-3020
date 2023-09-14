package eost;

import static org.testng.Assert.*;
import org.testng.annotations.*;
import eost.Insurance.Status;

public class InsuranceTest {

    //TCI data
    public Object[][] testData01 = new Object[][] {
        {"T1.1", 10, Status.YES, true, 0},
        {"T1.2", 20, Status.YES, true, 2000},
        {"T1.3", 35, Status.YES, true, 300},
        {"T1.4", 55, Status.NO, false, 500},
        {"T1.2", 90, Status.NOT_STATED, false, -1},
        {"T1.2", -10, Status.NO, false, -1},
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
