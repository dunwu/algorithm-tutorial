package io.github.dunwu.algorithm.dfs.permutation_combination;

import cn.hutool.core.collection.CollectionUtil;
import io.github.dunwu.algorithm.util.ArrayUtil;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations-ii/">47. 全排列 II</a>
 * <a href="https://leetcode.cn/problems/7p8L0Z/">LCR 084. 全排列 II </a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-03
 */
public class 全排列2 {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] expect = { { 1, 1, 2 }, { 1, 2, 1 }, { 2, 1, 1 } };
        Assertions.assertArrayEquals(expect, ArrayUtil.toIntMatrixArray(s.permuteUnique(new int[] { 1, 1, 2 })));

        int[][] expect2 = { { 1, 2, 3 }, { 1, 3, 2 }, { 2, 1, 3 }, { 2, 3, 1 }, { 3, 1, 2 }, { 3, 2, 1 } };
        Assertions.assertArrayEquals(expect2, ArrayUtil.toIntMatrixArray(s.permuteUnique(new int[] { 1, 2, 3 })));
    }

    static class Solution {

        private boolean[] visited;
        private List<Integer> path;
        private List<List<Integer>> res;

        public List<List<Integer>> permuteUnique(int[] nums) {
            visited = new boolean[nums.length];
            path = new LinkedList<>();
            res = new LinkedList<>();
            Arrays.sort(nums);
            backtrack(nums);
            return res;
        }

        public void backtrack(int[] nums) {

            // 【结束】【前序】到达决策树叶子节点，可以记录结果
            if (path.size() == nums.length) {
                res.add(new LinkedList<>(path));
                System.out.printf("【结果】 %s\n\n", CollectionUtil.join(path, " -> "));
            }

            for (int i = 0; i < nums.length; i++) {

                // 排除不合法的选择
                if (visited[i]) { continue; }
                // 剪枝逻辑，固定相同的元素在排列中的相对位置
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) { continue; }

                // 【选择】
                visited[i] = true;
                path.add(nums[i]);
                System.out.printf("\t\t%s\n", CollectionUtil.join(path, " -> "));

                // 【回溯】
                backtrack(nums);

                // 【取消选择】
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }

    }

}
