package io.github.dunwu.algorithm.tree.btree.divide;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/flip-equivalent-binary-trees/">951. 翻转等价二叉树</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-29
 */
public class 翻转等价二叉树 {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode p = TreeNode.buildTree(1, 2, 3, 4, 5, 6, null, null, null, 7, 8);
        TreeNode q = TreeNode.buildTree(1, 3, 2, null, 6, 4, 5, null, null, null, null, 8, 7);
        Assertions.assertTrue(s.flipEquiv(p, q));
        Assertions.assertTrue(s.flipEquiv(TreeNode.buildTree(), TreeNode.buildTree()));
        Assertions.assertFalse(s.flipEquiv(TreeNode.buildTree(), TreeNode.buildTree(1)));
    }

    static class Solution {

        // 定义：输入两棵二叉树，判断这两棵二叉树是否是翻转等价的
        public boolean flipEquiv(TreeNode root1, TreeNode root2) {
            // 判断 root1 和 root2 两个节点是否能够匹配
            if (root1 == null && root2 == null) { return true; }
            if (root1 == null || root2 == null) { return false; }
            if (root1.val != root2.val) { return false; }
            // 根据函数定义，判断子树是否能够匹配
            // 不翻转、翻转两种情况满足一种即可算是匹配
            return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) // 不翻转子树
                || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)); // 翻转子树
        }

    }

}
