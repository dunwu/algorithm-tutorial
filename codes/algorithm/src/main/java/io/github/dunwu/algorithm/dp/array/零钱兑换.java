package io.github.dunwu.algorithm.dp.array;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/coin-change/">322. 零钱兑换</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-11-17
 */
public class 零钱兑换 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(3, s.coinChange(new int[] { 1, 2, 5 }, 11));
        Assertions.assertEquals(-1, s.coinChange(new int[] { 2 }, 3));
        Assertions.assertEquals(0, s.coinChange(new int[] { 1 }, 0));
    }

    static class Solution {

        public int coinChange(int[] coins, int amount) {
            if (coins == null || coins.length == 0) { return 0; }
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (i - coin >= 0) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            return (dp[amount] > amount) ? -1 : dp[amount];
        }

    }

}
