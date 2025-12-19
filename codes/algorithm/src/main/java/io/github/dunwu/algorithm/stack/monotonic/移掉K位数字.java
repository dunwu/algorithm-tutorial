package io.github.dunwu.algorithm.stack.monotonic;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/remove-k-digits/">402. 移掉 K 位数字</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-26
 */
public class 移掉K位数字 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals("1219", s.removeKdigits("1432219", 3));
        Assertions.assertEquals("200", s.removeKdigits("10200", 1));
        Assertions.assertEquals("0", s.removeKdigits("10", 2));
    }

    static class Solution {

        public String removeKdigits(String num, int k) {
            Stack<Character> s = new Stack<>();
            for (char c : num.toCharArray()) {
                // 单调栈代码模板
                while (!s.isEmpty() && c < s.peek() && k > 0) {
                    s.pop();
                    k--;
                }
                // 防止 0 作为数字的开头
                if (s.isEmpty() && c == '0') { continue; }
                s.push(c);
            }

            // 此时栈中元素单调递增，若 k 还没用完的话删掉栈顶元素
            while (!s.isEmpty() && k > 0) {
                s.pop();
                k--;
            }
            // 若最后没剩下数字，就是 0
            if (s.isEmpty()) { return "0"; }
            // 将栈中字符转化成字符串
            StringBuilder sb = new StringBuilder();
            while (!s.isEmpty()) { sb.append(s.pop()); }
            // 出栈顺序和字符串顺序是反的
            return sb.reverse().toString();
        }

    }

}
