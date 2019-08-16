package com.dzg.LeetCode.哈希.两数之和;

import java.util.HashMap;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/8/16
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
