package io.github.dunwu.algorithm.dfs;

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
        int[] input = new int[] { 1, 2, 3 };
        List<List<Integer>> output = s.permuteUnique(input);
        System.out.println("output: " + output);
    }

    static class Solution {

        private LinkedList<Integer> track = null;
        private LinkedList<List<Integer>> res = null;
        private boolean[] used = null;

        public List<List<Integer>> permuteUnique(int[] nums) {
            track = new LinkedList<>();
            res = new LinkedList<>();
            used = new boolean[nums.length];
            Arrays.sort(nums);
            backtrack(nums);
            return res;
        }

        public void backtrack(int[] nums) {
            if (track.size() == nums.length) {
                res.add(new LinkedList<>(track));
                // System.out.printf("\t=> %s\n", res);
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) { continue;}
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) { continue;}

                track.addLast(nums[i]);
                used[i] = true;
                backtrack(nums);
                track.removeLast();
                used[i] = false;
            }
        }

    }

}
