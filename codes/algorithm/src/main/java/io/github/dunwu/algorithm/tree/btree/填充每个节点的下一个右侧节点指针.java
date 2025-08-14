package io.github.dunwu.algorithm.tree.btree;

/**
 * <a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/">116. 填充每个节点的下一个右侧节点指针</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 填充每个节点的下一个右侧节点指针 {

    public Node connect(Node root) {
        if (root == null) return null;
        traverse(root.left, root.right);
        return root;
    }

    public void traverse(Node n1, Node n2) {
        if (n1 == null || n2 == null) return;
        n1.next = n2;
        traverse(n1.left, n1.right);
        traverse(n2.left, n2.right);
        traverse(n1.right, n2.left);
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
