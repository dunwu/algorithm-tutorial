package io.github.dunwu.algorithm.dfs;

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
        int[] input = new int[] { 1, 2, 3 };
        List<List<Integer>> output = s.permute(input);
        System.out.println("output: " + output);
    }

    static class Solution {

        private LinkedList<Integer> track = null;
        private LinkedList<List<Integer>> res = null;
        private boolean[] used = null;

        public List<List<Integer>> permute(int[] nums) {
            track = new LinkedList<>();
            res = new LinkedList<>();
            used = new boolean[nums.length];
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
                if (used[i]) { continue; }
                track.addLast(nums[i]);
                used[i] = true;
                backtrack(nums);
                track.removeLast();
                used[i] = false;
            }
        }

    }

}
