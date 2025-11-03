package io.github.dunwu.algorithm.tree.btree.dfs;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/">144. 二叉树的前序遍历</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 二叉树的前序遍历 {

    public static void main(String[] args) {

        Solution s1 = new Solution();
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 3 },
            s1.preorderTraversal(TreeNode.buildTree(1, null, 2, 3)).toArray());
        Assertions.assertArrayEquals(new Integer[] {},
            s1.preorderTraversal(TreeNode.buildTree()).toArray());
        Assertions.assertArrayEquals(new Integer[] { 1 },
            s1.preorderTraversal(TreeNode.buildTree(1)).toArray(new Integer[0]));

        Solution2 s2 = new Solution2();
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 3 },
            s2.preorderTraversal(TreeNode.buildTree(1, null, 2, 3)).toArray());
        Assertions.assertArrayEquals(new Integer[] {},
            s2.preorderTraversal(TreeNode.buildTree()).toArray());
        Assertions.assertArrayEquals(new Integer[] { 1 },
            s2.preorderTraversal(TreeNode.buildTree(1)).toArray(new Integer[0]));
    }

    /**
     * 【分解】思路解法
     */
    private static class Solution {

        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            // 前序遍历的结果，root.val 在第一个
            res.add(root.val);
            // 利用函数定义，后面接着左子树的前序遍历结果
            res.addAll(preorderTraversal(root.left));
            // 利用函数定义，最后接着右子树的前序遍历结果
            res.addAll(preorderTraversal(root.right));
            return res;
        }

    }

    /**
     * 【遍历】思路解法
     */
    private static class Solution2 {

        List<Integer> res;

        public List<Integer> preorderTraversal(TreeNode root) {
            res = new ArrayList<>();
            traverse(root);
            return res;
        }

        public void traverse(TreeNode root) {
            if (root == null) { return; }
            res.add(root.val);
            traverse(root.left);
            traverse(root.right);
        }

    }

}
