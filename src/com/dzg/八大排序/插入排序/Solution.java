package com.dzg.八大排序.插入排序;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/8/19
 */
public class Solution {
    public void insertionSort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int temp = nums[i];
            while (i > 0 && nums[i - 1] > temp) {
                nums[i] = nums[i - 1];
                i--;
            }
            nums[i] = temp;
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }

    public static void main(String[] args) {
        new Solution().insertionSort(new int[]{2, 3, 1, 5, 9, 7,3});
    }
}


