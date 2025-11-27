package io.github.dunwu.algorithm.queue.monotonic;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/daily-temperatures/">739. 每日温度</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-26
 */
public class 设计自助结算系统 {

    public static void main(String[] args) {
        Checkout c = new Checkout();
        c.add(4);
        c.add(7);
        Assertions.assertEquals(7, c.get_max());
        Assertions.assertEquals(4, c.remove());
        Assertions.assertEquals(7, c.get_max());
    }

    static class Checkout {

        private MonotonicQueue<Integer> q;
        public Checkout() {
            q = new MonotonicQueue<>();
        }

        public int get_max() {
            return q.isEmpty() ? -1 : q.max();
        }

        public void add(int value) {
            q.push(value);
        }

        public int remove() {
            if (q.isEmpty()) { return -1; }
            return q.pop();
        }

    }

}
