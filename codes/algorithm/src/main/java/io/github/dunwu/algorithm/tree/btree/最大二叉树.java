package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.List;

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
        List<Integer> outputList = TreeNode.toValueList(output);
        Assertions.assertArrayEquals(new Integer[] { 6, 3, 5, null, 2, 0, null, null, 1 }, outputList.toArray());

        TreeNode root = s.constructMaximumBinaryTree(new int[] { 3, 2, 1 });
        List<Integer> list = TreeNode.toValueList(root);
        Assertions.assertArrayEquals(new Integer[] { 3, null, 2, null, 1 }, list.toArray());
    }

    static class Solution {

        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (nums == null || nums.length == 0) { return null; }
            return build(nums, 0, nums.length - 1);
        }

        public TreeNode build(int[] nums, int low, int high) {
            if (low > high) { return null; }
            int mid = 0;
            int max = Integer.MIN_VALUE;
            for (int i = low; i <= high; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    mid = i;
                }
            }
            TreeNode root = new TreeNode(max);
            root.left = build(nums, low, mid - 1);
            root.right = build(nums, mid + 1, high);
            return root;
        }

    }

}
