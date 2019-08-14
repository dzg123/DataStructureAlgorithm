package com.dzg.LeetCode.回溯.$0_1背包.$0_1背包升级版;

/*
 * 对于一组不同重量、不同价值、不可分割的物品,我们选择将某些物品 装入背包,
 * 在满足背包最大重量限制的前提下,背包中可装入物品的总价值最大是多少呢？
 * */
public class Solution {
    private int maxV = Integer.MIN_VALUE;
    private int[] items = {2, 2, 4, 6, 3};  // 物品的重量
    private int n = 5; // 物品个数
    private int[] value = {3, 4, 8, 9, 6};// 物品的价值
    private int w = 9; // 背包承受的最大重量

    public void f(int i, int curW, int curV) {
        if (curW == w || i == n) {
            if (curV > maxV) {
                maxV = curV;
                return;
            }
        }
        f(i + 1, curW, curV);
        if (curW + items[i] <= w) {
            f(i + 1, curW + items[i], curV + value[i]);
        }
    }
}
