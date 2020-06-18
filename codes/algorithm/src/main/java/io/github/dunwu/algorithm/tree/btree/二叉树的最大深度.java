package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeUtils;

/**
 * <code>104. 二叉树的最大深度</code> 算法实现
 *
 * @see <a href="https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/">104. 二叉树的最大深度</a>
 */
public class 二叉树的最大深度 {

    public static void main(String[] args) {
        TreeNode tree = TreeUtils.buildTree(3, 9, 20, null, null, 15, 7);
        System.out.println("result = " + maxDepth(tree));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

}
