package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-05
 */
public class 存在重复元素 {

    public static void main(String[] args) {
        Assertions.assertTrue(containsDuplicate(new Integer[] { 1, 2, 3, 1 }));
        Assertions.assertFalse(containsDuplicate(new Integer[] { 1, 2, 3, 4 }));
        Assertions.assertTrue(containsDuplicate(new Integer[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));
    }

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

}
