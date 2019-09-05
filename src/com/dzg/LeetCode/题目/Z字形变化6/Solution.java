package com.dzg.LeetCode.题目.Z字形变化6;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int row = Math.min(s.length(), numRows);
        String[] strArr = new String[row];
        for (int i = 0; i < row; i++) {
            strArr[i] = "";
        }
        int pos = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            strArr[pos] += s.substring(i, i + 1);
            if (pos == 0 || pos == numRows - 1) {
                flag = !flag;
            }
            pos += flag ? 1 : -1;
        }
        StringBuilder str = new StringBuilder();
        for (String s2 : strArr) {
            str.append(s2);
        }
        return str.toString();
    }

    public static void main(String[] args) {
//        new Solution().convert("LEETCODEISHIRING", 3);
        new Solution().convert("AB", 1);
    }
}
