package io.github.dunwu.algorithm.tree.btree;

import cn.hutool.json.JSONUtil;
import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/maximum-binary-tree/">654. 最大二叉树</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 最大二叉树 {

    public static void main(String[] args) {
        TreeNode output = constructMaximumBinaryTree(new int[] { 3, 2, 1, 6, 0, 5 });
        List<Integer> outputList = TreeUtils.toBfsValueList(output);
        Assertions.assertArrayEquals(new Integer[] { 6, 3, 5, null, 2, 0, null, null, 1 }, outputList.toArray());

        TreeNode root = constructMaximumBinaryTree(new int[] { 3, 2, 1 });
        List<Integer> list = TreeUtils.toBfsValueList(root);
        Assertions.assertArrayEquals(new Integer[] { 3, null, 2, null, 1 }, list.toArray());
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return traverse(nums, 0, nums.length - 1);
    }

    public static TreeNode traverse(int[] nums, int left, int right) {
        if (nums == null || nums.length == 0) return null;
        if (left > right) return null;

        int pos = left, max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                pos = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = traverse(nums, left, pos - 1);
        root.right = traverse(nums, pos + 1, right);
        return root;
    }

}
