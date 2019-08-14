package com.dzg.Offer.堆.数据流中的中位数;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    private int count;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void Insert(Integer num) {
        count++;
        if ((count & 1) == 0) {
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.add(num);
                num = maxHeap.poll();
            }
            minHeap.add(num);
        } else {
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.add(num);
                num = minHeap.poll();
            }
            maxHeap.add(num);
        }
    }

    public Double GetMedian() {
        if (count == 0) throw new RuntimeException("没有数据流");
        if ((count & 1) == 0) return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else return Double.valueOf(maxHeap.peek());

    }
}
