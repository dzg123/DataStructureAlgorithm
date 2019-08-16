package com.dzg.LeetCode.哈希.LeetCode242$有效的字母异位词;

import java.util.HashMap;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/8/16
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else map.put(c, map.get(c) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            } else {
                Integer v = map.get(c);
                if (v <= 0) return false;
                map.put(c, v - 1);
            }
        }
        return true;
    }
    public boolean isAnagramBetter(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
