package testNG.annotation_parameters_tests;


import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasicTest {
    static String a = "as";

    @Test
    public void testAssertTrueJavaInner() {//пример java assert
        assert 2 > 3;
    }

    @Test
    public void testAssertJavaInner() {//пример java assert
        assert 2 < 3;
    }

    @Test
    public void testAssertEqualsJavaInner() {//пример java assert, с сообщением
        assert "asd".equals("asd1") : "This method is now working";
    }


    @Test
    public void testAssertTrue() {//assert от testNG
        assertTrue(2 > 3, "Same message assertTrue");
    }

    @Test
    public void testAssertFalse() {//assert от testNG
        assertFalse(2 > 3, "Same message assertFalse");
    }

    @Test
    public void testAssertEquals() {//assert от testNG
        assertEquals("2", "2", "Same message assertEquals");
    }


    @Test
    public void testAssertTrueJunit() {//assert от Junit4
        AssertJUnit.assertTrue("Error message Junit assertTrue", 2 > 3);
    }

    @Test
    public void testAssertEqualsJunit() {//assert от Junit4
        AssertJUnit.assertEquals("Error message Junit assertTrue", 2, 3);
    }

    @Test
    public void testAssertFalseJunit() {//assert от Junit4
        AssertJUnit.assertFalse("Error message Junit assertTrue", 2 > 3);
    }

    @Test
    public void testAssertNotEquals() {//assert от Junit4
        AssertJUnit.assertNotNull("Same message assertFalse", a);
    }


}
