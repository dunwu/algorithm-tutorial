package io.github.dunwu.algorithm.array;

import cn.hutool.core.util.ArrayUtil;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.InvocationTargetException;
import java.util.PriorityQueue;

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
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < m; i++) {
            pq.offer(nums1[i]);
        }
        for (int i = 0; i < n; i++) {
            pq.offer(nums2[i]);
        }

        int pos = 0;
        while (!pq.isEmpty() && pos < (m + n)) {
            nums1[pos++] = pq.poll();
        }
    }

}
