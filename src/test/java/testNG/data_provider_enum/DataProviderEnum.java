package testNG.data_provider_enum;

import org.testng.annotations.DataProvider;

import static enums.Months.*;

public class DataProviderEnum {
    @DataProvider
    public static Object[][] dataEnum() {
        return new Object[][]{
                {APRIL, APRIL},
                {APRIL, JANUARY},
                {APRIL, null},
                {APRIL, JULY}
        };
    }
}
