package com.dzg.Offer.数组.连续子数组的最大和;

public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int sum = 0;
        int betterSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (sum <= 0) sum = array[i];
            else sum += array[i];
            betterSum = Math.max(sum, betterSum);
        }
        return betterSum;
    }
}
