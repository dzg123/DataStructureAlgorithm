package com.dzg.Offer.二叉树.二叉搜索树的第K个结点;


import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    private PriorityQueue<TreeNode> queue;

    //最大堆
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) return null;
        queue = new PriorityQueue<>(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return o2.val - o1.val;
            }
        });
        RecursivePush(pRoot, k);
        return queue.size() == k ? queue.peek() : null;
    }

    private void RecursivePush(TreeNode node, int k) {
        if (node == null) return;
        queue.add(node);
        if (queue.size() > k) queue.poll();
        RecursivePush(node.left, k);
        RecursivePush(node.right, k);
    }

    private int index;
    private TreeNode node;

    //中序遍历
    TreeNode KthNode2(TreeNode pRoot, int k) {
        if (pRoot == null) return null;
        KthNode2(pRoot.left, k);
        index++;
        if (index == k) node = pRoot;
        KthNode2(pRoot.right, k);
        return node;
    }
}
