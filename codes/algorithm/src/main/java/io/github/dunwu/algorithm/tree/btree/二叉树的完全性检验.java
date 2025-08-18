package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/check-completeness-of-a-binary-tree/">958. 二叉树的完全性检验</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-18
 */
public class 二叉树的完全性检验 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertTrue(s.isCompleteTree(TreeUtils.buildTree(1, 2, 3, 4, 5, 6)));
        Assertions.assertFalse(s.isCompleteTree(TreeUtils.buildTree(1, 2, 3, 4, 5, null, 7)));
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

            int id = 1;
            LinkedList<NodeInfo> q = new LinkedList<>();
            q.offer(new NodeInfo(id, root));

            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    NodeInfo info = q.poll();
                    if (info.id != id) { return false; }
                    if (info.node.left != null) { q.offer(new NodeInfo(id * 2, info.node.left)); }
                    if (info.node.right != null) { q.offer(new NodeInfo(id * 2 + 1, info.node.right)); }
                    id++;
                }
            }
            return true;
        }

    }

}
