package io.github.dunwu.algorithm.tree.btree;

import java.util.LinkedList;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-06
 */
public class 填充每个节点的下一个右侧节点指针 {

    public Node connect(Node root) {
        if (root == null) return null;
        bfs(root);
        return root;
    }

    /**
     * 基于 BFS 实现二叉树层次遍历。关键在于使用一个队列存储
     */
    public void bfs(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i < size; i++) {
                queue.get(i - 1).next = queue.get(i);
            }

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
    }

    private static class Node {

        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int val) { this.val = val; }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                "val=" + val +
                '}';
        }

    }

}
