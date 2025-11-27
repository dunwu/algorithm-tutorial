package io.github.dunwu.algorithm.array.bsearch;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/binary-search/">704. 二分查找</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-05
 */
public class 二分查找 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(4, s.search(new int[] { -1, 0, 3, 5, 9, 12 }, 9));
        Assertions.assertEquals(-1, s.search(new int[] { -1, 0, 3, 5, 9, 12 }, 2));
    }

    static class Solution {

        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }

    }

}
