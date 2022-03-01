package exampleJunit5.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TaggedTests {
    @Test
    @Tag("Smoke")//теги используются для настройки запуска определенных групп тестов, как указанно ниже
    public void testAssertTrueExample() {
        System.out.println("Smoke");
    }

    @Test
    @Tag("Integration")
    public void testAssertFalseExample() {
        System.out.println("Integration");
    }

    @Test
    @Tag("System")
    public void testComparingStrings() {
        System.out.println("System");
    }
}
