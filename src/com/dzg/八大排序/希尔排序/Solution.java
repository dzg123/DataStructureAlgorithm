package com.dzg.八大排序.希尔排序;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/8/20
 */
public class Solution {
    public void shellSort(int[] arr) {
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while (j - step >= 0 && arr[j - step] > temp) {
                    arr[j] = arr[j - step];
                    j = j - step;
                }
                arr[j] = temp;

            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {2, 3, 1, 5, 9, 7, 3};
        new Solution().shellSort(ints);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
