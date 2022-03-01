package exampleJunit4.tests;

import exampleJunit4.runners.ExampleRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(ExampleRunner.class)//При использовании нестандартного ранера нужно указывать в обьявлении
// тестового класса анотацию @RunWith(классРанена.class)
//смотреть описание действий в ExampleListener и ExampleRunner
public class BasicJunitTest {//класс заканчивается на Test
    @Test
    public void testAssertTrueExample() {
        assertTrue(5 > 3);
    }

    @Test
    public void testAssertFalseExample() {
        assertFalse(5 > 3);
    }

    @Test
    public void testComparingStrings() {
        assertEquals("a", "b");
    }

    @Test(expected = ArithmeticException.class)
    public void testExpectedException() {
        double a = 5 / 0;
        assertEquals(0, a, 0);
    }

    @Test(timeout = 1)
    public void testWithoutExpectedException() throws InterruptedException {
        Thread.sleep(40);
        double a = 5 / 1;
        assertEquals(5, a, 1);
    }
}
