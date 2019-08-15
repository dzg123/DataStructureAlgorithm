package com.dzg.LeetCode.优先级队列.TopK;

import java.util.PriorityQueue;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/8/14
 */
public class KthLargest {
    private PriorityQueue<Integer> queue;
    private int size;

    public KthLargest(int k, int[] nums) {
        size = k;
        queue = new PriorityQueue<>(size);
        for (int num : nums) {
            add(num);
        }

    }

    public int add(int val) {
        if (!queue.isEmpty() && queue.size() == size && val > queue.peek()) {
            queue.poll();
            queue.add(val);
        } else if (queue.size() < size)
            queue.add(val);
        return queue.peek();
    }
}
