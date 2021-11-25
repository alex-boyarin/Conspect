package exampleJunit4.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class ParametrizedPrimitivesTest {
    private String str1;
    private String str2;

    public ParametrizedPrimitivesTest(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{"zxc", "ZXC"}, {"123", "qwe"}, {"a", "a"}, {"", null}};
        return Arrays.asList(data);
    }

    @Test
    public void testComparingString() {
        assertEquals(str1, str2);
    }
}
