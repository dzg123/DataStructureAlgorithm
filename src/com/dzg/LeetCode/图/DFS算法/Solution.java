package com.dzg.LeetCode.图.DFS算法;

import java.util.LinkedList;

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

    public void topoSortByDFS() {
// 先构建逆邻接表，边 s->t 表示， s 依赖于 t, t 先于 s
        LinkedList<Integer> inverseAdj[] = new LinkedList[v];
        for (int i = 0; i < v; i++) { // 申请空间
            inverseAdj[i] = new LinkedList<>();
        }
        for (int i = 0; i < v; i++) { // 通过邻接表生成逆邻接表
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j); // i->w
                inverseAdj[w].add(i); // w->i
            }
        }
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) { //深度优先遍历图
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, inverseAdj, visited);
            }
        }
    }

    private void dfs(int vertex, LinkedList<Integer> inverseAdj[], boolean[] visited) {
        for (int i = 0; i < inverseAdj[vertex].size(); i++) {
            int w = inverseAdj[vertex].get(i);
            if (visited[w] ) {
                continue;
            }
            visited[w] = true;
            dfs(w, inverseAdj, visited);
        } // 先把 vertex 这个顶点可达的所有顶点都打印出来之后，再打印它自己
        System.out.println("->" + vertex);
    }


}
