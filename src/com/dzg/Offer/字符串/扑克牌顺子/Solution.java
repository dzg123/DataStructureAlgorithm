package com.dzg.Offer.字符串.扑克牌顺子;

import java.util.TreeSet;

public class Solution {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5) return false;
        TreeSet<Integer> set = new TreeSet<>();
        for (int number : numbers) {
            if (number == 0) continue;
            if (!set.contains(number)) set.add(number);
            else return false;
        }
        return set.last() - set.first() <= 4;
    }
}
