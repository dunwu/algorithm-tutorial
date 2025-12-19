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
            int n = nums.length;
            int[] res = new int[n];
            Stack<Integer> s = new Stack<>();
            for (int i = 2 * n - 1; i >= 0; i--) {
                int index = i % n;
                // 遍历栈，将小于当前元素的值都踢了
                while (!s.isEmpty() && s.peek() <= nums[index]) {
                    s.pop();
                }
                // nums[i] 下一个更大元素在栈顶
                res[index] = s.isEmpty() ? -1 : s.peek();
                s.push(nums[index]);
            }
            return res;
        }

    }

}
