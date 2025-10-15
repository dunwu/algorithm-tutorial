package io.github.dunwu.algorithm.array.window;

import org.junit.jupiter.api.Assertions;

import java.util.HashSet;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">3. 无重复字符的最长子串</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-14
 */
public class 无重复字符的最长子串 {

    public static void main(String[] args) {
        Assertions.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        Assertions.assertEquals(1, lengthOfLongestSubstring("bbbbb"));
        Assertions.assertEquals(3, lengthOfLongestSubstring("pwwkew"));
        Assertions.assertEquals(2, lengthOfLongestSubstring("aab"));
    }

    public static int lengthOfLongestSubstring(String s) {
        // 【debug】
        System.out.println("============> 原始字符串：" + s);
        // 定义窗口
        HashSet<Character> window = new HashSet<>();
        // 窗口边界
        int left = 0, right = 0;
        int max = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            // 扩大边界
            right++;
            if (window.contains(r)) {
                while (r != s.charAt(left)) {
                    char l = s.charAt(left);
                    window.remove(l);
                    left++;
                }
                char l = s.charAt(left);
                left++;
            } else {
                window.add(r);
                if (window.size() > max) {
                    // 【debug】
                    System.out.format("首个最大不重复子串：%s, Offset: [%d, %d)\n",
                        s.substring(left, right), left, right);
                    max = window.size();
                }
            }
        }
        return max;
    }

}
