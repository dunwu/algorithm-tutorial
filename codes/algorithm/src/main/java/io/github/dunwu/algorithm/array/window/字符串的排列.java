package io.github.dunwu.algorithm.array.window;

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
        Solution s = new Solution();
        Assertions.assertTrue(s.checkInclusion("ab", "eidbaooo"));
        Assertions.assertFalse(s.checkInclusion("ab", "eidboaoo"));
    }

    static class Solution {

        public boolean checkInclusion(String t, String s) {
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            for (char c : t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);

            int left = 0, right = 0;
            int valid = 0;
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c))) { valid++; }
                }

                // 判断左侧窗口是否要收缩
                while (right - left >= t.length()) {
                    // 在这里判断是否找到了合法的子串
                    if (valid == need.size()) { return true; }
                    char d = s.charAt(left);
                    left++;
                    // 进行窗口内数据的一系列更新
                    if (need.containsKey(d)) {
                        if (window.get(d).equals(need.get(d))) { valid--; }
                        window.put(d, window.get(d) - 1);
                    }
                }
            }
            // 未找到符合条件的子串
            return false;
        }

    }

}
