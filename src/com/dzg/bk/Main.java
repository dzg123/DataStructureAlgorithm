package com.dzg.bk;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int count = sc.nextInt();
            float sum = num;
            double temp = num;
            for (int i = 1; i < count; i++) {
                temp = Math.sqrt(temp);
                sum += temp;
            }
            System.out.printf("%.2f",sum);
        }
    }
}
