package io.github.dunwu.algorithm.dfs;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/subsets/">78. 子集</a>
 * <p>
 * 元素不可重复，不可复选
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-04
 */
public class 子集 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = new int[] { 1, 2, 3 };
        Integer[][] expect = new Integer[][] { {}, { 1 }, { 2 }, { 1, 2 }, { 3 }, { 1, 3 }, { 2, 3 }, { 1, 2, 3 } };
        List<List<Integer>> output = s.subsets(input);
        Assertions.assertEquals(expect.length, output.size());
        System.out.println("output: " + output);
    }

    static class Solution {

        // 记录回溯算法的递归路径
        LinkedList<Integer> track = null;
        List<List<Integer>> res = null;

        public List<List<Integer>> subsets(int[] nums) {
            track = new LinkedList<>();
            res = new LinkedList<>();
            backtrack(nums, 0);
            return res;
        }

        public void backtrack(int[] nums, int start) {

            // 前序位置，每个节点的值都是一个子集
            res.add(new LinkedList<>(track));
            System.out.printf("\t=> %s\n", res);

            // 回溯算法标准框架
            for (int i = start; i < nums.length; i++) {
                // 做选择
                track.addLast(nums[i]);
                // 通过 start 参数控制树枝的遍历，避免产生重复的子集
                backtrack(nums, i + 1);
                // 撤销选择
                track.removeLast();
            }
        }

    }

}
