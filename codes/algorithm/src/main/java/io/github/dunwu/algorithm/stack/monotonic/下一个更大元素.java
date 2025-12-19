package io.github.dunwu.algorithm.stack.monotonic;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/next-greater-element-i/">496. 下一个更大元素 I</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 下一个更大元素 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] output1 = s.nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 });
        Assertions.assertArrayEquals(new int[] { -1, 3, -1 }, output1);
        int[] output2 = s.nextGreaterElement(new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 });
        Assertions.assertArrayEquals(new int[] { 3, -1 }, output2);
    }

    // 采用单调栈解决问题，算法复杂度：O(n)
    static class Solution {

        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Stack<Integer> stack = new Stack<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = nums2.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                    stack.pop();
                }
                int largerVal = stack.isEmpty() ? -1 : stack.peek();
                map.put(nums2[i], largerVal);
                stack.push(nums2[i]);
            }

            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = map.get(nums1[i]);
            }
            return nums1;
        }

    }

}
