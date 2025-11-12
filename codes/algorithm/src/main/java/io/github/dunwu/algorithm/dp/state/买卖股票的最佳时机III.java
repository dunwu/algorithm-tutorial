package io.github.dunwu.algorithm.dp.state;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/">123. 买卖股票的最佳时机 III</a>
 * @since 2020-07-05
 */
public class 买卖股票的最佳时机III {

    public static void main(String[] args) {
        int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
        int[] prices2 = { 1, 2, 3, 4, 5 };
        Assertions.assertEquals(6, maxProfit(prices));
        Assertions.assertEquals(4, maxProfit(prices2));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        final int days = prices.length;
        final int deal = 2; // 交易笔数

        // 定义二维数组
        // 一维表示第 i 天
        // 二维表示交易笔数，最多 2 笔
        // 三维表示是否持有股票：0/1（持有）
        int[][][] dp = new int[days][deal + 1][2];

        // 第一天数据初始化
        for (int k = 0; k <= deal; k++) {
            dp[0][k][0] = 0;
            dp[0][k][1] = -prices[0];
        }

        for (int i = 1; i < days; i++) { // 扫描天数
            for (int k = deal; k >= 1; k--) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }

        return dp[days - 1][deal][0];
    }

}
