package io.github.dunwu.algorithm.tree.btree.dfs;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/balanced-binary-tree/">110. 平衡二叉树</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-06
 */
public class 平衡二叉树 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertTrue(s.isBalanced(TreeNode.buildTree(3, 9, 20, null, null, 15, 7)));
        Assertions.assertFalse(s.isBalanced(TreeNode.buildTree(1, 2, 2, 3, 3, null, null, 4, 4)));
        Assertions.assertTrue(s.isBalanced(TreeNode.buildTree()));
    }

    static class Solution {

        boolean isOk = true;

        public boolean isBalanced(TreeNode root) {
            isOk = true;
            maxDepth(root);
            return isOk;
        }

        public int maxDepth(TreeNode root) {
            if (root == null) { return 0; }
            if (root.left == null && root.right == null) { return 1; }
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            if (Math.abs(leftDepth - rightDepth) > 1) {
                isOk = false;
            }
            return Math.max(leftDepth, rightDepth) + 1;
        }

    }

}
