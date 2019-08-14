package com.dzg.Offer.数组.数字在排序数组中出现的次数;

public class Solution {
    public int GetNumberOfK(int[] array, int k) {
        int count = 0;
        int index = BinarySearch(array, k);
        if (index == -1) return 0;
        int temp = index;
        while (array[temp] == k) {
            count++;
            if (temp == array.length - 1) break;
            temp++;

        }
        while (array[index] == k) {
            count++;
            if (index == 0) break;
            index--;
        }
        return count - 1;
    }

    private int BinarySearch(int[] array, int k) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] < k) {
                low = mid + 1;
            } else if (array[mid] > k) high = mid - 1;
            else return mid;
        }
        return -1;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.GetNumberOfK(new int[]{3, 3, 3, 3, 4, 5}, 3);
        System.out.println(i);
    }
}
