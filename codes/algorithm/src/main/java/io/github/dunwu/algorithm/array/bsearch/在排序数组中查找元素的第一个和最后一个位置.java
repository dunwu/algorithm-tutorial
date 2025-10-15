package io.github.dunwu.algorithm.array.bsearch;

import org.junit.jupiter.api.Assertions;

/**
 * <a
 * href="https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/">34.在排序数组中查找元素的第一个和最后一个位置</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-05
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) {
        Assertions.assertArrayEquals(new int[] { 3, 4 }, searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8));
        Assertions.assertArrayEquals(new int[] { -1, -1 }, searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6));
        Assertions.assertArrayEquals(new int[] { -1, -1 }, searchRange(new int[] {}, 0));
        Assertions.assertArrayEquals(new int[] { 0, 0 }, searchRange(new int[] { 1 }, 1));

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

    public static int[] searchRange(int[] nums, int target) {
        final int[] notFound = { -1, -1 };
        if (nums == null || nums.length == 0) {
            return notFound;
        }
        int begin = searchLeft(nums, target);
        int end = searchRight(nums, target);
        return new int[] { begin, end };
    }

    static int searchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left < 0 || left >= nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    static int searchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (right < 0 || right >= nums.length) {
            return -1;
        }
        return nums[right] == target ? right : -1;
    }

}
