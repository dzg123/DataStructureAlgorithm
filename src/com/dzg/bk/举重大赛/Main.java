package com.dzg.bk.举重大赛;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < num - 1; i++) {
            for (int j = i + 1; j < num; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                    continue;
                }
                double temp = nums[i] / (double) nums[j];
                if (temp >= 0.9) count++;
                else break;
            }
        }
        System.out.println(count);

    }
}
