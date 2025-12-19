package io.github.dunwu.algorithm.dp.array;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/ugly-number-iii/">1201. 丑数 III</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-24
 */
public class 丑数3 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(4, s.nthUglyNumber(3, 2, 3, 5));
        Assertions.assertEquals(6, s.nthUglyNumber(4, 2, 3, 4));
        Assertions.assertEquals(10, s.nthUglyNumber(5, 2, 11, 13));
    }

    static class Solution {

        public int nthUglyNumber(int n, int a, int b, int c) {
            int[] dp = new int[n + 1];
            int pa = 1, pb = 1, pc = 1;
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                int na = pa * a, nb = pb * b, nc = pc * c;
                dp[i] = min(na, nb, nc);
                if (dp[i] == na) { pa++; }
                if (dp[i] == nb) { pb++; }
                if (dp[i] == nc) { pc++; }
            }
            return dp[n];
        }

        int min(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }

    }

}
