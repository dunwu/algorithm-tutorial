package io.github.dunwu.algorithm.dp.state;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/">188. 买卖股票的最佳时机 IV</a>
 * @since 2020-07-05
 */
public class 买卖股票的最佳时机IV {

    public static void main(String[] args) {
        int[] prices = { 2, 4, 1 };
        int[] prices2 = { 3, 2, 6, 5, 0, 3 };
        Assertions.assertEquals(2, maxProfit(2, prices));
        Assertions.assertEquals(7, maxProfit(2, prices2));
    }

    public static int maxProfit(final int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        final int days = prices.length;
        if (k > days / 2) return maxProfit(prices);

        // 定义二维数组
        // 一维表示第 i 天
        // 二维表示交易笔数，最多 2 笔
        // 三维表示是否持有股票：0/1（持有）
        int[][][] dp = new int[days][k + 1][2];

        // 第一天数据初始化
        for (int j = 0; j <= k; j++) {
            dp[0][j][0] = 0;
            dp[0][j][1] = -prices[0];
        }

        for (int i = 1; i < days; i++) { // 扫描天数
            for (int j = k; j >= 1; j--) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[days - 1][k][0];
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
