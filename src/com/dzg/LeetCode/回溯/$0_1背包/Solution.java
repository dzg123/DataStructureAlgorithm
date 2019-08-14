package com.dzg.LeetCode.回溯.$0_1背包;

/*
 * 。我们有一个背包，背包总的承载重量是Wkg。现在我们有n个物品，每个物品的重量不等，并且不可分割。
 * 我们现在期望选择几件物品，装载到背包中。在不超过背包所能装载重量的前提下，如何让背包中物品的总重量最大
 * */
public class Solution {
    private int maxW = Integer.MIN_VALUE;
    private boolean[][] flag = new boolean[5][10]; // 备忘录，默认值false

    // curW表示当前已经装进去的物品的重量和；i表示考察到哪个物品了； // w背包重量；items表示每个物品的重量；n表示物品个数
    public void f(int i, int curW, int[] items, int n, int w) {
        if (i == n || curW == w) {//递归结束条件
            if (curW > maxW) {
                maxW = curW;
                return;
            }
        }
        if (flag[i][curW]) return; // 重复状态
        flag[i][curW] = true; // 记录(i, curW)这个状态
        f(i + 1, curW, items, n, w);//不选择当前物品，直接考虑下一个（第 i+test1 个），故 cw 不更新
        if (curW + items[i] <= w) {
            f(i + 1, curW + items[i], items, n, w);//选择了当前物品，故考虑下一个时，cw 通过入参更新为 cw + items[i]
        }
    }
}
