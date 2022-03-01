package exampleJunit5.tests;

import org.junit.jupiter.api.*;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //сортировка по номеру в аннотации
//@TestMethodOrder(MethodOrderer.MethodName.class) //сортировка по имени метода
//@TestMethodOrder(MethodOrderer.Random.class) // сортировка в случайном порядке
@TestMethodOrder(MethodOrderer.DisplayName.class) // сортировка по имени кастомному имени
public class OrderedTests {
    @Test()
    @DisplayName("a")//задаем кастомное имя, и потом MethodOrderer выбираем DisplayName.class
    @Order(1)//указываем приоритет выполнения тестов
    public void testExpectedException() {
        System.out.println("Test 1");
    }
    @Test()
    @DisplayName("b")
    @Order(2)
    public void testCalculation() {
        System.out.println("Test 2");
    }
    @Test()
    @DisplayName("c")
    @Order(4)
    public void testzalulation() {
        System.out.println("Test 4");
    }
    @Test()
    @DisplayName("d")
    @Order(3)
    public void testxalculation() {
        System.out.println("Test 3");
    }
}
