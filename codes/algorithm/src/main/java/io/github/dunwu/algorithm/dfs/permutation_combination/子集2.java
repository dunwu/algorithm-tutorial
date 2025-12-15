package io.github.dunwu.algorithm.dfs.permutation_combination;

import cn.hutool.core.collection.CollectionUtil;
import io.github.dunwu.algorithm.util.ArrayUtil;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/subsets-ii/">90. 子集 II</a>
 * <p>
 * 元素可重复，不可复选
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-04
 */
public class 子集2 {

    public static void main(String[] args) {

        Solution s = new Solution();

        int[][] expect = { {}, { 1 }, { 1, 2 }, { 1, 2, 2 }, { 2 }, { 2, 2 } };
        Assertions.assertArrayEquals(expect, ArrayUtil.toIntMatrixArray(s.subsetsWithDup(new int[] { 1, 2, 2 })));

        int[][] expect2 = { {}, { 0 } };
        Assertions.assertArrayEquals(expect2, ArrayUtil.toIntMatrixArray(s.subsetsWithDup(new int[] { 0 })));
    }

    static class Solution {

        private List<List<Integer>> res;
        private LinkedList<Integer> path;

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            path = new LinkedList<>();
            res = new LinkedList<>();
            // 先排序，让相同的元素靠在一起
            Arrays.sort(nums);
            backtrack(nums, 0);
            return res;
        }

        public void backtrack(int[] nums, int start) {

            // 【结束】
            res.add(new LinkedList<>(path));
            System.out.printf("【结果】 %s\n\n", CollectionUtil.join(path, " -> "));

            for (int i = start; i < nums.length; i++) {

                // 剪枝逻辑，值相同的相邻树枝，只遍历第一条
                if (i > start && nums[i] == nums[i - 1]) continue;

                // 【选择】
                path.add(nums[i]);
                System.out.printf("\t\t%s\n", CollectionUtil.join(path, " -> "));

                // 【回溯】
                backtrack(nums, i + 1);

                // 【取消选择】
                path.remove(path.size() - 1);
            }
        }

    }

}
