package com.dzg.LeetCode.栈.比较含退格的字符串;

import java.util.Stack;
public class Solution {
    //用两个栈来解决
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack = realStr(S);
        Stack<Character> stack2 = realStr(T);
        if (stack.size()!=stack2.size()) return false;
        while (!stack.isEmpty() && stack.pop() != stack2.pop()) return false;
        return true;
    }

    private Stack<Character> realStr(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '#') stack.push(c);
            else stack.pop();
        }
        return stack;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.backspaceCompare("xywrrmp", "xywrrmu#p");
    }
}
