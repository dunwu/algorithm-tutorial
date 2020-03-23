package io.github.dunwu.leetcode.tree;

import java.util.List;

// 559. N叉树的最大深度
//
// https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
//
// 给定一个 N 叉树，找到其最大深度。
//
// 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
//
// 例如，给定一个 3叉树 :
//
// 我们应返回其最大深度，3。
//
// 说明:
//
// 树的深度不会超过 1000。
// 树的节点总不会超过 5000。

public class TreeMaxDepth {

    public int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children == null || root.children.size() == 0) return 1;
        int subMax = 0;
        for (Node node : root.children) {
            int temp = maxDepth(node);
            if (temp > subMax) {
                subMax = temp;
            }
        }
        return subMax + 1;
    }

    static class Node {

        public int val;

        public List<Node> children;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }

    }

}
