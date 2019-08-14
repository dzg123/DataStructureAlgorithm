package com.dzg.LeetCode.回溯.八皇后问题;

public class Solution {
    private int[] res = new int[8];//下标表示行,值表示queen存储在哪一列

    public void cal8Queens(int row) {
        if (row == 8) {
            printQueens(res);
            return;
        }
        for (int cols = 0; cols < 8; cols++) {// 每一行都有8中放法
            if (isOk(row, cols)) {
                res[row] = cols;
                cal8Queens(row + 1);
            }


        }

    }

    private boolean isOk(int row, int cols) {
        int leftUp = cols - 1, rightUp = cols + 1;
        for (int i = row - 1; i >= 0; i--) { // 逐行往上考察每一行
            if (res[i] == cols) return false;
            if (leftUp >= 0) { // 考察左上对角线：第i行leftup列有棋子吗
                if (res[i] == leftUp) return false;
            }
            if (rightUp < 8) { // 考察右上对角线：第i行leftup列有棋子吗
                if (res[i] == rightUp) return false;
            }
            --leftUp;
            ++rightUp;
        }
        return true;
    }

    private void printQueens(int[] res) {
        for (int row = 0; row < 8; row++) {
            for (int cols = 0; cols < 8; cols++) {
                if (res[row] == cols) System.out.print("Q");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new Solution().cal8Queens(0);
    }
}
