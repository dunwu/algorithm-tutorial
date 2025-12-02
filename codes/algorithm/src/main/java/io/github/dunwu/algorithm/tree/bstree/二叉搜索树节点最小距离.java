package io.github.dunwu.algorithm.tree.bstree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes">783. 二叉搜索树节点最小距离</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2020-06-18
 */
public class 二叉搜索树节点最小距离 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(1, s.minDiffInBST(TreeNode.buildTree(4, 2, 6, 1, 3)));
        Assertions.assertEquals(1, s.minDiffInBST(TreeNode.buildTree(1, 0, 48, null, null, 12, 49)));
    }

    static class Solution {

        private int res;

        public int minDiffInBST(TreeNode root) {
            res = 0;
            int rightMin = getMin(root.right);
            int leftMax = getMax(root.left);
            res = min(root.val, rightMin, leftMax);
            return res;
        }

        public int getMin(TreeNode root) {
            if (root.left != null) {
                return getMin(root.left);
            }
            return root.val;
        }

        public int getMax(TreeNode root) {
            if (root.right != null) {
                return getMax(root.right);
            }
            return root.val;
        }

        public int min(int a, int b, int c) {
            int min = 0;
            min = Math.min(Math.abs(a - b), Math.abs(a - c));
            min = Math.min(min, Math.abs(b - c));
            return min;
        }

    }

}
