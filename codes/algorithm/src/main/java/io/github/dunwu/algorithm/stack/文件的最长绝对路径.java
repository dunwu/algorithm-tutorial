package io.github.dunwu.algorithm.stack;

import org.junit.jupiter.api.Assertions;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/evaluate-reverse-polish-notation/">150. 逆波兰表达式求值</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 文件的最长绝对路径 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(20, s.lengthLongestPath("dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext"));
        Assertions.assertEquals(32, s.lengthLongestPath(
            "dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext"));
        Assertions.assertEquals(0, s.lengthLongestPath("a"));
        Assertions.assertEquals(12, s.lengthLongestPath("file1.txt\\nfile2.txt\\nlongfile.txt"));
    }

    static class Solution {

        public int lengthLongestPath(String input) {
            // 这个栈存储之前的父路径。实际上这里只用存父路径的长度就够了，这个优化留给你吧
            Deque<String> stack = new LinkedList<>();
            int maxLen = 0;
            for (String part : input.split("\n")) {
                int level = part.lastIndexOf("\t") + 1;
                // 让栈中只保留当前目录的父路径
                while (level < stack.size()) {
                    stack.removeLast();
                }
                stack.addLast(part.substring(level));
                // 如果是文件，就计算路径长度
                if (part.contains(".")) {
                    int sum = stack.stream().mapToInt(String::length).sum();
                    // 加上父路径的分隔符
                    sum += stack.size() - 1;
                    maxLen = Math.max(maxLen, sum);
                }
            }
            return maxLen;
        }

    }

}
