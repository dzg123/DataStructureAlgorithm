package com.dzg.LeetCode.数组.和不超过k的三个数;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/9/15
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
            set.add(sc.nextInt());
        }
        Integer[] arr = new Integer[set.size()];
        Integer[] temp = set.toArray(arr);
        int[] nums = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
        int k = sc.nextInt();
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < k) {
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    count += r - l;
                    l++;
                } else r--;
            }
        }
        System.out.println(count);
    }
}
//8
//        -2 0 1 2 3 6 2 3
//        2
