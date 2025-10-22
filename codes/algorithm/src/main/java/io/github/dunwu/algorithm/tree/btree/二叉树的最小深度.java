package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/minimum-depth-of-binary-tree">二叉树的最小深度</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 二叉树的最小深度 {

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = TreeNode.buildTree(3, 9, 20, null, null, 15, 7);
        Assertions.assertEquals(2, s.minDepth(root));

        TreeNode root2 = TreeNode.buildTree(2, null, 3, null, 4, null, 5, null, 6);
        Assertions.assertEquals(5, s.minDepth(root2));
    }

    static class Solution {

        public int minDepth(TreeNode root) {
            if (root == null) { return 0; }
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            if (root.left == null || root.right == null) { return left + right + 1; }
            return Math.min(left, right) + 1;
        }

    }

}
