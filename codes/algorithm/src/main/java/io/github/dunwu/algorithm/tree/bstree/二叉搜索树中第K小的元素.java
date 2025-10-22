package io.github.dunwu.algorithm.tree.bstree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/validate-binary-search-tree/">98. 验证二叉搜索树</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-22
 */
public class 二叉搜索树中第K小的元素 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(1, s.kthSmallest(TreeNode.buildTree(3, 1, 4, null, 2), 1));
        Assertions.assertEquals(3, s.kthSmallest(TreeNode.buildTree(5, 3, 6, 2, 4, null, null, 1), 3));
    }

    static class Solution {

        int res = 0;
        int rank = 0;

        public int kthSmallest(TreeNode root, int k) {
            if (root == null) { return -1; }
            rank = 0;
            res = 0;
            traverse(root, k);
            return res;
        }

        void traverse(TreeNode root, int k) {
            if (root == null) { return; }
            traverse(root.left, k);
            rank++;
            if (rank == k) {
                System.out.printf("val: %s, rank: %d\n", root.val, rank);
                res = root.val;
                return;
            }
            traverse(root.right, k);
        }

    }

}
