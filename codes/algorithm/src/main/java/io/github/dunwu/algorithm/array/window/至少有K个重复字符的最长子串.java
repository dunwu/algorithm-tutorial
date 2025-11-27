package io.github.dunwu.algorithm.array.window;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/">395. 至少有 K
 * 个重复字符的最长子串</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-15
 */
public class 至少有K个重复字符的最长子串 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(3, s.longestSubstring("aaabb", 3));
        Assertions.assertEquals(5, s.longestSubstring("ababbc", 2));
        Assertions.assertEquals(6, s.longestSubstring("aaabbb", 3));
    }

    public static class Solution {

        public int longestSubstring(String s, int k) {
            int len = 0;
            for (int i = 1; i <= 26; i++) {
                // 限制窗口中只能有 i 种不同字符
                len = Math.max(len, logestKLetterSubstr(s, k, i));
            }
            return len;
        }

        // 寻找 s 中含有 count 种字符，且每种字符出现次数都大于 k 的子串
        int logestKLetterSubstr(String s, int k, int count) {
            // 记录答案
            int res = 0;
            // 快慢指针维护滑动窗口，左闭右开区间
            int left = 0, right = 0;
            // 题目说 s 中只有小写字母，所以用大小 26 的数组记录窗口中字符出现的次数
            int[] windowCount = new int[26];
            // 记录窗口中存在几种不同的字符（字符种类）
            int windowUniqueCount = 0;
            // 记录窗口中有几种字符的出现次数达标（大于等于 k）
            int windowValidCount = 0;
            // 滑动窗口代码模板
            while (right < s.length()) {
                // 移入字符，扩大窗口
                char c = s.charAt(right);
                if (windowCount[c - 'a'] == 0) {
                    // 窗口中新增了一种字符
                    windowUniqueCount++;
                }
                windowCount[c - 'a']++;
                if (windowCount[c - 'a'] == k) {
                    // 窗口中新增了一种达标的字符
                    windowValidCount++;
                }
                right++;

                // 当窗口中字符种类大于 count 时，缩小窗口
                while (windowUniqueCount > count) {
                    // 移出字符，缩小窗口
                    char d = s.charAt(left);
                    if (windowCount[d - 'a'] == k) {
                        // 窗口中减少了一种达标的字符
                        windowValidCount--;
                    }
                    windowCount[d - 'a']--;
                    if (windowCount[d - 'a'] == 0) {
                        // 窗口中减少了一种字符
                        windowUniqueCount--;
                    }
                    left++;
                }

                // 当窗口中字符种类为 count 且每个字符出现次数都满足 k 时，更新答案
                if (windowValidCount == count) {
                    res = Math.max(res, right - left);
                }
            }
            return res;
        }

    }

}
