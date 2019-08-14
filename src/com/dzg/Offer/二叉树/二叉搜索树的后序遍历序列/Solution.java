package com.dzg.Offer.二叉树.二叉搜索树的后序遍历序列;

public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return Verify(sequence, 0, sequence.length - 1);
    }

    private boolean Verify(int[] sequence, int first, int last) {
        if (last - first <= 1) return true;
        int root = sequence[last];
        int curIndex = first;
        while (curIndex < last && sequence[curIndex] < root)
            curIndex++;
        for (int i = curIndex; i < last; i++) {
            if (sequence[i] < root) return false;
        }
        return Verify(sequence, 0, curIndex-1) && Verify(sequence, curIndex + 1, last-1);

    }

    public static void main(String[] args) {
        boolean b = new Solution().VerifySquenceOfBST(new int[]{7, 4, 6, 5});
        System.out.println(b);
    }
}
