package com.dzg.byteDance.装水;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/9/8
 */
class Solution {
    public boolean canMeasureWater(int x, int y, int h, int z) {
        if (z == 0) {
            System.out.println(0);
        }
        if (x + y + h < z) {
            System.out.println(-1);
        }
        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
        }
        if (y > 0) {
            int r = x % y;
            while (r > 0) {
                x = y;
                y = r;
                r = x % y;
            }
            return z % y == 0;
        }
        return z % x == 0;
    }
}
