package io.github.dunwu.algorithm.stack;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/backspace-string-compare/">844. 比较含退格的字符串</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 比较含退格的字符串 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertTrue(s.backspaceCompare("ab#c", "ad#c"));
        Assertions.assertTrue(s.backspaceCompare("ab##", "c#d#"));
        Assertions.assertTrue(s.backspaceCompare("a##c", "#a#c"));
        Assertions.assertFalse(s.backspaceCompare("a#c", "b"));
    }

    static class Solution {

        public boolean backspaceCompare(String s, String t) {
            Stack<Character> a = new Stack<>();
            Stack<Character> b = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '#') {
                    if (!a.isEmpty()) { a.pop(); }
                } else {
                    a.push(c);
                }
            }
            for (char c : t.toCharArray()) {
                if (c == '#') {
                    if (!b.isEmpty()) { b.pop(); }
                } else {
                    b.push(c);
                }
            }

            if (a.size() != b.size()) { return false; }
            while (!a.isEmpty()) {
                if (a.pop() != b.pop()) { return false; }
            }
            return true;
        }

    }

}
