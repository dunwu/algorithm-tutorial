package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

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

    public static boolean checkInclusion(String t, String s) {

        // 定义 window, need
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int valid = 0;
        int left = 0, right = 0;
        while (right < s.length()) {

            // 2. right++，窗口右扩，直到满足条件

            // 移入窗口的字符
            char c = s.charAt(right);
            // 扩大窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }


        }
        return false;
    }

}
