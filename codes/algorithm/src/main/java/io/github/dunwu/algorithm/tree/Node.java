package io.github.dunwu.algorithm.tree;

import java.util.LinkedList;
import java.util.List;

// 多叉树节点
public class Node {

    public int val;
    public List<Node> children;

    public Node() {
        val = -1;
        children = new LinkedList<>();
    }

    public Node(int val) {
        this.val = val;
        this.children = new LinkedList<>();
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }

}