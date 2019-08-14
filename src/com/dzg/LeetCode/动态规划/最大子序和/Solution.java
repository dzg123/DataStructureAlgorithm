package com.dzg.LeetCode.动态规划.最大子序和;

//leetCode53
public class Solution {
    public int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length + 1];
        sum[0] = nums[0];
        int max = sum[0];
        for (int i = 1; i <= nums.length; i++) {
//            if (sum[i - test1] < 0) sum[i] = nums[i];
//            else sum[i] = sum[i - test1] + nums[i];
            sum[i] = Math.max(sum[i - 1] + nums[i], nums[i]);
            if (max < sum[i]) max = sum[i];
        }
        return max;
    }
}
