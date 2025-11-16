package io.github.dunwu.algorithm.dp.fib;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/min-cost-climbing-stairs/">746. 使用最小花费爬楼梯</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-10
 */
public class 使用最小花费爬楼梯 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(15, s.minCostClimbingStairs(new int[] { 10, 15, 20 }));
        Assertions.assertEquals(6, s.minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));

        Solution2 s2 = new Solution2();
        Assertions.assertEquals(15, s2.minCostClimbingStairs(new int[] { 10, 15, 20 }));
        Assertions.assertEquals(6, s2.minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));
    }

    static class Solution {

        public int minCostClimbingStairs(int[] cost) {
            if (cost == null || cost.length == 0) { return 0; }
            int N = cost.length;
            int[] dp = new int[N + 1];
            dp[0] = dp[1] = 0;
            for (int i = 2; i <= N; i++) {
                dp[i] = Math.min(
                    dp[i - 1] + cost[i - 1],
                    dp[i - 2] + cost[i - 2]
                );
            }
            return dp[N];
        }

    }

    static class Solution2 {

        public int minCostClimbingStairs(int[] cost) {
            if (cost == null || cost.length == 0) { return 0; }
            int pre1 = 0, pre2 = 0;
            for (int i = 2; i <= cost.length; i++) {
                int tmp = Math.min(
                    pre1 + cost[i - 1],
                    pre2 + cost[i - 2]
                );
                pre2 = pre1;
                pre1 = tmp;
            }
            return pre1;
        }

    }

}
