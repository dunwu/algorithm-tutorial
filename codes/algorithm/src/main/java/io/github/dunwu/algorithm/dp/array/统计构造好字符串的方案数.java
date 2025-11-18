package io.github.dunwu.algorithm.dp.array;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

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

        int[] memo = null;
        private static final int MOD = 1_000_000_007;

        public int countGoodStrings(int low, int high, int zero, int one) {
            memo = new int[high + 1];
            Arrays.fill(memo, -1);
            int res = 0;
            for (int i = low; i <= high; i++) {
                res = (res + dp(i, zero, one)) % MOD;
            }
            return res;
        }

        public int dp(int i, int zero, int one) {
            if (i < 0) { return 0; }
            if (i == 0) { return 1; }
            if (memo[i] != -1) { return memo[i]; }
            memo[i] = (dp(i - zero, zero, one) + dp(i - one, zero, one)) % MOD;
            return memo[i];
        }

    }

}
