package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;

/**
 * <code>100. 相同的树</code> 算法实现
 * <p>
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 示例 1:
 * <pre>
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * </pre>
 * 示例 2:
 * <pre>
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * </pre>
 * 示例 3:
 * <pre>
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 * </pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/same-tree/">100. 相同的树</a>
 */
public class 相同的树 {

    public static void main(String[] args) {
        TreeNode tree1 = TreeNode.buildTree(1, 2, 3);
        TreeNode tree2 = TreeNode.buildTree(1, 2, 3);
        System.out.println("result = " + isSameTree(tree1, tree2));

        tree1 = TreeNode.buildTree(1, 2);
        tree2 = TreeNode.buildTree(1, 2, 3);
        System.out.println("result = " + isSameTree(tree1, tree2));

        tree1 = TreeNode.buildTree(1, 2, 1);
        tree2 = TreeNode.buildTree(1, 1, 2);
        System.out.println("result = " + isSameTree(tree1, tree2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
