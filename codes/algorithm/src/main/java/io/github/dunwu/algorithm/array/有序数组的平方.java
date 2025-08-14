package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/squares-of-a-sorted-array/">977. 有序数组的平方</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-08-06
 */
public class 有序数组的平方 {

    public static void main(String[] args) {
        int[] input1 = { -4, -1, 0, 3, 10 };
        int[] expect1 = { 0, 1, 9, 16, 100 };
        int[] output1 = sortedSquares(input1);
        Assertions.assertArrayEquals(expect1, output1);

        int[] input2 = { -7, -3, 2, 3, 11 };
        int[] expect2 = { 4, 9, 9, 49, 121 };
        int[] output2 = sortedSquares(input2);
        Assertions.assertArrayEquals(expect2, output2);
    }

    public static int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int left = 0, right = len - 1;
        int p = len - 1;
        int[] output = new int[len];
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                output[p] = nums[left] * nums[left];
                left++;
            } else {
                output[p] = nums[right] * nums[right];
                right--;
            }
            p--;
        }
        return output;
    }

}
