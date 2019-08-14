package com.dzg.Offer.二叉树.二叉搜索树转为双向链表;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {
    private TreeNode pre = null;
    private TreeNode head = null;
    public Solution() {

    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        Convert(pRootOfTree.left);
        pRootOfTree.left = pre;
        if (pre != null) pre.right = pRootOfTree;
        pre = pRootOfTree;
        if (head == null) head = pRootOfTree;

        Convert(pRootOfTree.right);
        return head;
    }
}
