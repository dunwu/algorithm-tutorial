package io.github.dunwu.algorithm.dfs;

import io.github.dunwu.algorithm.util.ArrayUtil;
import org.junit.jupiter.api.Assertions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/non-decreasing-subsequences/">491. 非递减子序列</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-12-12
 */
public class 非递减子序列 {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] expect = new int[][] {
            { 4, 6 }, { 4, 6, 7 }, { 4, 6, 7, 7 }, { 4, 7 }, { 4, 7, 7 }, { 6, 7 }, { 6, 7, 7 }, { 7, 7 }
        };
        List<List<Integer>> output = s.findSubsequences(new int[] { 4, 6, 7, 7 });
        Assertions.assertArrayEquals(expect, ArrayUtil.toIntMatrixArray(output));

        List<List<Integer>> output2 = s.findSubsequences(new int[] { 4, 4, 3, 2, 1 });
        Assertions.assertArrayEquals(new int[][] { { 4, 4 } }, ArrayUtil.toIntMatrixArray(output2));
    }

    static class Solution {

        private List<Integer> path;
        private List<List<Integer>> res;

        public List<List<Integer>> findSubsequences(int[] nums) {

            // base case
            if (nums == null || nums.length == 0) { return new LinkedList<>(); }

            path = new LinkedList<>();
            res = new LinkedList<>();

            dfs(nums, 0);
            return res;
        }

        public void dfs(int[] nums, int start) {
            if (path.size() >= 2) {
                res.add(new LinkedList<>(path));
            }

            // 用哈希集合防止重复选择相同元素
            HashSet<Integer> visited = new HashSet<>();

            for (int i = start; i < nums.length; i++) {

                if (!path.isEmpty() && nums[i] < path.get(path.size() - 1)) { continue; }
                // 保证不要重复使用相同的元素
                if (visited.contains(nums[i])) { continue; }

                // 【选择】
                visited.add(nums[i]);
                path.add(nums[i]);

                // 【递归】
                dfs(nums, i + 1);

                // 【取消选择】
                path.remove(path.size() - 1);
            }
        }

    }

}
