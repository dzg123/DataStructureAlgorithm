package com.dzg.LeetCode.动态规划.最长上升子序列;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public int tempMaxgthOfLIS(int[] nums) {
        if (nums == null) return 0;
        int[] dp = new int[nums.length];
        int tempMax;
        for (int i = 0; i < nums.length; i++) {
            tempMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    tempMax = Math.max(tempMax, dp[j]);
                }
            }
            dp[i] = tempMax + 1;
        }
        tempMax = 0;
        for (int i = 0; i < dp.length; i++) {
            tempMax = Math.max(tempMax, dp[i]);
        }
        return tempMax;
    }
    public int tempMaxgthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int tempMax = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, tempMax, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == tempMax) {
                tempMax++;
            }
        }
        return tempMax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }
        int[] dp = new int[count];
        int tempMax = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, tempMax, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == tempMax) {
                tempMax++;
            }
        }
        System.out.println(tempMax);

    }
}
