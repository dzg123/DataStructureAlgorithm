package com.dzg.网易.二进制回文数;

import java.util.Scanner;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/9/7
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] a = new int[25];
        int c,e,f;
        double sum;
        for (int i = 0; i < count; i++) {
            int x = sc.nextInt();
            f = x;
            e = 0;
            sum = 0;
            while (x != 0){
                c = x %2;
                a[e] = c;
                e++;
                x /=2;
            }
            e--;
            for (int j = 0; j <= e; j++) {
                sum = sum + a[j] * Math.pow(2, e - j);
            }
            if (sum - f == 0){
                System.out.println("YES");
            }else System.out.println("NO");


//            int num = 1, len = 1, temp = x >> 1;
//            while (temp != 0) {
//                num <<= 1;
//                temp >>= 1;
//                len++;
//            }
//            len /= 2;
//            while (len-- != 0) {
//                if ((num & x == 0 ) && (x & 1) != 0){
//
//                }
//            }
        }
    }
}
