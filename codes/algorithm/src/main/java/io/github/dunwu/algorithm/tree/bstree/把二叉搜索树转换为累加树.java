package io.github.dunwu.algorithm.tree.bstree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/convert-bst-to-greater-tree/">538. 把二叉搜索树转换为累加树</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-22
 */
public class 把二叉搜索树转换为累加树 {

    public static void main(String[] args) {

        Solution s = new Solution();

        TreeNode input1 = TreeNode.buildTree(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8);
        TreeNode output1 = s.convertBST(input1);
        Assertions.assertArrayEquals(
            new Integer[] { 30, 36, 21, 36, 35, 26, 15, null, null, null, 33, null, null, null, 8 },
            TreeNode.toValueList(output1).toArray());

        TreeNode input2 = TreeNode.buildTree(0, null, 1);
        TreeNode output2 = s.convertBST(input2);
        Assertions.assertArrayEquals(new Integer[] { 1, null, 1 }, TreeNode.toValueList(output2).toArray());

        TreeNode input3 = TreeNode.buildTree(1, 0, 2);
        TreeNode output3 = s.convertBST(input3);
        Assertions.assertArrayEquals(new Integer[] { 3, 3, 2 }, TreeNode.toValueList(output3).toArray());

        TreeNode input4 = TreeNode.buildTree(3, 2, 4, 1);
        TreeNode output4 = s.convertBST(input4);
        Assertions.assertArrayEquals(new Integer[] { 7, 9, 4, 10 }, TreeNode.toValueList(output4).toArray());
    }

    static class Solution {

        int sum = 0;

        public TreeNode convertBST(TreeNode root) {
            sum = 0; // 重置
            traverse(root);
            return root;
        }

        public void traverse(TreeNode root) {
            if (root == null) return;
            traverse(root.right);
            sum += root.val;
            root.val = sum;
            // System.out.printf("val: %d\n", root.val);
            traverse(root.left);
        }

    }

}
