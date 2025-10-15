package io.github.dunwu.algorithm.array;

import cn.hutool.core.util.ArrayUtil;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.InvocationTargetException;

/**
 * <a href="https://leetcode.cn/problems/merge-sorted-array/">88. 合并两个有序数组</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-08-06
 */
public class 合并两个有序数组 {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = new int[] { 2, 5, 6 };
        merge(nums1, 3, nums2, 3);
        Assertions.assertTrue(ArrayUtil.equals(new int[] { 1, 2, 2, 3, 5, 6 }, nums1));

        int[] nums3 = new int[] { 1 };
        int[] nums4 = new int[] {};
        merge(nums3, 1, nums4, 0);
        Assertions.assertTrue(ArrayUtil.equals(new int[] { 1 }, nums3));

        int[] nums5 = new int[] { 0 };
        int[] nums6 = new int[] { 1 };
        merge(nums5, 0, nums6, 1);
        Assertions.assertTrue(ArrayUtil.equals(new int[] { 1 }, nums5));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int p = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[p--] = nums1[i--];
            } else {
                nums1[p--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[p--] = nums2[j--];
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        // 两个指针分别初始化在两个数组的最后一个元素（类似拉链两端的锯齿）
        int i = m - 1, j = n - 1;
        // 生成排序的结果（类似拉链的拉锁）
        int p = nums1.length - 1;
        // 从后向前生成结果数组，类似合并两个有序链表的逻辑
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[p--] = nums1[i--];
            } else {
                nums1[p--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[p--] = nums2[j--];
        }
    }

}
