package com.dzg.网易.test1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sNum = sc.nextInt();
        int[] arr = new int[sNum];
        for (int i = 0; i < sNum; i++) {
            arr[i] = sc.nextInt();
        }
        int[] ints = new int[151];
        int[] arrPre = new int[151];
        for (int i = 0; i < arr.length; i++) {
            ints[arr[i]]++;
        }
        arrPre[0] = ints[0];
        for (int i = 1; i < 151; i++) {
            arrPre[i] = arrPre[i - 1] + ints[i];
        }
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            int i1 = sc.nextInt();
            double res = 100.0 * (arrPre[arr[i1-1]] - 1) / sNum;
            System.out.println(String.format("%.6f", res));
        }
    }
}
