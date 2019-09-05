package com.dzg.京东.合唱队列;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stu = sc.nextInt();
        int[] h = new int[stu];
        int count = 0;
        int min = 0;
        int max = 0;
        for (int i = 0; i < stu; i++) {
            h[i] = sc.nextInt();
        }
        for (int i = 1; i < stu; i++) {
            if (h[i] >= h[i - 1]) {
                count++;
                min = h[i-1];
                max = h[i];
            }
            if (h[i] < h[i - 1] && h[i] < min) {
                count++;
                min = max;
            }

        }
        System.out.println(count);
    }
}
