package com.dzg.八大排序.冒泡排序;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/8/19
 */
public class Solution {
    public void bubbleSort(int[] nums) {
        int len = nums.length;
        boolean flag;
        for (int i = 0; i < len - 1; i++) {
             flag = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    nums[j] = nums[j] + nums[j + 1];
                    nums[j + 1] = nums[j] - nums[j + 1];
                    nums[j] = nums[j] - nums[j + 1];
//                    nums[j] = nums[j] ^ nums[j + 1];
//                    nums[j + 1] = nums[j] ^ nums[j + 1];
//                    nums[j] = nums[j] ^ nums[j + 1];
                    flag = true;
                }
            }
            if (!flag) break;

        }
        for (int num : nums) {

            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        new Solution().bubbleSort(new int[]{2, 3, 1, 5, 9, 7});
    }
}
