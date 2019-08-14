package com.dzg.Offer.其他.整数中1出现的次数;

public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int num = 0;
        int a, b;
        for (int i = 0; i < n; i *= 10) {
            a = n / i;
            b = n % i;
            num += (a + 8) / 10 * i + ((a % 10 == 1) ? b+1 : 0);
        }
        return num;
    }
}
