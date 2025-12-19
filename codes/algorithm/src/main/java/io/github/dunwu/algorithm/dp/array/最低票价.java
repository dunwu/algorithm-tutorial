package io.github.dunwu.algorithm.dp.array;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/minimum-cost-for-tickets/">983. 最低票价</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-11-17
 */
public class 最低票价 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(11, s.mincostTickets(new int[] { 1, 4, 6, 7, 8, 20 }, new int[] { 2, 7, 15 }));
        Assertions.assertEquals(17,
            s.mincostTickets(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 }, new int[] { 2, 7, 15 }));
    }

    // 动态规划
    static class Solution {

        public int mincostTickets(int[] days, int[] costs) {
            int n = days.length;
            int lastDay = days[n - 1];
            boolean[] isTravel = new boolean[lastDay + 1];
            for (int d : days) { isTravel[d] = true; }

            // dp[i] 表示 1 到 i 天的最小花费
            int[] dp = new int[lastDay + 1];
            dp[0] = 0;
            for (int i = 1; i <= lastDay; i++) {
                if (!isTravel[i]) {
                    // 如果第 i 天不在 days 中，则第 i 天和第 i - 1 天花费相同
                    dp[i] = dp[i - 1];
                } else {
                    // 如果第 i 天在 days 中
                    // 则求三种不同方案最小值：
                    dp[i] = min(
                        // 在第 i 天购买为期 1 天的通行证的最小花费
                        costs[0] + dp[i - 1],
                        // 在第 i - 7 天购买为期 7 天的通行证的最小花费（如果 i - 7 < 0，视为 0，f[0] 花费为 0）
                        costs[1] + dp[Math.max(0, i - 7)],
                        // 在第 i - 30 天购买为期 30 天的通行证的最小花费（如果 i - 30 < 0，视为 0，f[0] 花费为 0）
                        costs[2] + dp[Math.max(0, i - 30)]
                    );
                }
            }
            return dp[lastDay];
        }

        public int min(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }

    }

}
