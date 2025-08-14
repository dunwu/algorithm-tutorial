package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

/**
 * <code>路径总和</code> 算法实现
 *
 * <pre>
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * </pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/path-sum/">112. 路径总和</a>
 */
public class 路径总和 {

    public static void main(String[] args) {
        TreeNode
            tree = TreeUtils.buildTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1);
        Assertions.assertTrue(hasPathSum(tree, 22));
        TreeNode tree2 = TreeUtils.buildTree(1, 2);
        Assertions.assertFalse(hasPathSum(tree2, 1));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) { return false; }
        sum -= root.val;
        if (root.left == null && root.right == null) { return sum == 0; }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

}
