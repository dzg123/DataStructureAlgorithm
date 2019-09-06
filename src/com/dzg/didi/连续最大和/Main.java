package com.dzg.didi.连续最大和;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        Integer betterSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < num; i++) {
            if (sum <= 0) sum = arr[i];
            else sum += arr[i];
            betterSum = Math.max(sum, betterSum);
        }
        System.out.println(betterSum);

    }
}
