package com.dzg.奇偶打印;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/9/6
 */
public class AtomicOddAndEvenPrint {
    private static AtomicInteger num = new AtomicInteger(1);
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        new Thread(() -> {
            while (num.get() <= 100) {
                if (!flag) {
                    System.out.println(Thread.currentThread() + ":" + num.getAndIncrement());

                    flag = !flag;
                }

            }
        }, "oddThread").start();
        new Thread(() -> {
            while (num.get() <= 100) {
                if (flag) {
                    System.out.println(Thread.currentThread() + ":" + num.getAndIncrement());
                    flag = !flag;
                }

            }
        }, "evenThread").start();
    }
}
