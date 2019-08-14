package com.dzg.Offer.二叉树.对称的二叉树;


public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return RecursiveMatch(pRoot.left, pRoot.right);


    }

    private void Mirror(TreeNode root) {
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        Mirror(root.left);
        Mirror(root.right);
    }

    private boolean RecursiveMatch(TreeNode left,TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return RecursiveMatch(left.left, right.right) && RecursiveMatch(left.right, right.left);

    }
}
