package io.github.dunwu.algorithm.dp.matrix;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/longest-increasing-subsequence/">300. 最长递增子序列</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-10
 */
public class 下降路径最小和 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(13, s.minFallingPathSum(new int[][] { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } }));
    }

    static class Solution {

        int N = 0;
        int[][] matrix = null;
        int[][] memo = null;

        public int minFallingPathSum(int[][] matrix) {
            this.matrix = matrix;
            this.N = matrix.length;
            int res = Integer.MAX_VALUE;
            memo = new int[N + 1][N + 1];
            for (int i = 0; i <= N; i++) {
                Arrays.fill(memo[i], Integer.MAX_VALUE);
            }
            for (int y = 0; y < N; y++) {
                res = Math.min(res, dp(N - 1, y));
            }
            return res;
        }

        public int dp(int x, int y) {
            if (y < 0 || y >= N) { return Integer.MAX_VALUE; }
            if (x == 0) { return matrix[0][y]; }
            if (memo[x][y] != Integer.MAX_VALUE) { return memo[x][y]; }
            memo[x][y] = matrix[x][y] + min(dp(x - 1, y - 1), dp(x - 1, y), dp(x - 1, y + 1));
            return memo[x][y];
        }

        int min(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }

    }

}
