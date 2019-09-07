package com.dzg.奇偶打印;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/9/6
 */
public class WaitAndNotifyPrintOddAndEven {
    private static int num = 1;
    private static volatile boolean flag;
    private static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {

            while (num <= 100) {
                synchronized (lock) {
                    if (!flag) {
                        System.out.println(Thread.currentThread().getName() + ":" + num++);
                        flag = !flag;
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "odd").start();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 1, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5), new ThreadPoolExecutor.AbortPolicy());

    }
}
