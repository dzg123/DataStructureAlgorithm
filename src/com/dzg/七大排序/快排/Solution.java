package com.dzg.七大排序.快排;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/8/19
 */
public class Solution {
    public void quickSort(int[] nums, int l, int h) {
        if (l >= h) {
            return;
        }
        int lo = l;
        int hi = h;
        int mid = lo + (hi - lo >> 1);
        int pivot = nums[l];
        while (lo < hi) {
            while (lo < hi && nums[hi] >= pivot) hi--;
            nums[lo] = nums[hi];
            while (lo < hi && nums[lo] <= pivot) lo++;
            nums[hi] = nums[lo];
        }
//        swap(nums,l,hi);
        nums[hi] = pivot;
        quickSort(nums, l, hi - 1);
        quickSort(nums, hi + 1, h);
    }

    private static void swap(int[] aa, int a, int b) {
        int temp = aa[a];
        aa[a] = aa[b];
        aa[b] = temp;
    }

    public static void main(String[] args) {
        int[] ints = {2, 3, 1, 5, 9, 7, 3};
        new Solution().quickSort(ints, 0, 6);
        for (int anInt : ints) {
            System.out.println(anInt);

        }
    }
}


