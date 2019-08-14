package com.dzg.Offer.其他.丑数;

public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index ==0) return 0;
        int a = 0, b = 0, c = 0;
        int[] uglyArray = new int[index];
        uglyArray[0] = 1;
        for (int i = 0; i < index; i++) {
            int next1 = uglyArray[a] * 2;
            int next2 = uglyArray[b] * 2;
            int next3 = uglyArray[c] * 2;
            uglyArray[i] = Math.min(next1, Math.min(next2, next3));
            if (uglyArray[i] == next1) a++;
            if (uglyArray[i] == next2) b++;
            if (uglyArray[i] == next3) c++;
        }
        return uglyArray[index-1];
    }
}
