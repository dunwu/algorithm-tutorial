package io.github.dunwu.algorithm.dfs;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-05
 */
public class 连续差相同的数字 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new int[] { 181, 292, 707, 818, 929 }, s.numsSameConsecDiff(3, 7));
    }

    static class Solution {

        int track = 0;
        int digit = 0;
        LinkedList<Integer> res = null;

        public int[] numsSameConsecDiff(int n, int k) {
            res = new LinkedList<>();
            backtrack(n, k);
            return res.stream().mapToInt(Integer::intValue).toArray();
        }

        public void backtrack(int n, int k) {
            if (digit == n) {
                res.addLast(track);
                return;
            }

            for (int i = 0; i <= 9; i++) {
                if (digit == 0 && i == 0) { continue; }
                if (digit > 0 && Math.abs(i - track % 10) != k) { continue; }
                digit++;
                track = track * 10 + i;
                backtrack(n, k);
                track = track / 10;
                digit--;
            }
        }

    }

}
