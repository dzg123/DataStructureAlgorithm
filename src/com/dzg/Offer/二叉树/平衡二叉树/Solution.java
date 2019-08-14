package com.dzg.Offer.二叉树.平衡二叉树;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
//平衡二叉树不一定是二叉查找树，两者其实关系不大，平衡二叉树的诞生只是由于普通二叉查找树插入删除后时间复杂度变大后衍生出来的，
// 往往平衡树的原理会用在查找树上，从而出现平衡二叉查找树。
public class Solution {
    private boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        TreeDepth(root);
        return isBalanced;
    }

    private int TreeDepth(TreeNode root) {
        if (root == null || !isBalanced) return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if (Math.abs(left - right) > 1) isBalanced = false;
        return Math.max(left, right) + 1;
    }

}
