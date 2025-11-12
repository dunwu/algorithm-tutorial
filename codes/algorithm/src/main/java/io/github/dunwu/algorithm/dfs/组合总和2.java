package io.github.dunwu.algorithm.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-ii/">40. 组合总和 II</a>
 * <a href="https://leetcode.cn/problems/4sjJUc/">LCR 082. 组合总和 II</a>
 * <p>
 * 元素不可重复，不可复选
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-04
 */
public class 组合总和2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> output = s.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8);
        System.out.println("output = " + output);
        // 期望输出：
        // [
        // [1,1,6],
        // [1,2,5],
        // [1,7],
        // [2,6]
        // ]
    }

    static class Solution {

        // 记录回溯算法的递归路径
        LinkedList<Integer> track = null;
        List<List<Integer>> res = null;
        // 记录 track 中的元素之和
        int sum = 0;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            track = new LinkedList<>();
            res = new LinkedList<>();
            sum = 0;
            Arrays.sort(candidates);
            backtrack(candidates, 0, target);
            return res;
        }

        public void backtrack(int[] nums, int start, int taget) {

            // 前序位置，每个节点的值都是一个子集
            if (sum == taget) {
                res.add(new LinkedList<>(track));
                // System.out.printf("\t=> %s\n", res);
                return;
            }

            if (sum > taget) {
                return;
            }

            // 回溯算法标准框架
            for (int i = start; i < nums.length; i++) {

                if (i > start && nums[i] == nums[i - 1]) { continue; }

                // 做选择
                track.addLast(nums[i]);
                sum += nums[i];
                // 通过 start 参数控制树枝的遍历，避免产生重复的子集
                backtrack(nums, i + 1, taget);
                // 撤销选择
                track.removeLast();
                sum -= nums[i];
            }
        }

    }

}
