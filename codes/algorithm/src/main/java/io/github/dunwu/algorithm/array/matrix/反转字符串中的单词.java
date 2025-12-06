package io.github.dunwu.algorithm.array.matrix;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/reverse-words-in-a-string/">151. 反转字符串中的单词</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-05
 */
public class 反转字符串中的单词 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals("blue is sky the", s.reverseWords("the sky is blue"));
        Assertions.assertEquals("world hello", s.reverseWords("  hello world  "));
        Assertions.assertEquals("example good a", s.reverseWords("a good   example"));

        Solution2 s2 = new Solution2();
        Assertions.assertEquals("blue is sky the", s2.reverseWords("the sky is blue"));
        Assertions.assertEquals("world hello", s2.reverseWords("  hello world  "));
        Assertions.assertEquals("example good a", s2.reverseWords("a good   example"));
    }

    // 利用库函数
    static class Solution {

        public String reverseWords(String s) {
            String[] arr = s.trim().split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i].equals("")) {
                    continue;
                }
                sb.append(arr[i]).append(" ");
            }
            return sb.toString().trim();
        }

    }

    // 双指针
    static class Solution2 {

        public String reverseWords(String s) {
            // 删除首尾空格
            s = s.trim();
            int l = s.length() - 1, r = l;
            StringBuilder res = new StringBuilder();
            while (l >= 0) {
                // 左指针偏移，直到遇到空格
                while (l >= 0 && s.charAt(l) != ' ') { l--; }
                // 添加单词
                res.append(s.substring(l + 1, r + 1)).append(' ');
                // 左指针偏移，直到遇到非空格
                while (l >= 0 && s.charAt(l) == ' ') { l--; }
                // 右指针对齐左指针
                r = l;
            }
            return res.toString().trim();
        }

    }

}
