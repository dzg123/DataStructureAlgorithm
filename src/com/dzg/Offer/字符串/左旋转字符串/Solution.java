package com.dzg.Offer.字符串.左旋转字符串;

public class Solution {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0) return str;
        int count = n % str.length();
        if (count == 0) return str;
        String s1 = str.substring(count);
        String s2 = str.substring(0, count);
        return s1 + s2;
    }
}
