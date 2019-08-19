package com.dzg.bk.美丽数;

import java.util.Scanner;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/8/8
 */
//对于一个非负整数我们称它是美丽的当且仅当它的十进制表示下不包含多个相同的数字。比如1234，7523 都是美丽的，但 99，121，3043 等都不是美丽的。
// 现在给出一个数字n，你需要找到比n大的，最小的美 丽的数。 输入描述： 第一行包含一个整数n。1000 ≤ n ≤ 9000 输出描述： 输出对应的答案，若不存在满足条件的数，输出-1。
// 输入样例1： 1987 输出样例1： 2013 输入样例2： 2013 输出样例2： 2014
//
//
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9001];
        int num = sc.nextInt();
        for (int i = 1000; i < 9001; i++) {
            arr[i] = isBeautiful(i) ? 1 : 0;
        }
        for (int i = num + 1; i < 9001; i++) {
            if (arr[i] == 1) {
                System.out.println(i);
                System.exit(0);
            }
        }
        System.out.println(-1);

    }

    private static boolean isBeautiful(int num) {
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            if (s.lastIndexOf(s.charAt(i)) != i) return false;
        }
        return true;

    }
}
