package com.dzg.LeetCode.图.最短路径算法.A星算法;

import java.util.LinkedList;


public class Graph {
    private int v;// 顶点个数
    private LinkedList<Edge>[] adj;//邻接表
    // Graph 类的成员变量，在构造函数中初始化
    Vertex[] vertexes = new Vertex[this.v];

    // 新增一个方法，添加顶点的坐标
    public void addVetex(int id, int x, int y) {
        vertexes[id] = new Vertex(id, x, y);
    }

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
        public int f; // 新增：f(i) = g(i) + h(i)
        public int x, y; // 新增：顶点在地图中的坐标（x,y）


        public Vertex(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.f = Integer.MAX_VALUE;
            this.dist = Integer.MAX_VALUE;
        }
    }

    // 因为Java提供的优先级队列，没有暴露更新数据的接口，所以我们需要重新实现一个
    public class PriorityQueue<T> { // 根据vertex.dist构建小顶堆
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

        public void clear() {
            for (int i = 0; i < count; i++)
                nodes[i] = null;
            count = 0;

        }
    }

    public void astar(int s, int t) { // 从顶点s到顶点t的路径
        int[] predecessor = new int[this.v]; // 用来还原路径
        // 按照 vertex 的 f 值构建小顶堆，而不是按照dist
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>(this.v);
        boolean[] inqueue = new boolean[this.v]; // 标记是否进入过队列
        vertexes[s].dist = 0;
        vertexes[s].f = 0;
        queue.add(vertexes[s]);
        inqueue[s] = true;
        while (!queue.isEmpty()) {
            Vertex minVertex = queue.poll(); // 取出堆顶元素并删除
            for (int i = 0; i < adj[minVertex.id].size(); i++) {
                Edge e = adj[minVertex.id].get(i); // 取出一条 minVertex相连的边
                Vertex nextVertex = vertexes[e.tid]; // minVertex --> nextVertex
                if (minVertex.dist + e.w < nextVertex.dist) {
                    nextVertex.dist = minVertex.dist + e.w;
                    nextVertex.f = nextVertex.dist + hManhatta(nextVertex, vertexes[t]);
                    predecessor[nextVertex.id] = minVertex.id;
                    if (inqueue[nextVertex.id]) {
                        queue.update(nextVertex);
                    } else {
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }
                if (nextVertex.id == t) {
                    queue.clear();
                    break;
                }

            }
        }
        System.out.println(s);
        print(s, t, predecessor); //print函数实现参看 Dijkstra算法实现
    }

    private int hManhatta(Vertex v1 , Vertex v2) {
        return Math.abs(v1.x - v2.x) + Math.abs(v1.y - v2.y);
    }

    private void print(int s, int t, int[] predecessor) {
        if (s == t) return;
        print(s, predecessor[t], predecessor);
        System.out.println("->" + t);
    }

}
