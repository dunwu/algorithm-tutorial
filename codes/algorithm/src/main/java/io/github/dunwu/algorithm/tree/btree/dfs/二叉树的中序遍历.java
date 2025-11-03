package io.github.dunwu.algorithm.tree.btree.dfs;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/">94. 二叉树的中序遍历</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-06
 */
public class 二叉树的中序遍历 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new Integer[] { 1, 3, 2 },
            s.inorderTraversal(TreeNode.buildTree(1, null, 2, 3)).toArray());
        Assertions.assertArrayEquals(new Integer[] {},
            s.inorderTraversal(TreeNode.buildTree()).toArray());
        Assertions.assertArrayEquals(new Integer[] { 1 },
            s.inorderTraversal(TreeNode.buildTree(1)).toArray());
    }

    private static class Solution {

        List<Integer> values;

        public List<Integer> inorderTraversal(TreeNode root) {
            values = new ArrayList<>();
            traverse(root);
            return values;
        }

        public void traverse(TreeNode root) {
            if (root == null) return;
            // 【前序】
            // System.out.printf("[node -> left]从节点 %s 进入节点 %s\n", root, root.left);
            traverse(root.left);
            // 【中序】
            // System.out.printf("\t[left -> node]从节点 %s 回到节点 %s\n", root.left, root);
            // System.out.printf("\t[node -> right]从节点 %s 进入节点 %s\n", root, root.right);
            values.add(root.val);
            traverse(root.right);
            // 【后序】
            // System.out.printf("\t[right -> node]从节点 %s 回到节点 %s\n", root.right, root);
        }

    }

}
