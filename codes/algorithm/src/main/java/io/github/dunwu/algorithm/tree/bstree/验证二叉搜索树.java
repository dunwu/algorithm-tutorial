package io.github.dunwu.algorithm.tree.bstree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/validate-binary-search-tree/">98. 验证二叉搜索树</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-02
 */
public class 验证二叉搜索树 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertTrue(s.isValidBST(TreeNode.buildTree(2, 1, 3)));
        Assertions.assertFalse(s.isValidBST(TreeNode.buildTree(5, 1, 4, null, null, 3, 6)));
        Assertions.assertFalse(s.isValidBST(TreeNode.buildTree(2, 2, 2)));
        Assertions.assertFalse(s.isValidBST(TreeNode.buildTree(5, 4, 6, null, null, 3, 7)));
    }

    static class Solution {

        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }

        // 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val
        boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
            // base case
            if (root == null) return true;
            // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
            if (min != null && root.val <= min.val) return false;
            if (max != null && root.val >= max.val) return false;
            // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
            return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
        }

    }

}
