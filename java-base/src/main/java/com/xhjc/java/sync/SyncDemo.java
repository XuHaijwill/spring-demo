package com.xhjc.java.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SyncDemo {

    private final static Logger logger = LoggerFactory.getLogger(SyncDemo.class);
    private static int counter = 0;

    public static void increment() {
        counter++;
    }

    public static void decrement() {
        counter--;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                increment();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                decrement();
            }
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        //思考： counter=？
        logger.info("{}-log-info", counter);
    }
}
