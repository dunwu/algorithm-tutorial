package io.github.dunwu.algorithm.stack.monotonic;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/online-stock-span/">901. 股票价格跨度</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-26
 */
public class 股票价格跨度 {

    public static void main(String[] args) {
        StockSpanner stock = new StockSpanner();
        Assertions.assertEquals(1, stock.next(100));
        Assertions.assertEquals(1, stock.next(80));
        Assertions.assertEquals(1, stock.next(60));
        Assertions.assertEquals(2, stock.next(70));
        Assertions.assertEquals(1, stock.next(60));
        Assertions.assertEquals(4, stock.next(75));
        Assertions.assertEquals(6, stock.next(85));

        StockSpanner2 stock2 = new StockSpanner2();
        Assertions.assertEquals(1, stock2.next(100));
        Assertions.assertEquals(1, stock2.next(80));
        Assertions.assertEquals(1, stock2.next(60));
        Assertions.assertEquals(2, stock2.next(70));
        Assertions.assertEquals(1, stock2.next(60));
        Assertions.assertEquals(4, stock2.next(75));
        Assertions.assertEquals(6, stock2.next(85));
    }

    static class StockSpanner {

        private final List<Integer> l;

        public StockSpanner() {
            l = new ArrayList<>();
        }

        public int next(int price) {
            int count = 1;
            for (int i = l.size() - 1; i >= 0; i--) {
                if (l.get(i) > price) {
                    break;
                }
                count++;
            }
            l.add(price);
            return count;
        }

    }

    static class StockSpanner2 {

        // int[] 记录 {价格，小于等于该价格的天数} 二元组
        private final Stack<int[]> s;

        public StockSpanner2() {
            s = new Stack<>();
        }

        public int next(int price) {
            // 算上当天
            int count = 1;
            // 单调栈模板
            while (!s.isEmpty() && s.peek()[0] <= price) {
                // 挤掉价格低于 price 的记录
                int[] prev = s.pop();
                count += prev[1];
            }
            s.push(new int[] { price, count });
            return count;
        }

    }

}
