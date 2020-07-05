package io.github.dunwu.algorithm.dynamic;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/">121. 买卖股票的最佳时机</a>
 * @since 2020-07-05
 */
public class 买卖股票的最佳时机 {

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        int[] prices2 = { 7, 6, 4, 3, 1 };
        Assertions.assertEquals(5, maxProfit(prices));
        Assertions.assertEquals(0, maxProfit(prices2));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int max = 0;

        // 定义二维数组
        // 一维表示第 i 天
        // 二维表示交易状态：0 表示没有买卖；1 表示买入；2 表示卖出
        int[][] mp = new int[n][3];
        mp[0][0] = 0; // 无
        mp[0][1] = -prices[0]; // 买
        mp[0][2] = 0; // 当天买进卖出，净赚0
        for (int i = 1; i < n; i++) {
            mp[i][0] = mp[i - 1][0]; // 一直不买
            mp[i][1] = Math.max(mp[i - 1][1], mp[i - 1][0] - prices[i]); // 昨天买或今天买
            mp[i][2] = mp[i - 1][1] + prices[i]; // 昨天还有股，今天卖出
            for (int j = 0; j <= 2; j++) {
                if (max < mp[i][j]) {
                    max = mp[i][j];
                }
            }
        }
        return max;
    }

}
