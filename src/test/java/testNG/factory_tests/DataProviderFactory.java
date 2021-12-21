package testNG.factory_tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class DataProviderFactory  {
    private int param;

    @Factory(dataProvider = "dataMethod")
    public DataProviderFactory(int param) {//конструктор
        this.param = param;
        System.out.println(param);
    }

    @DataProvider
    public static Object[][] dataMethod() {
        return new Object[][]{{0}, {1}};
    }

    @Test
    public void testMethodOne() {
        int opValue = param + 1;
        System.out.print("Test method one output: " + opValue);
        System.out.println(this);
    }

    @Test
    public void testMethodTwo() {
        int opValue = param + 2;
        System.out.print("Test method two output: " + opValue);
        System.out.println(this);
    }


}
