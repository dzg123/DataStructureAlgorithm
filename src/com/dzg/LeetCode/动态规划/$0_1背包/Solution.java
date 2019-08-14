package com.dzg.LeetCode.动态规划.$0_1背包;

/*  动态规划是一种空间换时间的算法思想
 * 把每一层重复的状态（节点）合并，只记录不同的状态，然后基于上一层的状态集合，来推导下一层的状态集合。
 * 我们可以通过合并每一层重复的状态，这 样就保证每一层不同状态的个数都不会超过w个
 * */
public class Solution {
    //    weight:物品重量，n:物品个数，w:背包可承载重量
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1];//记录每层可以达到的不同状态
        states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        states[0][weight[0]] = true;
        for (int i = 1; i < n; i++) { // 动态规划状态转移
            for (int j = 0; j <= w; j++) {// 不把第i个物品放入背包
                if (states[i - 1][j]) states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= w - weight[i]; j++) {//把第i个物品放入背包
                if (states[i - 1][j]) states[i][j + weight[i]] = true;
            }
        }
        for (int i = w; i >= 0; i--) {
            if (states[n - 1][i]) return i;
        }
        return 0;


    }
}
