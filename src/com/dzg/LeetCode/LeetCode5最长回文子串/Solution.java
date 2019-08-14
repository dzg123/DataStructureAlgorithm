package com.dzg.LeetCode.LeetCode5最长回文子串;

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        boolean[][] status = new boolean[s.length()][s.length()];
        String longestPalindromeStr = s.substring(0, 1);
        int longestPalindrome = 1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if ((s.charAt(i) == s.charAt(j)) && (i - j <= 2 || status[j + 1][i - 1])) {
                    status[j][i] = true;
                    if (i + 1 - j > longestPalindrome) {
                        longestPalindrome = i + 1 - j;
                        longestPalindromeStr = s.substring(j, i + 1);
                    }
                }

            }

        }
        return longestPalindromeStr;
    }
}
