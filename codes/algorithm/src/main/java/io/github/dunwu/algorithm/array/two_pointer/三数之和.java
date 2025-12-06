package io.github.dunwu.algorithm.array.two_pointer;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * <a href="https://leetcode.cn/problems/3sum/">三数之和</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-18
 */
public class 三数之和 {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> input = s.threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
        List<List<Integer>> expect = new ArrayList<>();
        expect.add(Arrays.asList(-1, -1, 2));
        expect.add(Arrays.asList(-1, 0, 1));
        Assertions.assertArrayEquals(expect.toArray(), input.toArray());
    }

    static class Solution {

        public List<List<Integer>> threeSum(int[] nums) {
            if (nums == null || nums.length < 3) { return new ArrayList<>(); }
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                // 跳过重复元素
                if (i > 0 && nums[i] == nums[i - 1]) continue;

                // 双指针，目标是找到 nums[l] + nums[r] = -nums[i]
                int left = i + 1, right = nums.length - 1;
                int target = -nums[i];

                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                        // 跳过重复元素
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return res;
        }

    }

}
