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

        // 主函数
        public int numTrees(int n) {
            // 备忘录的值初始化
            memo = new int[n + 1][n + 1];
            // 计算闭区间 [1, n] 组成的 BST 个数
            return count(1, n);
        }

        // 计算闭区间 [lo, hi] 组成的 BST 个数
        int count(int low, int high) {
            // base case
            if (low > high) { return 1; }
            if (memo[low][high] != 0) { return memo[low][high]; }

            int res = 0;
            for (int i = low; i <= high; i++) {
                // i 的值作为根节点 root
                int left = count(low, i - 1);
                int right = count(i + 1, high);
                // 左右子树的组合数乘积是 BST 的总数
                res += left * right;
            }
            memo[low][high] = res;
            return res;
        }

    }

}
