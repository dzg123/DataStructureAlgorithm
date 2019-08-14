package com.dzg.LeetCode.动态规划.$0_1背包.升级版;

public class Solution {
    public int knapsack(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        states[0][weight[0]] = value[0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {//不选择第i个物品
                if (states[i - 1][j] >= 0) states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= w - weight[i]; j++) {//选择第i个物品
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + value[i];
                    if (v > states[i][j + weight[i]])
                        states[i][j + weight[i]] = v;
                }
            }

        }
        int maxV = -1;
        for (int j = 0; j <= w; j++) {
            if (states[n - 1][j] > maxV) maxV = states[n - 1][j];
        }
        return maxV;
    }
}
