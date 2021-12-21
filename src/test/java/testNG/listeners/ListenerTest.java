package testNG.listeners;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class ListenerTest {
    @Test
    public void testListener() {
        System.out.println("test");
    }
}
