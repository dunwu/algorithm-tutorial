package io.github.dunwu.algorithm.tree.btree.divide;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/maximum-binary-tree-ii/">998. 最大二叉树 II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-18
 */
public class 最大二叉树2 {

    public static void main(String[] args) {

        Solution s = new Solution();

        Assertions.assertEquals(TreeNode.buildTree(5, 4, null, 1, 3, null, null, 2),
            s.insertIntoMaxTree(TreeNode.buildTree(4, 1, 3, null, null, 2), 5));

        Assertions.assertEquals(TreeNode.buildTree(5, 2, 4, null, 1, null, 3),
            s.insertIntoMaxTree(TreeNode.buildTree(5, 2, 4, null, 1), 3));

        Assertions.assertEquals(TreeNode.buildTree(5, 2, 4, null, 1, 3),
            s.insertIntoMaxTree(TreeNode.buildTree(5, 2, 3, null, 1), 4));
    }

    static class Solution {

        public TreeNode insertIntoMaxTree(TreeNode root, int val) {

            if (root == null) { return new TreeNode(val); }

            if (val > root.val) {
                TreeNode temp = root;
                root = new TreeNode(val);
                root.left = temp;
            } else {
                root.right = insertIntoMaxTree(root.right, val);
            }
            return root;
        }

    }

}
