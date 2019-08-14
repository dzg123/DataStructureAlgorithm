package com.dzg.Offer.数组.把数组排成最小的数;

import java.util.*;

public class Solution {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) return "";
        HashMap<Integer, Object> map = new HashMap<>();
        HashSet<Object> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int[] array = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            int m = 1;
            for (int j = 0; j < (int) Math.log10(numbers[i]); j++) {
                m *= 10;
            }
            array[i] = numbers[i] < 10 ? numbers[i] : numbers[i] / m;
            if (map.containsKey(array[i])) {
                Object value = map.get(array[i]);
                String s = ("" + value + numbers[i]).compareTo("" + numbers[i] + value) > 0 ? "" + numbers[i] + value : "" + value + numbers[i];
                map.put(array[i], s);
            } else map.put(array[i], numbers[i]);
        }
        Arrays.sort(array);
        for (int i : array) {
            Object num = map.get(i);
            if (!set.contains(num)) sb.append(num);
            set.add(num);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] array = {3, 5, 1, 4, 2};
        System.out.println("" + 12 + 24);
    }

    //    比较器
    public String PrintMinNumber2(int[] numbers) {
        String ret = "";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : numbers) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = "" + o1 + o2;
                String s2 = "" + o2 + o1;
                return s1.compareTo(s2);
            }
        });
        for (Integer i : list) {
            ret += i;

        }
        return ret;
    }
}
