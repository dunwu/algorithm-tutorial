package io.github.dunwu.algorithm.tree.bstree;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/unique-binary-search-trees/">96. 不同的二叉搜索树</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-22
 */
public class 不同的二叉搜索树 {

    public static void main(String[] args) {

        Solution s = new Solution();

        Assertions.assertEquals(5, s.numTrees(3));
        Assertions.assertEquals(1, s.numTrees(1));
    }

    static class Solution {

        public int numTrees(int n) {
            int[][] memo = new int[n + 1][n + 1];
            return recursion(1, n, memo);
        }

        public int recursion(int begin, int end, int[][] memo) {
            if (begin > end) { return 1; }

            if (memo[begin][end] != 0) { return memo[begin][end]; }

            int res = 0;
            for (int i = begin; i <= end; i++) {
                int left = recursion(begin, i - 1, memo);
                int right = recursion(i + 1, end, memo);
                res += left * right;
            }
            memo[begin][end] = res;
            return res;
        }

    }

}
