package io.github.dunwu.algorithm.dfs.permutation_combination;

import cn.hutool.core.collection.CollectionUtil;
import io.github.dunwu.algorithm.util.ArrayUtil;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-iii/">216. 组合总和 III</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-04
 */
public class 组合总和3 {

    public static void main(String[] args) {
        Solution s = new Solution();

        Assertions.assertArrayEquals(new int[][] { { 1, 2, 4 } }, ArrayUtil.toIntMatrixArray(s.combinationSum3(3, 7)));

        int[][] expect2 = { { 1, 2, 6 }, { 1, 3, 5 }, { 2, 3, 4 } };
        Assertions.assertArrayEquals(expect2, ArrayUtil.toIntMatrixArray(s.combinationSum3(3, 9)));

        Assertions.assertArrayEquals(new int[][] {}, ArrayUtil.toIntMatrixArray(s.combinationSum3(4, 1)));
    }

    static class Solution {

        private int sum;
        private boolean[] visited;
        private List<Integer> path;
        private List<List<Integer>> res;

        public List<List<Integer>> combinationSum3(int k, int n) {
            sum = 0;
            visited = new boolean[9];
            path = new LinkedList<>();
            res = new LinkedList<>();
            int[] nums = new int[9];
            for (int i = 0; i < 9; i++) {
                nums[i] = i + 1;
            }
            backtrack(nums, n, k, 0);
            return res;
        }

        public void backtrack(int[] nums, int target, int k, int s) {

            // 【结束】【前序】找到目标和，记录结果
            if (sum == target && path.size() == k) {
                res.add(new LinkedList<>(path));
                System.out.printf("【结果】 %s\n\n", CollectionUtil.join(path, " -> "));
                return;
            }
            // base case，超过目标和，停止向下遍历
            if (sum > target || path.size() > k) { return; }

            for (int i = s; i < nums.length; i++) {

                if (visited[i]) { continue; }

                // 【选择】
                sum += nums[i];
                visited[i] = true;
                path.add(nums[i]);
                System.out.printf("\t\t%s\n", CollectionUtil.join(path, " -> "));

                // 【回溯】
                // 同一元素可重复使用，注意参数
                backtrack(nums, target, k, i + 1);

                // 【取消选择】
                path.remove(path.size() - 1);
                visited[i] = false;
                sum -= nums[i];
            }
        }

    }

}
