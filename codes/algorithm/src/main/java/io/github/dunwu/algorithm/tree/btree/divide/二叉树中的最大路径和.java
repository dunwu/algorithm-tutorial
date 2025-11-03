package io.github.dunwu.algorithm.tree.btree.divide;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/">124. 二叉树中的最大路径和</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-06
 */
public class 二叉树中的最大路径和 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(6, s.maxPathSum(TreeNode.buildTree(1, 2, 3)));
        Assertions.assertEquals(42, s.maxPathSum(TreeNode.buildTree(-10, 9, 20, null, null, 15, 7)));
    }

    static class Solution {

        int res = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            if (root == null) { return 0; }
            oneSideMax(root);
            return res;
        }

        int oneSideMax(TreeNode root) {
            if (root == null) { return 0; }
            int left = Math.max(oneSideMax(root.left), 0);
            int right = Math.max(oneSideMax(root.right), 0);
            int pathMaxSum = root.val + left + right;
            res = Math.max(res, pathMaxSum);
            return Math.max(left, right) + root.val;
        }

    }

}
