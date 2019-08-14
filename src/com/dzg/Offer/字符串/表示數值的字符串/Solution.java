package com.dzg.Offer.字符串.表示數值的字符串;

public class Solution {
    private int index = 0;

    public boolean isNumeric(char[] str) {
        if (str.length < 1) return false;
        boolean flag = scanInteger(str);
        if (index < str.length && str[index] == '.') {
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')){
            index++;
            flag = flag && scanInteger(str);
        }
        return flag && index == str.length;

    }

    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        return scanUnsignedInteger(str);

    }

    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && (str[index] >= '0' && str[index] <= '9')) {
            index++;
        }
        return start < index;
    }
}
