package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;

/**
 * <code>翻转二叉树</code> 算法实现
 *
 * <pre>
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 * </pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/invert-binary-tree/">翻转二叉树</a>
 */
public class 翻转二叉树 {

    public static void main(String[] args) {
        TreeNode tree = TreeUtils.asTree(4, 2, 7, 1, 3, 6, 9);
        System.out.println("result = " + invertTree(tree));
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) { return null; }

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        root.left = right;
        root.right = left;
        return root;
    }

}
