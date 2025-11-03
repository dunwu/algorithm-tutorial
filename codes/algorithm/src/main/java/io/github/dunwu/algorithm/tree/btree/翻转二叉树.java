package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/invert-binary-tree/">226. 翻转二叉树</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 翻转二叉树 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(TreeNode.buildTree(4, 2, 7, 1, 3, 6, 9),
            s.invertTree(TreeNode.buildTree(4, 7, 2, 9, 6, 3, 1)));
        Assertions.assertEquals(TreeNode.buildTree(2, 3, 1),
            s.invertTree(TreeNode.buildTree(2, 1, 3)));
        Assertions.assertEquals(TreeNode.buildTree(),
            s.invertTree(TreeNode.buildTree()));

        Solution2 s2 = new Solution2();
        Assertions.assertEquals(TreeNode.buildTree(4, 2, 7, 1, 3, 6, 9),
            s2.invertTree(TreeNode.buildTree(4, 7, 2, 9, 6, 3, 1)));
        Assertions.assertEquals(TreeNode.buildTree(2, 3, 1),
            s2.invertTree(TreeNode.buildTree(2, 1, 3)));
        Assertions.assertEquals(TreeNode.buildTree(),
            s2.invertTree(TreeNode.buildTree()));
    }

    /**
     * 【分解】思路解法
     */
    static class Solution {

        public TreeNode invertTree(TreeNode root) {
            if (root == null) { return root; }
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.right = left;
            root.left = right;
            return root;
        }

    }

    /**
     * 【遍历】思路解法
     */
    static class Solution2 {

        public TreeNode invertTree(TreeNode root) {
            traverse(root);
            return root;
        }

        // 遍历二叉树
        void traverse(TreeNode root) {
            if (root == null) { return; }

            // 【前序】
            // System.out.printf("[node -> left]从节点 %s 进入节点 %s\n", root, root.left);
            traverse(root.left);
            // 【中序】
            // System.out.printf("\t[left -> node]从节点 %s 回到节点 %s\n", root.left, root);
            // System.out.printf("\t[node -> right]从节点 %s 进入节点 %s\n", root, root.right);
            traverse(root.right);
            // 【后序】
            // System.out.printf("\t[right -> node]从节点 %s 回到节点 %s\n", root.right, root);

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

    }

}
