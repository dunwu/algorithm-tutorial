package io.github.dunwu.algorithm.dp.state;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/">122. 买卖股票的最佳时机 II</a>
 * @since 2020-07-05
 */
public class 买卖股票的最佳时机II {

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        int[] prices2 = { 1, 2, 3, 4, 5 };
        Assertions.assertEquals(7, maxProfit(prices));
        Assertions.assertEquals(4, maxProfit(prices2));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int max = 0;
        final int days = prices.length;
        final int[][] dp = new int[days][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < days; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            max = Math.max(dp[i][0], dp[i][1]);
        }
        return max;
    }

}
