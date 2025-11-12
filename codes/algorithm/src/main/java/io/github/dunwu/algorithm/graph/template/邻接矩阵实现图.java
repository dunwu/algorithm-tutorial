package io.github.dunwu.algorithm.graph.template;

import io.github.dunwu.algorithm.graph.Edge;

import java.util.ArrayList;
import java.util.List;

/**
 * 邻接矩阵实现图
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-06
 */
public class 邻接矩阵实现图 {

    public static void main(String[] args) {
        WeightedDigraph graph = new WeightedDigraph(3);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 0, 3);
        graph.addEdge(2, 1, 4);

        System.out.println(graph.hasEdge(0, 1)); // true
        System.out.println(graph.hasEdge(1, 0)); // false

        graph.neighbors(2).forEach(edge -> {
            System.out.println(2 + " -> " + edge.to + ", wight: " + edge.weight);
        });
        // 2 -> 0, wight: 3
        // 2 -> 1, wight: 4

        graph.removeEdge(0, 1);
        System.out.println(graph.hasEdge(0, 1)); // false
    }    // 存储相邻节点及边的权重

    // 加权有向图的通用实现（邻接矩阵）
    static class WeightedDigraph {

        // 邻接矩阵，matrix[from][to] 存储从节点 from 到节点 to 的边的权重
        // 0 表示没有连接
        private int[][] matrix;

        public WeightedDigraph(int n) {
            matrix = new int[n][n];
        }

        // 增，添加一条带权重的有向边，复杂度 O(1)
        public void addEdge(int from, int to, int weight) {
            matrix[from][to] = weight;
        }

        // 删，删除一条有向边，复杂度 O(1)
        public void removeEdge(int from, int to) {
            matrix[from][to] = 0;
        }

        // 查，判断两个节点是否相邻，复杂度 O(1)
        public boolean hasEdge(int from, int to) {
            return matrix[from][to] != 0;
        }

        // 查，返回一条边的权重，复杂度 O(1)
        public int weight(int from, int to) {
            return matrix[from][to];
        }

        // 查，返回某个节点的所有邻居节点，复杂度 O(V)
        public List<Edge> neighbors(int v) {
            List<Edge> res = new ArrayList<>();
            for (int i = 0; i < matrix[v].length; i++) {
                if (matrix[v][i] != 0) {
                    res.add(new Edge(i, matrix[v][i]));
                }
            }
            return res;
        }

    }

    // 无向加权图的通用实现
    static class WeightedUndigraph {

        private WeightedDigraph graph;

        public WeightedUndigraph(int n) {
            graph = new WeightedDigraph(n);
        }

        // 增，添加一条带权重的无向边
        public void addEdge(int from, int to, int weight) {
            graph.addEdge(from, to, weight);
            graph.addEdge(to, from, weight);
        }

        // 删，删除一条无向边
        public void removeEdge(int from, int to) {
            graph.removeEdge(from, to);
            graph.removeEdge(to, from);
        }

        // 查，判断两个节点是否相邻
        public boolean hasEdge(int from, int to) {
            return graph.hasEdge(from, to);
        }

        // 查，返回一条边的权重
        public int weight(int from, int to) {
            return graph.weight(from, to);
        }

        // 查，返回某个节点的所有邻居节点
        public List<Edge> neighbors(int v) {
            return graph.neighbors(v);
        }

        public static void main(String[] args) {
            WeightedUndigraph graph = new WeightedUndigraph(3);
            graph.addEdge(0, 1, 1);
            graph.addEdge(2, 0, 3);
            graph.addEdge(2, 1, 4);

            System.out.println(graph.hasEdge(0, 1)); // true
            System.out.println(graph.hasEdge(1, 0)); // true

            graph.neighbors(2).forEach(edge -> {
                System.out.println(2 + " <-> " + edge.to + ", wight: " + edge.weight);
            });
            // 2 <-> 0, wight: 3
            // 2 <-> 1, wight: 4

            graph.removeEdge(0, 1);
            System.out.println(graph.hasEdge(0, 1)); // false
            System.out.println(graph.hasEdge(1, 0)); // false
        }

    }

}
