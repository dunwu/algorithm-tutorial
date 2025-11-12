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
    }

    static class Solution {

        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            int dp_i_1 = 0, dp_i_2 = 0, dp_i = 0;
            for (int i = 2; i <= n; i++) {
                dp_i = Math.min(
                    dp_i_1 + cost[i - 1],
                    dp_i_2 + cost[i - 2]
                );
                dp_i_2 = dp_i_1;
                dp_i_1 = dp_i;
            }
            return dp_i;
        }

    }

}
