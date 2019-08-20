package com.dzg.八大排序.插入排序.插入排序二分优化;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/8/19
 */
public class Solution {
    public void insertionSortByBinarySearch(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int temp = nums[i];
            int index = binarySearch(temp, nums, 0, i - 1);
            for (int j = i - 1; j >= index; j--) {
                nums[j + 1] = nums[j];
            }
            nums[index] = temp;
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }

    public static void main(String[] args) {
        new Solution().insertionSortByBinarySearch(new int[]{2, 3, 1, 5, 9, 7, 3});
    }

    private static int binarySearch(int num, int[] nums, int lIndex, int hIndex) {
        int lo = lIndex;
        int hi = hIndex;
        while (lo <= hi) {
            int mid = lo + (hi - lo >>> 1);
            if (nums[mid] > num) {
                hi = mid - 1;
            } else if (nums[mid] < num) lo = mid + 1;
            else {
                while (mid < nums.length && nums[mid] == num) {
                    mid++;
                }
                return mid;
            }
        }
        return lo;
    }
}
