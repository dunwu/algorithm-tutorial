package io.github.dunwu.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-20
 */
public class ArrayDemo {

    /**
     * 题目：<a href="https://leetcode-cn.com/problems/contains-duplicate/">217. 存在重复元素</a>
     * <p>
     * 给定一个数组，判断是否存在重复元素。
     * <p>
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     *
     * @param array 数组
     * @return true/false
     */
    public static <T> boolean containsDuplicate(T[] array) {
        if (array == null || array.length <= 1) {
            return false;
        }

        Set<T> set = new HashSet<>();
        set.addAll(Arrays.asList(array));

        return set.size() != array.length;
    }

    /**
     * 题目：<a href="https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/">面试题53 - I.
     * 在排序数组中查找数字I</a>
     * <p>
     * 统计一个元素在数组中出现的次数。
     */
    public static <T> int count(T target, T[] array) {
        Arrays.sort(array);

        int count = 0;
        for (T i : array) {
            if (target.equals(i)) {
                count++;
                continue;
            }

            if (count != 0) { break; }
        }
        return count;
    }

    public static int maxSubArray(int[] nums) {
        int len = nums.length;

        int maxSum = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int max = maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });
        System.out.println("max = " + max);
    }

}
