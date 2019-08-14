package com.dzg.LeetCode.$122买卖股票的最佳时机2;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int curMax = 0;
        int max = 0;
        int cur ;
        for (int i = 0; i < prices.length; i++) {
            cur = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - cur > 0) {
                    curMax += prices[j] - cur;
                    cur = prices[j];
                } else cur = prices[j];
            }
            if (curMax > max) max = curMax;
            curMax = 0;


        }
        return max;
    }

    public static void main(String[] args) {
        int i = new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(i);
    }
}
