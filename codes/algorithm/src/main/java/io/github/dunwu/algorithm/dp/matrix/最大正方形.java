package io.github.dunwu.algorithm.dp.matrix;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/longest-increasing-subsequence/">300. 最长递增子序列</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-10
 */
public class 最大正方形 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(4, s.maximalSquare(new char[][] {
            { '1', '0', '1', '0', '0' },
            { '1', '0', '1', '1', '1' },
            { '1', '1', '1', '1', '1' },
            { '1', '0', '0', '1', '0' }
        }));
    }

    static class Solution {

        public int maximalSquare(char[][] matrix) {

            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }

            int m = matrix.length, n = matrix[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = matrix[0][0] == '1' ? 1 : 0;
            int max = dp[0][0];
            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    if (matrix[i][j] == '0') {
                        dp[i][j] = 0;
                        continue;
                    }
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
            return max * max;
        }

        public int min(int a, int b, int c) {
            return Math.min(Math.min(a, b), c);
        }

    }

}
