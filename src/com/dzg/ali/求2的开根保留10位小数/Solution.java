package com.dzg.ali.求2的开根保留10位小数;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/8/23
 */
public class Solution {
    private final static double EPSILON = 0.0000000001;

    double sqrt2() {
        double low = 1.4, high = 1.5;
        double mid = (low + high) / 2;

        while (high - low > EPSILON) {
            if (mid * mid > 2) {
                high = mid;
            } else {
                low = mid;
            }
            mid = (high + low) / 2;
        }

        return mid;
    }
}
