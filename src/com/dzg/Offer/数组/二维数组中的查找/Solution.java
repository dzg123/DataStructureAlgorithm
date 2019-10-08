package com.dzg.Offer.数组.二维数组中的查找;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/10/8
 */
public class Solution {
    public boolean find(int[][] array, int target) {
        int row = array.length;
        int col = array[0].length;
        for (int i = 0, j = col - 1; i < row && j >= 0; ) {
            if (target == array[i][j]) {
                return true;
            } else if (target < array[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;

    }

    public boolean find2(int[][] array, int target) {
        for (int i = 0; i < array.length; i++) {
            int low = 0;
            int high = array[0].length - 1;
            while (low <= high) {
                int mid = low + (high - low >> 1);
                if (array[i][mid] == target) {
                    return true;
                } else if (array[i][mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
