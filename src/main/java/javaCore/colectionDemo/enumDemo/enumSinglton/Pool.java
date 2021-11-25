package javaCore.colectionDemo.enumDemo.enumSinglton;

import javaCore.colectionDemo.enumDemo.Plane;

import java.util.concurrent.BlockingQueue;

public enum Pool {
    INSTANCE;
    private BlockingQueue<Plane> planes;

    Pool() {
        //more code
    }
    //more methods
}
