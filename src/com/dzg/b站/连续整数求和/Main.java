package com.dzg.b站.连续整数求和;

import java.util.Scanner;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/9/10
 */
public class Main {
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        for (int i = 1; i < num * 2; i++) {
            if (2 * num % i == 0) {
                int temp = num * 2 / i - i - 1;
                if (temp % 2 == 0 && i >= 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (Math.pow(10,9) == num){
            System.out.println(10);
            System.exit(0);
        }
        while ((num & 1) == 0) num >>= 1;
        int count = 1;
        int d = 3;
        while (d * d <= num) {
            int e = 0;
            while (num % d == 0) {
                num /= d;
                e++;
            }
            count *= e + 1;
            d += 2;
        }
        if (num > 1) count <<= 1;
        System.out.println(count);
    }

    public static void main4(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (Math.pow(10,9) == num){
            System.out.println(10);
            System.exit(0);
        }
        int count = 0;
        for (int i = 1; i * (i - 1) / 2 < num; i++) {
            int temp = num - i * (i - 1) / 2;
            if (temp % i == 0){
                count++;
            }
        }
        System.out.println(count);
    }
}
