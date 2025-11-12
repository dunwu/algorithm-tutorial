package io.github.dunwu.algorithm.graph;

// 图结构的 BFS 遍历，从节点 s 开始进行 BFS，且记录遍历步数（从起点 s 到当前节点的边的条数）
// 每个节点自行维护 State 类，记录从 s 走来的遍历步数
public class State {

    // 当前节点 ID
    public int node;
    // 从起点 s 到当前节点的遍历步数
    public int step;

    public State(int node, int step) {
        this.node = node;
        this.step = step;
    }

}