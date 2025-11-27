package io.github.dunwu.algorithm.dp;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/coin-change-ii/">518. 零钱兑换 II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-11
 */
public class 零钱兑换2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(4, s.change(5, new int[] { 1, 2, 5 }));
        Assertions.assertEquals(0, s.change(3, new int[] { 2 }));
        Assertions.assertEquals(1, s.change(10, new int[] { 10 }));
    }

    static class Solution {

        public int change(int amount, int[] coins) {
            int n = coins.length;
            int[][] dp = new int[n + 1][amount + 1];
            // base case
            for (int i = 0; i <= n; i++)
                dp[i][0] = 1;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= amount; j++)
                    if (j - coins[i - 1] >= 0) {
                        dp[i][j] = dp[i - 1][j]
                            + dp[i][j - coins[i - 1]];
                    } else { dp[i][j] = dp[i - 1][j]; }
            }
            return dp[n][amount];
        }

    }

}
