package io.github.dunwu.algorithm.stack;

import org.junit.jupiter.api.Assertions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/next-greater-element-i/">496. 下一个更大元素 I</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 下一个更大元素I {

    public static void main(String[] args) {
        int[] output1 = nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 });
        int[] expect1 = new int[] { -1, 3, -1 };
        Assertions.assertArrayEquals(expect1, output1);

        int[] output2 = nextGreaterElement(new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 });
        int[] expect2 = new int[] { 3, -1 };
        Assertions.assertArrayEquals(expect2, output2);
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int val = nums1[i];
            int pos = Integer.MAX_VALUE;
            result[i] = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (val == nums2[j]) {
                    pos = j;
                    continue;
                }
                if (pos < j && val < nums2[j]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }
        return result;
    }

    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int val = nums1[i];
            int pos = Integer.MAX_VALUE;
            result[i] = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (val == nums2[j]) {
                    pos = j;
                    continue;
                }
                if (pos < j && val < nums2[j]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }
        return result;
    }

    // 计算 nums 中每个元素的下一个更大元素
    public static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() > nums[i]) {
                s.pop();
            }
            // nums[i] 身后的下一个更大元素
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }

}
