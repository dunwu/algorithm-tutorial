package io.github.dunwu.algorithm.data_structure;

import org.junit.jupiter.api.Assertions;

import java.util.TreeMap;

/**
 * <a href="https://leetcode.cn/problems/my-calendar-i/">729. 我的日程安排表 I</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-03
 */
public class 我的日程安排表 {

    public static void main(String[] args) {
        MyCalendar s = new MyCalendar();
        Assertions.assertTrue(s.book(10, 20));
        Assertions.assertFalse(s.book(15, 25));
        Assertions.assertTrue(s.book(20, 30));
    }

    static class MyCalendar {

        private TreeMap<Integer, Integer> calendar = null;

        public MyCalendar() {
            calendar = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Integer earlier = calendar.floorKey(start);
            Integer later = calendar.ceilingKey(start);
            if (later != null && later < end) {
                return false;
            }
            if (earlier != null && start < calendar.get(earlier)) {
                return false;
            }
            calendar.put(start, end);
            return true;
        }

    }

}
