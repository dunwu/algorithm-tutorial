package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/diameter-of-binary-tree/">543. 二叉树的直径</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 二叉树的直径 {

    public static void main(String[] args) {
        TreeNode tree = TreeUtils.buildTree(new Integer[] { 1, 2, 3, 4, 5 });
        Assertions.assertEquals(3, diameterOfBinaryTree(tree));

        TreeNode tree2 = TreeUtils.buildTree(new Integer[] { 1, 2 });
        Assertions.assertEquals(1, diameterOfBinaryTree(tree2));
    }

    static int max = Integer.MIN_VALUE;

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        traverse(root);
        return max;
    }

    public static void traverse(TreeNode root) {
        if (root == null) return;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        max = Math.max(max, left + right);
        traverse(root.left);
        traverse(root.right);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

}
