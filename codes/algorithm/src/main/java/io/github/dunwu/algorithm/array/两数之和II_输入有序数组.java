package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/kLl5u1/">LCR 006. 两数之和 II - 输入有序数组</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-08-06
 */
public class 两数之和II_输入有序数组 {

    public static void main(String[] args) {
        Assertions.assertArrayEquals(new int[] { 1, 3 }, twoSum(new int[] { 1, 2, 4, 6, 10 }, 8));
        Assertions.assertArrayEquals(new int[] { 0, 2 }, twoSum(new int[] { 2, 3, 4 }, 6));
        Assertions.assertArrayEquals(new int[] { 0, 1 }, twoSum(new int[] { -1, 0 }, -1));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left, right };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }

}
