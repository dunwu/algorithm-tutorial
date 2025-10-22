package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/diameter-of-binary-tree/">543. 二叉树的直径</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 二叉树的直径 {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNode.buildTree(1, 2, 3, 4, 5);
        Assertions.assertEquals(3, s.diameterOfBinaryTree(root));

        Solution s2 = new Solution();
        TreeNode root2 = TreeNode.buildTree(1, 2);
        Assertions.assertEquals(1, s2.diameterOfBinaryTree(root2));
    }

    static class Solution {

        private int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) { return 0; }
            maxDepth(root);
            return max;
        }

        public int maxDepth(TreeNode root) {
            if (root == null) { return 0; }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            int temp = left + right;
            max = Math.max(max, temp);
            return Math.max(left, right) + 1;
        }

    }

}
