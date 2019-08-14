package com.dzg.bk.计算绝对值;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] nums = new int[count];
        nums[0] = sc.nextInt();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = sc.nextInt();
            int temp = Math.abs(nums[i] - nums[i - 1]);
            if (min > temp) min = temp;
        }
        for (int i = 1; i < nums.length; i++) {
            int temp = Math.abs(nums[i] - nums[i - 1]);
            if (min == temp) {
                System.out.print(nums[i-1] + " ");
                System.out.println(nums[i]);
                break;
            }
        }
    }
}
//9
//        1 3 5 7 2 6 5 12 12
