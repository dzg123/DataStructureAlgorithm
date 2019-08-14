package com.dzg.LeetCode.动态规划.商品凑优惠券;

/*
 * 淘宝的“双十一”购物节有各种促销活动，比如“满200元减50元”。假设你女朋友的购物车中有n个（n>100）想买的商品，
 * 她希望从里面选几个，在凑够满减条件的 前提下，让选出来的商品价格总和最大程度地接近满减条件（200元），这样就可以极大限度地“薅羊毛”。作为程序员的你，能不能编个代码来帮她搞定呢？
 * */
public class Solution {
    public static void double11Advance(int[] items, int n, int w) {
        boolean[][] states = new boolean[n][3 * w + 1];
        states[0][0] = true;
        states[0][items[0]] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (states[i - 1][j]) states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= w - items[i]; j++) {
                if (states[i - 1][j]) states[i][j + items[i]] = true;
            }

        }
        int j;
        for (j = w; j < 3 * w + 1; j++) {
            if (states[n - 1][j]) break;
        }
        if (j == -1) return;
        for (int i = n - 1; i >= 1; i--) {
            if (j - items[i] >= 0 && states[i - 1][items[i]]) {
                System.out.print(items[i] + " ");//购买这个商品
                j = j - items[i];
            }
        }
        if (j != 0) System.out.print(items[0]);

    }
}
