package exampleJunit4.tests;

import org.junit.*;

public class ConditionsTest {
    @Before
    public void testBeforeEachMethod() {
        System.out.println("I'm before every method");
    }

    @BeforeClass
    public static void testBeforeClass() {
        System.out.println("I'm before  class");
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
    public void testAfterEachMethod() {
        System.out.println("I'm after every method");
    }

    @AfterClass
    public static void testAfterClass() {
        System.out.println("I'm after class");
    }
}
