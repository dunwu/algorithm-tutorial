package io.github.dunwu.algorithm.stack.monotonic;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/">1475. 商品折扣后的最终价格</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-26
 */
public class 商品折扣后的最终价格 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new int[] { 4, 2, 4, 2, 3 }, s.finalPrices(new int[] { 8, 4, 6, 2, 3 }));
        Assertions.assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, s.finalPrices(new int[] { 1, 2, 3, 4, 5 }));
        Assertions.assertArrayEquals(new int[] { 9, 0, 1, 6 }, s.finalPrices(new int[] { 10, 1, 1, 6 }));
    }

    static class Solution {

        public int[] finalPrices(int[] prices) {
            int[] res = new int[prices.length];
            Stack<Integer> stack = new Stack<>();
            for (int i = prices.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && stack.peek() > prices[i]) {
                    stack.pop();
                }
                res[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
                stack.push(prices[i]);
            }
            return res;
        }

    }

}
