package com.dzg.相反数;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/7/30
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = String.valueOf(n);
        int size = s.length();
        int flag = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            int sum = s.charAt(size - 1 - i) + s.charAt(i) - 48*2 + flag;
            if (sum - 10  >= 0) {
                sum = sum - 10;
                flag = 1;
            } else {
                flag = 0;
            }
            stack.add(sum);
            if (i == size - 1 && flag == 1) stack.add(flag);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}
