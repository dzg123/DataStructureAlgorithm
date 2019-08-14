package com.dzg.Offer.数组.数组中出现次数超过一半的数组;

import java.util.HashMap;

public class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        int l = array.length;
        int count;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                count = 0;
                count++;
                if ((count << 1) > l ) return array[i];
                map.put(array[i], count);
            } else {
                count = map.get(array[i]) + 1;
                if (count << 1 > l ) return array[i];
                map.put(array[i], count);
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(11 > 20 >>> 2);
    }
}
