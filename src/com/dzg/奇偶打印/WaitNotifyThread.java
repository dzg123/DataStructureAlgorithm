package com.dzg.奇偶打印;

import java.util.concurrent.locks.Lock;

public class WaitNotifyThread {
    private int start = 1;
    private volatile boolean flag = false;

    public static class OddThread implements Runnable {
        private WaitNotifyThread thread;

        public OddThread(WaitNotifyThread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            synchronized (WaitNotifyThread.class) {
                while (thread.start <= 100) {
                    if (!thread.flag) {
                        System.out.println(Thread.currentThread().getName() + ":" + thread.start);
                        thread.start++;
                        thread.flag = true;
                        WaitNotifyThread.class.notify();
                    } else {
                        try {
                            WaitNotifyThread.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }


        }
    }
    public static class EvenThread implements Runnable {
        private WaitNotifyThread thread;

        public EvenThread(WaitNotifyThread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            synchronized (WaitNotifyThread.class) {
                while (thread.start <= 100) {
                    if (thread.flag) {
                        System.out.println(Thread.currentThread().getName() + ":" + thread.start);
                        thread.start++;
                        thread.flag = false;
                        WaitNotifyThread.class.notify();
                    } else {
                        try {
                            WaitNotifyThread.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }


        }
    }

    public static void main(String[] args) {
        WaitNotifyThread waitNotifyThread = new WaitNotifyThread();
        Thread thread1 = new Thread(new OddThread(waitNotifyThread));
        thread1.setName("t1");
        thread1.start();
        Thread thread2 = new Thread(new EvenThread(waitNotifyThread));
        thread2.setName("t2");
        thread2.start();
    }

}
