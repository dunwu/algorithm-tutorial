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
        Assertions.assertEquals(3, s.diameterOfBinaryTree(TreeNode.buildTree(1, 2, 3, 4, 5)));
        Assertions.assertEquals(1, s.diameterOfBinaryTree(TreeNode.buildTree(1, 2)));
        Assertions.assertEquals(0, s.diameterOfBinaryTree(TreeNode.buildTree(1)));
        Assertions.assertEquals(2, s.diameterOfBinaryTree(TreeNode.buildTree(2, 3, null, 1)));
    }

    static class Solution {

        private int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            max = 0;
            depth(root);
            return max;
        }

        public int depth(TreeNode root) {
            if (root == null) { return 0; }
            int left = depth(root.left);
            int right = depth(root.right);
            int depth = Math.max(left, right) + 1;
            max = Math.max(max, left + right);
            return depth;
        }

    }

}
