package io.github.dunwu.algorithm.dp.state;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/">121. 买卖股票的最佳时机</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-05
 */
public class 买卖股票的最佳时机 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(5, s.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
        Assertions.assertEquals(0, s.maxProfit(new int[] { 7, 6, 4, 3, 1 }));
    }

    static class Solution {

        public int maxProfit(int[] prices) {
            int min = prices[0];
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] <= min) {
                    min = prices[i];
                } else {
                    max = Math.max(max, prices[i] - min);
                }
            }
            return max;
        }

    }

}
