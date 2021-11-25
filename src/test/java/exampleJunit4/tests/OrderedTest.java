package exampleJunit4.tests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

//@FixMethodOrder(MethodSorters.JVM) //разнобой по мнению jvm
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)// в алфавитном порядке
public class OrderedTest {
    @Test()
    public void testC() {
        System.out.println("test C 1");
    }

    @Test()
    public void testA() {
        System.out.println("test A 2");
    }

    @Test()
    public void testB() {
        System.out.println("test B 3");
    }
}
