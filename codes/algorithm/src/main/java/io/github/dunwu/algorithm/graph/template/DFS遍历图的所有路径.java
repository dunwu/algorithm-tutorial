package io.github.dunwu.algorithm.graph.template;

import io.github.dunwu.algorithm.graph.Edge;
import io.github.dunwu.algorithm.graph.Graph;
import io.github.dunwu.algorithm.tree.Node;

import java.util.LinkedList;

/**
 * DFS遍历图的所有路径
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-12-02
 */
public class DFS遍历图的所有路径 {

    // onPath 和 path 记录当前递归路径上的节点
    boolean[] onPath = null;
    // 多叉树的遍历框架，寻找从根节点到目标节点的路径
    LinkedList<String> path = new LinkedList<>();

    void traverse(Node root, Node targetNode) {
        // base case
        if (root == null) {
            return;
        }
        if (root.val == targetNode.val) {
            // 找到目标节点
            System.out.println("find path: " + String.join("->", path) + "->" + targetNode);
            return;
        }
        // 前序位置
        path.addLast(String.valueOf(root.val));
        for (Node child : root.children) {
            traverse(child, targetNode);
        }
        // 后序位置
        path.removeLast();
    }

    void traverse(Graph graph, int from, int to) {
        if (onPath == null) { onPath = new boolean[graph.size()]; }
        // base case
        if (from < 0 || from >= graph.size()) { return; }
        // 防止死循环（成环）
        if (onPath[from]) { return; }
        if (from == to) {
            // 找到目标节点
            System.out.println("find path: " + String.join("->", path) + "->" + to);
            return;
        }

        // 前序位置
        onPath[from] = true;
        path.add(String.valueOf(from));
        for (Edge e : graph.neighbors(from)) {
            traverse(graph, e.to, to);
        }
        // 后序位置
        path.remove(path.size() - 1);
        onPath[from] = false;
    }

}
