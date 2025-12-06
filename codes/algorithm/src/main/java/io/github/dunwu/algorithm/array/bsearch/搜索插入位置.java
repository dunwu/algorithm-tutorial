package io.github.dunwu.algorithm.array.bsearch;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/search-insert-position/">35. 搜索插入位置</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-29
 */
public class 搜索插入位置 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(0, s.searchInsert(new int[] { 1 }, 1));
        Assertions.assertEquals(2, s.searchInsert(new int[] { 1, 3, 5, 6 }, 5));
        Assertions.assertEquals(1, s.searchInsert(new int[] { 1, 3, 5, 6 }, 2));
        Assertions.assertEquals(4, s.searchInsert(new int[] { 1, 3, 5, 6 }, 7));
        Assertions.assertEquals(0, s.searchInsert(new int[] { 1, 3, 5, 6 }, 0));
    }

    static class Solution {

        public int searchInsert(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            }
            return left;
        }

    }

}
