package io.github.dunwu.algorithm.dp.array;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/ugly-number-ii/">264. 丑数II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-24
 */
public class 丑数2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(12, s.nthUglyNumber(10));
        Assertions.assertEquals(1, s.nthUglyNumber(1));
        Assertions.assertEquals(15, s.nthUglyNumber(11));
    }

    static class Solution {

        public int nthUglyNumber(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            int p2 = 1, p3 = 1, p5 = 1;
            for (int index = 2; index <= n; index++) {
                int n2 = dp[p2] * 2, n3 = dp[p3] * 3, n5 = dp[p5] * 5;
                dp[index] = min(n2, n3, n5);
                if (dp[index] == n2) { p2++; }
                if (dp[index] == n3) { p3++; }
                if (dp[index] == n5) { p5++; }
            }
            return dp[n];
        }

        public int min(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }

    }

}
