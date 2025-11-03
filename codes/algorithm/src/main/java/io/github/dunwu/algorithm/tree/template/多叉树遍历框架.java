package io.github.dunwu.algorithm.tree.template;

import java.util.List;

/**
 * 多叉树遍历框架
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-03
 */
public class 多叉树遍历框架 {

    // 多叉树的遍历框架
    void traverse(Node root) {
        // base case
        if (root == null) {
            return;
        }
        // 前序位置
        System.out.println("visit " + root.val);
        for (Node child : root.children) {
            traverse(child);
        }
        // 后序位置
    }

    // 多叉树节点
    static class Node {

        int val;
        List<Node> children;

    }

}
