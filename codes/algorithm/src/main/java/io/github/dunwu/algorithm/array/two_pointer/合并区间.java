package io.github.dunwu.algorithm.array.two_pointer;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/merge-intervals/">56. 合并区间</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-29
 */
public class 合并区间 {

    public static void main(String[] args) {

        Solution s = new Solution();

        int[][] input = new int[][] { { 1, 4 }, { 2, 3 } };
        int[][] expect = new int[][] { { 1, 4 } };
        Assertions.assertArrayEquals(expect, s.merge(input));

        int[][] input2 = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] expect2 = new int[][] { { 1, 6 }, { 8, 10 }, { 15, 18 } };
        Assertions.assertArrayEquals(expect2, s.merge(input2));

        int[][] input3 = new int[][] { { 1, 4 }, { 4, 5 } };
        int[][] expect3 = new int[][] { { 1, 5 } };
        Assertions.assertArrayEquals(expect3, s.merge(input3));
    }

    static class Solution {

        public int[][] merge(int[][] intervals) {

            // base case
            if (intervals == null || intervals.length <= 1) { return intervals; }

            // 先按区间下限排序
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

            // 设置双指针，扫描 intervals
            List<int[]> merged = new ArrayList<>();
            for (int[] interval : intervals) {
                int l = interval[0], r = interval[1];
                int last = merged.size() - 1;
                if (last == -1 || merged.get(last)[1] < l) {
                    merged.add(new int[] { l, r });
                } else {
                    l = merged.get(last)[0];
                    r = Math.max(merged.get(last)[1], r);
                    merged.set(last, new int[] { l, r });
                }
            }
            return merged.toArray(new int[merged.size()][2]);
        }

    }

}
