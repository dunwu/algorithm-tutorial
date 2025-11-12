package io.github.dunwu.algorithm.dp.fib;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/fibonacci-number/">509. 斐波那契数</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-10
 */
public class 斐波那契数 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(1, s.fib(2));
        Assertions.assertEquals(2, s.fib(3));
        Assertions.assertEquals(3, s.fib(4));

        Solution2 s2 = new Solution2();
        Assertions.assertEquals(1, s2.fib(2));
        Assertions.assertEquals(2, s2.fib(3));
        Assertions.assertEquals(3, s2.fib(4));

        Solution2 s3 = new Solution2();
        Assertions.assertEquals(1, s3.fib(2));
        Assertions.assertEquals(2, s3.fib(3));
        Assertions.assertEquals(3, s3.fib(4));
    }

    /**
     * 使用备忘录优化动态规划问题
     */
    static class Solution {

        int fib(int n) {
            // 备忘录全初始化为 -1
            // 因为斐波那契数肯定是非负整数，所以初始化为特殊值 -1 表示未计算

            // 因为数组的索引从 0 开始，所以需要 n + 1 个空间
            // 这样才能把 `f(0) ~ f(n)` 都记录到 memo 中
            int[] memo = new int[n + 1];
            Arrays.fill(memo, -1);

            return dp(memo, n);
        }

        // 带着备忘录进行递归
        int dp(int[] memo, int n) {
            // base case
            if (n == 0 || n == 1) {
                return n;
            }
            // 已经计算过，不用再计算了
            if (memo[n] != -1) {
                return memo[n];
            }
            // 在返回结果之前，存入备忘录
            memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
            return memo[n];
        }

    }

    /**
     * DP Table 解决动态规划问题
     */
    static class Solution2 {

        int fib(int n) {
            if (n == 0 || n == 1) {
                return n;
            }

            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }

    }

    /**
     * 在 DP Table 基础上优化空间复杂度
     */
    static class Solution3 {

        int fib(int n) {
            if (n == 0 || n == 1) {
                return n;
            }

            // 分别代表 dp[i - 1] 和 dp[i - 2]
            int dp_i_1 = 1, dp_i_2 = 0;
            for (int i = 2; i <= n; i++) {
                // dp[i] = dp[i - 1] + dp[i - 2];
                int dp_i = dp_i_1 + dp_i_2;
                dp_i_2 = dp_i_1;
                dp_i_1 = dp_i;
            }
            return dp_i_1;
        }

    }

}
