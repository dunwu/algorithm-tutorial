package io.github.dunwu.algorithm.tree.btree.dfs;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-postorder-traversal/">145. 二叉树的后序遍历</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-06
 */
public class 二叉树的后序遍历 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new Integer[] { 3, 2, 1 },
            s.postorderTraversal(TreeNode.buildTree(1, null, 2, 3)).toArray());
        Assertions.assertArrayEquals(new Integer[] {},
            s.postorderTraversal(TreeNode.buildTree()).toArray());
        Assertions.assertArrayEquals(new Integer[] { 1 },
            s.postorderTraversal(TreeNode.buildTree(1)).toArray());
        Assertions.assertArrayEquals(new Integer[] { 4, 6, 7, 5, 2, 9, 8, 3, 1 },
            s.postorderTraversal(TreeNode.buildTree(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9)).toArray());
    }

    private static class Solution {

        List<Integer> values = null;

        public List<Integer> postorderTraversal(TreeNode root) {
            values = new ArrayList<>();
            traverse(root);
            return values;
        }

        public void traverse(TreeNode root) {
            if (root == null) return;
            // 【前序】
            System.out.printf("[node -> left]从节点 %s 进入节点 %s\n", root, root.left);
            traverse(root.left);
            // 【中序】
            System.out.printf("\t[left -> node]从节点 %s 回到节点 %s\n", root.left, root);
            System.out.printf("\t[node -> right]从节点 %s 进入节点 %s\n", root, root.right);
            traverse(root.right);
            // 【后序】
            System.out.printf("\t[right -> node]从节点 %s 回到节点 %s\n", root.right, root);
            values.add(root.val);
        }

    }

}
