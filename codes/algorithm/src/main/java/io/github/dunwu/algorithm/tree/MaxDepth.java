package io.github.dunwu.algorithm.tree;

/**
 * <code>104. 二叉树的最大深度</code> 算法实现
 *
 * @see <a href="https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/">104. 二叉树的最大深度</a>
 */
public class MaxDepth {

    public static void main(String[] args) {
        MaxDepth demo = new MaxDepth();
        TreeNode tree = TreeUtils.buildTree(3, 9, 20, null, null, 15, 7);
        System.out.println("result = " + demo.maxDepth(tree));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);

        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

}
