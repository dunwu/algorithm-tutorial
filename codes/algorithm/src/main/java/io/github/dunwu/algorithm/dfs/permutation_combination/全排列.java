package io.github.dunwu.algorithm.dfs.permutation_combination;

import cn.hutool.core.collection.CollectionUtil;
import io.github.dunwu.algorithm.util.ArrayUtil;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations/">46. 全排列</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-03
 */
public class 全排列 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] expect = { { 1, 2, 3 }, { 1, 3, 2 }, { 2, 1, 3 }, { 2, 3, 1 }, { 3, 1, 2 }, { 3, 2, 1 } };
        int[][] expect2 = { { 0, 1 }, { 1, 0 } };
        Assertions.assertArrayEquals(expect, ArrayUtil.toIntMatrixArray(s.permute(new int[] { 1, 2, 3 })));
        Assertions.assertArrayEquals(expect2, ArrayUtil.toIntMatrixArray(s.permute(new int[] { 0, 1 })));
        Assertions.assertArrayEquals(new int[][] { { 1 } }, ArrayUtil.toIntMatrixArray(s.permute(new int[] { 1 })));
    }

    static class Solution {

        // 「路径」中的元素会被标记为 true，避免重复使用
        boolean[] visited;
        // 记录「路径」
        LinkedList<Integer> path;
        List<List<Integer>> res;

        // 主函数，输入一组不重复的数字，返回它们的全排列
        List<List<Integer>> permute(int[] nums) {
            visited = new boolean[nums.length];
            path = new LinkedList<>();
            res = new LinkedList<>();
            backtrack(nums);
            return res;
        }

        // 路径：记录在 path 中
        // 选择列表：nums 中不存在于 path 的那些元素（visited[i] 为 false）
        // 结束条件：nums 中的元素全都在 path 中出现
        void backtrack(int[] nums) {
            // 【结束】【前序】到达决策树叶子节点，可以记录结果
            if (path.size() == nums.length) {
                res.add(new LinkedList<>(path));
                System.out.printf("【结果】 %s\n\n", CollectionUtil.join(path, " -> "));
                return;
            }

            for (int i = 0; i < nums.length; i++) {

                // 排除不合法的选择
                // nums[i] 已经在 path 中，跳过
                if (visited[i]) { continue; }

                // 【选择】
                path.add(nums[i]);
                visited[i] = true;
                System.out.printf("\t\t%s\n", CollectionUtil.join(path, " -> "));

                // 【回溯】
                backtrack(nums);

                // 【取消选择】
                path.removeLast();
                visited[i] = false;
            }
        }

    }

}
