package com.dzg.小米.移动数组;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/9/11
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            int[] dpup = new int[n];
            int[] dpdown = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                dpup[i] = 1;
                dpdown[i] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[j] <= arr[i]) {
                        dpup[i] = Math.max(dpup[i], dpup[j] + 1);
                    }
                    if (arr[j] >= arr[i]) {
                        dpdown[i] = Math.max(dpdown[i], dpdown[j] + 1);
                    }
                }
            }

            int upmax = 0;
            int downmax = 0;
            for (int i = 0; i < n; i++) {
                upmax = Math.max(upmax, dpup[i]);
                downmax = Math.max(downmax, dpdown[i]);
            }
            System.out.println((n - upmax) < (n - downmax) ? (n - upmax) : (n - downmax));

        }
    }
}
