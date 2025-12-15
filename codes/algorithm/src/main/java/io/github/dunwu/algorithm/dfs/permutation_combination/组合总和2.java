package io.github.dunwu.algorithm.dfs.permutation_combination;

import cn.hutool.core.collection.CollectionUtil;
import io.github.dunwu.algorithm.util.ArrayUtil;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-ii/">40. 组合总和 II</a>
 * <a href="https://leetcode.cn/problems/4sjJUc/">LCR 082. 组合总和 II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-04
 */
public class 组合总和2 {

    public static void main(String[] args) {

        Solution s = new Solution();

        List<List<Integer>> output = s.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8);
        int[][] expect = { { 1, 1, 6 }, { 1, 2, 5 }, { 1, 7 }, { 2, 6 } };
        Assertions.assertArrayEquals(expect, ArrayUtil.toIntMatrixArray(output));

        List<List<Integer>> output2 = s.combinationSum2(new int[] { 2, 5, 2, 1, 2 }, 5);
        int[][] expect2 = { { 1, 2, 2 }, { 5 } };
        Assertions.assertArrayEquals(expect2, ArrayUtil.toIntMatrixArray(output2));
    }

    static class Solution {

        private int sum;
        private boolean[] visited;
        private List<Integer> path;
        private List<List<Integer>> res;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            sum = 0;
            visited = new boolean[candidates.length];
            path = new ArrayList<>();
            res = new ArrayList<>();
            Arrays.sort(candidates);
            backtrack(candidates, target, 0);
            return res;
        }

        public void backtrack(int[] nums, int target, int start) {

            // 【结束】【前序】找到目标和，记录结果
            if (sum == target) {
                res.add(new LinkedList<>(path));
                System.out.printf("【结果】 %s\n\n", CollectionUtil.join(path, " -> "));
                return;
            }
            // base case，超过目标和，停止向下遍历
            if (sum > target) { return; }

            for (int i = start; i < nums.length; i++) {

                // 剪枝逻辑
                if (visited[i]) { continue; }
                if (i > start && nums[i] == nums[i - 1] && !visited[i - 1]) { continue; }

                // 【选择】
                sum += nums[i];
                visited[i] = true;
                path.add(nums[i]);
                System.out.printf("\t\t%s\n", CollectionUtil.join(path, " -> "));

                // 【回溯】
                backtrack(nums, target, i + 1);

                // 【取消选择】
                path.remove(path.size() - 1);
                visited[i] = false;
                sum -= nums[i];
            }
        }

    }

}
