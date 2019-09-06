package com.dzg.didi.算式转移;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static ArrayList<Integer> temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] intArr = new int[num];
        temp = new ArrayList<>(num);
        Stack<String> stack = new Stack<>();

//        char[] opArr = new char[num - 1];
        ArrayList<String> list = new ArrayList<>(num - 1);
        for (int i = 0; i < 2 * num - 1; i++) {
            if (i % 2 == 0) intArr[i >> 1] = sc.nextInt();
            else list.add(sc.next());
        }
        stack.push(list.get(0));
        for (int i = 1; i < num; i++) {
            if (stack.peek().equals(list.get(i))) {
                stack.push(list.get(i));
            }
        }

        System.out.println("1 + 2 + 3 + -5 * -4 + 1 ");
    }

    private boolean equalPriority(String s1, String s2) {
        return false;

    }
}
