package io.github.dunwu.algorithm.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-iii/">216. 组合总和 III</a>
 * <p>
 * 元素不可重复，不可复选
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-04
 */
public class 组合总和3 {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> output = s.combinationSum3(3, 7);
        System.out.println("output = " + output);
        // 期望输出：
        // [
        // [1,2,4]
        // ]

        List<List<Integer>> output2 = s.combinationSum3(3, 9);
        System.out.println("output = " + output2);
        // 期望输出：
        // [[1,2,6], [1,3,5], [2,3,4]]

        List<List<Integer>> output3 = s.combinationSum3(4, 1);
        System.out.println("output = " + output3);
        // 期望输出：
        // []
    }

    static class Solution {

        // 记录回溯算法的递归路径
        LinkedList<Integer> track = null;
        List<List<Integer>> res = null;
        // 记录 track 中的元素之和
        int sum = 0;

        public List<List<Integer>> combinationSum3(int k, int n) {
            track = new LinkedList<>();
            res = new LinkedList<>();
            int[] nums = new int[9];
            for (int i = 0; i < 9; i++) {
                nums[i] = i + 1;
            }
            backtrack(nums, 0, k, n);
            return res;
        }

        public void backtrack(int[] nums, int start, int len, int taget) {

            // 前序位置，每个节点的值都是一个子集
            if (sum == taget && track.size() == len) {
                res.add(new LinkedList<>(track));
                // System.out.printf("\t=> %s\n", res);
                return;
            }

            // 剪枝
            if (sum > taget || track.size() > len) {
                return;
            }

            // 回溯算法标准框架
            for (int i = start; i < nums.length; i++) {

                // 做选择
                track.addLast(nums[i]);
                sum += nums[i];
                // 通过 start 参数控制树枝的遍历，避免产生重复的子集
                backtrack(nums, i + 1, len, taget);
                // 撤销选择
                track.removeLast();
                sum -= nums[i];
            }
        }

    }

}
