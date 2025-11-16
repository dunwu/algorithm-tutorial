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

        // char[][] input1 = new char[][] {
        //     { '1', '0', '1', '0', '0' },
        //     { '1', '0', '1', '1', '1' },
        //     { '1', '1', '1', '1', '1' },
        //     { '1', '0', '0', '1', '0' }
        // };
        // Assertions.assertEquals(4, s.maximalSquare(input1));
        //
        // char[][] input2 = new char[][] { { '0', '1' }, { '1', '0' } };
        // Assertions.assertEquals(1, s.maximalSquare(input2));
        //
        // char[][] input3 = new char[][] { { '0' } };
        // Assertions.assertEquals(0, s.maximalSquare(input3));

        char[][] input4 = new char[][] {
            { '1', '0', '1', '1', '0', '1' },
            { '1', '1', '1', '1', '1', '1' },
            { '0', '1', '1', '0', '1', '1' },
            { '1', '1', '1', '0', '1', '0' },
            { '0', '1', '1', '1', '1', '1' },
            { '1', '1', '0', '1', '1', '1' }
        };
        Assertions.assertEquals(4, s.maximalSquare(input4));
    }

    static class Solution {

        public int maximalSquare(char[][] matrix) {

            // base case
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { return 0; }
            if (matrix.length == 1 && matrix[0][0] == '1') { return 1; }

            // 状态定义
            int m = matrix.length, n = matrix[0].length;
            int[][] dp = new int[m][n];

            // 初始化、边界状态
            dp[0][0] = matrix[0][0] == '1' ? 1 : 0;
            int max = dp[0][0];

            // 状态转移
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        if (i == 0 || j == 0) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1;
                        }
                    }
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
