package io.github.dunwu.algorithm.tree.btree.dfs;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/balanced-binary-tree/">110. 平衡二叉树</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-10-30
 */
public class 二叉树的坡度 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(1, s.findTilt(TreeNode.buildTree(1, 2, 3)));
        Assertions.assertEquals(15, s.findTilt(TreeNode.buildTree(4, 2, 9, 3, 5, null, 7)));
        Assertions.assertEquals(9, s.findTilt(TreeNode.buildTree(21, 7, 14, 1, 1, 2, 2, 3, 3)));
    }

    static class Solution {

        int res = 0;

        public int findTilt(TreeNode root) {
            res = 0;
            sum(root);
            return res;
        }

        public int sum(TreeNode root) {
            if (root == null) { return 0; }
            int left = sum(root.left);
            int right = sum(root.right);
            res += Math.abs(left - right);
            return left + right + root.val;
        }

    }

}
