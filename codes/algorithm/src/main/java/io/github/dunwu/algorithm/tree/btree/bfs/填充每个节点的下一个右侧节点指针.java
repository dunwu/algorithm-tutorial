package io.github.dunwu.algorithm.tree.btree.bfs;

import cn.hutool.json.JSONUtil;
import io.github.dunwu.algorithm.tree.TreeNode;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/">116. 填充每个节点的下一个右侧节点指针</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 填充每个节点的下一个右侧节点指针 {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode treeNode = TreeNode.buildTree(1, 2, 3, 4, 5, 6, 7);
        Node root = JSONUtil.toBean(JSONUtil.toJsonStr(treeNode), Node.class);
        s.connect(root);
        System.out.println(root);
    }

    static class Solution {

        public Node connect(Node root) {
            if (root == null) return root;
            LinkedList<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                Node prev = queue.poll();
                if (prev.left != null) queue.offer(prev.left);
                if (prev.right != null) queue.offer(prev.right);
                for (int i = 1; i < size; i++) {
                    Node next = queue.poll();
                    prev.next = next;
                    prev = next;
                    if (next.left != null) queue.offer(next.left);
                    if (next.right != null) queue.offer(next.right);
                }
            }
            return root;
        }

    }

    static class Node extends TreeNode {

        public Node next;
        public Node left;
        public Node right;

        public Node(int val) {
            super(val);
        }

        public Node(int val, TreeNode left, TreeNode right) {
            super(val, left, right);
        }

    }

}
