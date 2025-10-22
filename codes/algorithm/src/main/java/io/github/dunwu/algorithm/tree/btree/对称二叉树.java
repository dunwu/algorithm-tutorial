package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;

/**
 * <code>101. 对称二叉树</code> 算法实现
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <pre>
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * </pre>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <pre>
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * </pre>
 * 说明：如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 * @see <a href="https://leetcode-cn.com/problems/symmetric-tree/">101. 对称二叉树</a>
 */
public class 对称二叉树 {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.buildTree(1, 2, 2, 3, 4, 4, 3);
        System.out.println("result = " + isSymmetric(tree));

        tree = TreeNode.buildTree(1, 2, 2, null, 3, null, 3);
        System.out.println("result = " + isSymmetric(tree));
    }

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) return true;
        if (tree1 == null || tree2 == null) return false;
        if (tree1.val != tree2.val) return false;
        return isMirror(tree1.left, tree2.right) && isMirror(tree1.right, tree2.left);
    }

}
