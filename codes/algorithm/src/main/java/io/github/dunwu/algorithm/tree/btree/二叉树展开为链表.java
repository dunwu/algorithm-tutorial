package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/">114. 二叉树展开为链表</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 二叉树展开为链表 {

    public static void main(String[] args) {

        Solution s = new Solution();

        TreeNode root = TreeNode.buildTree(1, 2, 5, 3, 4, null, 6);
        s.flatten(root);
        Assertions.assertArrayEquals(new Integer[] { 1, null, 2, null, 3, null, 4, null, 5, null, 6 },
            TreeNode.toValueList(root).toArray());

        TreeNode root2 = TreeNode.buildTree(0);
        s.flatten(root2);
        Assertions.assertArrayEquals(new Integer[] { 0 }, TreeNode.toValueList(root2).toArray());

        TreeNode root3 = TreeNode.buildTree();
        s.flatten(root3);
        Assertions.assertArrayEquals(new Integer[] {}, TreeNode.toValueList(root3).toArray());
    }

    static class Solution {

        public void flatten(TreeNode root) {
            // base case
            if (root == null) { return; }

            // 利用定义，把左右子树拉平
            flatten(root.left);
            flatten(root.right);

            // *** 后序遍历位置 ***
            // 1、左右子树已经被拉平成一条链表
            TreeNode left = root.left;
            TreeNode right = root.right;

            // 2、将左子树作为右子树
            root.left = null;
            root.right = left;

            // 3、将原先的右子树接到当前右子树的末端
            TreeNode p = root;
            while (p.right != null) {
                p = p.right;
            }
            p.right = right;
        }

    }

}
