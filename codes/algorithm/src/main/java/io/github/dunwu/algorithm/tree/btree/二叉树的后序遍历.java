package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-postorder-traversal/">145. 二叉树的后序遍历</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-06
 */
public class 二叉树的后序遍历 {

    public static void main(String[] args) {
        Solution s1 = new Solution();
        TreeNode root = TreeNode.buildTree(1, null, 2, 3);
        Assertions.assertArrayEquals(new Integer[] { 3, 2, 1 }, s1.postorderTraversal(root).toArray(new Integer[0]));

        Solution s2 = new Solution();
        TreeNode root2 = TreeNode.buildTree();
        Assertions.assertArrayEquals(new Integer[] {}, s2.postorderTraversal(root2).toArray(new Integer[0]));

        Solution s3 = new Solution();
        TreeNode root3 = TreeNode.buildTree(1);
        Assertions.assertArrayEquals(new Integer[] { 1 }, s3.postorderTraversal(root3).toArray(new Integer[0]));

        Solution s4 = new Solution();
        TreeNode root4 = TreeNode.buildTree(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9);
        Assertions.assertArrayEquals(new Integer[] { 4, 6, 7, 5, 2, 9, 8, 3, 1 },
            s4.postorderTraversal(root4).toArray(new Integer[0]));
    }

    private static class Solution {

        List<Integer> values = new ArrayList<>();

        public List<Integer> postorderTraversal(TreeNode root) {
            traverse(root);
            return values;
        }

        public void traverse(TreeNode root) {
            if (root == null) return;
            traverse(root.left);
            traverse(root.right);
            values.add(root.val);
        }

    }

}
