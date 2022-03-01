package exampleJunit4.tests;

import enums.Months;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static enums.Months.*;

@RunWith(Parameterized.class)
public class ParameterizedEnumTest {
    private Months month1;
    private Months month2;


    public ParameterizedEnumTest(Months month1, Months month2) {
        this.month1 = month1;
        this.month2 = month2;

    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {Months.APRIL, Months.MAY},
                {Months.JULY, Months.JANUARY},
                {Months.AUGUST, null}};
        return Arrays.asList(data);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data1() {
        Object[][] data1 = new Object[][]{
                {Months.JANUARY, Months.FEBRUARY},
                {Months.JULY, Months.OCTOBER},
                {Months.NOVEMBER, Months.DECEMBER}};
        return Arrays.asList(data1);
    }

    @Test()
    public void testComparingMonths() {
        Assert.assertTrue(month1.getNumber() < month2.getNumber());
    }
}
