package io.github.dunwu.algorithm.tree.btree.bfs;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/check-completeness-of-a-binary-tree/">958. 二叉树的完全性检验</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-18
 */
public class 二叉树的完全性检验 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertTrue(s.isCompleteTree(TreeNode.buildTree(1, 2, 3, 4, 5, 6)));
        Assertions.assertTrue(s.isCompleteTree(
            TreeNode.buildTree(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                25, 26, 27, 28, 29, 30, 31, 32, 33)));
        Assertions.assertFalse(s.isCompleteTree(TreeNode.buildTree(1, 2, 3, 4, 5, null, 7)));
        Assertions.assertFalse(s.isCompleteTree(TreeNode.buildTree(1, 2, 3, 5, null, 7, 8)));
        Assertions.assertFalse(s.isCompleteTree(TreeNode.buildTree(1, null, 7)));
    }

    static class Solution {

        static class NodeInfo {

            public int id;
            public TreeNode node;

            public NodeInfo(int id, TreeNode node) {
                this.id = id;
                this.node = node;
            }

        }

        public boolean isCompleteTree(TreeNode root) {

            if (root == null) { return false; }

            int expect = 1;
            LinkedList<NodeInfo> queue = new LinkedList<>();
            queue.offer(new NodeInfo(1, root));
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    NodeInfo info = queue.poll();
                    if (expect != info.id) { return false; }
                    if (info.node.left == null && info.node.right != null) {
                        return false;
                    }
                    if (info.node.left != null) {
                        queue.offer(new NodeInfo(info.id * 2, info.node.left));
                    }
                    if (info.node.right != null) {
                        queue.offer(new NodeInfo(info.id * 2 + 1, info.node.right));
                    }
                    expect++;
                }
            }

            return true;
        }

    }

}
