package com.dzg.LeetCode.优先级队列.滑动窗口最大值;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {
    private PriorityQueue<Integer> queue;
    private ArrayList<Integer> res = new ArrayList<>();
    private int[] ints;
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[]{};
        queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.add(nums[i]);
                if (queue.size() == k) res.add(queue.peek());
            }
            else {
                queue.remove(nums[i - k]);
                queue.add(nums[i]);
                res.add(queue.peek());
            }
        }
         ints = new int[res.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = res.get(i);
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] ints = new Solution().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);

    }
}
