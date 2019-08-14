package com.dzg.Offer.模拟.孩子们的游戏;

public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if (m < 1) return -1;
        if (n <= 1) return n - 1;
        int[] array = new int[n];
        int cur = 0;
        int count = n - 1;
        while (true) {
            cur = findLucky(array, cur, m);
            array[cur] = 1;
            count--;
            if (count == 0) break;
        }
        return findLucky(array, cur, m);

    }

    private int findLucky(int[] array, int start, int m) {
        int cur = start;
        int count = 0;
        while (true) {
            if (cur > array.length - 1) {
                cur = 0;
            }
            if (array[cur] == 0) m--;
            if (m == 0) break;
            cur++;
        }
        return cur;
    }

    public static void main(String[] args) {
        int i = new Solution().LastRemaining_Solution(5, 3);
        System.out.println(i);
    }
}
