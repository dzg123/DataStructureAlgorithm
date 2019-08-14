package com.dzg.Offer.字符串.第一个只出现一次的字符;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String s = String.valueOf(chars[i]);
            if (str.indexOf(s) == str.lastIndexOf(s)) return i;
        }
        return -1;
    }
}
