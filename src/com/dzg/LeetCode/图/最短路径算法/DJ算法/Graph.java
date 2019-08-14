package com.dzg.LeetCode.图.最短路径算法.DJ算法;

import javafx.scene.layout.Priority;

import java.util.LinkedList;


public class Graph {
    private int v;// 顶点个数
    private LinkedList<Edge>[] adj;//邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();

        }
    }

    public void addEdge(int s, int t, int w) {// s 先于 t, 边 s -> t 添加一条边
        adj[s].add(new Edge(s, t, w));

    }

    private class Edge {
        private int sid; // 边的起始顶点编号
        private int tid; // 边的终止顶点编号
        private int w; // 权重

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }

    private class Vertex {
        private int id;//顶点编号
        private int dist;//从起始顶点到这个顶点的距离

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;

        }
    }

    // 因为Java提供的优先级队列，没有暴露更新数据的接口，所以我们需要重新实现一个
    public class PriorityQueue { // 根据vertex.dist构建小顶堆
        private Vertex[] nodes;
        private int count;

        public PriorityQueue(int v) {
            this.nodes = new Vertex[v + 1];
            this.count = v;
        }

        public Vertex poll() {
            // TODO: 留给读者实现...
            if (count == 0) throw new NullPointerException("dont have elements in queue");
            Vertex temp = null;
            temp = nodes[0];
            System.arraycopy(nodes, 1, new Vertex[v - 1], 0, v + 1);
            count--;
            return temp;
        }

        public void add(Vertex vertex) {
            // TODO: 留给读者实现...
        }

        public void remove(Vertex vertex) {
            // TODO: 留给读者实现...
        }

        // 更新结点的值，并且从下往上堆化，重新符合堆的定义。时间复杂度O(logn)。
        public void update(Vertex vertex) {
            // TODO: 留给读者实现...
            remove(vertex);
            add(vertex);
        }

        public boolean isEmpty() {
            return count == 0;
        }


    }

    public void dijkstra(int s, int t) {// 从顶点s到顶点t的最短路径
        int[] predecessor = new int[v];// 用来还原最短路径
        Vertex[] vertices = new Vertex[v];
        for (int i = 0; i < v; i++) {
            vertices[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        PriorityQueue queue = new PriorityQueue(v);
        boolean[] inqueue = new boolean[v]; // 标记是否进入过队列
        vertices[s].dist = 0;
        queue.add(vertices[s]);
        inqueue[s] = true;
        while (!queue.isEmpty()) {
            Vertex minVertex = queue.poll();//去堆顶元素并删除
            if (minVertex.id == t) break;//最短路径产生了
            for (int i = 0; i < adj[minVertex.id].size(); i++) {
                Edge e = adj[minVertex.id].get(i); // 取出一条minVetex相连的边
                Vertex nextVertex = vertices[e.tid]; // minVertex-->nextVertex
                if (minVertex.dist + e.w < nextVertex.dist) { // 更新next的dist
                    nextVertex.dist = minVertex.dist + e.w;
                    predecessor[nextVertex.id] = minVertex.id;
                    if (inqueue[nextVertex.id]) {
                        queue.update(nextVertex); // 更新队列中的dist值
                    } else {
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }

            }
        }
        System.out.println(s);
        print(s, t, predecessor);
    }

    private void print(int s, int t, int[] predecessor) {
        if (s == t) return;
        print(s, predecessor[t], predecessor);
        System.out.println("->" + t);
    }
}
