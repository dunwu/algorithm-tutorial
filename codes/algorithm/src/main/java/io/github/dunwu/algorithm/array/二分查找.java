package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/binary-search/">704. 二分查找</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-05
 */
public class 二分查找 {

    public static void main(String[] args) {
        Assertions.assertEquals(4, search(new int[] { -1, 0, 3, 5, 9, 12 }, 9));
        Assertions.assertEquals(-1, search(new int[] { -1, 0, 3, 5, 9, 12 }, 2));
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
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
