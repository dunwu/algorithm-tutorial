package io.github.dunwu.algorithm.tree.btree.divide;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/symmetric-tree/">101. 对称二叉树</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2020-01-28
 */
public class 对称二叉树 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertTrue(s.isSymmetric(TreeNode.buildTree(1, 2, 2, 3, 4, 4, 3)));
        Assertions.assertFalse(s.isSymmetric(TreeNode.buildTree(1, 2, 2, null, 3, null, 3)));
    }

    static class Solution {

        public boolean isSymmetric(TreeNode root) {
            if (root == null) { return true; }
            return isSymmetric(root.left, root.right);
        }

        boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) { return true; }
            if (left == null || right == null) { return false; }
            // 两个根节点需要相同
            if (left.val != right.val) { return false; }
            // 左右子树也需要镜像对称
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }

    }

}
