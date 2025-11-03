package io.github.dunwu.algorithm.backtrack;

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

        private List<List<Integer>> res = null;

        public List<List<Integer>> permute(int[] nums) {
            // 记录「路径」
            LinkedList<Integer> track = new LinkedList<>();
            // 「路径」中的元素会被标记为 true，避免重复使用
            boolean[] used = new boolean[nums.length];
            res = new LinkedList<>();
            backtrack(nums, track, used);
            return res;
        }

        public void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
            if (track.size() == nums.length) {
                res.add(new LinkedList<>(track));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }

                // 选择
                track.addLast(nums[i]);
                used[i] = true;

                // 进入下一层决策树
                backtrack(nums, track, used);

                // 取消选择
                track.removeLast();
                used[i] = false;
            }
        }

    }

}
