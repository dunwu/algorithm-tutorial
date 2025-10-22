package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/">104. 二叉树的最大深度</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 二叉树的最大深度 {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNode.buildTree(3, 9, 20, null, null, 15, 7);
        Assertions.assertEquals(3, s.maxDepth(root));

        TreeNode root2 = TreeNode.buildTree(1, null, 2);
        Assertions.assertEquals(2, s.maxDepth(root2));
    }

    static class Solution {

        int depth = 0;
        int res = 0;

        public int maxDepth(TreeNode root) {
            traverse(root);
            return res;
        }

        public void traverse(TreeNode root) {
            if (root == null) return;
            depth++;
            if (root.left == null && root.right == null) {
                res = Math.max(res, depth);
            }
            traverse(root.left);
            traverse(root.right);

            depth--;
        }

        public int maxDepth2(TreeNode root) {
            if (root == null) { return 0; }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }

    }

}
