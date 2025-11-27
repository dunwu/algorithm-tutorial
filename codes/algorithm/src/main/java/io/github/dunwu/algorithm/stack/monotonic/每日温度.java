package io.github.dunwu.algorithm.stack.monotonic;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/daily-temperatures/">739. 每日温度</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-26
 */
public class 每日温度 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new int[] { 1, 1, 4, 2, 1, 1, 0, 0 },
            s.dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 }));
        Assertions.assertArrayEquals(new int[] { 1, 1, 1, 0 },
            s.dailyTemperatures(new int[] { 30, 40, 50, 60 }));
    }

    static class Solution {

        public int[] dailyTemperatures(int[] t) {
            int[] res = new int[t.length];
            Stack<int[]> s = new Stack<>();
            for (int i = t.length - 1; i >= 0; i--) {
                while (!s.isEmpty() && s.peek()[1] <= t[i]) {
                    s.pop();
                }
                res[i] = s.isEmpty() ? 0 : s.peek()[0] - i;
                s.push(new int[] { i, t[i] });
            }
            return res;
        }

    }

}
