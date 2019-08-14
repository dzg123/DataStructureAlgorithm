package com.dzg.LeetCode.栈.有效的括号;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    //用哈希表来做左右括号映射
    private HashMap<Character, Character> map = new HashMap<>();

    public Solution() {
        this.map.put(')', '(');
        this.map.put('}', '{');
        this.map.put(']', '[');
    }

    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0 && map.containsKey(c)) return false;
            if (map.containsValue(c)) {
                stack.push(c);
                continue;
            } else if (map.get(c) == stack.pop()) continue;
            return false;
        }
        return stack.isEmpty();
    }
}
