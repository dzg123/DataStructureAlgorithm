package com.dzg.Offer.字符串.翻转单词顺序列;

public class Solution {
    public String ReverseSentence(String str) {
        if (str == null ||  str.trim().length() == 0) return str;
        String[] split = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (i == 0)
                stringBuilder.append(split[i]);
            else
                stringBuilder.append(split[i]).append(" ");
        }
        return stringBuilder.toString();
    }
}
