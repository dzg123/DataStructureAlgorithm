package com.dzg.$360.最短距离;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/9/16
 */
//现有一个数组A，对于A中的每个元素A[i]，都可以进行+K或者-K的操作（每个元素仅能选择加或减一次）。
//
//在这个操作后，我们将得到许多不同版本的数组B。
//
//请找出所有可能的B数组中，数组中最大值与最小值里最小的差值。
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        int[][] dp = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 0) dp[i][j] = arr[i] + k;
                else dp[i][j] = arr[i] - k;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            
        }
        int t1 = dp[arr.length - 1][0] - dp[arr.length - 2][1];
        int t2 = dp[1][0] - dp[0][1];
        int t = t1 > t2 ? t2 : t1;
        System.out.println(t);
    }
}
//3
//        1 3 6
//