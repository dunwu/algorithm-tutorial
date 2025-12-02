package io.github.dunwu.algorithm.tree.bstree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/convert-bst-to-greater-tree/">538. 把二叉搜索树转换为累加树</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-22
 */
public class 从二叉搜索树到更大和树 {

    public static void main(String[] args) {

        Solution s = new Solution();

        TreeNode input1 = TreeNode.buildTree(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8);
        TreeNode output1 = s.bstToGst(input1);
        TreeNode expect1 = TreeNode.buildTree(30, 36, 21, 36, 35, 26, 15, null, null, null, 33, null, null, null, 8);
        Assertions.assertEquals(expect1, output1);

        Assertions.assertEquals(TreeNode.buildTree(1, null, 1), s.bstToGst(TreeNode.buildTree(0, null, 1)));
    }

    static class Solution {

        private int sum = 0;

        public TreeNode bstToGst(TreeNode root) {
            sum = 0;
            dfs(root);
            return root;
        }

        public void dfs(TreeNode root) {
            if (root == null) { return; }
            dfs(root.right);
            sum += root.val;
            root.val = sum;
            // System.out.printf("%s\n", root.val);
            dfs(root.left);
        }

    }

}
