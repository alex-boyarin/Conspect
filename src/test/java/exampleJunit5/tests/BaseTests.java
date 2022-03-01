package exampleJunit5.tests;


import exampleJunit4.Calculator;
import exampleJunit5.AnotherCondition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(AnotherCondition.class)//нужен для того чтобы описаные в этом классе AnotherCondition
//можно было использовать
public class BaseTests {
    @Test
    public void testAssertTrueExample() {
        assertTrue(5 > 3);
    }

    @Test
    public void testAssertFalseExample() {
        assertFalse(5 > 3, "message error ");
    }

    @Test
    public void testComparingStrings() {
        assertEquals("a", "b");
    }

    @Test
    public void testException() {
        assertThrows(ArithmeticException.class, () -> new Calculator(1, 0).calculate('/'));
    }

    @Test
    public void testTimeout() { //дожидается пока тест не закончится, а потом падает
        assertTimeout(Duration.ofMillis(1), () -> {
            Thread.sleep(40);
            System.out.println(123);
        });
    }

    @Test
    public void testTimeoutPreemptively() { //сразу как закончится таймаут заканчивает тест
        assertTimeoutPreemptively(Duration.ofMillis(1), () -> {
            Thread.sleep(40);
            System.out.println("123");
        });
    }

    @Test
    public void testAllAssertions() {
        assertAll(
                () -> assertThrows(ArithmeticException.class, () -> {float a = 5 / 0;}),
                () -> assertTrue("".isEmpty()),
                () -> assertFalse("".isEmpty())
        );
    }
}
