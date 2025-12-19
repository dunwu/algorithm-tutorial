package io.github.dunwu.algorithm.dp.array;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/count-ways-to-build-good-strings/">2466. 统计构造好字符串的方案数</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-11-17
 */
public class 统计构造好字符串的方案数 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(8, s.countGoodStrings(3, 3, 1, 1));
        Assertions.assertEquals(5, s.countGoodStrings(2, 3, 1, 2));
    }

    static class Solution {

        public int countGoodStrings(int low, int high, int zero, int one) {
            final int MOD = 1_000_000_007;
            int res = 0;
            // dp[i] 表示构造长为 i 的字符串的方案数
            int[] dp = new int[high + 1];
            // 构造空串的方案数为 1
            dp[0] = 1;
            for (int i = 1; i <= high; i++) {
                if (i >= zero) dp[i] = dp[i - zero];
                if (i >= one) dp[i] = (dp[i] + dp[i - one]) % MOD;
                if (i >= low) res = (res + dp[i]) % MOD;
            }
            return res;
        }

    }

}
