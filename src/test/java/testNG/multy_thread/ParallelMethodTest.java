package testNG.multy_thread;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelMethodTest {
    @BeforeMethod
    public void beforeMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id);
    }

    @Test
    public void beforeMethodOne() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method one. Thread id is: " + id);
    }

    @Test
    public void beforeMethodTwo() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method two. Thread id is: " + id);
    }

    @Test
    public void beforeMethodThree() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method three. Thread id is: " + id);
    }

    @Test
    public void beforeMethodFour() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method four. Thread id is: " + id);
    }

    @AfterMethod
    public void afterMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("After test-method. Thread id is: " + id);
    }
}
