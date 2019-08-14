package com.dzg.Offer.数组.顺时针打印矩阵;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int rowS = 0;
        int rowE = matrix.length - 1;
        int columnS = 0;
        int columnE = matrix[0].length - 1;

        while (rowS <= rowE && columnS <= columnE) {
            for (int i = columnS; i <= columnE; i++)
                list.add(matrix[rowS][i]);
            for (int j = rowS + 1; j <= rowE; j++)
                list.add(matrix[j][columnE]);
            if (rowS < rowE) for (int i = columnE - 1; i >= columnS; i--) {
                list.add(matrix[rowE][i]);
            }
            if (columnS < columnE) for (int i = rowE - 1; i > rowS; i--) {
                list.add(matrix[i][rowS]);
            }
            rowS++;
            rowE--;
            columnS++;
            columnE--;
        }
        return list;
    }
}
