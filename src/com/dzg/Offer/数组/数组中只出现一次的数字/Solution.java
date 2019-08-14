package com.dzg.Offer.数组.数组中只出现一次的数字;

import java.util.*;

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce2(int[] array, int num1[], int num2[]) {
        int diff = 0;
        for (int i : array) {
            diff ^= i;
        }
        diff &= -diff;
        for (int i : array) {
            if ((diff & i) == 0) num1[0] ^= i;
            else num2[0] ^= i;

        }
    }

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
                while (list.contains(i)) list.remove((Integer) i);

            } else {
                map.put(i, 1);
            }
        }
        num1[0] = list.get(0);
        num2[0] = list.get(1);
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        new Solution().FindNumsAppearOnce(new int[]{1, 1, 1, 1, 4, 6}, new int[]{0}, new int[]{0});
        char s = 97;
        System.out.println(s);
    }
}
