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
            String[] strs = s.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = strs.length - 1; i >= 0; i--) {
                if (strs[i].equals("")) {
                    continue;
                }
                sb.append(strs[i]).append(" ");
            }
            if (sb.lastIndexOf(" ") == sb.length() - 1) {
                return sb.substring(0, sb.length() - 1);
            }
            return sb.toString();
        }

    }

    // 双指针
    static class Solution2 {

        public String reverseWords(String s) {
            // 删除首尾空格
            s = s.trim();
            int i = s.length() - 1, j = i;
            StringBuilder res = new StringBuilder();
            while (i >= 0) {
                // 搜索首个空格
                while (i >= 0 && s.charAt(i) != ' ') { i--; }
                // 添加单词
                res.append(s.substring(i + 1, j + 1)).append(" ");
                // 跳过单词间空格
                while (i >= 0 && s.charAt(i) == ' ') { i--; }
                // j 指向下个单词的尾字符
                j = i;
            }
            // 转化为字符串并返回
            return res.toString().trim();
        }

    }

}
