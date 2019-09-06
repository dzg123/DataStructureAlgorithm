package com.dzg.LeetCode.递归.二叉树的最近公共祖先;

import com.dzg.Offer.二叉树.二叉搜索树的第K个结点.TreeNode;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {

            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);

        }
        return root;
    }
}
