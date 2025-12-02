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

        // 备忘录
        int[][] memo;

        int numTrees(int n) {
            // 备忘录的值初始化为 0
            memo = new int[n + 1][n + 1];
            return count(1, n);
        }

        // 定义：返回 [begin, end] 范围内构造的不同 BST 的数量
        int count(int begin, int end) {
            if (begin >= end) return 1;
            // 查备忘录
            if (memo[begin][end] != 0) {
                return memo[begin][end];
            }

            int res = 0;
            for (int mid = begin; mid <= end; mid++) {
                int left = count(begin, mid - 1);
                int right = count(mid + 1, end);
                res += left * right;
            }
            // 将结果存入备忘录
            memo[begin][end] = res;

            return res;
        }

    }

}
