package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/">114. 二叉树展开为链表</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 二叉树展开为链表 {

    public static void main(String[] args) {

        Solution s = new Solution();

        TreeNode root = TreeUtils.buildTree(1, 2, 5, 3, 4, null, 6);
        s.flatten(root);
        List<Integer> list = TreeUtils.toValueList(root);
        Assertions.assertArrayEquals(new Integer[] { 1, null, 2, null, 3, null, 4, null, 5, null, 6 },
            list.toArray(new Integer[0]));

        TreeNode root2 = TreeUtils.buildTree(0);
        s.flatten(root2);
        List<Integer> list2 = TreeUtils.toValueList(root2);
        Assertions.assertArrayEquals(new Integer[] { 0 },
            list2.toArray(new Integer[0]));

        TreeNode root3 = TreeUtils.buildTree();
        s.flatten(root3);
        List<Integer> list3 = TreeUtils.toValueList(root3);
        Assertions.assertArrayEquals(new Integer[] {},
            list3.toArray(new Integer[0]));
    }

    static class Solution {

        public void flatten(TreeNode root) {
            traverse(root);
        }

        void traverse(TreeNode root) {
            if (root == null) { return; }
            traverse(root.left);
            traverse(root.right);
            if (root.left == null) { return; }
            TreeNode right = root.right;
            root.right = root.left;
            TreeNode p = root.left;
            while (p.right != null) {
                p = p.right;
            }
            p.right = right;
            root.left = null;
        }

    }

}
