package javaCore.colectionDemo.enumColectionDemo.enumSinglton;

import javaCore.colectionDemo.enumColectionDemo.Plane;

import java.util.concurrent.BlockingQueue;

public enum Pool {
    INSTANCE;
    private BlockingQueue<Plane> planes;

    Pool() {
        //more code
    }
    //more methods
}
