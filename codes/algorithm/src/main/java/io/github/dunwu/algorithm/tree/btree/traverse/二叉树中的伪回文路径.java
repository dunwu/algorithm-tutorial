package io.github.dunwu.algorithm.tree.btree.traverse;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/pseudo-palindromic-paths-in-a-binary-tree/">1457. 二叉树中的伪回文路径</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-15
 */
public class 二叉树中的伪回文路径 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(2,
            s.pseudoPalindromicPaths(TreeNode.buildTree(2, 3, 1, 3, 1, null, 1)));
        Assertions.assertEquals(1,
            s.pseudoPalindromicPaths(TreeNode.buildTree(2, 1, 1, 1, 3, null, null, null, null, null, 1)));
        Assertions.assertEquals(1,
            s.pseudoPalindromicPaths(TreeNode.buildTree(9)));
    }

    static class Solution {

        int res = 0;
        // 计数数组，题目说了 1 <= root.val <= 9
        int[] count;

        public int pseudoPalindromicPaths(TreeNode root) {
            res = 0;
            count = new int[10];
            traverse(root);
            return res;
        }

        public void traverse(TreeNode root) {
            if (root == null) { return; }

            // 选择
            if (root.left == null && root.right == null) {
                count[root.val]++;
                int odd = 0;
                for (int cnt : count) {
                    if (cnt % 2 != 0) {
                        odd++;
                    }
                }
                if (odd <= 1) {
                    res++;
                }
                count[root.val]--;
                return;
            }

            // 选择
            count[root.val]++;

            traverse(root.left);
            traverse(root.right);

            // 取消选择
            count[root.val]--;
        }

    }

}
