package testNG.annotation_parameters_tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
    @Test
    public void test1() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("asd", "ASD");
        softAssert.assertEquals(2, 2);
        softAssert.assertTrue(2 > 1);
        softAssert.assertFalse(2 > 1);
        softAssert.assertAll();
    }
}
