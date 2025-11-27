package io.github.dunwu.algorithm.queue.monotonic;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/sliding-window-maximum/">239. 滑动窗口最大值</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-26
 */
public class 滑动窗口最大值 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new int[] { 3, 3, 5, 5, 6, 7 },
            s.maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3));
        Assertions.assertArrayEquals(new int[] { 1 }, s.maxSlidingWindow(new int[] { 1 }, 1));
    }

    static class Solution {

        public int[] maxSlidingWindow(int[] nums, int k) {
            MonotonicQueue window = new MonotonicQueue();
            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                if (i < k - 1) {
                    window.push(nums[i]);
                } else {
                    window.push(nums[i]);
                    res.add(window.max());
                    window.pop(nums[i - (k - 1)]);
                }
            }

            int[] arr = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                arr[i] = res.get(i);
            }
            return arr;
        }

        static class MonotonicQueue {

            LinkedList<Integer> q = new LinkedList<>();

            public void push(int n) {
                // 将小于 n 的元素全部删除
                while (!q.isEmpty() && q.getLast() < n) {
                    q.pollLast();
                }
                // 然后将 n 加入尾部
                q.addLast(n);
            }

            public int max() {
                return q.getFirst();
            }

            public void pop(int n) {
                if (n == q.getFirst()) {
                    q.pollFirst();
                }
            }

        }

    }

}
