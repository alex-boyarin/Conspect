package testNG.annotation_parameters_tests;

import org.testng.annotations.Test;

public class AnnotationParametersTest {

    @Test(priority = 2,expectedExceptions = ArithmeticException.class)//выполнится третьим, и упадет с исключ.
    public void testDivisionWithException() {
        int i = 1 / 0;
    }

    @Test(description = "Just test")//Выполнится первым, т.к. приоритета нет, а по умолч. он "0"
    public void testWithPriority() {
        System.out.println(123);
    }

    @Test(enabled = false)//будет пропущен.
    public void testIgnored() {
        System.out.println("Method isn't ready yet");
    }

    @Test(timeOut = 1000, priority = 1)//Выполнится вторым и упадет т.к. внутри бесконечный цикл
    public void testRunForever() {
        while (true) ;
    }
}
