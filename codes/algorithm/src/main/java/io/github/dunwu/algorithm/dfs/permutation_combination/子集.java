package io.github.dunwu.algorithm.dfs.permutation_combination;

import cn.hutool.core.collection.CollectionUtil;
import io.github.dunwu.algorithm.util.ArrayUtil;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/subsets/">78. 子集</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-04
 */
public class 子集 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] expect = { {}, { 1 }, { 1, 2 }, { 1, 2, 3 }, { 1, 3 }, { 2 }, { 2, 3 }, { 3 } };
        Assertions.assertArrayEquals(expect, ArrayUtil.toIntMatrixArray(s.subsets(new int[] { 1, 2, 3 })));
        Assertions.assertArrayEquals(new int[][] { {}, { 0 } }, ArrayUtil.toIntMatrixArray(s.subsets(new int[] { 0 })));
    }

    static class Solution {

        private boolean[] visited;
        private List<Integer> path;
        private List<List<Integer>> res;

        // 主函数
        public List<List<Integer>> subsets(int[] nums) {
            visited = new boolean[nums.length];
            path = new LinkedList<>();
            res = new LinkedList<>();
            Arrays.sort(nums);
            backtrack(nums, 0);
            return res;
        }

        // 回溯算法核心函数，遍历子集问题的回溯树
        public void backtrack(int[] nums, int start) {

            // 【结束】【前序】到达决策树叶子节点，可以记录结果
            res.add(new LinkedList<>(path));
            System.out.printf("【结果】 %s\n\n", CollectionUtil.join(path, " -> "));

            for (int i = start; i < nums.length; i++) {

                // 排除不合法的选择
                if (visited[i]) { continue; }

                // 【选择】
                visited[i] = true;
                path.add(nums[i]);
                System.out.printf("\t\t%s\n", CollectionUtil.join(path, " -> "));

                // 【回溯】
                backtrack(nums, i + 1);

                // 【取消选择】
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }

    }

}
