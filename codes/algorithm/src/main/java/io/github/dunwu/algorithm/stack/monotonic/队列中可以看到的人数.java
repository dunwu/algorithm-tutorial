package io.github.dunwu.algorithm.stack.monotonic;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/number-of-visible-people-in-a-queue/">1944. 队列中可以看到的人数</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-12-19
 */
public class 队列中可以看到的人数 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(new int[] { 3, 1, 2, 1, 1, 0 }, s.canSeePersonsCount(new int[] { 10, 6, 8, 5, 11, 9 }));
        Assertions.assertEquals(new int[] { 4, 1, 1, 1, 0 }, s.canSeePersonsCount(new int[] { 5, 1, 2, 3, 10 }));
    }

    static class Solution {

        public int[] canSeePersonsCount(int[] heights) {
            int n = heights.length;
            int[] res = new int[n];
            // int[] 记录 {身高，小于等于该身高的人数} 二元组
            Stack<Integer> stk = new Stack<>();
            for (int i = n - 1; i >= 0; i--) {
                // 记录右侧比自己矮的人
                int count = 0;
                // 单调栈模板，计算下一个更大或相等元素（身高）
                while (!stk.isEmpty() && heights[i] > stk.peek()) {
                    stk.pop();
                    count++;
                }
                // 不仅可以看到比自己矮的人，如果后面存在更高的的人，也可以看到这个高人
                res[i] = stk.isEmpty() ? count : count + 1;
                stk.push(heights[i]);
            }
            return res;
        }

    }

}
