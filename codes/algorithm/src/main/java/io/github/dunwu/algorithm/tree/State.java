package io.github.dunwu.algorithm.tree;

// 多叉树的层序遍历
// 每个节点自行维护 State 类，记录深度等信息
public class State {

    public Node node;
    public int depth;

    public State(Node node, int depth) {
        this.node = node;
        this.depth = depth;
    }

}