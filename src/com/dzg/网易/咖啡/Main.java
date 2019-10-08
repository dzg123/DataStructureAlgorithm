package com.dzg.网易.咖啡;

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
        for (int i = 0; i < count; i++) {
            int interval = sc.nextInt();
            int day = sc.nextInt();
            int res = day;
            int[] mon = new int[day];
            for (int j = 0; j < day; j++) {
                mon[j] = sc.nextInt();
            }
            int l = 0;
            int r = 1;
            for (int j = 0; j < day; j++) {
                if (j == 0) {
                }
                if (mon[j + 1] - mon[j] < 2 * interval + 1) continue;
//                int temp = (mon[j + 1] - mon[j])/

            }

        }
    }
}


