package testNG.annotation_parameters_tests;

import org.testng.annotations.Test;

public class GroupTests {

    @Test(groups = {"Test1","Test2","Test3"})
    public void testGroup123(){
        System.out.println("I'm in 1, 2and 3 group");
    }
    @Test(groups = {"Test1"})
    public void testGroup1(){
        System.out.println("I'm in 1 group");
    }
    @Test(groups = {"Test2","Test1"})
    public void testGroup21(){
        System.out.println("I'm in 1, 2 group");
    }
    @Test(groups = {"Test1","Test3"})
    public void testGroup13(){
        System.out.println("I'm in 1 and 3 group");
    }
}
