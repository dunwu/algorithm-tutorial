package io.github.dunwu.algorithm.tree.btree.dfs;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-pruning/">814. 二叉树剪枝</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-10-30
 */
public class 二叉树剪枝 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(TreeNode.buildTree(1, null, 0, null, 1),
            s.pruneTree(TreeNode.buildTree(1, null, 0, 0, 1)));
        Assertions.assertEquals(TreeNode.buildTree(1, null, 1, null, 1),
            s.pruneTree(TreeNode.buildTree(1, 0, 1, 0, 0, 0, 1)));
        Assertions.assertEquals(TreeNode.buildTree(1, 1, 0, 1, 1, null, 1),
            s.pruneTree(TreeNode.buildTree(1, 1, 0, 1, 1, 0, 1, 0)));
    }

    static class Solution {

        public TreeNode pruneTree(TreeNode root) {
            if (root == null) { return null; }

            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);

            if (root.left == null && root.right == null && root.val == 0) {
                return null;
            }
            return root;
        }

    }

}
