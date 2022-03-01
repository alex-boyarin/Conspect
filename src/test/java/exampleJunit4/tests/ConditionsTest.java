package exampleJunit4.tests;

import org.junit.*;

public class ConditionsTest {

    @BeforeClass
    public static void BeforeClass() {
        System.out.println("I'm before  class");
    }

    @Before
    public void BeforeEachMethod() {
        System.out.println("I'm before every method");
    }


    @Test(expected = ArithmeticException.class)
    public void testExpectedException() {
        System.out.println("test 1");
    }

    @Test
    public void testCalculation() {
        System.out.println("test 2");
    }

    @After
    public void AfterEachMethod() {
        System.out.println("I'm after every method");
    }

    @AfterClass
    public static void  AfterClass() {
        System.out.println("I'm after class");
    }
}
