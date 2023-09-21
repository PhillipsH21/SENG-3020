package eost;

import static org.testng.Assert.*;
import org.testng.annotations.*;
import eost.Insurance.Status;

public class InsuranceTest {

    //TCI data
    public Object[][] testData01 = new Object[][] {
        {"T2.1", 0, Status.YES, true, 0},
        {"T2.2", 15, Status.NO, false, 0},
        {"T2.3", 16, Status.NO, false, 2000},
        {"T2.4", 24, Status.NO, false, 2000},
        {"T2.5", 25, Status.NO, false, 500},
        {"T2.6", 44, Status.YES, true, 300},
        {"T2.7", 45, Status.NO, false, 500},
        {"T2.8", 65, Status.NO, false, 500},
        {"T2.9", 66, Status.NO, false, 0},
        {"T2.10", Integer.MAX_VALUE, Status.NO, false, 0},
        {"T2.11*", Integer.MIN_VALUE, Status.NO, false, -1},
        {"T2.12*", -1, Status.NO, false, -1},
        {"T2.13*", 0, Status.NOT_STATED, false, -1},
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
