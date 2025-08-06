package io.github.dunwu.algorithm.array;

import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
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
        List<List<Integer>> list1 = kSmallestPairs(new int[] { 1, 7, 11 }, new int[] { 2, 4, 6 }, 3);
        System.out.println(JSONUtil.toJsonStr(list1));

        List<List<Integer>> list2 = kSmallestPairs(new int[] { 1, 1, 2 }, new int[] { 1, 2, 3 }, 2);
        System.out.println(JSONUtil.toJsonStr(list2));
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        // 存储三元组 (num1[i], nums2[i], i)
        // i 记录 nums2 元素的索引位置，用于生成下一个节点
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            // 按照数对的元素和升序排序
            return (a[0] + a[1]) - (b[0] + b[1]);
        });
        for (int i = 0; i < nums1.length; i++) {
            pq.offer(new int[] { nums1[i], nums2[0], 0 });
        }

        List<List<Integer>> list = new ArrayList<>();
        // 执行合并多个有序链表的逻辑
        while (!pq.isEmpty() && k > 0) {
            int[] cur = pq.poll();
            k--;
            // 链表中的下一个节点加入优先级队列
            int next = cur[2] + 1;
            if (next < nums2.length) {
                pq.add(new int[] { cur[0], nums2[next], next });
            }

            List<Integer> pair = new ArrayList<>();
            pair.add(cur[0]);
            pair.add(cur[1]);
            list.add(pair);
        }
        return list;
    }

}
