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
            if (root.val < val) {
                // 如果 val 是整棵树最大的，那么原来的这棵树应该是 val 节点的左子树，
                // 因为 val 节点是接在原始数组 a 的最后一个元素
                TreeNode node = new TreeNode(val);
                node.left = root;
                return node;
            } else {
                // 如果 val 不是最大的，那么就应该在右子树上，
                // 因为 val 节点是接在原始数组 a 的最后一个元素
                root.right = insertIntoMaxTree(root.right, val);
                return root;
            }
        }

    }

}
