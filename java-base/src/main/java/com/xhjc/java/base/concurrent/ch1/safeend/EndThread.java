package com.xhjc.java.base.concurrent.ch1.safeend;

public class EndThread {

    private static class UseThread extends Thread {

        public UseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
//            while(isInterrupted()) {
            while (true) {
                System.out.println(threadName + " is run!");
            }
            //System.out.println(threadName+" interrput flag is "+isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread endThread = new UseThread("endThread");
        endThread.start();
        Thread.sleep(20);
        endThread.interrupt();

    }
}
