package colectionDemo.enumDemo.enumSinglton;

import colectionDemo.enumDemo.Plane;

import java.util.concurrent.BlockingQueue;

public enum Pool {
    INSTANCE;
    private BlockingQueue<Plane> planes;

    Pool() {
        //more code
    }
    //more methods
}
