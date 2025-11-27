package io.github.dunwu.algorithm.queue;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/time-needed-to-buy-tickets/">2073. 买票需要的时间</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-11-26
 */
public class 买票需要的时间 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(6, s.timeRequiredToBuy(new int[] { 2, 3, 2 }, 2));
        Assertions.assertEquals(8, s.timeRequiredToBuy(new int[] { 5, 1, 1, 1 }, 0));
    }

    static class Solution {

        public int timeRequiredToBuy(int[] tickets, int k) {
            int i = 0;
            int seconds = 0;
            while (tickets[k] != 0) {
                if (tickets[i] != 0) {
                    tickets[i]--;
                    seconds++;
                }
                i = (i + 1) % tickets.length;
            }
            return seconds;
        }

    }

}
