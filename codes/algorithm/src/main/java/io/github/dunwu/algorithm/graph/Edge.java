package io.github.dunwu.algorithm.graph;

/**
 * 存储相邻节点及边的权重
 */
public class Edge {

    public int to;
    public int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

}