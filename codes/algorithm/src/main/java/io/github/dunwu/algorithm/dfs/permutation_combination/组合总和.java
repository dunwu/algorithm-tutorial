package io.github.dunwu.algorithm.dfs.permutation_combination;

import cn.hutool.core.collection.CollectionUtil;
import io.github.dunwu.algorithm.util.ArrayUtil;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum/">39. 组合总和</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-04
 */
public class 组合总和 {

    public static void main(String[] args) {
        Solution s = new Solution();

        List<List<Integer>> output = s.combinationSum(new int[] { 2, 3, 6, 7 }, 7);
        Assertions.assertArrayEquals(new int[][] { { 2, 2, 3 }, { 7 } }, ArrayUtil.toIntMatrixArray(output));

        List<List<Integer>> output2 = s.combinationSum(new int[] { 2, 3, 5 }, 8);
        Assertions.assertArrayEquals(new int[][] { { 2, 2, 2, 2 }, { 2, 3, 3 }, { 3, 5 } },
            ArrayUtil.toIntMatrixArray(output2));
    }

    static class Solution {

        private int sum;
        private List<Integer> path;
        private List<List<Integer>> res;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            sum = 0;
            path = new LinkedList<>();
            res = new LinkedList<>();
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
                // 【选择】
                sum += nums[i];
                path.add(nums[i]);
                System.out.printf("\t\t%s\n", CollectionUtil.join(path, " -> "));

                // 【回溯】
                // 同一元素可重复使用，注意参数
                backtrack(nums, target, i);

                // 【取消选择】
                path.remove(path.size() - 1);
                sum -= nums[i];
            }
        }

    }

}
