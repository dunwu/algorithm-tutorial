package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-05
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) {
        Assertions.assertArrayEquals(new int[] { 3, 4 },
            searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8));
        Assertions.assertArrayEquals(new int[] { -1, -1 },
            searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6));

        Assertions.assertEquals(-1, searchLeft(new int[] { 5, 7, 7, 8, 8, 10 }, 3));
        Assertions.assertEquals(0, searchLeft(new int[] { 5, 7, 7, 8, 8, 10 }, 5));
        Assertions.assertEquals(5, searchLeft(new int[] { 5, 7, 7, 8, 8, 10 }, 10));
        Assertions.assertEquals(-1, searchLeft(new int[] { 5, 7, 7, 8, 8, 10 }, 12));
        Assertions.assertEquals(1, searchLeft(new int[] { 5, 7, 7, 8, 8, 10 }, 7));

        Assertions.assertEquals(-1, searchRight(new int[] { 5, 7, 7, 8, 8, 10 }, 3));
        Assertions.assertEquals(0, searchRight(new int[] { 5, 7, 7, 8, 8, 10 }, 5));
        Assertions.assertEquals(5, searchRight(new int[] { 5, 7, 7, 8, 8, 10 }, 10));
        Assertions.assertEquals(-1, searchRight(new int[] { 5, 7, 7, 8, 8, 10 }, 12));
        Assertions.assertEquals(2, searchRight(new int[] { 5, 7, 7, 8, 8, 10 }, 7));
    }

    /**
     * 题目：<a href="https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/">34.
     * 在排序数组中查找元素的第一个和最后一个位置</a>
     * <p>
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 如果数组中不存在目标值，返回 [-1, -1]。
     */
    public static int[] searchRange(int[] nums, int target) {
        final int[] notFoundResult = { -1, -1 };
        if (nums == null || nums.length == 0) { return notFoundResult; }

        int begin = searchLeft(nums, target);
        if (begin == nums.length || nums[begin] != target) { return notFoundResult; }
        int end = searchRight(nums, target);
        return new int[] { begin, end };
    }

    public static int searchLeft(int[] nums, int target) {
        if (nums == null || nums.length == 0) { return -1; }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }

        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public static int searchRight(int[] nums, int target) {
        if (nums == null || nums.length == 0) { return -1; }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

}
