package com.dzg.LeetCode.图.Kahn算法;

import java.util.LinkedList;
/*
拓扑排序算法: 如何确定代码源文件的编译依赖关系？
* */
public class Solution {
    private int v;
    private LinkedList<Integer>[] adj;

    public Solution(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();

        }
    }

    public void addEdge(int s, int t) {// s 先于 t, 边 s -> t
        adj[s].add(t);

    }

    public void topoSortByKahn() {
        int[] inDegree = new int[v];//统计每个顶点的入度
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j);
                inDegree[w]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int i = queue.remove();
            System.out.println("->" + i);
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j);
                inDegree[w]--;
                if (inDegree[w] == 0) queue.add(w);

            }

        }
    }
}
