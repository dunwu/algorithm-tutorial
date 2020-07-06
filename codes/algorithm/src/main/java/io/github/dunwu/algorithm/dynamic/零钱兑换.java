package io.github.dunwu.algorithm.dynamic;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/coin-change/">322. 零钱兑换</a>
 * @since 2020-07-06
 */
public class 零钱兑换 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 5 };
        Assertions.assertEquals(3, coinChange(nums, 11));
        Assertions.assertEquals(-1, coinChange(new int[] { 2 }, 3));
    }


    public static int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, 0);
    }

    public static int coinChange(int[] coins, int amount, int idxCoin) {
        if (amount == 0) { return 0; }
        if (idxCoin < coins.length && amount > 0) {
            int maxVal = amount / coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            for (int x = 0; x <= maxVal; x++) {
                if (amount >= x * coins[idxCoin]) {
                    int res = coinChange(coins, amount - x * coins[idxCoin], idxCoin + 1);
                    if (res != -1) { minCost = Math.min(minCost, res + x); }
                }
            }
            return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
        }
        return -1;
    }

}
