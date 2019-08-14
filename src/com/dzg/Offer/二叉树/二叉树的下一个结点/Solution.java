package com.dzg.Offer.二叉树.二叉树的下一个结点;

public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        TreeLinkNode parent = pNode.next;
       if (pNode.right != null){
           return RecursiveFind(pNode.right);
       }else {
           while (pNode.next != null && pNode.next.left!=pNode){
               pNode = pNode.next;
           }
           return pNode.next;
       }

    }
    private TreeLinkNode RecursiveFind(TreeLinkNode node) {
        while(node.left !=null){
            node = node.left;
        }
        return node;
    }

    public TreeLinkNode GetNext2(TreeLinkNode pNode) {
        if (pNode == null) return null;
        TreeLinkNode right = pNode.right;
        if (right == null) return null;

        return RecursiveFind(right);
    }

    private TreeLinkNode firstInRightTree(TreeLinkNode pNode){
        TreeLinkNode curr = pNode.right;
        while(curr.left != null){
            curr = curr.left;
        }
        return curr;
    }
}
