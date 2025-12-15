package io.github.dunwu.algorithm.dfs.permutation_combination;

import cn.hutool.core.collection.CollectionUtil;
import io.github.dunwu.algorithm.util.ArrayUtil;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combinations/">77. 组合</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-04
 */
public class 组合 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] expect = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 3, 4 } };
        Assertions.assertArrayEquals(expect, ArrayUtil.toIntMatrixArray(s.combine(4, 2)));
        Assertions.assertArrayEquals(new int[][] { { 1 } }, ArrayUtil.toIntMatrixArray(s.combine(1, 1)));
    }

    static class Solution {

        private List<Integer> path;
        private List<List<Integer>> res;

        public List<List<Integer>> combine(int n, int k) {
            path = new LinkedList<>();
            res = new LinkedList<>();
            backtrack(n, k, 1);
            return res;
        }

        public void backtrack(int n, int k, int s) {

            // 【结束】
            if (path.size() == k) {
                res.add(new LinkedList<>(path));
                System.out.printf("【结果】 %s\n\n", CollectionUtil.join(path, " -> "));
            }

            for (int i = s; i <= n; i++) {
                // 【选择】
                path.add(i);
                System.out.printf("\t\t%s\n", CollectionUtil.join(path, " -> "));

                // 【回溯】
                // 通过 start 参数控制树枝的遍历，避免产生重复的子集
                backtrack(n, k, i + 1);

                // 【取消选择】
                path.remove(path.size() - 1);
            }
        }

    }

}
