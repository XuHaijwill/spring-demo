package com.xhjc.java.base.concurrent.ch1;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 类说明：如何新建线程
 */
public class NewThread {

    /*实现Runnable接口*/
    private static class UseRun implements Runnable {

        @Override
        public void run() {
            System.out.println("I am implements Runnable");
        }
    }

    /*实现Callable接口，允许有返回值*/
    private static class UseCall implements Callable {

        @Override
        public Object call() throws Exception {
            System.out.println("I am implements Callable");
            return "CallResult";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        }

        UseRun useRun = new UseRun();
        new Thread(useRun).start();
        Thread thread = new Thread(useRun);
        thread.interrupt();

        UseCall useCall = new UseCall();
        FutureTask futureTask = new FutureTask<>(useCall);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
