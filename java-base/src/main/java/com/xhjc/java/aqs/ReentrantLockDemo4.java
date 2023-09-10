package com.xhjc.java.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁超时
 * 立即失败
 */
@Slf4j
public class ReentrantLockDemo4 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {

            log.debug("t1启动...");
            // 注意： 即使是设置的公平锁，此方法也会立即返回获取锁成功或失败，公平策略不生效
            if (!lock.tryLock()) {
                log.debug("t1获取锁失败，立即返回false");
                return;
            }
            try {
                log.debug("t1获得了锁");
            } finally {
                lock.unlock();
            }

        }, "t1");


        lock.lock();
        try {
            log.debug("main线程获得了锁");
            t1.start();
            //先让线程t1执行
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }

    }
}