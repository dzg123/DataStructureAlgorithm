package com.dzg.八大排序.归并排序;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/8/20
 */
public class Solution {
    public void mergeSort(int[] nums, int L, int R) {
        if (L == R) return;
        else {
            int mid = L + (R - L >> 1);
//            先分后合
            mergeSort(nums, L, mid);
            mergeSort(nums, mid + 1, R);
            merge(nums, L, mid + 1, R);

        }
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] left = new int[mid - l];
        int[] right = new int[r - mid + 1];
        for (int i = l; i < mid; i++) {
            left[i - l] = nums[i];
        }
        for (int i = mid; i <= r; i++) {
            right[i - mid] = nums[i];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                nums[k] = left[i];
                i++;
                k++;
            } else {
                nums[k] = right[j];
                j++;
                k++;
            }
        }
        while (i < left.length) {
            nums[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            nums[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] ints = {2, 3, 1, 5, 9, 7, 3};
        new Solution().mergeSort(ints, 0, 6);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }

    }
}
