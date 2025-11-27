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
        Solution s = new Solution();

        Assertions.assertEquals(-1, s.searchLeft(new int[] { 5, 7, 7, 8, 8, 10 }, 3));
        Assertions.assertEquals(0, s.searchLeft(new int[] { 5, 7, 7, 8, 8, 10 }, 5));
        Assertions.assertEquals(5, s.searchLeft(new int[] { 5, 7, 7, 8, 8, 10 }, 10));
        Assertions.assertEquals(-1, s.searchLeft(new int[] { 5, 7, 7, 8, 8, 10 }, 12));
        Assertions.assertEquals(1, s.searchLeft(new int[] { 5, 7, 7, 8, 8, 10 }, 7));

        Assertions.assertEquals(-1, s.searchRight(new int[] { 5, 7, 7, 8, 8, 10 }, 3));
        Assertions.assertEquals(0, s.searchRight(new int[] { 5, 7, 7, 8, 8, 10 }, 5));
        Assertions.assertEquals(5, s.searchRight(new int[] { 5, 7, 7, 8, 8, 10 }, 10));
        Assertions.assertEquals(-1, s.searchRight(new int[] { 5, 7, 7, 8, 8, 10 }, 12));
        Assertions.assertEquals(2, s.searchRight(new int[] { 5, 7, 7, 8, 8, 10 }, 7));

        Assertions.assertArrayEquals(new int[] { 3, 4 }, s.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8));
        Assertions.assertArrayEquals(new int[] { -1, -1 }, s.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6));
        Assertions.assertArrayEquals(new int[] { -1, -1 }, s.searchRange(new int[] {}, 0));
        Assertions.assertArrayEquals(new int[] { 0, 0 }, s.searchRange(new int[] { 1 }, 1));
    }

    static class Solution {

        public int[] searchRange(int[] nums, int target) {
            int left = searchLeft(nums, target);
            int right = searchRight(nums, target);
            return new int[] { left, right };
        }

        public int searchLeft(int[] nums, int target) {
            int res = -1;
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    res = mid;
                    right = mid - 1;
                }
            }
            return res;
        }

        public int searchRight(int[] nums, int target) {
            int res = -1;
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] == target) {
                    res = mid;
                    left = mid + 1;
                }
            }
            return res;
        }

    }

}
