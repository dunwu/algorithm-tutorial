package io.github.dunwu.algorithm.tree.btree.dfs;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-pruning/">814. 二叉树剪枝</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-10-30
 */
public class 删除给定值的叶子节点 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(TreeNode.buildTree(1, null, 3, null, 4),
            s.removeLeafNodes(TreeNode.buildTree(1, 2, 3, 2, null, 2, 4), 2));
        Assertions.assertEquals(TreeNode.buildTree(1, 3, null, null, 2),
            s.removeLeafNodes(TreeNode.buildTree(1, 3, 3, 3, 2), 3));
        Assertions.assertEquals(TreeNode.buildTree(1),
            s.removeLeafNodes(TreeNode.buildTree(1, 2, null, 2, null, 2), 2));
    }

    static class Solution {

        public TreeNode removeLeafNodes(TreeNode root, int target) {
            if (root == null) { return null; }
            root.left = removeLeafNodes(root.left, target);
            root.right = removeLeafNodes(root.right, target);
            if (root.left == null && root.right == null && root.val == target) {
                return null;
            }
            return root;
        }

    }

}
