package io.github.dunwu.algorithm.array.window;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/permutation-in-string/">567. 字符串的排列</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-08-06
 */
public class 字符串的排列 {

    public static void main(String[] args) {
        Assertions.assertTrue(checkInclusion("ab", "eidbaooo"));
        Assertions.assertFalse(checkInclusion("ab", "eidboaoo"));
    }

    public static boolean checkInclusion(String s1, String s2) {

        // 定义 need 和 window
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
        }

        // 符合 need 排列的字符个数
        int valid = 0;
        // 扫描 s 的窗口游标
        int left = 0, right = 0;
        // 符合要求的子串窗口信息
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s2.length()) {
            char r = s2.charAt(right);
            // 窗口扩展
            right++;
            // 窗口 window 满足 need 的一系列更新
            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (window.get(r).equals(need.get(r))) {
                    valid++;
                }
            }

            // 判断窗口左边界是否收缩
            while (valid == need.size()) {
                // 更新最小窗口信息
                if (right - left < len) {
                    start = left;
                    len = right - left;
                    System.out.format("窗口：[left: %s, right: %s), 子串：%s\n", left, right,
                        s2.substring(start, right));
                    if (len == s1.length()) {
                        return true;
                    }
                }

                // 窗口左边界收缩
                char l = s2.charAt(left);
                left++;
                if (need.containsKey(l)) {
                    if (window.get(l).equals(need.get(l))) {
                        valid--;
                    }
                    window.put(l, window.get(l) - 1);
                }
            }
        }

        return false;
    }

}
