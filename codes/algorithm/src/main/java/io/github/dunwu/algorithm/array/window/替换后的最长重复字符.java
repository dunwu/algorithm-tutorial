package io.github.dunwu.algorithm.array.window;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/longest-repeating-character-replacement/">424. 替换后的最长重复字符</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-15
 */
public class 替换后的最长重复字符 {

    public static void main(String[] args) {
        Assertions.assertEquals(4, characterReplacement("ABAB", 2));
        Assertions.assertEquals(4, characterReplacement("AABABBA", 1));
        Assertions.assertEquals(4, characterReplacement("AAAA", 2));
    }

    public static int characterReplacement(String s, int k) {
        int result = 0;
        int left = 0, right = 0;
        int windowMaxCnt = 0;
        HashMap<Character, Integer> map = new HashMap<>(26);
        while (right < s.length()) {
            char r = s.charAt(right);
            right++;

            map.put(r, map.getOrDefault(r, 0) + 1);
            windowMaxCnt = Math.max(windowMaxCnt, map.get(r));

            while (right - left - windowMaxCnt > k) {
                char l = s.charAt(left);
                left++;

                map.put(l, map.get(l) - 1);
            }
            result = Math.max(result, right - left);
        }
        return result;
    }

}
