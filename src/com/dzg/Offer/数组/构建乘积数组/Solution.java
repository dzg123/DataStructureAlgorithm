package com.dzg.Offer.数组.构建乘积数组;

public class Solution {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) return new int[0];
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            B[i] = 1;

        }
        for (int i = 0; i < A.length; i++) {
            int count = i;
            while (count > 0) {
                count--;
                B[i] *= A[count];
            }
            count = i;
            while (count < A.length - 1) {
                count++;
                B[i] *= A[count];
            }

        }
        return B;

    }
}
