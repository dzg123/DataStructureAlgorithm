package com.dzg.Offer.字符串.字符串转换成整数;

public class Solution {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) return 0;

        boolean isNagative = str.charAt(0) == '-';
        int num = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '-' || c == '+')) continue;
            if (c < '0' || c > '9') return 0;
            num = num * 10 + c - '0';

        }
        return isNagative ? -num : num;
    }

    public static void main(String[] args) {
        int a = 0;
        boolean b = a > 0 && a++ > 0;
        System.out.println(a);
        System.out.println(b);
        String s = String.format("%s", 0x1234);
        System.out.println(s);
    }
}
