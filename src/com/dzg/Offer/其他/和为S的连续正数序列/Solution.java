package com.dzg.Offer.其他.和为S的连续正数序列;

import java.util.ArrayList;

public class Solution {
//    滑动窗口法
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int lowW = 1, highW = 2;
        while (highW > lowW) {
            int curSum = (lowW + highW) * (highW - lowW + 1) >> 1;
            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = lowW; i <= highW; i++) {
                    list.add(i);
                }
                res.add(list);
                lowW++;
            }else if(curSum < sum){
                highW++;
            } else lowW++;
        }
        return res;
    }
}
