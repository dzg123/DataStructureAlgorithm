package com.dzg.Offer.二叉树.序列化二叉树;

import sun.reflect.generics.tree.Tree;

public class Solution {
    private String deserializeStr;

    String Serialize(TreeNode root) {
        if (root == null) return "#";
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    TreeNode Deserialize(String str) {
        deserializeStr = str;
        return RecursiveDeserialize();

    }

    private TreeNode RecursiveDeserialize() {
        if(deserializeStr.length() == 0) return null;
        int index = deserializeStr.indexOf(" ");
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        deserializeStr = index == -1 ? null : deserializeStr.substring(index + 1);
        if (node.equals("#")) return null;
        Integer value = Integer.valueOf(node);
        TreeNode root = new TreeNode(value);
        root.left = RecursiveDeserialize();
        root.right = RecursiveDeserialize();
        return root;
    }

}
