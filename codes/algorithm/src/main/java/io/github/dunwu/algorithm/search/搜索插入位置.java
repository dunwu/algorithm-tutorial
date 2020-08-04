package io.github.dunwu.algorithm.search;

import org.junit.jupiter.api.Assertions;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-13
 */
public class 搜索插入位置 {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 6 };
        Assertions.assertEquals(2, searchInsert2(nums, 5));
        Assertions.assertEquals(1, searchInsert2(nums, 2));
        Assertions.assertEquals(4, searchInsert2(nums, 7));
    }

    public static int searchInsert(int[] nums, int target) {

        int len = nums.length;
        int left = 0;
        int right = len - 1;
        if (nums[len - 1] < target) {
            return len;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static int searchInsert2(int[] nums, int target) {
        int N = nums.length;
        if (target < nums[0]) return 0;
        if (target > nums[N - 1]) return N;
        int left = 0, right = N - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
