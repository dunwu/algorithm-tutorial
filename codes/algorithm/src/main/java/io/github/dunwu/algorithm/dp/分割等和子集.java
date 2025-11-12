package io.github.dunwu.algorithm.dp;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/partition-equal-subset-sum/">416. 分割等和子集</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-10
 */
public class 分割等和子集 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertTrue(s.canPartition(new int[] { 1, 5, 11, 5 }));
        Assertions.assertFalse(s.canPartition(new int[] { 1, 2, 3, 5 }));
    }

    static class Solution {

        public boolean canPartition(int[] wights) {

            int sum = 0;
            for (int weight : wights) {
                sum += weight;
            }

            // 和为奇数时，不可能划分成两个和相等的集合
            if (sum % 2 != 0) return false;

            // 初始化为背包问题
            int W = sum / 2;
            int N = wights.length;

            // base case
            boolean[][] dp = new boolean[N + 1][W + 1];
            for (int i = 0; i <= N; i++)
                dp[i][0] = true;

            for (int i = 1; i <= N; i++) {
                for (int w = 1; w <= W; w++) {
                    if (w - wights[i - 1] < 0) {
                        dp[i][w] = dp[i - 1][w];
                    } else {
                        dp[i][w] = dp[i - 1][w]
                            || dp[i - 1][w - wights[i - 1]];
                    }
                }
            }
            return dp[N][W];
        }

    }

}
