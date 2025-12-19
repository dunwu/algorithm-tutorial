package io.github.dunwu.algorithm.stack.monotonic;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/">581. 最短无序连续子数组</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-26
 */
public class 最短无序连续子数组 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(5, s.findUnsortedSubarray(new int[] { 2, 6, 4, 8, 10, 9, 15 }));
        Assertions.assertEquals(0, s.findUnsortedSubarray(new int[] { 1, 2, 3, 4 }));
        Assertions.assertEquals(0, s.findUnsortedSubarray(new int[] { 1 }));

        Solution2 s2 = new Solution2();
        Assertions.assertEquals(5, s2.findUnsortedSubarray(new int[] { 2, 6, 4, 8, 10, 9, 15 }));
        Assertions.assertEquals(0, s2.findUnsortedSubarray(new int[] { 1, 2, 3, 4 }));
        Assertions.assertEquals(0, s2.findUnsortedSubarray(new int[] { 1 }));
    }

    // 排序解法
    static class Solution {

        public int findUnsortedSubarray(int[] nums) {
            int[] temp = Arrays.copyOf(nums, nums.length);
            Arrays.sort(temp);
            int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (temp[i] != nums[i]) {
                    left = i;
                    break;
                }
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                if (temp[i] != nums[i]) {
                    right = i;
                    break;
                }
            }
            if (left == Integer.MAX_VALUE && right == Integer.MIN_VALUE) {
                // nums 本来就是有序的
                return 0;
            }
            return right - left + 1;
        }

    }

    // 单调栈解法
    static class Solution2 {

        public int findUnsortedSubarray(int[] nums) {
            int n = nums.length;
            int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
            // 递增栈，存储元素索引
            Stack<Integer> incrStk = new Stack<>();
            for (int i = 0; i < n; i++) {
                while (!incrStk.isEmpty() && nums[incrStk.peek()] > nums[i]) {
                    // 弹出的元素都是乱序元素，其中最小的索引就是乱序子数组的左边界
                    left = Math.min(left, incrStk.pop());
                }
                incrStk.push(i);
            }
            // 递减栈，存储元素索引
            Stack<Integer> decrStk = new Stack<>();
            for (int i = n - 1; i >= 0; i--) {
                while (!decrStk.isEmpty() && nums[decrStk.peek()] < nums[i]) {
                    // 弹出的元素都是乱序元素，其中最大的索引就是乱序子数组的右边界
                    right = Math.max(right, decrStk.pop());
                }
                decrStk.push(i);
            }
            if (left == Integer.MAX_VALUE && right == Integer.MIN_VALUE) {
                // 说明单调栈没有弹出任何元素，即 nums 本来就是有序的
                return 0;
            }
            return right - left + 1;
        }

    }

}
