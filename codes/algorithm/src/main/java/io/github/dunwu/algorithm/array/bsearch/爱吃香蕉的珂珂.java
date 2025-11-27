package io.github.dunwu.algorithm.array.bsearch;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/koko-eating-bananas/">875. 爱吃香蕉的珂珂</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-08-06
 */
public class 爱吃香蕉的珂珂 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(4, s.minEatingSpeed(new int[] { 3, 6, 7, 11 }, 8));
        Assertions.assertEquals(30, s.minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 5));
        Assertions.assertEquals(23, s.minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 6));
        Assertions.assertEquals(2, s.minEatingSpeed(new int[] { 312884470 }, 312884469));
        Assertions.assertEquals(3, s.minEatingSpeed(new int[] { 805306368, 805306368, 805306368 }, 1000000000));
        Assertions.assertEquals(14, s.minEatingSpeed(
            new int[] { 332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077,
                337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728,
                941802184 }, 823855818));
    }

    static class Solution {

        public int minEatingSpeed(int[] piles, int h) {
            final int rightBound = 1_000_000_001;
            int left = 1, right = rightBound;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (f(piles, mid) == h) {
                    // 搜索左侧边界，则需要收缩右侧边界
                    right = mid ;
                } else if (f(piles, mid) < h) {
                    // 需要让 f(x) 的返回值大一些
                    right = mid ;
                } else if (f(piles, mid) > h) {
                    // 需要让 f(x) 的返回值小一些
                    left = mid + 1;
                }
            }
            if (left < 0 || left > rightBound) { return -1; }
            return left;
        }

        public int f(int[] nums, int x) {
            int res = 0;
            for (int num : nums) {
                if (num <= x) {
                    res++;
                } else {
                    res += num / x;
                    if (num % x != 0) {
                        res++;
                    }
                }
            }
            return res;
        }

    }

}
