package exampleJunit4.tests;

import exampleJunit4.Calculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParameterizedCustomClassesTest {
    private Calculator calculator;

    public ParameterizedCustomClassesTest(Calculator calculator) {
        this.calculator = calculator;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {new Calculator(1, 2)},
                {new Calculator(1, 0)},
                {new Calculator(0, 2)}};
        return Arrays.asList(data);
    }

    @Test
    public void testCalculator() {
        Assert.assertEquals(0f, calculator.calculate('/'), 0);
    }
}
