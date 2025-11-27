package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/maximum-binary-tree/">654. 最大二叉树</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 最大二叉树 {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode output = s.constructMaximumBinaryTree(new int[] { 3, 2, 1, 6, 0, 5 });
        Assertions.assertEquals(TreeNode.buildTree(6, 3, 5, null, 2, 0, null, null, 1), output);
        TreeNode output2 = s.constructMaximumBinaryTree(new int[] { 3, 2, 1 });
        Assertions.assertEquals(TreeNode.buildTree(3, null, 2, null, 1), output2);
    }

    static class Solution {

        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return dfs(nums, 0, nums.length - 1);
        }

        public TreeNode dfs(int[] nums, int start, int end) {
            if (start > end) { return null; }
            int max = -1;
            int maxIndex = start;
            for (int i = start; i <= end; i++) {
                if (nums[i] > max) {
                    maxIndex = i;
                    max = nums[i];
                }
            }
            TreeNode root = new TreeNode(nums[maxIndex]);
            root.left = dfs(nums, start, maxIndex - 1);
            root.right = dfs(nums, maxIndex + 1, end);
            return root;
        }

    }

}
