package com.dzg.Offer.字符串.字符流中第一个不重复的字符;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private int[] array = new int[256];
    Queue<Character> queue = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        array[ch]++;
        queue.add(ch);
        while (!queue.isEmpty() && array[(int) queue.peek()] > 1) queue.poll();

    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
