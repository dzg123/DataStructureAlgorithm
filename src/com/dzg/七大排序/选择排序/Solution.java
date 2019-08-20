package com.dzg.七大排序.选择排序;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/8/19
 */
public class Solution {
    public void selectionSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int index = 0;
            for (int j = 0; j < len - i; j++) {
                if (nums[j] > nums[index]) {
                    index = j;
                }
            }
//            nums[index] = nums[index] ^ nums[len - 1 - i];
//            nums[len - 1 - i] = nums[index] ^ nums[len - 1 - i];
//            nums[index] = nums[index] ^ nums[len - 1 - i];
            if (index != len - 1 - i) {
                nums[index] = nums[index] + nums[len - 1 - i];
                nums[len - 1 - i] = nums[index] - nums[len - 1 - i];
                nums[index] = nums[index] - nums[len - 1 - i];
            }
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        new Solution().selectionSort(new int[]{2, 3, 1, 5, 9, 7});
    }
}
