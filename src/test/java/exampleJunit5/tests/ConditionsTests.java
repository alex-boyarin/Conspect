package exampleJunit5.tests;

import org.junit.jupiter.api.*;

public class ConditionsTests {
    @BeforeEach
    public void testBeforeEachMethod() {
        System.out.println("I'm before every method");
    }

    @BeforeAll
    public static void testBeforeClass() {
        System.out.println("I'm before class");
    }

    @Test
    public void test1() {
        System.out.println("test 1");
    }

    @Test
    public void test2() {
        System.out.println("test 2");
    }

    @AfterEach
    public void testAfterEachMethod() {
        System.out.println("I'm after every method");
    }

    @AfterAll
    public static void testAfterClass() {
        System.out.println("I'm after class");
    }
}
