package com.dzg.奇偶打印;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenTrantSolution {
    private int start = 1;
    private volatile boolean flag = false;
    private static final Lock lock = new ReentrantLock();

    public static class oddThread implements Runnable {
        private ReenTrantSolution solution;

        public oddThread(ReenTrantSolution solution) {
            this.solution = solution;
        }

        @Override
        public void run() {

            while (solution.start <= 1000) {
                try {
                    lock.lock();
                    if (!solution.flag) {
                        System.out.println(Thread.currentThread().getName()+":"+solution.start);
                        solution.start++;
                        solution.flag = true;
                    }
                } finally {
                    lock.unlock();
                }


            }
        }
    }
    public static class evenThread implements Runnable {
        private ReenTrantSolution solution;

        public evenThread(ReenTrantSolution solution) {
            this.solution = solution;
        }

        @Override
        public void run() {

            while (solution.start <= 1000) {
                try {
                    lock.lock();
                    if (solution.flag) {
                        System.out.println(Thread.currentThread().getName()+":"+solution.start);
                        solution.start++;
                        solution.flag = false;
                    }
                } finally {
                    lock.unlock();
                }


            }
        }
    }

    public static void main(String[] args) {
        ReenTrantSolution solution = new ReenTrantSolution();
        Thread thread = new Thread(new oddThread(solution));
        Thread thread2 = new Thread(new evenThread(solution));
        thread.setName("t1");
        thread2.setName("t2");
        thread.start();
        thread2.start();

    }

}
