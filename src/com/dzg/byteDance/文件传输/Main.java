package com.dzg.byteDance.文件传输;

import java.util.Arrays;
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
        int[] time = new int[n];
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            time[i] = sc.nextInt();
            nums[i] = sc.nextInt();
        }
        long cost = Arrays.stream(nums).sum() + 1;
        long[] curNum = new long[n];
        curNum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curNum[i] = curNum[i - 1] + nums[i] - 1;
        }
        Arrays.sort(curNum);
        System.out.println(cost + " " + curNum[curNum.length - 1]);
    }
}
//18
//        1 1000000000
//        2 1000000000
//        3 1000000000
//        1 1000000000
//        2 1000000000
//        3 1000000000
//        1 1000000000
//        2 1000000000
//        3 1000000000
//        1 1000000000
//        2 1000000000
//        3 1000000000
//        1 1000000000
//        2 1000000000
//        3 1000000000
//        1 1000000000
//        2 1000000000
//        3 1000000000
//        1 1000000000
//        2 1000000000
//        3 1000000000
//        1 1000000000
//        2 1000000000
//        3 1000000000