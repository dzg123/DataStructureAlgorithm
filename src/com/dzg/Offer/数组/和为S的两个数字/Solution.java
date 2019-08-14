package com.dzg.Offer.数组.和为S的两个数字;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
    private int min = Integer.MAX_VALUE;

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int start = 0;
        int k;
        int mid = array.length - 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (start < array.length) {
            k = sum - array[start];
            int res = binarySearch(array, start, mid, k);
            if (res != -1) {
                int multiply = k * array[start];
                findMin(multiply);
                map.put(multiply, k);
                mid = res;
            }
            start++;
        }
        if (map.isEmpty()) return new ArrayList<>();
        Integer num = map.get(min);
        int otherNum = sum - num;
        list.add(num);
        list.add(otherNum);
        Collections.sort(list);
        return list;

    }

    private void findMin(int i) {
        if (i < min) min = i;
    }


    private int binarySearch(int[] array, int start, int mid, int k) {
        int low = start;
        int high = mid;
        while (low <= high) {
            int mid2 = low + (high - low) / 2;
            if (array[mid2] < k) {
                low = mid2 + 1;
            } else if (array[mid2] > k) high = mid2 - 1;
            else return mid2;
        }
        return -1;
    }

}
