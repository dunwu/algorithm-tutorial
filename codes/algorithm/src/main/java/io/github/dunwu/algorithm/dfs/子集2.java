package io.github.dunwu.algorithm.dfs;

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

        // int[] input = new int[] { 1, 2, 2 };
        // Integer[][] expect = new Integer[][] { {}, { 1 }, { 1, 2 }, { 1, 2, 2 }, { 2 }, { 2, 2 } };
        // List<List<Integer>> output = s.subsetsWithDup(input);
        // Assertions.assertEquals(expect.length, output.size());
        // System.out.println("output: " + output);

        int[] input2 = new int[] { 4, 4, 4, 1, 4 };
        Integer[][] expect2 =
            new Integer[][] { {}, { 1 }, { 1, 4 }, { 1, 4, 4 }, { 1, 4, 4, 4 }, { 1, 4, 4, 4, 4 }, { 4 }, { 4, 4 },
                { 4, 4, 4 }, { 4, 4, 4, 4 } };
        List<List<Integer>> output2 = s.subsetsWithDup(input2);
        System.out.println("output: " + output2);
        Assertions.assertEquals(expect2.length, output2.size());
    }

    static class Solution {

        // 记录回溯算法的递归路径
        LinkedList<Integer> track = null;
        List<List<Integer>> res = null;

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            track = new LinkedList<>();
            res = new LinkedList<>();
            // 先排序，让相同的元素靠在一起
            Arrays.sort(nums);
            backtrack(nums, 0);
            return res;
        }

        public void backtrack(int[] nums, int start) {

            // 前序位置，每个节点的值都是一个子集
            res.add(new LinkedList<>(track));
            // System.out.printf("\t=> %s\n", res);

            // 回溯算法标准框架
            for (int i = start; i < nums.length; i++) {

                // 剪枝逻辑，值相同的相邻树枝，只遍历第一条
                if (i > start && nums[i] == nums[i - 1]) { continue; }

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
