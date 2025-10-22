package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/invert-binary-tree/">226. 翻转二叉树</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 翻转二叉树 {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.buildTree(4, 2, 7, 1, 3, 6, 9);
        System.out.println("result = " + invertTree2(tree));
    }

    /**
     * 分解递归
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

    /**
     * 遍历递归
     */
    public static TreeNode invertTree2(TreeNode root) {
        traverse(root);
        return root;
    }

    public static void traverse(TreeNode root) {
        if (root == null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        traverse(root.left);
        traverse(root.right);
    }

}
