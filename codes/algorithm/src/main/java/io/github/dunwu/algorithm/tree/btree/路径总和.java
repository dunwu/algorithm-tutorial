package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/path-sum/">112. 路径总和</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2020-01-29
 */
public class 路径总和 {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode tree = TreeNode.buildTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1);
        Assertions.assertTrue(s.hasPathSum(tree, 22));
        TreeNode tree2 = TreeNode.buildTree(1, 2);
        Assertions.assertFalse(s.hasPathSum(tree2, 1));
    }

    static class Solution {

        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) { return false; }
            if (root.left == null && root.right == null && root.val == targetSum) { return true; }
            return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
        }

    }

}
