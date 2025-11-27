package io.github.dunwu.algorithm.stack.monotonic;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/online-stock-span/">901. 股票价格跨度</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-26
 */
public class 股票价格跨度 {

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        Assertions.assertEquals(1, stockSpanner.next(100));
        Assertions.assertEquals(1, stockSpanner.next(80));
        Assertions.assertEquals(1, stockSpanner.next(60));
        Assertions.assertEquals(2, stockSpanner.next(70));
        Assertions.assertEquals(1, stockSpanner.next(60));
        Assertions.assertEquals(4, stockSpanner.next(75));
        Assertions.assertEquals(6, stockSpanner.next(85));
    }

    static class StockSpanner {

        private Stack<int[]> stack;

        public StockSpanner() {
            stack = new Stack<>();
        }

        public int next(int price) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                int[] prev = stack.pop();
                count += prev[1];
            }
            stack.push(new int[] { price, count });
            return count;
        }

    }

}
