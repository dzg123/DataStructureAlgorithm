package com.dzg.byteDance.试炼;

import java.util.Scanner;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/9/15
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int[][] dp = new int[n][2];
        int l = 0;
        int r = arr.length - 1;
        int sum = 0;
        boolean flag = false;
        while (l <= r) {
            if (arr[l] > arr[r]) {
                if (!flag) sum += arr[l];
                l++;
            } else {
                if (!flag) sum += arr[r];
                r--;
            }
            flag = !flag;
        }
        System.out.println(sum);
    }
}
