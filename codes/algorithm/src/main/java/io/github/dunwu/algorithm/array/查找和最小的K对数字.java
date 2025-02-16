package io.github.dunwu.algorithm.array;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/description/">373. 查找和最小的 K 对数字</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-21
 */
public class 查找和最小的K对数字 {

    public static void main(String[] args) {
        List<List<Integer>> expectList1 = new ArrayList<>();
        expectList1.add(Arrays.asList(1, 2));
        expectList1.add(Arrays.asList(1, 4));
        expectList1.add(Arrays.asList(1, 6));
        List<List<Integer>> list1 = kSmallestPairs2(new int[] { 1, 7, 11 }, new int[] { 2, 4, 6 }, 3);
        System.out.println(JSONUtil.toJsonStr(list1));

        List<List<Integer>> list2 = kSmallestPairs2(new int[] { 1, 1, 2 }, new int[] { 1, 2, 3 }, 2);
        System.out.println(JSONUtil.toJsonStr(list2));
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(0, 0));
        TreeMap<Integer, String> map = new TreeMap<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {

            if (i == nums1.length - 1 && j != nums2.length - 1) {
                i = 0;
                j++;
            } else if (i != nums1.length - 1 && j == nums2.length - 1) {
                j = 0;
                i++;
            }
            if (i == nums1.length - 1 && j == nums2.length - 1) {
                break;
            }

            if (nums1[i] + nums2[j + 1] <= nums1[i + 1] + nums2[j]) {
                list.add(Arrays.asList(i, j + 1));
                j++;
            } else {
                list.add(Arrays.asList(i + 1, j));
                i++;
            }

            if (i + 1 >= nums1.length && j + 1 >= nums2.length) { }
        }
        return list;
    }

    public static List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        int i = 0, j = 0;
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(nums1[i], nums2[j]));
        while (i < nums1.length - 1 && j < nums2.length - 1) {
            if (nums1[i] + nums2[j + 1] <= nums1[i + 1] + nums2[j]) {
                j++;
            } else {
                i++;
            }
            result.add(Arrays.asList(nums1[i], nums2[j]));
            if (i == nums1.length - 1 && j != nums2.length - 1) {
                i = 0;
                j++;
            }
            if (i != nums1.length - 1 && j == nums2.length - 1) {
                j = 0;
                i++;
            }
        }
        System.out.println(JSONUtil.toJsonStr(result));
        return null;
    }

}
