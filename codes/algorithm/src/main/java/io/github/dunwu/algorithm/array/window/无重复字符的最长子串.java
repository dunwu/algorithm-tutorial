package io.github.dunwu.algorithm.array.window;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">3. 无重复字符的最长子串</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-14
 */
public class 无重复字符的最长子串 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(3, s.lengthOfLongestSubstring("abcabcbb"));
        Assertions.assertEquals(1, s.lengthOfLongestSubstring("bbbbb"));
        Assertions.assertEquals(3, s.lengthOfLongestSubstring("pwwkew"));
        Assertions.assertEquals(2, s.lengthOfLongestSubstring("aab"));
    }

    static class Solution {

        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> window = new HashMap<>();

            int left = 0, right = 0;
            // 记录结果
            int res = 0;
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                // 进行窗口内数据的一系列更新
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 判断左侧窗口是否要收缩
                while (window.get(c) > 1) {
                    char d = s.charAt(left);
                    left++;
                    // 进行窗口内数据的一系列更新
                    window.put(d, window.get(d) - 1);
                }
                // 在这里更新答案
                res = Math.max(res, right - left);
            }
            return res;
        }

    }

}
