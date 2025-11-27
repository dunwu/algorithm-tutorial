package io.github.dunwu.algorithm.design;

import java.util.Arrays;

/**
 * 计数器模板
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-31
 */
public class 计算器 {

    public static void main(String[] args) {
        Solution s = new  Solution();
        System.out.println("args = " + Arrays.toString(args));
    }

    static class Solution {

        public int toNum(String s) {
            if (s == null || s.length() == 0) { return 0; }
            int num = 0;
            for (char c : s.toCharArray()) {
                num = num * 10 + (c - '0');
            }
            return num;
        }

    }

}
