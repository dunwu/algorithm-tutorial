package io.github.dunwu.algorithm.stack.monotonic;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/next-greater-element-ii/">503. 下一个更大元素 II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-26
 */
public class 下一个更大元素2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new int[] { 2, -1, 2 }, s.nextGreaterElements(new int[] { 1, 2, 1 }));
        Assertions.assertArrayEquals(new int[] { 2, 3, 4, -1, 4 }, s.nextGreaterElements(new int[] { 1, 2, 3, 4, 3 }));
    }

    static class Solution {

        public int[] nextGreaterElements(int[] nums) {
            int[] res = new int[nums.length];
            Stack<Integer> stack = new Stack<>();
            for (int index = 2 * nums.length - 1; index >= 0; index--) {
                int i = index % nums.length;
                while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                    stack.pop();
                }
                res[i] = stack.empty() ? -1 : stack.peek();
                stack.push(nums[i]);
            }
            return res;
        }

    }

}
