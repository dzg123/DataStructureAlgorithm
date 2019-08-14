package com.dzg.Offer.数组.数组中的逆序对;

public class Solution {
    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) return 0;
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        int count = InversePairsCore(array, copy, 0, array.length - 1);
        return count;
    }

    private int InversePairsCore(int[] array, int[] copy, int low, int high) {
        if (low == high) return 0;
        int mid =(high - low >> 1)+low;
//        int mid = mids + low;
        System.out.println(mid);
        int leftCount = InversePairsCore(array, copy, low, mid) % 1000000007;
        int rightCount = InversePairsCore(array, copy, mid + 1, high) % 1000000007;
        int count = 0;
        int i = mid;
        int j = high;
        int locCopy = high;
        while (i >= low && j > mid) {
            if (array[i] > array[j]) {
                count += j - mid;
                copy[locCopy--] = array[i--];
                if (count >= 1000000007) count %= 1000000007;

            } else {
                copy[locCopy--] = array[j--];
            }

        }
        for (; i >= low; i--) {
            copy[locCopy--] = array[i];
        }
        for (; j > mid; j--) {
            copy[locCopy--] = array[j];
        }
        for (int k = low; k <= high; k++) {
            array[k] = copy[k];
        }
        return (leftCount + rightCount + count) % 1000000007;

    }


    private int InversePairsCore2(int[] array, int[] copy, int low, int high) {
        if (low == high) {
            return 0;
        }
        int mid = (low + high) >> 1;
        int leftCount = InversePairsCore2(array, copy, low, mid) % 1000000007;
        int rightCount = InversePairsCore2(array, copy, mid + 1, high) % 1000000007;
        int count = 0;
        int i = mid;
        int j = high;
        int locCopy = high;
        while (i >= low && j > mid) {
            if (array[i] > array[j]) {
                count += j - mid;
                copy[locCopy--] = array[i--];
                if (count >= 1000000007)//数值过大求余
                {
                    count %= 1000000007;
                }
            } else {
                copy[locCopy--] = array[j--];
            }
        }
        for (; i >= low; i--) {
            copy[locCopy--] = array[i];
        }
        for (; j > mid; j--) {
            copy[locCopy--] = array[j];
        }
        for (int s = low; s <= high; s++) {
            array[s] = copy[s];
        }
        return (leftCount + rightCount + count) % 1000000007;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 0};
        int i = (5 + 2 << 1) + 10;
        System.out.println(i);
    }
}
