package com.dzg.Offer.其他.不用加减乘除做加法;

import java.util.Arrays;

public class Solution {
    public int Add(int num1, int num2) {
        return num2 == 0 ? num1 : Add(num1 ^ num2, (num1 & num2) << 1);
    }
}

