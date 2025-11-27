package io.github.dunwu.algorithm.array.bsearch;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/">LCR 172. 统计目标成绩的出现次数</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-15
 */
public class 统计目标成绩的出现次数 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(3, s.countTarget(new int[] { 2, 2, 3, 4, 4, 4, 5, 6, 6, 8 }, 4));
        Assertions.assertEquals(0, s.countTarget(new int[] { 1, 2, 3, 5, 7, 9 }, 6));
    }

    static class Solution {

        public int countTarget(int[] scores, int target) {
            int leftBound = searchLeft(scores, target);
            if (leftBound == -1) { return 0; }
            int cnt = 1;
            for (int i = leftBound + 1; i < scores.length; i++) {
                if (scores[i] == target) {
                    cnt++;
                }
            }
            return cnt;
        }

        public int searchLeft(int[] nums, int target) {
            int res = -1;
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    right = mid - 1;
                    res = mid;
                }
            }
            return res;
        }

    }

}
