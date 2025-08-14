package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/">114. 二叉树展开为链表</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 二叉树展开为链表 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(1, 2, 5, 3, 4, null, 6);
        flatten(root);
        System.out.println("args = " + Arrays.toString(args));
    }

    public static void flatten(TreeNode root) {
        traverse(root);
    }

    static void traverse(TreeNode root) {
        if (root == null) { return ; }
        traverse(root.left);
        traverse(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

}
