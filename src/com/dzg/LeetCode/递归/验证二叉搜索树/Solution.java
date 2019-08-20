package com.dzg.LeetCode.递归.验证二叉搜索树;

import com.dzg.Offer.二叉树.二叉搜索树的第K个结点.TreeNode;

import java.util.LinkedList;

public class Solution {
    //DFS
    LinkedList<TreeNode> queue = new LinkedList<>();
    LinkedList<Integer> min = new LinkedList<>(), max = new LinkedList<>();

    private void update(TreeNode root, Integer min, Integer max) {
        queue.add(root);
        this.min.add(min);
        this.max.add(max);

    }

    public boolean isValidBST(TreeNode root) {
        Integer min = null, max = null, val;
        update(root, min, max);
        while (!queue.isEmpty()) {
            root = queue.poll();
            min = this.min.poll();
            max = this.max.poll();
            if (root == null) continue;
            val = root.val;
            if (min != null && min >= val) return false;
            if (max != null && max <= val) return false;
            update(root.left, min, val);
            update(root.right, val, max);
        }
        return true;

    }

    //中序遍历+判断是否为升序序列
    long pre = Long.MIN_VALUE;
    boolean flag = true;

    public boolean isVaildBST2(TreeNode root) {
        inOrder(root);
        return flag;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (pre >= root.val) {
            flag = false;
            return;
        }
        pre = root.val;
        inOrder(root.right);
    }

}
