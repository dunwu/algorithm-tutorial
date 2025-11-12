package io.github.dunwu.algorithm.dp.state;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/">714.
 * 买卖股票的最佳时机含手续费</a>
 * @since 2020-07-05
 */
public class 买卖股票的最佳时机含手续费 {

    public static void main(String[] args) {
        int[] prices = { 1, 3, 2, 8, 4, 9 };
        Assertions.assertEquals(8, maxProfit(prices, 2));
    }

    public static int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;

        int max = 0;
        final int days = prices.length;
        final int[][] dp = new int[days][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < days; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            max = Math.max(dp[i][0], dp[i][1]);
        }
        return max;
    }

}
