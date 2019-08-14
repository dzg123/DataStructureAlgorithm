package com.dzg.bk.递增递减;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] nums = new int[count];
        nums[0] = sc.nextInt();
        int index = 0;
        int pIndex = count - 1;
        for (int i = 1; i < count; i++) {
            if (nums[i] == nums[i - 1]) {
                System.out.println(-1);
                System.exit(0);
            }
            if (nums[i] < nums[i - 1]) {
                index = i;
                break;
            }
            if (i == count - 1) {
                System.out.println(0);
                System.exit(0);
            }
        }
        for (int i = count - 1; i > index; i--) {
            if (nums[i] > nums[i - 1]) {
                pIndex = i;
                break;
            }

        }
        int res = 0;
        for (int i = index; i < pIndex; i++) {
            res += nums[pIndex] + 1 - nums[i];
        }
        System.out.println(res);
    }
}
