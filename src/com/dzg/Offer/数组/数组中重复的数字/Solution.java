package com.dzg.Offer.数组.数组中重复的数字;

import java.util.HashSet;

public class Solution {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length == 0) {
            duplication[0] = -1;
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i : numbers) {
            if (!set.contains(i)) set.add(i);
            else {
                duplication[0] = i;
                return true;
            }
        }
        return false;
    }
}
