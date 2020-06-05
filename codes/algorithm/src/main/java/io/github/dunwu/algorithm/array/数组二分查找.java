package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-05
 */
public class 数组二分查找 {

    public static void main(String[] args) {
        Assertions.assertEquals(5, binarySearch(new int[] { 5, 7, 7, 8, 8, 10 }, 10));
        Assertions.assertEquals(0, binarySearch(new int[] { 5, 7, 7, 8, 8, 10 }, 5));
        Assertions.assertEquals(2, binarySearch(new int[] { 5, 7, 7, 8, 8, 10 }, 7));
    }

    /**
     * 数组二分查找，要求传入的数组是有序排列
     * <p>
     * 参考：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/er-fen-cha-zhao-suan-fa-xi-jie-xiang-jie-by-labula/
     */
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) { return -1; }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // 防止 mid 溢出
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        return -1;
    }

}
