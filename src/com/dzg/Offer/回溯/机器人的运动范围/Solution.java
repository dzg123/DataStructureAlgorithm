package com.dzg.Offer.回溯.机器人的运动范围;

public class Solution {
    private int[] flag;
    private int count;


    public int movingCount(int threshold, int rows, int cols) {
        flag = new int[rows * cols];
        helper(rows, cols, 0, 0, threshold);
        return count;
    }

    private boolean helper(int rows, int cols, int i, int j, int threshold) {
        int index = cols * i + j;
        System.out.println(index);
        if (i < 0 || i >= rows || j < 0 || j >= cols || flag[index] == 1) {
            return false;
        }
        if (getSum(i) + getSum(j) > threshold) {
            flag[index] = 1;
            return false;
        }
        flag[index] = 1;
        count++;
        helper(rows, cols, i - 1, j, threshold);
        helper(rows, cols, i + 1, j, threshold);
        helper(rows, cols, i, j - 1, threshold);
        helper(rows, cols, i, j + 1, threshold);
        return true;
    }

    private int getSum(int num) {
        int res = 0;
        while (num != 0) {
            res += num % 10;
            num = num / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().movingCount(15, 100, 1);
    }
}
