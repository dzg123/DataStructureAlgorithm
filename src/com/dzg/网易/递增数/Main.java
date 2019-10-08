package com.dzg.网易.递增数;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author shz
 * @Description: ${todo}
 * @date 2019/9/7
 */
public class Main {
    static class TreeNode {
        int val;
        int left;
        int right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            int num = sc.nextInt();
            TreeNode[] nodes = new TreeNode[num];
            int[] inDegree = new int[num];
            for (int j = 0; j < num; j++) {
                nodes[j] = new TreeNode(sc.nextInt());
                nodes[j].left = sc.nextInt();
                if (nodes[j].left != -1) inDegree[nodes[j].left]++;
                nodes[j].right = sc.nextInt();
                if (nodes[j].right != -1) inDegree[nodes[j].right]++;
            }
            int rootIndex = 0;
            for (int j = 0; j < num; j++) {
                if (inDegree[j] == 0) {
                    rootIndex = j;
                }
            }
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = nodes[rootIndex];
            queue.add(nodes[root.left]);
            queue.add(nodes[root.right]);
            boolean flag = false;
            while (!queue.isEmpty()) {
                int size = queue.size();
//                int n = size;
                double sum = root.val;
                double sum2 = 0;
                while (size-- > 0) {
                    TreeNode node = queue.poll();
                    sum2 += node.val;
                    if (node.left != -1) {
                        queue.add(nodes[node.left]);
                    }
                    if (node.right != -1) {
                        queue.add(nodes[node.right]);
                    }
                }
                if (sum >= sum2) {
                    list.add("NO");
                    flag = true;
                    break;
                }
                sum = sum2;
                sum2 = 0;
            }
            if (!flag) list.add("YES");
        }
        for (String s : list) {
            System.out.println(s);

        }


    }
}
//2
//        8
//        2 -1 -1
//        1 5 3
//        4 -1 6
//        2 -1 -1
//        3 0 2
//        2 4 7
//        7 -1 -1
//        2 -1 -1
//        8
//        21 6 -1
//        52 4 -1
//        80 0 3
//        31 7 -1
//        21 -1 -1
//        59 -1 -1
//        50 5 -1
//        48 -1 1
//