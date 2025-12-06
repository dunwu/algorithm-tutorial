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
            int left = 0, right = 0;
            // 统计窗口中每个字符的出现次数
            int[] charCnt = new int[26];
            // 记录窗口中字符的最多重复次数
            // 记录这个值的意义在于，最划算的替换方法肯定是把其他字符替换成出现次数最多的那个字符
            int windowMaxCnt = 0;
            // 记录结果长度
            int res = 0;

            // 开始滑动窗口模板
            while (right < s.length()) {
                // 扩大窗口
                int c = s.charAt(right) - 'A';
                charCnt[c]++;
                windowMaxCnt = Math.max(windowMaxCnt, charCnt[c]);
                right++;

                // 这个 while 换成 if 也可以
                while (right - left - windowMaxCnt > k) {
                    // 杂牌字符数量 right - left - windowMaxCnt 多于 k
                    // 此时，k 次替换已经无法把窗口内的字符都替换成相同字符了
                    // 必须缩小窗口
                    int d = s.charAt(left) - 'A';
                    charCnt[d]--;
                    left++;
                }
                // 经过收缩后，此时一定是一个合法的窗口
                res = Math.max(res, right - left);
            }
            return res;
        }

    }

}
