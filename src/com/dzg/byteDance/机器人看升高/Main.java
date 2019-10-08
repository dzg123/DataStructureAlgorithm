package com.dzg.byteDance.机器人看升高;

import java.util.HashMap;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/9/8
 */
public class Main {
    public static void main(String[] args) {
        find(new int[]{6, 5, 3, 4});
        find(new int[]{4, 5, 6, 7});
        find(new int[]{4, 50, 6, 7});
        find(new int[]{6, 4, 5, 2,3});
        find(new int[]{10, 8, 9, 7,11,5,6,7,8});
    }

    public static void find(int[] arr) {
        int[] h = arr;
        int[] count = new int[arr.length];
        int max = 0;
        boolean flag = false;
        for (int i = 0; i < h.length - 1; i++) {
            for (int j = i + 1; j < h.length; j++) {
                if (h[j] > h[i]) break;
                else if (h[j] == h[i]) {
                    count[i]++;
                    break;
                } else {
                    max = Math.max(max, h[j]);
                    if (h[j] < max) continue;
                    count[i]++;
                }

            }
            max = 0;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }
        if (max == 0) {
        System.out.println(0);
        flag = true;

    }
        if (!flag){
            for (int i = 0; i < count.length; i++) {
                if (count[i] == max) {
                    System.out.println(h[i]);
                    break;
                }
            }
        }



    }
}
