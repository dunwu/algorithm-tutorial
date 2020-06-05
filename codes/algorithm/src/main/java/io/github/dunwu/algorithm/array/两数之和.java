package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-05
 */
public class 两数之和 {

    public static void main(String[] args) {
        Assertions.assertArrayEquals(new int[] { 1, 2 }, twoSumInSorted(new int[] { 2, 7, 11, 15 }, 9));
        Assertions.assertArrayEquals(new int[] { 1, 3 }, twoSumInSorted(new int[] { 2, 3, 4 }, 6));
        Assertions.assertArrayEquals(new int[] { 1, 2 }, twoSumInSorted(new int[] { 0, 0, 3, 4 }, 0));

        Assertions.assertArrayEquals(new int[] { 0, 1 },
            twoSum_method1(new int[] { 2, 7, 11, 15 }, 9));
        Assertions.assertArrayEquals(new int[] { 1, 2 },
            twoSum_method1(new int[] { 3, 2, 4 }, 6));
        Assertions.assertArrayEquals(new int[] { -1, -1 },
            twoSum_method1(new int[] { 3, 2, 4 }, 9));

        Assertions.assertArrayEquals(new int[] { 0, 1 },
            twoSum_method2(new int[] { 2, 7, 11, 15 }, 9));
        Assertions.assertArrayEquals(new int[] { 1, 2 },
            twoSum_method2(new int[] { 3, 2, 4 }, 6));
        Assertions.assertArrayEquals(new int[] { -1, -1 },
            twoSum_method2(new int[] { 3, 2, 4 }, 9));
    }

    /**
     * 题目：<a href="https://leetcode-cn.com/problems/two-sum/">1. 两数之和</a>
     * <p>
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     */
    public static int[] twoSumInSorted(int[] nums, int target) {
        final int[] notFound = new int[] { -1, -1 };
        if (nums == null || nums.length < 2) {
            return notFound;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int v = nums[left] + nums[right];
            if (v == target) {
                return new int[] { left + 1, right + 1 };
            } else if (v > target) {
                right--;
            } else {
                left++;
            }
        }
        return notFound;
    }

    /**
     * 题目：<a href="https://leetcode-cn.com/problems/two-sum/">1. 两数之和</a>
     * <p>
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     */
    public static int[] twoSum_method1(int[] nums, int target) {
        final int[] notFound = new int[] { -1, -1 };
        if (nums == null || nums.length < 2) {
            return notFound;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return notFound;
    }

    /**
     * 题目：<a href="https://leetcode-cn.com/problems/two-sum/">1. 两数之和</a>
     * <p>
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     */
    public static int[] twoSum_method2(int[] nums, int target) {
        final int[] notFound = new int[] { -1, -1 };
        if (nums == null || nums.length < 2) {
            return notFound;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[] { map.get(temp), i };
            } else {
                map.put(nums[i], i);
            }
        }

        return notFound;
    }

}
