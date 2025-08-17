package io.github.dunwu.algorithm.tree.btree;

import cn.hutool.json.JSONUtil;
import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/">117. 填充每个节点的下一个右侧节点指针 II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 填充每个节点的下一个右侧节点指针2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode treeNode = TreeUtils.buildTree(1, 2, 3, 4, 5, null, 7);
        Node root = JSONUtil.toBean(JSONUtil.toJsonStr(treeNode), Node.class);
        s.connect(root);
        System.out.println(root);
    }

    static class Solution {

        public Node connect(Node root) {
            if (root == null) return null;
            traverse(root);
            return root;
        }

        public void traverse(Node root) {
            if (root == null) return;
            LinkedList<Node> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                int size = q.size();
                Node prev = null;
                for (int i = 0; i < size; i++) {
                    Node cur = q.poll();
                    if (prev != null) { prev.next = cur; }
                    if (cur.left != null) q.offer(cur.left);
                    if (cur.right != null) q.offer(cur.right);
                    prev = cur;
                }
            }
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
