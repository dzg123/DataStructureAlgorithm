package com.dzg.Offer.堆.最小的K个数;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input.length < k || k <= 0) return new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : input) {
            maxHeap.add(i);
            if (maxHeap.size() > k) maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }
}
