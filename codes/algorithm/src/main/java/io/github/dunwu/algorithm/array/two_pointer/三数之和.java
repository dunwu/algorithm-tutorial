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

            // 数组排序
            Arrays.sort(nums);

            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {

                // 跳过重复元素
                if (i > 0 && nums[i] == nums[i - 1]) { continue; }

                // 双指针，目标是找到 nums[l] + nums[r] = -nums[i]
                int target = -nums[i];
                int l = i + 1, r = nums.length - 1;

                while (l < r) {
                    int sum = nums[l] + nums[r];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        l++;
                        r--;
                        // 跳过重复元素
                        while (l < r && nums[l] == nums[l - 1]) l++;
                        while (l < r && nums[r] == nums[r + 1]) r--;
                    } else if (sum > target) {
                        r--;
                    } else if (sum < target) {
                        l++;
                    }
                }
            }
            return res;
        }

    }

}
