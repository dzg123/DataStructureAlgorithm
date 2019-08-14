package com.dzg.LeetCode.最小堆.TopK问题;

import java.util.*;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else map.put(num, 1);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (Integer key : map.keySet()) {
            if (priorityQueue.size() < k) priorityQueue.add(key);
            else if (key > priorityQueue.peek()) {
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }
        while (!priorityQueue.isEmpty()) {
            list.add(priorityQueue.poll());
        }
        return list;

    }
}
