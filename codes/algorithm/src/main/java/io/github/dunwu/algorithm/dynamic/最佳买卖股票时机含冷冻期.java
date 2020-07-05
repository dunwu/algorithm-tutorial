package io.github.dunwu.algorithm.dynamic;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/">309. 最佳买卖股票时机含冷冻期</a>
 * @since 2020-07-05
 */
public class 最佳买卖股票时机含冷冻期 {

    public static void main(String[] args) {
        int[] prices = { 1, 2, 3, 0, 2 };
        Assertions.assertEquals(3, maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int max = 0;
        final int days = prices.length;
        final int[][][] dp = new int[days][2][2];

        dp[0][0][0] = 0;
        dp[0][0][1] = 0;
        dp[0][1][0] = -prices[0];

        for (int i = 1; i < days; i++) {
            dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1]);
            dp[i][0][1] = dp[i - 1][1][0] + prices[i];
            dp[i][1][0] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][1][0]);

            int temp1 = Math.max(dp[i][0][0], dp[i][0][1]);
            int temp2 = Math.max(dp[i][1][0], temp1);
            max = Math.max(max, temp2);
        }
        return max;
    }

}
