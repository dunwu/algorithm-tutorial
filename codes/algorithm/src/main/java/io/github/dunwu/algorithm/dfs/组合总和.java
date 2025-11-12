package io.github.dunwu.algorithm.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum/">39. 组合总和</a>
 * <p>
 * 元素不可重复，不可复选
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-04
 */
public class 组合总和 {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> output = s.combinationSum(new int[] { 2, 3, 6, 7 }, 7);
        System.out.println("output = " + output);
    }

    static class Solution {

        // 记录回溯算法的递归路径
        LinkedList<Integer> track = null;
        List<List<Integer>> res = null;
        // 记录 track 中的元素之和
        int sum = 0;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            track = new LinkedList<>();
            res = new LinkedList<>();
            sum = 0;
            backtrack(candidates, 0, target);
            return res;
        }

        public void backtrack(int[] nums, int start, int taget) {

            // 前序位置，每个节点的值都是一个子集
            if (sum == taget) {
                res.add(new LinkedList<>(track));
                System.out.printf("\t=> %s\n", res);
                return;
            }

            if (sum > taget) {
                return;
            }

            // 回溯算法标准框架
            for (int i = start; i < nums.length; i++) {
                // 做选择
                track.addLast(nums[i]);
                sum += nums[i];
                // 通过 start 参数控制树枝的遍历，避免产生重复的子集
                backtrack(nums, i, taget);
                // 撤销选择
                track.removeLast();
                sum -= nums[i];
            }
        }

    }

}
