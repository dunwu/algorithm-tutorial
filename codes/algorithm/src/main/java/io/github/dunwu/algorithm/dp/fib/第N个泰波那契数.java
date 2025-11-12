package io.github.dunwu.algorithm.dp.fib;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/n-th-tribonacci-number/">1137. 第 N 个泰波那契数</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-10
 */
public class 第N个泰波那契数 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(4, s.tribonacci(4));
        Assertions.assertEquals(1389537, s.tribonacci(25));
    }

    static class Solution {

        public int tribonacci(int n) {
            if (n == 0) return 0;
            if (n == 1 || n == 2) return 1;

            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
            return dp[n];
        }

    }

}
