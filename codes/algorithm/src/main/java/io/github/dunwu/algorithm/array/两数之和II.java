package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/">167. 两数之和 II - 输入有序数组</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-05
 */
public class 两数之和II {

    public static void main(String[] args) {
        Assertions.assertArrayEquals(new int[] { 1, 2 }, twoSum(new int[] { 2, 7, 11, 15 }, 9));
        Assertions.assertArrayEquals(new int[] { 1, 3 }, twoSum(new int[] { 2, 3, 4 }, 6));
        Assertions.assertArrayEquals(new int[] { 1, 2 }, twoSum(new int[] { -1, 0 }, -1));

        Assertions.assertArrayEquals(new int[] { 1, 2 }, twoSum2(new int[] { 2, 7, 11, 15 }, 9));
        Assertions.assertArrayEquals(new int[] { 1, 3 }, twoSum2(new int[] { 2, 3, 4 }, 6));
        Assertions.assertArrayEquals(new int[] { 1, 2 }, twoSum2(new int[] { -1, 0 }, -1));

        Assertions.assertArrayEquals(new int[] { 1, 2 }, twoSum3(new int[] { 2, 7, 11, 15 }, 9));
        Assertions.assertArrayEquals(new int[] { 1, 3 }, twoSum3(new int[] { 2, 3, 4 }, 6));
        Assertions.assertArrayEquals(new int[] { 1, 2 }, twoSum3(new int[] { -1, 0 }, -1));
    }

    /**
     * 时间复杂度：O(logn)
     */
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {};
    }

    /**
     * 时间复杂度：O(n)
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int len = numbers.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            int diff = target - numbers[i];
            if (map.containsKey(diff)) {
                return new int[] { map.get(diff) + 1, i + 1 };
            } else {
                map.put(numbers[i], i);
            }
        }
        return new int[] {};
    }

    /**
     * 时间复杂度：O(n^2)
     */
    public static int[] twoSum3(int[] numbers, int target) {
        for (int left = 0; left < numbers.length; left++) {
            for (int right = left + 1; right < numbers.length; right++) {
                if (numbers[left] + numbers[right] == target) {
                    return new int[] { left + 1, right + 1 };
                }
            }
        }
        return new int[] {};
    }

}
