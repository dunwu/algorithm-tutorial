package io.github.dunwu.algorithm.tree.btree.bfs;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/n-ary-tree-level-order-traversal/">429. N 叉树的层序遍历</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-27
 */
public class N叉树的层序遍历 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Node node3 = new Node(3);
        node3.children.add(new Node(5));
        node3.children.add(new Node(6));
        Node root = new Node(1);
        root.children.add(node3);
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        List<List<Integer>> res = s.levelOrder(root);
        System.out.printf("res: %s\n", res);
    }

    static class Solution {

        public List<List<Integer>> levelOrder(Node root) {
            if (root == null) { return new LinkedList<>(); }

            int depth = 1;
            LinkedList<List<Integer>> res = new LinkedList<>();
            LinkedList<Node> queue = new LinkedList<>();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    Node node = queue.removeFirst();
                    if (node == null) {
                        continue;
                    }
                    list.add(node.val);
                    if (node.children != null && node.children.size() > 0) {
                        for (Node child : node.children) {
                            queue.addLast(child);
                        }
                    }
                }
                System.out.printf("[depth: %d]nodes: %s\n", depth, list);
                res.add(list);
                depth++;
            }
            return res;
        }

    }

    static class Node {

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

}
