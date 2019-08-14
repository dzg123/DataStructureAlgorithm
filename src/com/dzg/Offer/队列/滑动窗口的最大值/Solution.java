package com.dzg.Offer.队列.滑动窗口的最大值;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private Queue<Integer> queue;
    private int curMax;

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (size < 1 || num == null || num.length < size) return new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= num.length - size; i++) {
            curMax = Integer.MIN_VALUE;
            for (int j = 0; j < size; j++) {
                if (curMax < num[i + j]) curMax = num[i + j];
            }
            list.add(curMax);
        }
        return list;
    }

    private void findSlideWindowMax(int[] num, int size) {
        for (int i = 0; i < size; i++) {


        }

    }
}
