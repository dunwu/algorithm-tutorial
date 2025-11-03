package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/">104. 二叉树的最大深度</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 二叉树的最大深度 {

    public static void main(String[] args) {

        Solution s = new Solution();
        Assertions.assertEquals(3, s.maxDepth(TreeNode.buildTree(3, 9, 20, null, null, 15, 7)));
        Assertions.assertEquals(2, s.maxDepth(TreeNode.buildTree(1, null, 2)));

        Solution2 s2 = new Solution2();
        Assertions.assertEquals(3, s2.maxDepth(TreeNode.buildTree(3, 9, 20, null, null, 15, 7)));
        Assertions.assertEquals(2, s2.maxDepth(TreeNode.buildTree(1, null, 2)));
    }

    /**
     * 【分解】思路解法
     */
    static class Solution {

        public int maxDepth(TreeNode root) {
            if (root == null) { return 0; }

            // 计算左右子树的最大深度
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);

            // 根据左右子树的最大深度推出原二叉树的最大深度
            // 整棵树的最大深度等于左右子树的最大深度取最大值，
            // 然后再加上根节点自己
            return Math.max(left, right) + 1;
        }

    }

    /**
     * 【遍历】思路解法
     */
    static class Solution2 {

        // 记录最大深度
        int res = 0;
        // 记录遍历到的节点的深度
        int depth = 0;

        public int maxDepth(TreeNode root) {
            // 重置全局变量
            res = 0;
            depth = 0;
            traverse(root);
            return res;
        }

        // 遍历二叉树
        void traverse(TreeNode root) {
            if (root == null) { return; }

            // 【前序遍历位置】（进入节点）增加深度
            depth++;
            // 遍历到叶子节点时记录最大深度
            if (root.left == null && root.right == null) {
                res = Math.max(res, depth);
            }
            traverse(root.left);
            // 【中序遍历位置】
            traverse(root.right);
            // 【后序遍历位置】（离开节点）减少深度
            depth--;
        }

    }

}
