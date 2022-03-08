package testNG.parameterized_test;

import enums.Months;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testNG.data_provider_enum.DataProviderEnum;

import static org.testng.Assert.assertEquals;

public class DataProviderTest {
    @DataProvider
    public static Object[][] data1() {
        return new Object[][]{
                {1, 0, 1},
                {2, 1, 2},
                {10, 20, 30},
                {-1, -2, 1}
        };
    }

    @DataProvider
    public static Object[][] data2() {
        return new Object[][]{
                {1, 1, 1},
                {2, 0, 2},
                {10, 30, 30},
                {-1, 2, 1}
        };
    }

    @Test(dataProvider = "data2")
    public void test(int a, int b, int c) {
        System.out.println(this);
        assertEquals(a + b, c, "Incorrect operation result");
    }

    @Test(dataProviderClass = DataProviderEnum.class, dataProvider = "dataEnum")
    public void test1(Months a, Months b) {
        assertEquals(a, b);
    }
}
