package io.github.dunwu.algorithm.array.window;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/longest-repeating-character-replacement/">424. 替换后的最长重复字符</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-15
 */
public class 替换后的最长重复字符 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(4, s.characterReplacement("ABAB", 2));
        Assertions.assertEquals(4, s.characterReplacement("AABABBA", 1));
        Assertions.assertEquals(4, s.characterReplacement("AAAA", 2));
    }

    static class Solution {

        public int characterReplacement(String s, int k) {

            int res = 0;
            int windowMaxCount = 0;
            int left = 0, right = 0;
            int[] windowCount = new int[26];
            while (right < s.length()) {
                int c = s.charAt(right) - 'A';
                windowCount[c]++;
                windowMaxCount = Math.max(windowMaxCount, windowCount[c]);
                right++;

                while (right - left - windowMaxCount > k) {
                    int d = s.charAt(left) - 'A';
                    windowCount[d]--;
                    left++;
                }

                res = Math.max(res, right - left);
            }
            return res;
        }

    }

}
