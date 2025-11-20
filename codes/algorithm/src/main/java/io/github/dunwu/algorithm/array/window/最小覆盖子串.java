package io.github.dunwu.algorithm.array.window;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/minimum-window-substring/">76. 最小覆盖子串</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-10
 */
@Slf4j
public class 最小覆盖子串 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals("BANC", s.minWindow("ADOBECODEBANC", "ABC"));
        Assertions.assertEquals("a", s.minWindow("a", "a"));
        Assertions.assertEquals("", s.minWindow("a", "aa"));
    }

    static class Solution {

        public String minWindow(String s, String t) {
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            for (char c : t.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }

            int left = 0, right = 0;

            int valid = 0;
            // 记录最小覆盖子串的起始索引及长度
            int start = 0, len = Integer.MAX_VALUE;
            while (right < s.length()) {
                // c 是将移入窗口的字符
                char c = s.charAt(right);
                // 扩大窗口
                right++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c))) { valid++; }
                }

                // 判断左侧窗口是否要收缩
                while (valid == need.size()) {

                    // 在这里更新最小覆盖子串
                    if (right - left < len) {
                        start = left;
                        len = right - left;
                    }
                    // d 是将移出窗口的字符
                    char d = s.charAt(left);
                    // 缩小窗口
                    left++;
                    // 进行窗口内数据的一系列更新
                    if (need.containsKey(d)) {
                        if (window.get(d).equals(need.get(d))) { valid--; }
                        window.put(d, window.get(d) - 1);
                    }
                }
            }
            // 返回最小覆盖子串
            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }

    }

}
