package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-05
 */
public class 在排序数组中查找数字I {

    public static void main(String[] args) {
        Assertions.assertEquals(2, count(8, new Integer[] { 7, 8, 5, 10, 7, 8 }));
        Assertions.assertEquals(0, count(6, new Integer[] { 5, 7, 7, 8, 8, 10 }));
        Assertions.assertEquals(2, count("abc", new String[] { "abc", "xyz", "lmn", "abc" }));
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

}
