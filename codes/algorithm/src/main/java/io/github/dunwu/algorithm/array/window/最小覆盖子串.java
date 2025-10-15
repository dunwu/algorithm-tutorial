package io.github.dunwu.algorithm.array.window;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/minimum-window-substring/">76. 最小覆盖子串</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-10
 */
@Slf4j
public class 最小覆盖子串 {

    public static void main(String[] args) {
        Assertions.assertEquals("BANC", minWindow("ADOBECODEBANC", "ABC"));
        Assertions.assertEquals("a", minWindow("a", "a"));
        Assertions.assertEquals("", minWindow("a", "aa"));
    }

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            // 扩大窗口：右边界右移
            right++;
            // 窗口 window 满足 need 的一系列更新
            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (window.get(r).equals(need.get(r))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                    System.out.format("窗口：[left: %s, right: %s), 子串：%s\n", left, right,
                        s.substring(start, right));
                }
                char l = s.charAt(left);
                // 缩小窗口：左边界右移
                left++;
                if (need.containsKey(l)) {
                    if (window.get(l).equals(need.get(l))) valid--;
                    window.put(l, window.get(l) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

}
