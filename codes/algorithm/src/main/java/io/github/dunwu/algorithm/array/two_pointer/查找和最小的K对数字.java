package io.github.dunwu.algorithm.array.two_pointer;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/">373. 查找和最小的 K 对数字</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-21
 */
public class 查找和最小的K对数字 {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> expectList1 = new ArrayList<>();
        expectList1.add(Arrays.asList(1, 2));
        expectList1.add(Arrays.asList(1, 4));
        expectList1.add(Arrays.asList(1, 6));
        List<List<Integer>> list1 = s.kSmallestPairs(new int[] { 1, 7, 11 }, new int[] { 2, 4, 6 }, 3);
        System.out.println(JSONUtil.toJsonStr(list1));

        List<List<Integer>> list2 = s.kSmallestPairs(new int[] { 1, 1, 2 }, new int[] { 1, 2, 3 }, 2);
        System.out.println(JSONUtil.toJsonStr(list2));
    }

    static class Solution {

        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] + a[1])));
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    queue.offer(new int[] { nums1[i], nums2[j] });
                }
            }

            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                int[] element = queue.poll();
                res.add(Arrays.asList(element[0], element[1]));
            }
            return res;
        }

    }

}
