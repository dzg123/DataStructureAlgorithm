package com.dzg.Offer.字符串.正则表达式匹配;

public class Solution {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return tinMatch(str, 0, pattern, 0);

    }

    private boolean tinMatch(char[] str, int strIndex, char[] pattern, int patIndex) {
        if (strIndex == str.length && patIndex == pattern.length) {
            return true;
        }
        if (strIndex != str.length && pattern.length == patIndex) return false;
        if (patIndex + 1 < pattern.length && pattern[patIndex + 1] == '*') {
            if ((strIndex != str.length && str[strIndex] == pattern[patIndex]) || (strIndex != str.length && pattern[patIndex] == '.')) {
                return tinMatch(str, strIndex, pattern, patIndex + 2)
                        || tinMatch(str, strIndex + 1, pattern, patIndex) || tinMatch(str, strIndex+1, pattern, patIndex+2);
            } else return tinMatch(str, strIndex, pattern, patIndex + 2);
        }
        if ((strIndex != str.length && str[strIndex] == pattern[patIndex]) || (strIndex != str.length && pattern[patIndex] == '.')) {
            return tinMatch(str, strIndex + 1, pattern, patIndex + 1);
        }
        return false;
    }
}
