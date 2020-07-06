package io.github.dunwu.algorithm.dynamic;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/is-subsequence/">392. 判断子序列</a>
 * @since 2020-07-06
 */
public class 判断子序列 {

    public static void main(String[] args) {
        Assertions.assertTrue(isSubsequence("abc", "ahbgdc"));
        Assertions.assertFalse(isSubsequence("axc", "ahbgdc"));
        Assertions.assertTrue(isSubsequence("", "ahbgdc"));
        Assertions.assertFalse(isSubsequence("aaaaaa", "bbaaaa"));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        if (s.length() > t.length()) return false;
        char[] source = s.toCharArray();
        char[] target = t.toCharArray();
        int i = 0, j = 0;
        while (i < source.length && j < target.length) {
            if (target[j] != source[i]) {
                j++;
            } else {
                if (i == source.length - 1) {
                    return true;
                }
                i++;
                j++;
            }
        }
        return false;
    }

}
