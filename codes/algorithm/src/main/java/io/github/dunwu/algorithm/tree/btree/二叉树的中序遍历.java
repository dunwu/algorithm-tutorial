package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/">94. 二叉树的中序遍历</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-06
 */
public class 二叉树的中序遍历 {

    public static void main(String[] args) {
        Solution s1 = new Solution();
        TreeNode root = TreeUtils.buildTree(1, null, 2, 3);
        Assertions.assertArrayEquals(new Integer[] { 1, 3, 2 }, s1.inorderTraversal(root).toArray(new Integer[0]));

        Solution s2 = new Solution();
        TreeNode root2 = TreeUtils.buildTree();
        Assertions.assertArrayEquals(new Integer[] {}, s2.inorderTraversal(root2).toArray(new Integer[0]));

        Solution s3 = new Solution();
        TreeNode root3 = TreeUtils.buildTree(1);
        Assertions.assertArrayEquals(new Integer[] { 1 }, s3.inorderTraversal(root3).toArray(new Integer[0]));
    }

    private static class Solution {

        List<Integer> values = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            traverse(root);
            return values;
        }

        public void traverse(TreeNode root) {
            if (root == null) return;
            traverse(root.left);
            values.add(root.val);
            traverse(root.right);
        }

    }

}
