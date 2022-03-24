package testNG.multy_thread;

import org.testng.annotations.Test;

public class ParallelTest {
    //threadPoolSize-кол-во потоков, желательно не больше чем на компе
    //invocationCount-кол-во вызовов метода
    //timeOut -время за которое должен выполн. метод, иначе он упадет
    @Test(threadPoolSize = 4, invocationCount = 4, timeOut = 500)
    public void testMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("Test method executing on thread with id: " + id);
    }
}
