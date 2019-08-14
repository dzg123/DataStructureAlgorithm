package com.dzg.LeetCode.动态规划.买卖股票的最佳时机;

import java.util.Collections;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int[] profit = new int[prices.length];
        profit[0] = prices[1] - prices[0];
        for (int i = 0; i < profit.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {

                profit[i] = Math.max(prices[j] - prices[i], profit[i]);
            }

        }
        int max = Integer.MIN_VALUE;
        for (int i : profit) {
            if (i > max)
                max = i;
        }
        return max;
    }

    public static void main(String[] args) {
        int i = new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(i);
    }
}
